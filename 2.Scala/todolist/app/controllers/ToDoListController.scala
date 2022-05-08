package controllers

import javax.inject._
import models.{NewTodoListItem, TodoListItem}
import play.api._
import play.api.mvc.Result
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import scala.collection.mutable


//Należy stworzyć aplikację na frameworku Play w Scali 2, która będzie miała zaimplementowane 3 kontrolery CRUD (w sumie 15 endpointów). Kontrolery mogą bazować na listach zamiast baz danych. CRUD: showAll, showById (get), update (put), delete (delete), add (post).

@Singleton
class TodoListController @Inject() (
    val controllerComponents: ControllerComponents
) extends BaseController {

  private val todoList = new mutable.ListBuffer[TodoListItem]()
  todoList += TodoListItem(1, "jakas wartosc testowa1", true)
  todoList += TodoListItem(2, "jakas wartosc testowa2", false)

  implicit val todoListJson = Json.format[TodoListItem]
  implicit val newTodoListJson = Json.format[NewTodoListItem]

  // curl localhost:9000/todo -> GET
  def showAll(): Action[AnyContent] = Action {
    if (todoList.isEmpty) NoContent else Ok(Json.toJson(todoList))
  }

  // curl localhost:9000/todo/1 -> GET
  def showById(itemId: Long) = Action {
    val foundItem = todoList.find(_.id == itemId)
    foundItem match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound
    }
  }

  // curl -X PUT localhost:9000/todo/done/1 -> PUT
  def markAsDone(itemId: Long) = Action {
    val foundItem = todoList.find(_.id == itemId)
    foundItem match {
      case Some(item) =>
        val newItem = item.copy(isItDone = true)
        todoList.dropWhileInPlace(_.id == itemId)
        todoList += newItem
        Accepted(Json.toJson(newItem))
      case None => NotFound
    }
  }

  // curl -X DELETE localhost:9000/todo/done ->DELETE
  def deleteAllDone() = Action {
    todoList.filterInPlace(_.isItDone == false)
    Accepted
  }

   // curl -X DELETE localhost:9000/todo/1 ->DELETE
  def delete(itemId: Long) = Action {
    todoList.filterInPlace(_.id != itemId)
    Accepted
  }

  // curl -v -d '{"description": "some new item"}' -H 'Content-Type: application/json' -X POST localhost:9000/todo
  def addNewItem() = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val todoListItem: Option[NewTodoListItem] = jsonObject.flatMap(Json.fromJson[NewTodoListItem](_).asOpt)
    todoListItem match {
    case Some(newItem) =>
      val nextId = todoList.map(_.id).max + 1
      val toBeAdded = TodoListItem(nextId, newItem.description, false)
      todoList += toBeAdded
      Created(Json.toJson(toBeAdded))
    case None =>
      BadRequest
  }
    //Ok("contact saved") // or if you want to render a templated: Ok(someTemplate())
  }
}
