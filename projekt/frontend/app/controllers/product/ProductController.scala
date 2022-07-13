package controllers.product

import javax.inject._
import models.product.{NewProduct, Product}
import play.api._
import play.api.mvc.Result
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents,AbstractController}
import scala.collection.mutable


@Singleton //wyłącznie jedna instancja
class ProductController @Inject() (controllerComponents: ControllerComponents) extends AbstractController(controllerComponents)
{
  private val productList = new mutable.ListBuffer[Product]() //lista koszyków

  productList += Product(1,"Banan",1.5,5)
  productList += Product(2,"Gruszka",1.5,4)
  productList += Product(3,"Pomidor",2.5,3)

 implicit val shopListJson = Json.format[Product]
implicit val newShopListJson = Json.format[NewProduct]

  // POSZCZEGÓLNE METODY

  // curl localhost:9000/shoppingCart -> GET
  def showAll(): Action[AnyContent] = Action {
    if (productList.isEmpty) NoContent else Ok(Json.toJson(productList))
  }

  // curl localhost:9000/shoppingCart/1 -> GET
  def showById(itemId: Long) = Action {
    val foundItem = productList.find(_.id == itemId)
    foundItem match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound
    }
  }

//curl -X PUT -H "Content-Type: application/json" -d '{"name": "Sliwka", "weight":2, "price":10}' localhost:9000/product/update/4 -> UPDATE
  def update(itemId: Long): Action[AnyContent] = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val found_id=productList.indexWhere(_.id == itemId)
    if(found_id < 0)
      BadRequest

    val productListItem: Option[NewProduct] = jsonObject.flatMap(Json.fromJson[NewProduct](_).asOpt)
    productListItem match {
      case Some(newItem) =>
        val toUpdate = Product(itemId, newItem.name, newItem.weight, newItem.price)
        productList.update(found_id, toUpdate)
        Accepted(Json.toJson(toUpdate))
      case None =>
        BadRequest
    }
  }

    // curl -X DELETE localhost:9000/product/4 ->DELETE
  def delete(itemId: Long) = Action {
    productList.filterInPlace(_.id != itemId)
    Accepted
  }

  //curl -v -d '{"name": "Sliwka", "weight":3, "price":1.5}' -H 'Content-Type: application/json' -X POST localhost:9000/product
  def add() = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val productListItem: Option[NewProduct] = jsonObject.flatMap(Json.fromJson[NewProduct](_).asOpt)

    productListItem match {
      case Some(newItem) =>
        val nextId = productList.map(_.id).max + 1
        val toBeAdded = Product(nextId, newItem.name, newItem.weight, newItem.price)
        productList += toBeAdded
        Created(Json.toJson(toBeAdded))
      case None =>
        BadRequest
    }
  }
}
