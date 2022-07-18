// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:32
package login.github {

  // @LINE:32
  class ReverseGithubRun(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def githubLogin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "github/githubRedirect")
    }
  
    // @LINE:33
    def githubCallback(code:String = "", state:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "github/callback" + play.core.routing.queryString(List(if(code == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("code", code)), if(state == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("state", state)))))
    }
  
  }


}
