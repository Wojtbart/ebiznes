// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:16
package controllers.product {

  // @LINE:16
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def delete(itemId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:16
    def showAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product")
    }
  
    // @LINE:17
    def showById(itemId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:18
    def update(itemId:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "product/update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:20
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "product")
    }
  
  }


}
