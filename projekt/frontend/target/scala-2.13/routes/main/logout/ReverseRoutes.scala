// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:44
package logout {

  // @LINE:44
  class ReverseLogout(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def logoutController(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:45
    def logoutCallback(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logoutCallback")
    }
  
  }


}
