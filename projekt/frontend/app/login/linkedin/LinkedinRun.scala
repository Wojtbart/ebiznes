// package login.github

// import com.ocadotechnology.sttp.oauth2.common.Scope
// import com.ocadotechnology.sttp.oauth2.{AuthorizationCodeProvider, OAuth2TokenResponse, Secret}
// import play.api.Configuration
// import play.api.libs.json.Json
// import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
// import sttp.client3.{SttpBackend, _}
// import sttp.model.Uri
// import sttp.tapir.CodecFormat.TextPlain
// import sttp.tapir._

// import javax.inject.{Inject, Singleton}

// final case class AuthorizationCode(value: String) extends AnyVal

// object AuthorizationCode {
//   implicit val endpointCodec: Codec[String, AuthorizationCode, TextPlain] =
//     Codec.string.map(AuthorizationCode(_))(_.value)
// }

// @Singleton
// class LinkedinRun @Inject()(cc: ControllerComponents, configuration: Configuration) extends AbstractController(cc) {
//   val backend: SttpBackend[Identity, Any] = HttpURLConnectionBackend()
//   val linkedinInst: Linkedin = Linkedin.instance(backend)
//   val redirectUri: String = configuration.get[String]("linkedin.redirectUri")
//   val clientId: String = configuration.get[String]("linkedin.clientId")
//   val clientSecret: String = configuration.get[String]("linkedin.clientSecret")
//   val apiUri: String = configuration.get[String]("api.uri")

// //   val authorizationCodeProvider: AuthorizationCodeProvider[Uri, Identity] = AuthorizationCodeProvider.uriInstance[Identity](
// //     baseUrl = Uri.unsafeParse("https://github.com/"),
// //     redirectUri = Uri.unsafeParse(s"${redirectUri}"),
// //     clientId = clientId,
// //     clientSecret = Secret(clientSecret),
// //     pathsConfig = AuthorizationCodeProvider.Config.GitHub)(backend)

//   def githubLogin(): Action[AnyContent] = Action {
//     // val scopes = Set(Scope("read:user"), Scope("user:email"))
//     // val uri = authorizationCodeProvider.loginLink(scope = scopes)
//     // Accepted(Json.toJson(uri.toString()))
//   }

//   def githubCallback(code: String, state: String): Action[AnyContent] = Action {
//     // val authCode = AuthorizationCode(code)
//     // val token = authorizationCodeProvider.authCodeToToken[OAuth2TokenResponse](authCode.value)
//     // val userInfo = githubInst.userInfo(token.accessToken)

//     // val session  = login.SessionController.add(userInfo.email)
//     // Redirect(apiUri + "login?username=" + userInfo.login  + "&token=" + session.token)
//   }
// }