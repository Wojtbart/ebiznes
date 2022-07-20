package controllers.payments

import javax.inject._
import models.payments.{NewPayment, Payment}
import play.api._
import play.api.mvc.Result
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, ControllerComponents,AbstractController}
import sttp.client3.{HttpURLConnectionBackend, Identity, SttpBackend, UriContext, basicRequest}
import sttp.model.{Header, HeaderNames}
import scala.collection.mutable
import cats.implicits.toFunctorOps
import play.api.Configuration


@Singleton //wyłącznie jedna instancja
class PaymentsController @Inject() (controllerComponents: ControllerComponents,configuration: Configuration) extends AbstractController(controllerComponents)
{
  private val paymentsList = new mutable.ListBuffer[Payment]() //lista koszyków

  val clientSecret: String = configuration.get[String]("stripe.clientSecret")
  val backend: SttpBackend[Identity, Any] = HttpURLConnectionBackend()
  val baseUri = uri"https://api.stripe.com/v1/payment_intents"

  paymentsList += Payment(1, 5,"")

  implicit val paymentListJson= Json.format[Payment]
  implicit val newCardListJson= Json.format[NewPayment]

  // POSZCZEGÓLNE METODY

  // curl localhost:9000/payments -> GET
  def showAll(): Action[AnyContent] = Action {
    if (paymentsList.isEmpty) NoContent else Ok(Json.toJson(paymentsList))
  }

  // curl localhost:9000/payments/1 -> GET one ID
  def showById(itemId: Long) = Action {
    val foundItem = paymentsList.find(_.id == itemId)
    foundItem match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound
    }
  }

//curl -X PUT -H "Content-Type: application/json" -d '{"number_card": "0000 0000 0000 0000", "name":"AAA", "expiration_date":"01/01", "cvc": "000"}' localhost:9000/payments/update/2 -> UPDATE
  def update(itemId: Long) = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val found_id=paymentsList.indexWhere(_.id == itemId)
    if(found_id<0)
      BadRequest

    val paymentListItem: Option[NewPayment] = jsonObject.flatMap(Json.fromJson[NewPayment](_).asOpt)
    paymentListItem match {
      case Some(newItem) =>
        val toUpdate = Payment(itemId, newItem.value,paymentsList(found_id).payment_id)
        paymentsList.update(found_id,toUpdate)
        Accepted(Json.toJson(toUpdate))
      case None =>
        BadRequest
    }
  }

    // curl -X DELETE localhost:9000/payments/2 ->DELETE
  def delete(itemId: Long) = Action {
    paymentsList.filterInPlace(_.id != itemId)
    Accepted
  }

  //curl -v -d '{"number_card": "0000 0000 0000 0000", "name":"AAA", "expiration_date":"01/01", "cvc": "111"}' -H 'Content-Type: application/json' -X POST localhost:9000/payments
  def add(): Action[AnyContent] = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val paymentListItem: Option[NewPayment] = jsonObject.flatMap(Json.fromJson[NewPayment](_).asOpt)

    paymentListItem match {
      case Some(newItem) =>

        val chargeParams = Map(
          "amount" -> newItem.value.toString,
          // "amount" -> 2100,
          "currency" -> "pln",
          "payment_method" -> newItem.creditCardTokenId,
          // "payment_method"-> "pm_1LJzj3E19vO0UQxE51X6aXKN",
          "confirm" -> "true"
        )

        backend
          .send {
            basicRequest
              .post(baseUri)
              .headers(
                Header(HeaderNames.ContentType, "application/x-www-form-urlencoded"),
                Header(HeaderNames.Authorization, "Bearer " + clientSecret))
              .body(chargeParams)
          }
          .map { response =>
            response.body match {
              case Right(t) => {
                val js = Json.parse(t)
                if (js("amount_received").toString() == newItem.value.toString) {
                  val nextId = paymentsList.map(_.id).max + 1
                  val toBeAdded = Payment(nextId, newItem.value, js("id").toString())
                  paymentsList += toBeAdded
                  Created(Json.toJson(toBeAdded))
                }
                else {
                  PaymentRequired
                }
              }
              case Left(e) => BadRequest(e)
            }
          }
      case None =>
        BadRequest
    }
  }
}
