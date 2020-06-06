/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import dbConnection.DBConnection;
import domain.Prijemnica;
import domain.Racun;
import domain.StavkaRacuna;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.ServiceKorisnik;
import service.ServicePrtljag;
import service.ServiceRadnik;

/**
 *
 * @author Stefan
 */
public class StorageDBRacun implements storage.storageRacun{
    ServiceRadnik serviceRadnik;
    ServicePrtljag servicePrtljag;
    ServiceKorisnik serviceKorisnik;
    StorageDBStavkaRacuna storageDBStavkaRacuna;

    public StorageDBRacun() {
        serviceKorisnik=new ServiceKorisnik();
        serviceRadnik=new ServiceRadnik();
        servicePrtljag=new ServicePrtljag();
        storageDBStavkaRacuna=new StorageDBStavkaRacuna();
    }
    
    @Override
    public List<Racun> getAll() throws Exception {
        String upit="SELECT id,idRadnika,idKlijenta,predatoVreme,preuzetoVreme FROM racun";
        List<Racun> racuni=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Racun racun = new Racun();
                racun.setIdRacuna(rs.getLong("id"));
                racun.setKlijent(serviceKorisnik.getKorisnik(rs.getLong("idKlijenta")));
                racun.setRadnik(serviceRadnik.getRadnika(rs.getLong("idRadnika")));
                racun.setPredatoVreme(rs.getDate("predatoVreme"));
                racun.setPreuzetoVreme(rs.getDate("preuzetoVreme"));
                List<StavkaRacuna> stavke=new ArrayList<>();
                stavke=storageDBStavkaRacuna.getAll(rs.getLong("id"));
                racun.setStavke(stavke);
                
                racuni.add(racun);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Racuna!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracena lista Racuna!\n"+ex.getMessage());
        }
        return racuni;
    }
    
    @Override
    public Racun insert(Racun racun) throws Exception {
        System.out.println("Storage: "+racun.getRadnik().getIdRadnik());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            String upit="INSERT INTO racun (idRadnika,idKlijenta,predatoVreme) VALUES (?,?,?)";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, racun.getRadnik().getIdRadnik());
            statement.setLong(2, racun.getKlijent().getIdKorisnika());
            statement.setTimestamp(3, date);
            statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            if(rs.next()){
                Long id=rs.getLong(1);
                racun.setIdRacuna(id);
                try {
                    for(int i=0;i<racun.getStavke().size();i++){
                        storageDBStavkaRacuna.insert(racun.getStavke().get(i), racun.getIdRacuna());
                    }
                } catch (Exception e) {
                    DBConnection.getInstance().getConnection().rollback();
                }
            }
            statement.close();
            System.out.println("Uspesno kreiran Racun u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return racun;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja Racuna u bazi!\n");
        } 
    }

    @Override
    public Racun update(Racun racun) throws Exception {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            String upit="UPDATE Racun SET preuzetoVreme=? WHERE id=?";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit);
            statement.setTimestamp(1, date);
            statement.setLong(2, racun.getIdRacuna());
            statement.executeUpdate();
            
            statement.close();
            System.out.println("Uspesan update Racuna u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return racun;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom update-a Racuna u bazi!\n");
        }
    }
    
}
