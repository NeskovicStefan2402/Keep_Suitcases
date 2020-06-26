/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Korisnik;
import domain.Prtljag;
import domain.Racun;
import domain.Radnik;
import domain.TipPrtljaga;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import service.ServiceKorisnik;
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
    private ServiceRacun serviceRacun;
    
    private Controller() {
          serviceRadnik=new ServiceRadnik();
          serviceKorisnik=new ServiceKorisnik();
          servicePrtljag=new ServicePrtljag();
          serviceTipPrtljaga=new ServiceTipPrtljaga();
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
    public Racun odpremiRacun(Racun racun) {
        Racun rez=null;
        try {
            rez = serviceRacun.predajRacun(racun);
            return rez;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rez;
    }
    public Racun obrisiPrijemnicu(Racun racun) {
        Racun rez=null;
        try {
            rez = serviceRacun.obrisiPrijemnicu(racun);
            return rez;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rez;
    }
    
    public String stampajIzvestaj(List<Racun> racuni) {
        String response="";
        try {
            try (PDDocument document = new PDDocument()) {
                PDPage page = new PDPage();
                LocalDate datum = LocalDate.now();           
                    
                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    PDImageXObject image=PDImageXObject.createFromFile("kofer.png", document);
                    contentStream.drawImage(image, 10, 10);
                    contentStream.beginText();
                    contentStream.moveTextPositionByAmount(40, 700);
                    contentStream.setFont(PDType1Font.COURIER, 24);
                    contentStream.drawString("Izvestaj trenutnog stanja poslovanja");
                    contentStream.newLineAtOffset(0,-15);
                    contentStream.setFont(PDType1Font.COURIER, 12);
                    contentStream.newLineAtOffset(0,-45);
                    contentStream.drawString("Transakcije : ");
                    contentStream.newLineAtOffset(0,-15);
                    double suma=0;
                    for (Racun racun : racuni) {
                        String red="Racun : "+racun.getIdRacuna()+" Korisnik : "+racun.getKlijent().getIme()+" "+racun.getKlijent().getPrezime()+" Radnik : "+racun.getRadnik().getKorisnickoIme()+" Cena : "+racun.getCena();
                        contentStream.drawString(red);
                        contentStream.newLineAtOffset(0, -15);
                        suma+=racun.getCena();
                    }
                    contentStream.newLineAtOffset(0, -50);
                    contentStream.drawString("Ukupna suma zavedenih transakcija : "+Double.toString(suma)+" RSD.");
                    contentStream.newLineAtOffset(0, -15);
                    contentStream.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 14);
                    contentStream.drawString("Izvestaj kreiran : "+datum.toString());
                    contentStream.newLineAtOffset(0, -15);contentStream.newLineAtOffset(0, -15);
                    contentStream.endText();
                    contentStream.close();
                }
                document.addPage(page);
                document.save("izvestaj"+datum.toString()+".pdf");
            }
            response="Sistem je odstampao izvestaj.";
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            response="Sistem ne moze da odstampa izvestaj.";
        }
        return response;
    }

    

    
    
    
    
    
}
