// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:32
package login.github.javascript {

  // @LINE:32
  class ReverseGithubRun(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def githubLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "login.github.GithubRun.githubLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/githubRedirect"})
        }
      """
    )
  
    // @LINE:33
    def githubCallback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "login.github.GithubRun.githubCallback",
      """
        function(code0,state1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/callback" + _qS([(code0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("code", code0)), (state1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("state", state1))])})
        }
      """
    )
  
  }


}
