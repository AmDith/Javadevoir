package com.ism.entities;

import java.time.LocalDate;
import java.time.LocalTime;


import lombok.Data;

@ Data
public class RV {
  private int id;
  private LocalDate date;
  private LocalTime heure;
  private Medecin medecin;
  private static int nbreR;

 
  public RV() {
    id = ++nbreR;
  }

  public static void setNbreR(int n){
  RV.nbreR = n;
}

public static int getNbreR() {
  return RV.nbreR;
}
}
