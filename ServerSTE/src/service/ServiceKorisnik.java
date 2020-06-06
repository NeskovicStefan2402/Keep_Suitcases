/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Korisnik;
import domain.Radnik;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.impl.database.StorageDBKorisnik;
import storage.impl.database.StorageDBRadnik;

/**
 *
 * @author Stefan
 */
public class ServiceKorisnik {
    private StorageDBKorisnik storageKorisnik;

    public ServiceKorisnik() {
        storageKorisnik=new StorageDBKorisnik();
    }
    
    public List<Korisnik> vratiSveKorisnike(){
        try {
            return storageKorisnik.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ServiceRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    public Korisnik kreirajKorisnika(Korisnik korisnik){
        try {
            return storageKorisnik.insert(korisnik);
        } catch (Exception ex) {
            Logger.getLogger(ServiceRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Korisnik pronadjiKorisnika(String jmbg) throws Exception{
        for(Korisnik k: vratiSveKorisnike()){
            if(k.getJMBG().equalsIgnoreCase(jmbg)){
                return k;
            }
        }
        return null;
    }
    
    public Korisnik getKorisnik(Long id) throws Exception{
        return storageKorisnik.getKorisnik(id);
    }
    
}
