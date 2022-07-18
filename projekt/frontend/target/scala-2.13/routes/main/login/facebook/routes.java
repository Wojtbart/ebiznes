// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package login.facebook;

import router.RoutesPrefix;

public class routes {
  
  public static final login.facebook.ReverseFacebookRun FacebookRun = new login.facebook.ReverseFacebookRun(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final login.facebook.javascript.ReverseFacebookRun FacebookRun = new login.facebook.javascript.ReverseFacebookRun(RoutesPrefix.byNamePrefix());
  }

}
