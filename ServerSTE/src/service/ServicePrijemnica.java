/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Prijemnica;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.impl.database.StorageDBPrijemnica;

/**
 *
 * @author Stefan
 */
public class ServicePrijemnica {
    StorageDBPrijemnica storageDBPrijemnica;

    public ServicePrijemnica() {
        storageDBPrijemnica=new StorageDBPrijemnica();
    }
    
    
    public Prijemnica dodajPrijemnicu(Prijemnica prijemnica){
        try {
            return storageDBPrijemnica.insert(prijemnica);
        } catch (Exception ex) {
            Logger.getLogger(ServicePrijemnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Prijemnica> vratiPrijemnice() throws Exception{
        return storageDBPrijemnica.getAll();
    }
}
