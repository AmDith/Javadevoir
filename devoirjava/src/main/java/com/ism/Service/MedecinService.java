package com.ism.Service;


import java.util.List;

import com.ism.Core.Database.MedecinRepoListInt;
import com.ism.entities.Medecin;

import lombok.Data;

@Data

public class MedecinService implements MedecinServiceInt<Medecin,MedecinRepoListInt>{

  private MedecinRepoListInt mserRepo;

  
  public MedecinService(MedecinRepoListInt mserRepo) {
    this.mserRepo = mserRepo;
  }


  @Override
  public boolean saveList(Medecin objet) {
    if(objet != null){
      mserRepo.insert(objet);
      return true;
    }
    return false;
  }


  @Override
  public List<Medecin> show() {
    return mserRepo.selectAll();
  }



  @Override
  public MedecinRepoListInt findData() {
    return mserRepo;
  }


  


  


  


  
  
  
}
