// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:44
package logout.javascript {

  // @LINE:44
  class ReverseLogout(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def logoutController: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "logout.Logout.logoutController",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:45
    def logoutCallback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "logout.Logout.logoutCallback",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logoutCallback"})
        }
      """
    )
  
  }


}
