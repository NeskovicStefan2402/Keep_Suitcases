/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import dbConnection.DBConnection;
import domain.Korisnik;
import domain.Prijemnica;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import service.ServiceKorisnik;
import service.ServicePrtljag;
import service.ServiceRadnik;

/**
 *
 * @author Stefan
 */
public class StorageDBPrijemnica implements storage.storagePrijemnica{
    ServiceRadnik serviceRadnik;
    ServicePrtljag servicePrtljag;
    ServiceKorisnik serviceKorisnik;

    public StorageDBPrijemnica() {
        serviceKorisnik=new ServiceKorisnik();
        serviceRadnik=new ServiceRadnik();
        servicePrtljag=new ServicePrtljag();
    }
    
    
    @Override
    public List<Prijemnica> getAll() throws Exception {
        String upit="SELECT idPrijemnice,idRadnika,idPrtljaga,idKlijenta,datum,preuzeto FROM prijemnica";
        List<Prijemnica> prijemnice=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Prijemnica prijemnica = new Prijemnica();
                prijemnica.setPreuzeto(rs.getBoolean("preuzeto"));
                prijemnica.setKlijent(serviceKorisnik.getKorisnik(rs.getLong("idKlijenta")));
                prijemnica.setDatum(rs.getDate("datum"));
                prijemnica.setPrtljag(servicePrtljag.getPrtljag(rs.getLong("idPrtljaga")));
                prijemnica.setRadnik(serviceRadnik.getRadnika(rs.getLong("idRadnika")));
                prijemnica.setIdPrijemnice(rs.getLong("idPrijemnice"));
                prijemnice.add(prijemnica);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Prijemnice!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracena lista Prijemnica!\n"+ex.getMessage());
        }
        return prijemnice;
    }

    @Override
    public Prijemnica insert(Prijemnica prijemnica) throws Exception {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            String upit="INSERT INTO prijemnica (idKlijenta, idRadnika,idPrtljaga,datum) VALUES (?,?,?,?)";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit);
            statement.setLong(1, prijemnica.getKlijent().getIdKorisnika());
            statement.setLong(2, prijemnica.getRadnik().getIdRadnik());
            statement.setLong(3, prijemnica.getPrtljag().getId());
            statement.setTimestamp(4, date);
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana Prijemnica u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return prijemnica;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja Prijemnice u bazi!\n");
        }
    }
    
}
