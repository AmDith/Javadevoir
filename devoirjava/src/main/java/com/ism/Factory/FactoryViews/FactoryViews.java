package com.ism.Factory.FactoryViews;


import java.util.Scanner;

import com.ism.Core.Database.ArticleRepoListInt;
import com.ism.Core.Database.ClientRepoListInt;
import com.ism.Core.Database.UserRepoListInt;
import com.ism.Repositories.list.ClientRepo;
import com.ism.Repositories.list.UserRepo;
import com.ism.Service.ArticleServiceInt;
import com.ism.Service.RVServiceInt;
import com.ism.Service.UserServiceInt;
import com.ism.Views.ArticleViews;
import com.ism.Views.ClientViews;
import com.ism.Views.UserViewInt;
import com.ism.Views.UserViews;
import com.ism.entities.Article;
import com.ism.entities.Client;
import com.ism.entities.User;

public class FactoryViews {
   private FactoryViews(){

  }

  private static ArticleViews articleService = null;
  private static ClientViews clientService = null ;
  private static UserViews userService = null ;


  public static ArticleViews getInstanceA(Scanner breuhk, ArticleServiceInt<Article,ArticleRepoListInt<Article>> breuk) {
    if (articleService == null) {
      articleService = new ArticleViews(breuhk,breuk);
      }
      return articleService;
}


public static ClientViews getInstanceC(Scanner breuhk, RVServiceInt<Client,ClientRepoListInt> breuk,UserViewInt moi){
  if (clientService == null) {
    clientService = new ClientViews(breuhk,breuk,moi);
    }
    return clientService;
}




public static UserViews getInstanceU(Scanner breuhk, UserServiceInt<User,UserRepoListInt> breuk) {
  if (userService == null) {
    userService = new UserViews(breuhk,breuk);
    }
    return userService;
}
}
