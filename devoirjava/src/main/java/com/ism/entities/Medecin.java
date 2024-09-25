package com.ism.entities;


import java.util.ArrayList;
import java.util.List;


import lombok.Data;


@Data
public class Medecin {
  private int id;
  private String nom;
  private String prenom;
  private List<RV> rvs = new ArrayList<>();
  private static int nbreM;

 
  public Medecin() {
    id = ++nbreM;
  }

  public static void setNbreM(int n){
  Medecin.nbreM = n;
}

public static int getNbreM() {
  return Medecin.nbreM;
}

  
}
