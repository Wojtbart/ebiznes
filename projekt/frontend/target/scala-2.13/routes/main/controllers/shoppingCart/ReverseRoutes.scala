// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.shoppingCart {

  // @LINE:8
  class ReverseShoppingCartController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def delete(itemId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "shoppingCart/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:10
    def getByUser(token:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "shoppingCart/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("token", token)))
    }
  
    // @LINE:8
    def showAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "shoppingCart")
    }
  
    // @LINE:11
    def update(itemId:Long, token:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "shoppingCart/update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)) + "/token" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("token", token)))))
    }
  
    // @LINE:9
    def showById(itemId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "shoppingCart/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:14
    def add(token:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "shoppingCart/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("token", token)))
    }
  
  }


}
