// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:41
package logout {

  // @LINE:41
  class ReverseLogout(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def logoutController(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:42
    def logoutCallback(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logoutCallback")
    }
  
  }


}
