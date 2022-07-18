// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers.product;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.product.ReverseProductController ProductController = new controllers.product.ReverseProductController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.product.javascript.ReverseProductController ProductController = new controllers.product.javascript.ReverseProductController(RoutesPrefix.byNamePrefix());
  }

}
