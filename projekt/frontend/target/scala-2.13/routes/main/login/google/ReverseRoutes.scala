// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:29
package login.google {

  // @LINE:29
  class ReverseGoogleRun(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def googleLogin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "google/googleRedirect")
    }
  
    // @LINE:30
    def googleCallback(code:String = "", state:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "google/callback" + play.core.routing.queryString(List(if(code == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("code", code)), if(state == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("state", state)))))
    }
  
  }


}
