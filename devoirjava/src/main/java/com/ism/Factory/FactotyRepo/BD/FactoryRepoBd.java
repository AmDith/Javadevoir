package com.ism.Factory.FactotyRepo.BD;

import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.BD.ClientRepoBd;
import com.ism.Repositories.BD.UserRepoBd;

public class FactoryRepoBd {
  private FactoryRepoBd(){

  }

  private static ClientRepoBd clientService = null ;
  private static UserRepoBd userService = null ;


  


public static ClientRepoBd getInstanceC(UserRepoListInt uRepo){
  if (clientService == null) {
    clientService = new ClientRepoBd(uRepo);
    }
    return clientService;
}


public static UserRepoBd getInstanceU() {
  if (userService == null) {
    userService = new UserRepoBd();
    }
    return userService;
}
}

