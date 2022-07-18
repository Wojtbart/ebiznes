// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:23
package controllers.payments {

  // @LINE:23
  class ReversePaymentsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def delete(itemId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "payments/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:23
    def showAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payments")
    }
  
    // @LINE:24
    def showById(itemId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payments/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:25
    def update(itemId:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "payments/update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:27
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "payments")
    }
  
  }


}
