// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:16
package controllers.product.javascript {

  // @LINE:16
  class ReverseProductController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.product.ProductController.delete",
      """
        function(itemId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:16
    def showAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.product.ProductController.showAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product"})
        }
      """
    )
  
    // @LINE:17
    def showById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.product.ProductController.showById",
      """
        function(itemId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:18
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.product.ProductController.update",
      """
        function(itemId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "product/update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:20
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.product.ProductController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product"})
        }
      """
    )
  
  }


}
