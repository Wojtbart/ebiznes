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

@Singleton //wyłącznie jedna instancja
class TodoListController @Inject() (val controllerComponents: ControllerComponents) extends BaseController 
{
  private val todoList = new mutable.ListBuffer[TodoListItem]() //lista zadań 

  // dodajemy zadania do listy
  todoList += TodoListItem(1, "pójść do sklepu", true)
  todoList += TodoListItem(2, "wyrzucić śmieci", false)
  todoList += TodoListItem(3, "zrobić pranie", false)

  implicit val todoListJson = Json.format[TodoListItem]
  implicit val newTodoListJson = Json.format[NewTodoListItem]

  // POSZCZEGÓLNE METODY

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
  def update(itemId: Long) = Action {
    val foundItem = todoList.find(_.id == itemId)
    foundItem match {
      case Some(item) =>
        val newItem = item.copy(zrobione = true)
        todoList.dropWhileInPlace(_.id == itemId)
        todoList += newItem
        Accepted(Json.toJson(newItem))
      case None => NotFound
    }
  }

  // curl -X DELETE localhost:9000/todo/done ->DELETE
  def deleteAllDone() = Action {
    todoList.filterInPlace(_.zrobione == false)
    Accepted
  }

    // curl -X DELETE localhost:9000/todo/1 ->DELETE
  def delete(itemId: Long) = Action {
    todoList.filterInPlace(_.id != itemId)
    Accepted
  }

  // curl -v -d '{"opis": "some new item"}' -H 'Content-Type: application/json' -X POST localhost:9000/todo
  def add() = Action { implicit request => //POST
    val content = request.body
    val jsonObject = content.asJson

    val todoListItem: Option[NewTodoListItem] = jsonObject.flatMap(Json.fromJson[NewTodoListItem](_).asOpt)
    todoListItem match {
      case Some(newItem) =>
        val nextId = todoList.map(_.id).max + 1
        val toBeAdded = TodoListItem(nextId, newItem.opis, false)
        todoList += toBeAdded
        Created(Json.toJson(toBeAdded))
      case None =>
        BadRequest
    }
  }
}
