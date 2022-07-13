package controllers.shoppingCart

import javax.inject._
import models.shoppingCart.{ShoppingCart, ShoppingCartProduct, NewShoppingCart}
import models.product.Product
import play.api._
import play.api.mvc.Result
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, ControllerComponents,AbstractController}
import scala.collection.mutable

//Należy stworzyć aplikację na frameworku Play w Scali 2, która będzie miała zaimplementowane 3 kontrolery CRUD (w sumie 15 endpointów). Kontrolery mogą bazować na listach zamiast baz danych. CRUD: showAll, showById (get), update (put), delete (delete), add (post).

@Singleton //wyłącznie jedna instancja
class ShoppingCartController @Inject() (controllerComponents: ControllerComponents) extends AbstractController(controllerComponents) 
{
  private val shoppingCartList = new mutable.ListBuffer[ShoppingCart]() //lista koszyków

  // dodajemy zadania do listy
  shoppingCartList += ShoppingCart(1,1,"", Array(ShoppingCartProduct(Product(1, "Banan",2, 3), 1)) )
  shoppingCartList += ShoppingCart(2,2,"", Array(ShoppingCartProduct(Product(2, "Gruszka",1.5, 3.5), 2)))
  shoppingCartList += ShoppingCart(3,3,"", Array(ShoppingCartProduct(Product(3, "Pomidor",2.5, 2), 3)) )

  // implicit val todoListJson = Json.format[TodoListItem]
  // implicit val newTodoListJson = Json.format[NewTodoListItem]

  implicit val productJson:OFormat[Product]= Json.format[Product]
  implicit val shoppingCartProductJson:OFormat[ShoppingCartProduct]= Json.format[ShoppingCartProduct]
  implicit val shoppingCartListJson:OFormat[ShoppingCart]= Json.format[ShoppingCart]
  implicit val newShoppingCartListJson:OFormat[NewShoppingCart] = Json.format[NewShoppingCart]

  // POSZCZEGÓLNE METODY

  // curl localhost:9000/shoppingCart -> GET
  def showAll(): Action[AnyContent] = Action {
    if (shoppingCartList.isEmpty) NoContent else Ok(Json.toJson(shoppingCartList))
  }

  // curl localhost:9000/shoppingCart/1 -> GET
  def showById(itemId: Long) = Action {
    val foundItem = shoppingCartList.find(_.id == itemId)
    foundItem match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound
    }
  }

  def getByUser(token: String = null): Action[AnyContent] = Action { implicit request =>
    if (token == null) {
      Unauthorized
    }
    else {
      val session = login.SessionController.getByToken(token)
      if (session.id == -1) {
        NoContent
      } else {
        val cartUserList = shoppingCartList.filter(_.email == session.email)
        if (cartUserList.isEmpty) NoContent else Ok(Json.toJson(cartUserList))
      }
    }
  }

//curl -X PUT -H "Content-Type: application/json" -d '{"payment_id": 2,"products_in_cart": [{"product_name": {"id": 3,"name": "Pomidor","weight": 2.5,"price": 10.5},"quantity": 10}]}' localhost:9000/shoppingCart/update/4 -> UPDATE
  def update(itemId: Long, token: String = null) = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val found_id=shoppingCartList.indexWhere(_.id == itemId)
    if(found_id<0)
      BadRequest

    val productList: Option[NewShoppingCart] = jsonObject.flatMap(Json.fromJson[NewShoppingCart](_).asOpt)

    productList match {
      case Some(newItem) =>
        if (token == null) {
          val toUpdate = ShoppingCart(itemId, newItem.payment_id,"", newItem.products_in_cart)
          shoppingCartList.update(found_id,toUpdate)
          Accepted(Json.toJson(toUpdate))
        } else {
          val session = login.SessionController.getByToken(token)
          if (session.id == -1) {
            Unauthorized
          } else {
            val toUpdate = ShoppingCart(itemId, newItem.payment_id,session.email, newItem.products_in_cart)
            shoppingCartList.update(found_id,toUpdate)
            Accepted(Json.toJson(toUpdate))
          }
        }
      case None =>
        BadRequest
    }
  }

  // curl -X DELETE localhost:9000/shoppingCart/4 ->DELETE
  def delete(itemId: Long) = Action {
    shoppingCartList.filterInPlace(_.id != itemId)
    Accepted
  }

//curl -v -d '{"payment_id": 4,"products_in_cart": [{"product_name": {"id": 3,"name": "Pomidor","weight": 2.5,"price": 2},"quantity": 2}]}' -H 'Content-Type: application/json' -X POST localhost:9000/shoppingCart
  def add(token: String = null) = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val productList: Option[NewShoppingCart] = jsonObject.flatMap(Json.fromJson[NewShoppingCart](_).asOpt)

    productList match {
      case Some(newItem) =>
        val nextId = shoppingCartList.map(_.id).max + 1

         if (token == null) {
          val toBeAdded = ShoppingCart(nextId, newItem.payment_id,"",  newItem.products_in_cart)
          shoppingCartList += toBeAdded
          Created(Json.toJson(toBeAdded))
        }
        else {
          val session = login.SessionController.getByToken(token)
          val toBeAdded = ShoppingCart(nextId, newItem.payment_id,session.email,  newItem.products_in_cart)
          shoppingCartList += toBeAdded
          Created(Json.toJson(toBeAdded))
        }
      case None =>
        BadRequest
    }
  }
}
