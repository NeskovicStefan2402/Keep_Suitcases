/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import domain.Radnik;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.impl.database.StorageDBRadnik;
/**
 *
 * @author Stefan
 */
public class ServiceRadnik {
    private StorageDBRadnik storageRadnik;

    public ServiceRadnik() {
        storageRadnik=new StorageDBRadnik();
    }
    
    public List<Radnik> vratiSveRadnike(){
        try {
            return storageRadnik.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ServiceRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    public Radnik kreirajRadnika(Radnik radnik){
        try {
            return storageRadnik.insert(radnik);
        } catch (Exception ex) {
            Logger.getLogger(ServiceRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Radnik pronadjiRadnika(String username) throws Exception{
        for(Radnik r: vratiSveRadnike()){
            if(r.getKorisnickoIme().equalsIgnoreCase(username)){
                return r;
            }
        }
        return null;
    }
    
    public Radnik getRadnika(Long id) throws Exception{
        return storageRadnik.getRadnik(id);
    }
    
    
}
