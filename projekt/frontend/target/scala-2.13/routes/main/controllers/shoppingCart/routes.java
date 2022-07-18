// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers.shoppingCart;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.shoppingCart.ReverseShoppingCartController ShoppingCartController = new controllers.shoppingCart.ReverseShoppingCartController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.shoppingCart.javascript.ReverseShoppingCartController ShoppingCartController = new controllers.shoppingCart.javascript.ReverseShoppingCartController(RoutesPrefix.byNamePrefix());
  }

}
