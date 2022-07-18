// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers.payments;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.payments.ReversePaymentsController PaymentsController = new controllers.payments.ReversePaymentsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.payments.javascript.ReversePaymentsController PaymentsController = new controllers.payments.javascript.ReversePaymentsController(RoutesPrefix.byNamePrefix());
  }

}
