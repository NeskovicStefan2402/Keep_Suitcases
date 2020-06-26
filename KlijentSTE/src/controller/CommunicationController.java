/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import domain.User;
import domain.Korisnik;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.OtherMethods;
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
    private List<TipPrtljaga> tipovi;
    private List<Korisnik> korisnici;
    private OtherMethods methods;
    private CommunicationController() throws IOException{
        socket=new Socket("localhost", 9000);
        methods=new OtherMethods();
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
    
    public ResponseObject prijaviRadnika(String username, String password) throws IOException, ClassNotFoundException, Exception {
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
        }else{
            response.setException(new Exception("Uspesno ste se prijavili!"));
        }
        return response;
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
    
    public Racun kreirajRacun(Racun racun) {
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
    public List<Racun> vratiIstoriju() {
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Vrati_IzvestajRacuna);
            
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
    
    public Racun odpremiRacun(Racun racun) {
       try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Kreiraj_Racun);
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
    public Racun obrisiPrijemnicu(Racun racun){
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Obrisi_Prijemnicu);
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

    public String stampajIzvestaj(List<Racun> racuni) {
        String resp="Sistem ne moze da odstampa izvestaj.";
        try {
            RequestObject request=new RequestObject();
            request.setOperation(Operation.Operacija_Stampaj_Izvestaj);
            request.setData(racuni);
            sendRequest(request);
            ResponseObject response=receiveResponse();
            if(response.getException()!=null){
                throw response.getException();
            }
            resp=(String) response.getData();
        } catch (Exception ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
}
