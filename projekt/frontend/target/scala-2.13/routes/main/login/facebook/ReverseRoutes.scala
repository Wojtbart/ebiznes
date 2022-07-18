// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:35
package login.facebook {

  // @LINE:35
  class ReverseFacebookRun(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def facebookLogin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "facebook/facebookRedirect")
    }
  
    // @LINE:36
    def facebookCallback(code:String = "", state:String = "", error:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "facebook/callback" + play.core.routing.queryString(List(if(code == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("code", code)), if(state == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("state", state)), if(error == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("error", error)))))
    }
  
  }


}
