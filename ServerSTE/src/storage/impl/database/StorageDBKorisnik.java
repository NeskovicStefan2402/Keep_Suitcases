/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import dbConnection.DBConnection;
import domain.Korisnik;
import domain.Radnik;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class StorageDBKorisnik implements storage.storageKorisnik{

    @Override
    public List<Korisnik> getAll() throws Exception {
        String upit="SELECT idKlijenta,ime,prezime,JMBG,kontaktBroj,idRadnika FROM klijent";
        List<Korisnik> korisnici=new ArrayList<>();
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Korisnik korisnik = new Korisnik();
                korisnik.setIdKorisnika(rs.getLong("idKlijenta"));
                korisnik.setIdRadnika(rs.getLong("idRadnika"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setJMBG(rs.getString("JMBG"));
                korisnik.setKontaktBroj(rs.getString("kontaktBroj"));
                korisnici.add(korisnik);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Korisnika!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracena lista Korisnika!\n"+ex.getMessage());
        }
        return korisnici;
    }

    @Override
    public Korisnik insert(Korisnik korisnik) throws Exception {
        try {
            String upit="INSERT INTO klijent (ime, prezime, kontaktBroj, idRadnika, JMBG) VALUES (?,?,?,?,?)";
            PreparedStatement statement=DBConnection.getInstance().getConnection().prepareStatement(upit);
            statement.setString(1, korisnik.getIme());
            statement.setString(2, korisnik.getPrezime());
            statement.setString(3, korisnik.getKontaktBroj());
            statement.setLong(4, korisnik.getIdRadnika());
            statement.setString(5, korisnik.getJMBG());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreiran Korisnik u bazi!");
            DBConnection.getInstance().getConnection().commit();
            return korisnik;
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja Korisnika u bazi!\n");
        }
    }

    @Override
    public Korisnik getKorisnik(Long id) throws Exception {
        String upit="SELECT idKlijenta,ime,prezime,JMBG,kontaktBroj,idRadnika FROM klijent WHERE idKlijenta="+id;
        Korisnik korisnik =null;
        try {
            Statement statement=DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                korisnik = new Korisnik();
                korisnik.setIdKorisnika(rs.getLong("idKlijenta"));
                korisnik.setIdRadnika(rs.getLong("idRadnika"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setJMBG(rs.getString("JMBG"));
                korisnik.setKontaktBroj(rs.getString("kontaktBroj"));
            }
            rs.close();
            statement.close();
            System.out.println("Uspesan SELECT Korisnika!");
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnection.getInstance().getConnection().rollback();
            throw new Exception("Neuspesno vracen Korisnik!\n"+ex.getMessage());
        }
        return korisnik;
    }

    
    
    
}
