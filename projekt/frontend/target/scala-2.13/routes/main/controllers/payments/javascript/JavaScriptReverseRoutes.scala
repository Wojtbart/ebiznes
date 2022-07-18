// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:23
package controllers.payments.javascript {

  // @LINE:23
  class ReversePaymentsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.payments.PaymentsController.delete",
      """
        function(itemId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "payments/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:23
    def showAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.payments.PaymentsController.showAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "payments"})
        }
      """
    )
  
    // @LINE:24
    def showById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.payments.PaymentsController.showById",
      """
        function(itemId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "payments/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:25
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.payments.PaymentsController.update",
      """
        function(itemId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "payments/update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:27
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.payments.PaymentsController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "payments"})
        }
      """
    )
  
  }


}
