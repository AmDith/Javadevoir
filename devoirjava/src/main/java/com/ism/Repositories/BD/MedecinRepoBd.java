package com.ism.Repositories.BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ism.Core.Database.MedecinRepoListInt;
import com.ism.Core.Database.Impl.RepositoryImplBd;
import com.ism.entities.Medecin;

public class MedecinRepoBd extends RepositoryImplBd<Medecin> implements MedecinRepoListInt {


    private Medecin medecin = null;
    private List<Medecin> medecins = new ArrayList<>();

    public MedecinRepoBd() {
    }
    


@Override
  public int insert(Medecin medecin2) {
      String query = generateSql("INSERT INTO `client` (`name`, `tel`, `adresse`, `idUser`) VALUES (?, ?, ?, ?)");
      try{
          conn = connexion();
          init(query);  
          return stmtfields(medecin,query);
      } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver: " + e.getMessage());
      } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD: " + e.getMessage());
      }finally{
        try {
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      return 0;
  }


@Override
public List<Medecin> selectAll() {
    String query =generateSql("SELECT m.* FROM medecin m");
    
    try {
        conn = connexion();  
        init(query);
        try (ResultSet rs = this.executeQuery()) {
            while (rs.next()) {
                medecin = new Medecin();
                medecin = setfields(rs,medecin);
                medecins.add(medecin);
            }
      }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
    }
    return medecins;
 }



@Override
public Medecin setfields(ResultSet rs, Medecin amour) throws SQLException {
   amour.setId(rs.getInt("id"));
    amour.setNom(rs.getString("nom"));
    amour.setPrenom(rs.getString("prenom"));
    amour.setNbreM(amour.getNbreM() - 1);
    return amour;
}



@Override
public int stmtfields(Medecin amour, String query) throws SQLException {
    try {
        init(query);
        stmt.setString(1, amour.getNom());
        stmt.setString(2, amour.getPrenom());
        return this.executeUpdate();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return 0;
}




























  
}
