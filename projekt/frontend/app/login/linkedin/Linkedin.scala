

// // // https://blog.knoldus.com/providing-a-sign-in-with-linkedin-functionality-using-scala/


// // package login.linkedin

// // import cats.implicits._
// // import com.ocadotechnology.sttp.oauth2.Secret
// // import io.circe.generic.auto._
// // import play.api.libs.json.{Json, OFormat}
// // import sttp.client3._
// // import sttp.client3.circe.asJson
// // import sttp.model.Header

// // trait Linkedin {
// //   def userInfo(accessToken: Secret[String]): UserInfoWithMail
// // }

// // final case class UserInfo(id: Int,login: String)

// // final case class Mail( email: String)

// // final case class UserInfoWithMail(id: Int,login: String,email: String)

// // object Linkedin {
// //   implicit val userInfoFormat: OFormat[UserInfo] = Json.format[UserInfo]
// //   implicit val mailFormat: OFormat[Mail] = Json.format[Mail]
// //   implicit val userInfoWithMailFormat: OFormat[UserInfoWithMail] = Json.format[UserInfoWithMail]

// //   val baseUri = uri"https://api.linkedin.com/v2/me"

// //   def instance(backend: SttpBackend[Identity, Any]): Github = (accessToken: Secret[String]) => {
// //     val header = Header("Content-type", "Content-Type: application/x-www-form-urlencoded")
// //     val header2 = Header("Authorization", s"token ${accessToken.value}")
// //     val user = basicRequest
// //       .get(baseUri.withPath("user"))
// //       .headers(header, header2)
// //       .response(asJson[UserInfo])
// //       .send(backend)
// //       .map { response =>
// //         response.body match {
// //           case Right(t) => {
// //             t
// //           }
// //           case Left(e) => throw e
// //         }
// //       }

// //     val mail = basicRequest
// //       .get(baseUri.withPath("user", "emails"))
// //       .headers(header, header2)
// //       .response(asJson[Array[Mail]])
// //       .send(backend)
// //       .map { response =>
// //         response.body match {
// //           case Right(t) => {
// //             t
// //           }
// //           case Left(e) => throw e
// //         }
// //       }

// //     UserInfoWithMail(user.id, user.login, mail.head.email)
// //   }
// // }

// package controllers

// import play.api.mvc.Controller
// import org.scribe.builder.ServiceBuilder
// import org.scribe.oauth.OAuthService
// import org.scribe.builder.api.LinkedInApi
// import org.scribe.model.Token
// import play.api.mvc.Action
// import org.scribe.model.Verifier
// import org.scribe.model.OAuthRequest
// import org.scribe.model.Verb
// import org.scribe.model.Response
// import scala.xml.XML
// import play.api.Logger
// import play.api.Play
// import play.api.i18n.Messages

// object LinkedInController extends Controller {
// val apiKey: String = Play.current.configuration.getString("linkedin.key").get
// val apiSecret: String = Play.current.configuration.getString("linkedin.secret").get
// var requestToken: Token = null
// val currentUserId = "userId"
// val protectedResourceUrl: String = "http://api.linkedin.com/v1/people/~:(id,first-name,last-name,email-address,headline,picture-url,industry,positions:(id,title,summary,start-date,end-date,is-current,company:(id,name,type,size,industry,ticker)))";

// /**
// * Get OAuthService Request
// */
// def getOAuthService: OAuthService = {
// // val service: OAuthService = new ServiceBuilder()
// // .provider(classOf[LinkedInApi])
// // .apiKey(apiKey)
// // .apiSecret(apiSecret)
// // .scope("r_fullprofile")
// // .scope("r_emailaddress")
// // .callback("http://" + getContextUrl + "/linkedin/callback")
// // .build();
// // service
// }

// /**
// * To get The root context from application.config
// */
// def getContextUrl: String = {
// // Play.current.configuration.getString("contextUrl").get
// }

// def linkedinLogin: Action[play.api.mvc.AnyContent] = Action {
// // try {
// // requestToken = getOAuthService.getRequestToken
// // val authUrl: String = getOAuthService.getAuthorizationUrl(requestToken)
// // Redirect(authUrl)
// // } catch {
// // case ex : Throwable=> {
// // Logger.error("Error During Login Through LinkedIn - " + ex)
// // Ok(views.html.RedirectMain("", "failure"))
// // }
// // }
// }

// def linkedinCallback: Action[play.api.mvc.AnyContent] = Action { implicit request =>
// // try {
// // getVerifier(request.queryString) match {
// // case None => Ok(views.html.RedirectMain("", "failure"))
// // case Some(oauth_verifier) =>
// // val verifier: Verifier = new Verifier(oauth_verifier)
// // val accessToken: Token = getOAuthService.getAccessToken(requestToken, verifier);
// // val oAuthRequest: OAuthRequest = new OAuthRequest(Verb.GET, protectedResourceUrl)
// // getOAuthService.signRequest(accessToken, oAuthRequest)
// // val response: Response = oAuthRequest.send
// // response.getCode match {
// // case 200 =>
// // val linkedinXML = scala.xml.XML.loadString(response.getBody)
// // val userEmailId = (linkedinXML \\ "email-address").text.trim
// // val userNetwokId = (linkedinXML \\ "id").text.trim
// // val userName = (linkedinXML \\ "first-name").text.trim +" " +(linkedinXML \\ "last-name").text.trim
// // val userSession = request.session + ("userId" -> userEmailId)
// // Ok(views.html.RedirectMain(userEmailId, "success")).withSession(userSession)
// // case _ =>
// // Logger.error("Error " + response.getCode + " : During Login Through LinkedIn - " + response.getBody)
// // Ok(views.html.RedirectMain("", "failure"))
// // }
// // }
// // } catch {
// // case ex: Throwable => {
// // Logger.error("Error During Login Through LinkedIn - " + ex)
// // Ok(views.html.RedirectMain("", "failure"))
// // }
// // }
// }
// def getVerifier(queryString: Map[String, Seq[String]]): Option[String] = {
// // val seq = queryString.get("oauth_verifier").getOrElse(Seq())
// // seq.isEmpty match {
// // case true => None
// // case false => seq.headOption
// // }
// }
// }