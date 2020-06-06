/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import dbConnection.DBConnection;
import domain.Prtljag;
import domain.Radnik;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.ServiceTipPrtljaga;

/**
 *
 * @author Stefan
 */
public class StorageDBPrtljag implements storage.storagePrtljag{
    private ServiceTipPrtljaga serviceTipPrtljaga;

    public StorageDBPrtljag() {
        serviceTipPrtljaga=new ServiceTipPrtljaga();
    }
    
    @Override
    public List<Prtljag> getAll(Radnik radnik) throws Exception {
        String upit="SELECT idPrtljaga,tezina,idRadnika,idTipa FROM prtljag";
        List<Prtljag> prtljazi=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Prtljag prtljag = new Prtljag();
                prtljag.setTip(serviceTipPrtljaga.getTip(rs.getLong("idTipa")));
                prtljag.setTezina(rs.getFloat("tezina"));
                prtljag.setId(rs.getLong("idPrtljaga"));
                prtljag.setRadnik(radnik);
                prtljazi.add(prtljag);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Prtljaga!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracena lista Prtljaga!\n"+ex.getMessage());
        }
        return prtljazi;
    }

    @Override
    public Prtljag insert(Prtljag prtljag) throws Exception {
        try {
            String upit="INSERT INTO prtljag (tezina, lomljivost, idTipa, idRadnika) VALUES (?,?,?,?)";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit);
            statement.setDouble(1, prtljag.getTezina());
            statement.setBoolean(2, prtljag.isLomljivost());
            statement.setLong(3, prtljag.getTip().getId());
            statement.setLong(4, prtljag.getRadnik().getIdRadnik());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreiran Prtljag u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return prtljag;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja Prtljaga u bazi!\n");
        }
    }

    @Override
    public Prtljag getPrtljag(Long id) throws Exception {
        String upit="SELECT idPrtljaga,tezina,idRadnika,idTipa FROM prtljag WHERE idPrtljaga="+id;
        Prtljag prtljag=null;
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                prtljag = new Prtljag();
                prtljag.setTip(serviceTipPrtljaga.getTip(rs.getLong("idTipa")));
                prtljag.setTezina(rs.getFloat("tezina"));
                prtljag.setId(rs.getLong("idPrtljaga"));
//                prtljag.setRadnik(radnik);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Prtljaga!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracen Prtljag!\n"+ex.getMessage());
        }
        return prtljag;
    }
    
}
