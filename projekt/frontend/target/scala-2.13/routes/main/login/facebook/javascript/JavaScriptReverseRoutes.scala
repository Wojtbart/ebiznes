// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:35
package login.facebook.javascript {

  // @LINE:35
  class ReverseFacebookRun(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def facebookLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "login.facebook.FacebookRun.facebookLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facebook/facebookRedirect"})
        }
      """
    )
  
    // @LINE:36
    def facebookCallback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "login.facebook.FacebookRun.facebookCallback",
      """
        function(code0,state1,error2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facebook/callback" + _qS([(code0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("code", code0)), (state1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("state", state1)), (error2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("error", error2))])})
        }
      """
    )
  
  }


}
