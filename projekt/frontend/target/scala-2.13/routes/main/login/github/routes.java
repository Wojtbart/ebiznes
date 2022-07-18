// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package login.github;

import router.RoutesPrefix;

public class routes {
  
  public static final login.github.ReverseGithubRun GithubRun = new login.github.ReverseGithubRun(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final login.github.javascript.ReverseGithubRun GithubRun = new login.github.javascript.ReverseGithubRun(RoutesPrefix.byNamePrefix());
  }

}
