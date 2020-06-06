/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Korisnik;
import domain.Prijemnica;
import domain.Prtljag;
import domain.Racun;
import domain.Radnik;
import domain.TipPrtljaga;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceKorisnik;
import service.ServicePrijemnica;
import service.ServicePrtljag;
import service.ServiceRacun;
import storage.impl.database.StorageDBRadnik;
import storage.storageRadnik;
import service.ServiceRadnik;
import service.ServiceTipPrtljaga;

/**
 *
 * @author Stefan
 */
public class Controller {
    private static Controller instance;
    private ServiceRadnik serviceRadnik;
    private ServiceKorisnik serviceKorisnik;
    private ServicePrtljag servicePrtljag;
    private ServiceTipPrtljaga serviceTipPrtljaga;
    private ServicePrijemnica servicePrijemnica;
    private ServiceRacun serviceRacun;
    
    private Controller() {
          serviceRadnik=new ServiceRadnik();
          serviceKorisnik=new ServiceKorisnik();
          servicePrtljag=new ServicePrtljag();
          serviceTipPrtljaga=new ServiceTipPrtljaga();
          servicePrijemnica=new ServicePrijemnica();
          serviceRacun = new ServiceRacun();

    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    public Radnik prijavaRadnika(String korisnicko, String sifra) throws Exception{
        Radnik r=serviceRadnik.pronadjiRadnika(korisnicko);
        if(r!=null){
            if(r.getSifra().equals(sifra)){
                return r;
            }else{
                throw new Exception("Pogresna lozinka!");
            }
        }else{
            throw new Exception("Uneti korisnik se ne nalazi u bazi!");
        }
    }
    public Radnik kreirajRadnika(Radnik radnik) {
        
        try {
            if(serviceRadnik.pronadjiRadnika(radnik.getKorisnickoIme())==null){
                serviceRadnik.kreirajRadnika(radnik);
                return radnik;
            }else{
                throw new Exception("Korisnik sa unetim korisnickim imenom vec postoji u bazi!");
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Korisnik kreirajKorisnika(Korisnik korisnik) {
        try {
            if(serviceKorisnik.pronadjiKorisnika(korisnik.getJMBG())==null){
                serviceKorisnik.kreirajKorisnika(korisnik);
                return korisnik;
            }else{
                throw new Exception("Korisnik sa unetim korisnickim imenom vec postoji u bazi!");
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Korisnik> vratiKorisnike(){
        return serviceKorisnik.vratiSveKorisnike();
    }
    public List<TipPrtljaga> vratiTipPrtljaga(){
        return serviceTipPrtljaga.vratiTipove();
    }
    public List<Prtljag> vratiPrtljage(Radnik radnik) {
        try {
            return servicePrtljag.getAll(radnik);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Prijemnica> vratiTrenutnoStanjePrijemnica(){
        try {
            ArrayList<Prijemnica> all=(ArrayList<Prijemnica>) servicePrijemnica.vratiPrijemnice();
            ArrayList<Prijemnica> stanje=new ArrayList<>();
            for(Prijemnica p:all){
                if(p.isPreuzeto()==false)
                    stanje.add(p);
            }
            return stanje;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    public List<Prijemnica> vratiPreuzetePrijemnice(){
        
        try {
            ArrayList<Prijemnica> all=(ArrayList<Prijemnica>) servicePrijemnica.vratiPrijemnice();
            ArrayList<Prijemnica> preuzete=new ArrayList<>();
            for(Prijemnica p:all){
                if(p.isPreuzeto()==true)
                    preuzete.add(p);
            }
            return preuzete;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    public Prtljag dodajPrtljag(Prtljag prtljag){
        Prtljag prt=null;
        try {
            prt= servicePrtljag.insert(prtljag);
            return prt;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prt;
    }
    
    public Racun dodajRacun(Racun racun){
        Racun rez=null;
        try {
            System.out.println("Controller: "+racun.getRadnik().getIdRadnik());
            rez = serviceRacun.dodajRacun(racun);
            return rez;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rez;
    }
    public List<Racun> vratiTrenutnoStanje(){
        List<Racun> all =serviceRacun.vratiSveRacune();
        List<Racun> stanje = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getPreuzetoVreme()==null){
                stanje.add(all.get(i));
            }
        }
        return stanje;
    }
    public List<Racun> vratiIstoriju(){
        List<Racun> all =serviceRacun.vratiSveRacune();
        List<Racun> istorija = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getPreuzetoVreme()!=null){
                istorija.add(all.get(i));
            }
        }
        return istorija;
    }
//    public User logIn(String username, String password) throws Exception{
//        List<User> users=storageUser.getAll();
//        for (User user : users) {
//            if(user.getUsername().equalsIgnoreCase(username)){
//                if(user.getPassword().equals(password)){
//                    return user;
//                }else{
//                    throw new Exception("Lozinka nije odgovarajuća!");
//                }
//            }
//        }
//        throw new Exception("Korisnik nije registrovan!");
//    }
//    
//    public List<Manufacturer> getAllManufacturers() throws Exception{
//        //return storageManufacturer.getAll();
//        return serviceManufacturer.getAll();
//    }
//    
//    public void saveProduct(Product product) throws Exception{
//        storageProduct.insert(product);
//        
//    }
//    
//    public List<Product> getAllProducts() throws Exception{
//        return storageProduct.getAll();
//    }
//    
//    public Invoice saveInvoice(Invoice invoice) throws Exception{
//        return serviceInvoice.save(invoice);
//    }

    
    
    
    
    
}
