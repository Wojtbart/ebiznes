// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.shoppingCart.javascript {

  // @LINE:8
  class ReverseShoppingCartController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.shoppingCart.ShoppingCartController.delete",
      """
        function(itemId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "shoppingCart/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:10
    def getByUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.shoppingCart.ShoppingCartController.getByUser",
      """
        function(token0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shoppingCart/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("token", token0))})
        }
      """
    )
  
    // @LINE:8
    def showAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.shoppingCart.ShoppingCartController.showAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shoppingCart"})
        }
      """
    )
  
    // @LINE:11
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.shoppingCart.ShoppingCartController.update",
      """
        function(itemId0,token1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "shoppingCart/update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0)) + "/token" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("token", token1)])})
        }
      """
    )
  
    // @LINE:9
    def showById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.shoppingCart.ShoppingCartController.showById",
      """
        function(itemId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shoppingCart/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:14
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.shoppingCart.ShoppingCartController.add",
      """
        function(token0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shoppingCart/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("token", token0))})
        }
      """
    )
  
  }


}
