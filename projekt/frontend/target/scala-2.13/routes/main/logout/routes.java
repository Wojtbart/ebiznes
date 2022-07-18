// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package logout;

import router.RoutesPrefix;

public class routes {
  
  public static final logout.ReverseLogout Logout = new logout.ReverseLogout(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final logout.javascript.ReverseLogout Logout = new logout.javascript.ReverseLogout(RoutesPrefix.byNamePrefix());
  }

}
