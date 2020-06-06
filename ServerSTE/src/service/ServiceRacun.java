package service;


import domain.Racun;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.impl.database.StorageDBRacun;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stefan
 */
public class ServiceRacun {
    StorageDBRacun storageDBRacun;
    
    public ServiceRacun() {
        storageDBRacun=new StorageDBRacun();
    }
    
    public List<Racun> vratiSveRacune(){
        List<Racun> racuni =null;
        try {
            racuni = storageDBRacun.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ServiceRacun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return racuni;
    }

    public Racun dodajRacun(Racun racun) {
        try {
            return storageDBRacun.insert(racun);
        } catch (Exception ex) {
            Logger.getLogger(ServiceRacun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
