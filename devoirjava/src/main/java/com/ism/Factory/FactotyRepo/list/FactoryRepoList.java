package com.ism.Factory.FactotyRepo.list;

import com.ism.Repositories.list.ArticleRepo;
import com.ism.Repositories.list.ClientRepo;
import com.ism.Repositories.list.DetteRepo;
import com.ism.Repositories.list.UserRepo;

public class FactoryRepoList {
  private FactoryRepoList(){

  }

  private static ArticleRepo articleService = null;
  private static ClientRepo clientService = null ;
  private static DetteRepo detteService = null;
  private static UserRepo userService = null ;


  public static ArticleRepo getInstanceA() {
    if (articleService == null) {
      articleService = new ArticleRepo();
      }
      return articleService;
}


public static ClientRepo getInstanceC(){
  if (clientService == null) {
    clientService = new ClientRepo();
    }
    return clientService;
}

public static DetteRepo getInstanceD() {
  if (detteService == null) {
    detteService = new DetteRepo();
    }
    return detteService;
}


public static UserRepo getInstanceU() {
  if (userService == null) {
    userService = new UserRepo();
    }
    return userService;
}
}
