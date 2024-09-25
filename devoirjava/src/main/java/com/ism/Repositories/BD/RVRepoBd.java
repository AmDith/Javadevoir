package com.ism.Repositories.BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.ism.Core.Database.MedecinRepoListInt;
import com.ism.Core.Database.RVRepoListInt;
import com.ism.Core.Database.Impl.RepositoryImplBd;
import com.ism.entities.RV;
import com.mysql.cj.xdevapi.Client;

public class RVRepoBd extends RepositoryImplBd<RV>  implements RVRepoListInt{

    private List<RV> rvs = new ArrayList<>();
    private RV rv = null;
    
    private MedecinRepoListInt mRepo;

    public RVRepoBd(MedecinRepoListInt mRepo) {
        this.mRepo = mRepo;
    }

    @Override
    public int insert(RV rv2) {
        String query = generateSql("INSERT INTO `rv` (`data`, `heure`) VALUES (?, ?)");
      try {
          conn = connexion();
          return stmtfields(rv2,query);
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
    public List<RV> selectAll() {
        String query = generateSql("SELECT r.*, m.nom " +
                                "FROM rv r " +
                                "JOIN medecin m ON r.medecinId = m.id ");
        
                try {
                    conn = connexion();  
                    init(query);
                    try (ResultSet rs = this.executeQuery()) {
                        while (rs.next()) {
                            rv = new RV();
                            rv = setfields(rs,rv);
                            rvs.add(rv);
                        }
                  }
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
                }
                return rvs;
    }
    @Override
    public RV setfields(ResultSet rs, RV amour) throws SQLException {
        amour.setId(rs.getInt("id"));
        amour.setDate(LocalDate.valueOf(rs.getDate("date")));
        amour.setHeure(LocalTime.valueof(rs.getTime("heure")));
        int medecinId = rs.getInt("medecinId");
        amour.getMedecin().setId(medecinId);
        amour.setNbreR(amour.getNbreR() - 1);
        return amour;
    }
    @Override
    public int stmtfields(RV amour, String query) throws SQLException {
        try {
            init(query);
            stmt.setDate(1, amour.getDate());
            stmt.setTime(2, amour.getHeure());
            stmt.setInt(3, mRepo.insert(amour.getMedecin()));
            return this.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public RV selectByDate(String val) {
        String query = generateSql("SELECT r.*, m.nom " +
                                "FROM rv r " +
                                "JOIN medecin m ON r.medecinId = m.id "+
                                "WHERE r.date = ? ");
            try{
                conn = connexion(); 
                init(query);
                stmt.setString(1, val);
                try (ResultSet rs = this.executeQuery()) {
                if (rs.next()) {
                        rv = new RV();
                        rv = setfields(rs,rv);
                }
            }
            } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
            }finally{
                try {
                    closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return rv;
    }


}








    












  

