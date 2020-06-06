/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import domain.Radnik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dbConnection.DBConnection;
import domain.TipPrtljaga;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class StorageDBRadnik implements storage.storageRadnik{

    @Override
    public List<Radnik> getAll() throws Exception {
        String upit="SELECT idRadnika,ime,prezime,JMBG,korisnickoIme,Sifra FROM Radnik";
        List<Radnik> radnici=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Radnik radnik=new Radnik();
                radnik.setIdRadnik(rs.getLong("idRadnika"));
                radnik.setIme(rs.getString("ime"));
                radnik.setPrezime(rs.getString("prezime"));
                radnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                radnik.setJMBG(rs.getString("JMBG"));
                radnik.setSifra(rs.getString("sifra"));
     
                radnici.add(radnik);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Radnika!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracena lista Product-a!\n"+ex.getMessage());
        }
        return radnici;
    }

    @Override
    public Radnik insert(Radnik radnik) throws Exception {
        try {
            String upit="INSERT INTO Radnik (ime, prezime, korisnickoIme, sifra, JMBG) VALUES (?,?,?,?,?) ";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit);
            statement.setString(1, radnik.getIme());
            statement.setString(2, radnik.getPrezime());
            statement.setString(3, radnik.getKorisnickoIme());
            statement.setString(4, radnik.getSifra());
            statement.setString(5, radnik.getJMBG());
            statement.executeUpdate();
            statement.close();
            System.out.println("Ispesno kreiran Product u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return radnik;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja Product-a u bazi!\n");
        }
    }

    @Override
    public Radnik getRadnik(Long id) throws Exception {
        String upit="SELECT idRadnika,ime,prezime,JMBG,korisnickoIme,Sifra FROM Radnik WHERE idRadnika="+id;
        Radnik radnik=null;
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            rs.next();
            radnik=new Radnik();
            radnik.setIdRadnik(rs.getLong("idRadnika"));
            radnik.setIme(rs.getString("ime"));
            radnik.setPrezime(rs.getString("prezime"));
            radnik.setJMBG(rs.getString("JMBG"));
            radnik.setKorisnickoIme(rs.getString("korisnickoIme"));
            radnik.setSifra(rs.getString("Sifra"));
            
            rs.close();
            statement.close();
            System.out.println("Uspesno pronadjen radnik!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                DBConnection.getInstance().getConnection().rollback();
                throw new Exception("Neuspesno vracen radnik!\n"+ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(StorageDBRadnik.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (Exception ex1) {
                Logger.getLogger(StorageDBRadnik.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            Logger.getLogger(StorageDBRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return radnik;
    }
    
    
}
