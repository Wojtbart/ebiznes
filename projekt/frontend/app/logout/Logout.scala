package logout

import play.api.Configuration
import play.api.libs.json.Json
import play.api.mvc._
import sttp.model.Uri

import javax.inject.{Inject, Singleton}

@Singleton //jedna instancja
class Logout @Inject()(controllerComponents: ControllerComponents, configuration: Configuration) extends AbstractController(controllerComponents) {

  val apiUri: String = configuration.get[String]("api.uri")

  def logoutController: Action[AnyContent] = Action { request =>
    val baseUri =
      if (request.secure)
        Uri.unsafeParse("https://" + request.host + "/logoutCallback")
      else
        Uri.unsafeParse("http://" + request.host + "/logoutCallback")

    request.session
      .get("token")
      .foreach { token =>
        login.SessionController.delete(token)
      }
    Accepted(Json.toJson(baseUri.toString()))
      // Ok (Json.toJson("")).discardingCookies(
      //   DiscardingCookie("PLAY_SESSION"),
      //   DiscardingCookie("username"),
      //   DiscardingCookie("email")).withNewSession
  }

  def logoutCallback: Action[AnyContent] = Action {
    Redirect(apiUri).withHeaders("Location" -> apiUri)
  }
}