/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import domain.User;
import domain.Korisnik;
import domain.Prijemnica;
import domain.Prtljag;
import domain.Racun;
import domain.Radnik;
import domain.StavkaRacuna;
import domain.TipPrtljaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

/**
 *
 * @author student1
 */
public class CommunicationController {
    private static CommunicationController instance;
    private Socket socket;
    private Racun racun;
    private List<TipPrtljaga> tipovi;
    private List<Korisnik> korisnici;
    private CommunicationController() throws IOException{
        socket=new Socket("localhost", 9000);
        racun =new Racun();
    }
    public static CommunicationController getInstance() throws IOException{
        if(instance==null){
            instance=new CommunicationController();
        }
        return instance;
    }

    
    private void sendRequest(RequestObject request) throws IOException{
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(request);
        out.flush();
    }
    
    private ResponseObject receiveResponse() throws IOException, ClassNotFoundException{
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        ResponseObject response=(ResponseObject)in.readObject();
        return response;
    }
    
    public Radnik prijaviRadnika(String username, String password) throws IOException, ClassNotFoundException, Exception {
        RequestObject request=new RequestObject();
        request.setOperation(Operation.Operacija_Prijava_Radnika);
        Map<String, String> data=new HashMap<>();
        data.put("korisnicko", username);
        data.put("sifra", password);
        request.setData(data);
        sendRequest(request);
        ResponseObject response=receiveResponse();
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Radnik)response.getData();
    }
    public Radnik kreirajRadnika(Radnik radnik) throws IOException, Exception {
        RequestObject request=new RequestObject();
        request.setOperation(Operation.Operacija_Kreiraj_Radnika);
        
        request.setData(radnik);
        sendRequest(request);
        ResponseObject response=receiveResponse();
        if(response.getException()!=null){
            throw response.getException();
        }
        return (Radnik)response.getData();
    }
    
    public Korisnik kreirajKorisnika(Korisnik korisnik) {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Kreiraj_Korisnika);
            
            request.setData(korisnik);
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (Korisnik)response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Korisnik> vratiSveKlijente() {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Vrati_Listu_Korisnika);
            
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (List<Korisnik>) response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<TipPrtljaga> vratiTipovePrtljaga() {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Vrati_Tipove_Prtljaga);
            
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (List<TipPrtljaga>) response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Korisnik getKorisnik(int id){
        int brojac=0;
        for (Korisnik k : vratiSveKlijente()) {
            if (id==brojac) {
                return k;
            }
            brojac++;
        }
        return null;
    }
    public Prtljag getPrtljag(int id,Radnik radnik){
        int brojac=0;
        for (Prtljag p : vratiSvePrtljage(radnik)) {
            if (id==brojac) {
                return p;
            }
            brojac++;
        }
        return null;
    }
    public Prtljag kreirajPrtljag(Prtljag prtljag) {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Kreiraj_Prtljag);
            
            request.setData(prtljag);
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (Prtljag)response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<TipPrtljaga> getTipovi() {
        if(tipovi==null){
            tipovi=vratiTipovePrtljaga();
        }
        return tipovi;
    }
    public List<Prtljag> vratiSvePrtljage(Radnik radnik) {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Vrati_Listu_Prtljaga);
            request.setData(radnik);
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (List<Prtljag>) response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Racun kreirajRacun() {
       try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Kreiraj_Prijemnicu);
            System.out.println("Comm: "+racun.getRadnik().getIdRadnik());
            request.setData(racun);
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (Racun)response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Racun> vratiTrenutnoStanje() {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Vrati_TrenutnoStanje);
            
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            return (List<Racun>) response.getData();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean proveriFormat(String username){
        if(username.length()>7 && brojVelikihSlova(username)>0){
            return true;
        }
        return false;
    }
    public boolean proveriFormatJMBG(String jmbg) {
        if(jmbg.length()==13 && daLiSuSviBrojevi(jmbg)){
            return true;
        }
        return false;
    }
    public boolean daLiSuSviBrojevi(String jmbg){
        for(int i=0;i<jmbg.length();i++){
            if(Character.isLetter(jmbg.charAt(i))){
                return false;
            }
       }
       return true;
    }
    public int brojVelikihSlova(String rec){
       int brojac=0;
        for(int i=0;i<rec.length();i++){
           if(Character.isUpperCase(rec.charAt(i))){
           brojac++;
           }
       }
       return brojac;
    }
    public boolean daLiJeBroj(String rec){
        try {  
            Double.parseDouble(rec);  
            return true;
        }catch(NumberFormatException e){  
            return false;  
        }
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    
    public void dodajStavkuRacunu(StavkaRacuna stavka){
        racun.getStavke().add(stavka);
    }
    public void ukloniStavkuRacunu(StavkaRacuna stavka){
        for(int i = 0; i < racun.getStavke().size(); i++) {
           if(stavka.getId()==racun.getStavke().get(i).getId())
               racun.getStavke().remove(i);
        }
    }
    public float getSuma(){
        float suma=0;
        for(int i = 0; i < racun.getStavke().size(); i++) {
           suma+=racun.getStavke().get(i).getPrtljag().getTezina();
        }
        return suma;
    }
//    public boolean preuzetaPrijemenica(Prijemnica prijemnica){
//        for(int i=0;i<vratiSvePrijemnice().size();i++){
//            if(prijemnica.equals(vratiSvePrijemnice().get(i))){
//                vratiSvePrijemnice().get(i).getPrtljag().setPreuzeto(true);
//                return true;
//            }
//        }
//        return false;
//    }
//    public List<Prijemnica> sveNepreuzetePrijemnice(){
//        List<Prijemnica> prijemnice=new ArrayList<Prijemnica>();
//        for(int i=0;i<vratiSvePrijemnice().size();i++){
//            if(!vratiSvePrijemnice().get(i).getPrtljag().isPreuzeto())
//                prijemnice.add(vratiSvePrijemnice().get(i));
//        }
//        return prijemnice;
//    }
//    public void kreirajRacun(Racun racun){
//        storageRacun.dodajRacun(racun);
//    }
//    public List<Racun> vratiRacune(){
//        return storageRacun.vratiRacune();
//    }
//    public BigDecimal vratiSumuRacuna(){
//        BigDecimal suma=new BigDecimal(0);
//        for(int i=0;i<vratiRacune().size();i++){
//            suma=suma.add(vratiRacune().get(i).getCena());
//        }
//        return suma;
//    }
//    
//    public List<Racun> vratiVece(int broj,List<Racun> lista){
//        List<Racun> racuni=new ArrayList<Racun>();
//        if(!lista.isEmpty()){
//        for(int i=0;i<lista.size();i++){
//            if(lista.get(i).getPrtljag().getTezina()>broj){
//                racuni.add(lista.get(i));
//            }
//        }}
//        return racuni;
//    }
//    public List<Racun> vratiManje(int broj,List<Racun> lista){
//        List<Racun> racuni=new ArrayList<Racun>();
//        if(!lista.isEmpty()){
//        for(int i=0;i<lista.size();i++){
//            if(lista.get(i).getPrtljag().getTezina()<broj){
//                racuni.add(lista.get(i));
//            }
//        }
//        }
//        return racuni;
//    }
//    public List<Racun> vratiIste(int broj,List<Racun> lista){
//        List<Racun> racuni=new ArrayList<Racun>();
//        if(!lista.isEmpty()){
//        for(int i=0;i<lista.size();i++){
//            if(lista.get(i).getPrtljag().getTezina()==broj){
//                racuni.add(lista.get(i));
//            }
//        }
//        }
//        return racuni;
//    }
//    public List<Racun> vratiKlijentRacun(String klijent,List<Racun> lista){
//        String[] elementi=klijent.split(" ");
//        List<Racun> racuni=new ArrayList<Racun>();
//        for(int i=0;i<lista.size();i++){
//            if(lista.get(i).getKlijent().getIme().equals(elementi[1]) && lista.get(i).getKlijent().getPrezime().equals(elementi[2])){
//                racuni.add(lista.get(i));
//            }
//        }
//        return racuni;
//    }



    

    


    

}
