// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  ShoppingCartController_7: controllers.shoppingCart.ShoppingCartController,
  // @LINE:16
  ProductController_5: controllers.product.ProductController,
  // @LINE:23
  PaymentsController_4: controllers.payments.PaymentsController,
  // @LINE:29
  GoogleRun_3: login.google.GoogleRun,
  // @LINE:32
  GithubRun_1: login.github.GithubRun,
  // @LINE:35
  FacebookRun_0: login.facebook.FacebookRun,
  // @LINE:41
  DiscordRun_6: login.discord.DiscordRun,
  // @LINE:44
  Logout_2: logout.Logout,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    ShoppingCartController_7: controllers.shoppingCart.ShoppingCartController,
    // @LINE:16
    ProductController_5: controllers.product.ProductController,
    // @LINE:23
    PaymentsController_4: controllers.payments.PaymentsController,
    // @LINE:29
    GoogleRun_3: login.google.GoogleRun,
    // @LINE:32
    GithubRun_1: login.github.GithubRun,
    // @LINE:35
    FacebookRun_0: login.facebook.FacebookRun,
    // @LINE:41
    DiscordRun_6: login.discord.DiscordRun,
    // @LINE:44
    Logout_2: logout.Logout
  ) = this(errorHandler, ShoppingCartController_7, ProductController_5, PaymentsController_4, GoogleRun_3, GithubRun_1, FacebookRun_0, DiscordRun_6, Logout_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ShoppingCartController_7, ProductController_5, PaymentsController_4, GoogleRun_3, GithubRun_1, FacebookRun_0, DiscordRun_6, Logout_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoppingCart""", """controllers.shoppingCart.ShoppingCartController.showAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoppingCart/""" + "$" + """itemId<[^/]+>""", """controllers.shoppingCart.ShoppingCartController.showById(itemId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoppingCart/user/""" + "$" + """token<[^/]+>""", """controllers.shoppingCart.ShoppingCartController.getByUser(token:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoppingCart/update/""" + "$" + """itemId<[^/]+>/token""", """controllers.shoppingCart.ShoppingCartController.update(itemId:Long, token:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoppingCart/""" + "$" + """itemId<[^/]+>""", """controllers.shoppingCart.ShoppingCartController.delete(itemId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoppingCart/""" + "$" + """token<[^/]+>""", """controllers.shoppingCart.ShoppingCartController.add(token:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product""", """controllers.product.ProductController.showAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """itemId<[^/]+>""", """controllers.product.ProductController.showById(itemId:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/update/""" + "$" + """itemId<[^/]+>""", """controllers.product.ProductController.update(itemId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """itemId<[^/]+>""", """controllers.product.ProductController.delete(itemId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product""", """controllers.product.ProductController.add()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments""", """controllers.payments.PaymentsController.showAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments/""" + "$" + """itemId<[^/]+>""", """controllers.payments.PaymentsController.showById(itemId:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments/update/""" + "$" + """itemId<[^/]+>""", """controllers.payments.PaymentsController.update(itemId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments/""" + "$" + """itemId<[^/]+>""", """controllers.payments.PaymentsController.delete(itemId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments""", """controllers.payments.PaymentsController.add()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """google/googleRedirect""", """login.google.GoogleRun.googleLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """google/callback""", """login.google.GoogleRun.googleCallback(code:String ?= "", state:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """github/githubRedirect""", """login.github.GithubRun.githubLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """github/callback""", """login.github.GithubRun.githubCallback(code:String ?= "", state:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """facebook/facebookRedirect""", """login.facebook.FacebookRun.facebookLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """facebook/callback""", """login.facebook.FacebookRun.facebookCallback(code:String ?= "", state:String ?= "", error:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discord/discordRedirect""", """login.discord.DiscordRun.discordLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discord/callback""", """login.discord.DiscordRun.discordCallback(code:String ?= "", state:String ?= "", error:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """logout.Logout.logoutController()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logoutCallback""", """logout.Logout.logoutCallback()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_showAll0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoppingCart")))
  )
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_showAll0_invoker = createInvoker(
    ShoppingCartController_7.showAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.shoppingCart.ShoppingCartController",
      "showAll",
      Nil,
      "GET",
      this.prefix + """shoppingCart""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_showById1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoppingCart/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_showById1_invoker = createInvoker(
    ShoppingCartController_7.showById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.shoppingCart.ShoppingCartController",
      "showById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """shoppingCart/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_getByUser2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoppingCart/user/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_getByUser2_invoker = createInvoker(
    ShoppingCartController_7.getByUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.shoppingCart.ShoppingCartController",
      "getByUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """shoppingCart/user/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_update3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoppingCart/update/"), DynamicPart("itemId", """[^/]+""",true), StaticPart("/token")))
  )
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_update3_invoker = createInvoker(
    ShoppingCartController_7.update(fakeValue[Long], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.shoppingCart.ShoppingCartController",
      "update",
      Seq(classOf[Long], classOf[String]),
      "PUT",
      this.prefix + """shoppingCart/update/""" + "$" + """itemId<[^/]+>/token""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_delete4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoppingCart/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_delete4_invoker = createInvoker(
    ShoppingCartController_7.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.shoppingCart.ShoppingCartController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """shoppingCart/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_add5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoppingCart/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_shoppingCart_ShoppingCartController_add5_invoker = createInvoker(
    ShoppingCartController_7.add(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.shoppingCart.ShoppingCartController",
      "add",
      Seq(classOf[String]),
      "POST",
      this.prefix + """shoppingCart/""" + "$" + """token<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:16
  private[this] lazy val controllers_product_ProductController_showAll6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product")))
  )
  private[this] lazy val controllers_product_ProductController_showAll6_invoker = createInvoker(
    ProductController_5.showAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.product.ProductController",
      "showAll",
      Nil,
      "GET",
      this.prefix + """product""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_product_ProductController_showById7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_product_ProductController_showById7_invoker = createInvoker(
    ProductController_5.showById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.product.ProductController",
      "showById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """product/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_product_ProductController_update8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/update/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_product_ProductController_update8_invoker = createInvoker(
    ProductController_5.update(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.product.ProductController",
      "update",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """product/update/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_product_ProductController_delete9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_product_ProductController_delete9_invoker = createInvoker(
    ProductController_5.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.product.ProductController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """product/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_product_ProductController_add10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product")))
  )
  private[this] lazy val controllers_product_ProductController_add10_invoker = createInvoker(
    ProductController_5.add(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.product.ProductController",
      "add",
      Nil,
      "POST",
      this.prefix + """product""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_payments_PaymentsController_showAll11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments")))
  )
  private[this] lazy val controllers_payments_PaymentsController_showAll11_invoker = createInvoker(
    PaymentsController_4.showAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.payments.PaymentsController",
      "showAll",
      Nil,
      "GET",
      this.prefix + """payments""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_payments_PaymentsController_showById12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_payments_PaymentsController_showById12_invoker = createInvoker(
    PaymentsController_4.showById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.payments.PaymentsController",
      "showById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """payments/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_payments_PaymentsController_update13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments/update/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_payments_PaymentsController_update13_invoker = createInvoker(
    PaymentsController_4.update(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.payments.PaymentsController",
      "update",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """payments/update/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_payments_PaymentsController_delete14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_payments_PaymentsController_delete14_invoker = createInvoker(
    PaymentsController_4.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.payments.PaymentsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """payments/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_payments_PaymentsController_add15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments")))
  )
  private[this] lazy val controllers_payments_PaymentsController_add15_invoker = createInvoker(
    PaymentsController_4.add(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.payments.PaymentsController",
      "add",
      Nil,
      "POST",
      this.prefix + """payments""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val login_google_GoogleRun_googleLogin16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("google/googleRedirect")))
  )
  private[this] lazy val login_google_GoogleRun_googleLogin16_invoker = createInvoker(
    GoogleRun_3.googleLogin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.google.GoogleRun",
      "googleLogin",
      Nil,
      "GET",
      this.prefix + """google/googleRedirect""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val login_google_GoogleRun_googleCallback17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("google/callback")))
  )
  private[this] lazy val login_google_GoogleRun_googleCallback17_invoker = createInvoker(
    GoogleRun_3.googleCallback(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.google.GoogleRun",
      "googleCallback",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """google/callback""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val login_github_GithubRun_githubLogin18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("github/githubRedirect")))
  )
  private[this] lazy val login_github_GithubRun_githubLogin18_invoker = createInvoker(
    GithubRun_1.githubLogin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.github.GithubRun",
      "githubLogin",
      Nil,
      "GET",
      this.prefix + """github/githubRedirect""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val login_github_GithubRun_githubCallback19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("github/callback")))
  )
  private[this] lazy val login_github_GithubRun_githubCallback19_invoker = createInvoker(
    GithubRun_1.githubCallback(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.github.GithubRun",
      "githubCallback",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """github/callback""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val login_facebook_FacebookRun_facebookLogin20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("facebook/facebookRedirect")))
  )
  private[this] lazy val login_facebook_FacebookRun_facebookLogin20_invoker = createInvoker(
    FacebookRun_0.facebookLogin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.facebook.FacebookRun",
      "facebookLogin",
      Nil,
      "GET",
      this.prefix + """facebook/facebookRedirect""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val login_facebook_FacebookRun_facebookCallback21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("facebook/callback")))
  )
  private[this] lazy val login_facebook_FacebookRun_facebookCallback21_invoker = createInvoker(
    FacebookRun_0.facebookCallback(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.facebook.FacebookRun",
      "facebookCallback",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """facebook/callback""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val login_discord_DiscordRun_discordLogin22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discord/discordRedirect")))
  )
  private[this] lazy val login_discord_DiscordRun_discordLogin22_invoker = createInvoker(
    DiscordRun_6.discordLogin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.discord.DiscordRun",
      "discordLogin",
      Nil,
      "GET",
      this.prefix + """discord/discordRedirect""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val login_discord_DiscordRun_discordCallback23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discord/callback")))
  )
  private[this] lazy val login_discord_DiscordRun_discordCallback23_invoker = createInvoker(
    DiscordRun_6.discordCallback(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "login.discord.DiscordRun",
      "discordCallback",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """discord/callback""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val logout_Logout_logoutController24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val logout_Logout_logoutController24_invoker = createInvoker(
    Logout_2.logoutController(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "logout.Logout",
      "logoutController",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val logout_Logout_logoutCallback25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logoutCallback")))
  )
  private[this] lazy val logout_Logout_logoutCallback25_invoker = createInvoker(
    Logout_2.logoutCallback(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "logout.Logout",
      "logoutCallback",
      Nil,
      "GET",
      this.prefix + """logoutCallback""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_shoppingCart_ShoppingCartController_showAll0_route(params@_) =>
      call { 
        controllers_shoppingCart_ShoppingCartController_showAll0_invoker.call(ShoppingCartController_7.showAll())
      }
  
    // @LINE:9
    case controllers_shoppingCart_ShoppingCartController_showById1_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_shoppingCart_ShoppingCartController_showById1_invoker.call(ShoppingCartController_7.showById(itemId))
      }
  
    // @LINE:10
    case controllers_shoppingCart_ShoppingCartController_getByUser2_route(params@_) =>
      call(params.fromPath[String]("token", None)) { (token) =>
        controllers_shoppingCart_ShoppingCartController_getByUser2_invoker.call(ShoppingCartController_7.getByUser(token))
      }
  
    // @LINE:11
    case controllers_shoppingCart_ShoppingCartController_update3_route(params@_) =>
      call(params.fromPath[Long]("itemId", None), params.fromQuery[String]("token", None)) { (itemId, token) =>
        controllers_shoppingCart_ShoppingCartController_update3_invoker.call(ShoppingCartController_7.update(itemId, token))
      }
  
    // @LINE:12
    case controllers_shoppingCart_ShoppingCartController_delete4_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_shoppingCart_ShoppingCartController_delete4_invoker.call(ShoppingCartController_7.delete(itemId))
      }
  
    // @LINE:14
    case controllers_shoppingCart_ShoppingCartController_add5_route(params@_) =>
      call(params.fromPath[String]("token", None)) { (token) =>
        controllers_shoppingCart_ShoppingCartController_add5_invoker.call(ShoppingCartController_7.add(token))
      }
  
    // @LINE:16
    case controllers_product_ProductController_showAll6_route(params@_) =>
      call { 
        controllers_product_ProductController_showAll6_invoker.call(ProductController_5.showAll())
      }
  
    // @LINE:17
    case controllers_product_ProductController_showById7_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_product_ProductController_showById7_invoker.call(ProductController_5.showById(itemId))
      }
  
    // @LINE:18
    case controllers_product_ProductController_update8_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_product_ProductController_update8_invoker.call(ProductController_5.update(itemId))
      }
  
    // @LINE:19
    case controllers_product_ProductController_delete9_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_product_ProductController_delete9_invoker.call(ProductController_5.delete(itemId))
      }
  
    // @LINE:20
    case controllers_product_ProductController_add10_route(params@_) =>
      call { 
        controllers_product_ProductController_add10_invoker.call(ProductController_5.add())
      }
  
    // @LINE:23
    case controllers_payments_PaymentsController_showAll11_route(params@_) =>
      call { 
        controllers_payments_PaymentsController_showAll11_invoker.call(PaymentsController_4.showAll())
      }
  
    // @LINE:24
    case controllers_payments_PaymentsController_showById12_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_payments_PaymentsController_showById12_invoker.call(PaymentsController_4.showById(itemId))
      }
  
    // @LINE:25
    case controllers_payments_PaymentsController_update13_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_payments_PaymentsController_update13_invoker.call(PaymentsController_4.update(itemId))
      }
  
    // @LINE:26
    case controllers_payments_PaymentsController_delete14_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_payments_PaymentsController_delete14_invoker.call(PaymentsController_4.delete(itemId))
      }
  
    // @LINE:27
    case controllers_payments_PaymentsController_add15_route(params@_) =>
      call { 
        controllers_payments_PaymentsController_add15_invoker.call(PaymentsController_4.add())
      }
  
    // @LINE:29
    case login_google_GoogleRun_googleLogin16_route(params@_) =>
      call { 
        login_google_GoogleRun_googleLogin16_invoker.call(GoogleRun_3.googleLogin())
      }
  
    // @LINE:30
    case login_google_GoogleRun_googleCallback17_route(params@_) =>
      call(params.fromQuery[String]("code", Some("")), params.fromQuery[String]("state", Some(""))) { (code, state) =>
        login_google_GoogleRun_googleCallback17_invoker.call(GoogleRun_3.googleCallback(code, state))
      }
  
    // @LINE:32
    case login_github_GithubRun_githubLogin18_route(params@_) =>
      call { 
        login_github_GithubRun_githubLogin18_invoker.call(GithubRun_1.githubLogin())
      }
  
    // @LINE:33
    case login_github_GithubRun_githubCallback19_route(params@_) =>
      call(params.fromQuery[String]("code", Some("")), params.fromQuery[String]("state", Some(""))) { (code, state) =>
        login_github_GithubRun_githubCallback19_invoker.call(GithubRun_1.githubCallback(code, state))
      }
  
    // @LINE:35
    case login_facebook_FacebookRun_facebookLogin20_route(params@_) =>
      call { 
        login_facebook_FacebookRun_facebookLogin20_invoker.call(FacebookRun_0.facebookLogin())
      }
  
    // @LINE:36
    case login_facebook_FacebookRun_facebookCallback21_route(params@_) =>
      call(params.fromQuery[String]("code", Some("")), params.fromQuery[String]("state", Some("")), params.fromQuery[String]("error", Some(""))) { (code, state, error) =>
        login_facebook_FacebookRun_facebookCallback21_invoker.call(FacebookRun_0.facebookCallback(code, state, error))
      }
  
    // @LINE:41
    case login_discord_DiscordRun_discordLogin22_route(params@_) =>
      call { 
        login_discord_DiscordRun_discordLogin22_invoker.call(DiscordRun_6.discordLogin())
      }
  
    // @LINE:42
    case login_discord_DiscordRun_discordCallback23_route(params@_) =>
      call(params.fromQuery[String]("code", Some("")), params.fromQuery[String]("state", Some("")), params.fromQuery[String]("error", Some(""))) { (code, state, error) =>
        login_discord_DiscordRun_discordCallback23_invoker.call(DiscordRun_6.discordCallback(code, state, error))
      }
  
    // @LINE:44
    case logout_Logout_logoutController24_route(params@_) =>
      call { 
        logout_Logout_logoutController24_invoker.call(Logout_2.logoutController())
      }
  
    // @LINE:45
    case logout_Logout_logoutCallback25_route(params@_) =>
      call { 
        logout_Logout_logoutCallback25_invoker.call(Logout_2.logoutCallback())
      }
  }
}
