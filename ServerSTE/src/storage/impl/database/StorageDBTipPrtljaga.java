/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import dbConnection.DBConnection;
import domain.Radnik;
import domain.TipPrtljaga;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.storageTipPrtljaga;

/**
 *
 * @author Stefan
 */
public class StorageDBTipPrtljaga implements storageTipPrtljaga{
    
    @Override
    public List<TipPrtljaga> getAll() {
        String upit="SELECT idTipa,naziv,cena FROM tipprtljaga";
        List<TipPrtljaga> tipovi=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                TipPrtljaga tip=new TipPrtljaga();
                tip.setId(rs.getLong("idTipa"));
                tip.setNaziv(rs.getString("naziv"));
                tip.setCena(rs.getFloat("cena"));
                
                tipovi.add(tip);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT TipaPrtljaga!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                DBConnection.getInstance().getConnection().rollback();
                throw new Exception("Neuspesno vracena lista Tipova!\n"+ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(StorageDBTipPrtljaga.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (Exception ex1) {
                Logger.getLogger(StorageDBTipPrtljaga.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            Logger.getLogger(StorageDBTipPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipovi;
    }

    @Override
    public TipPrtljaga getTip(Long id) {
        String upit="SELECT idTipa,naziv,cena FROM tipprtljaga WHERE idTipa="+id;
        TipPrtljaga tip=null;
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            rs.next();
            tip=new TipPrtljaga();
            tip.setId(rs.getLong("idTipa"));
            tip.setNaziv(rs.getString("naziv"));
            tip.setCena(rs.getFloat("cena"));
            
            rs.close();
            statement.close();
            System.out.println("Uspesno pronadjen tip prtljaga!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                DBConnection.getInstance().getConnection().rollback();
                throw new Exception("Neuspesno vracena lista Tipova!\n"+ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(StorageDBTipPrtljaga.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (Exception ex1) {
                Logger.getLogger(StorageDBTipPrtljaga.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            Logger.getLogger(StorageDBTipPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tip;
    }
    
}
