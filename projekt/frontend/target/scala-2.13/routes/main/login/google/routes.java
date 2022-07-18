// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package login.google;

import router.RoutesPrefix;

public class routes {
  
  public static final login.google.ReverseGoogleRun GoogleRun = new login.google.ReverseGoogleRun(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final login.google.javascript.ReverseGoogleRun GoogleRun = new login.google.javascript.ReverseGoogleRun(RoutesPrefix.byNamePrefix());
  }

}
