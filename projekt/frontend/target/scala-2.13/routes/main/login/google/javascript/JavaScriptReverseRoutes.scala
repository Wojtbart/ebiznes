// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:29
package login.google.javascript {

  // @LINE:29
  class ReverseGoogleRun(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def googleLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "login.google.GoogleRun.googleLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "google/googleRedirect"})
        }
      """
    )
  
    // @LINE:30
    def googleCallback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "login.google.GoogleRun.googleCallback",
      """
        function(code0,state1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "google/callback" + _qS([(code0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("code", code0)), (state1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("state", state1))])})
        }
      """
    )
  
  }


}
