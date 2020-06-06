/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import dbConnection.DBConnection;
import domain.Racun;
import domain.StavkaRacuna;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.ServicePrtljag;

/**
 *
 * @author Stefan
 */
public class StorageDBStavkaRacuna implements storage.storageStavkaRacuna{
    ServicePrtljag servicePrtljag;

    public StorageDBStavkaRacuna() {
        servicePrtljag=new ServicePrtljag();
    }
    
    
    @Override
    public List<StavkaRacuna> getAll(Long idRacuna) throws Exception{
        String upit="SELECT idStavke,idRacuna,idPrtljaga,cena FROM stavkaracuna WHERE idRacuna="+idRacuna;
        List<StavkaRacuna> stavke=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                StavkaRacuna stavka = new StavkaRacuna();
                stavka.setCena(rs.getFloat("cena"));
                stavka.setId(rs.getLong("idStavke"));
                stavka.setPrtljag(servicePrtljag.getPrtljag(rs.getLong("idPrtljaga")));
               
                stavke.add(stavka);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Stavki!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracena lista Stavki!\n"+ex.getMessage());
        }
        return stavke;
    }

    @Override
    public StavkaRacuna insert(StavkaRacuna stavka,Long idRacuna) throws Exception {
        try {
            String upit="INSERT INTO stavkaracuna ( idRacuna,idPrtljaga,cena) VALUES (?,?,?)";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit);
            statement.setLong(1, idRacuna);
            statement.setLong(2, stavka.getPrtljag().getId());
            statement.setFloat(3, stavka.getPrtljag().getTip().getCena());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana Stavka racuna u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return stavka;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja Stavke racuna u bazi!\n");
        } 
    }
    
}
