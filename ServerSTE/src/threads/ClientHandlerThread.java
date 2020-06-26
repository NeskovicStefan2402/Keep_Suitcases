/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.Controller;
import domain.Korisnik;
import domain.Prtljag;
import domain.Racun;
import domain.Radnik;
import domain.TipPrtljaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
public class ClientHandlerThread extends Thread {

    private Socket socket;

    public ClientHandlerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        RequestObject request = null;
        ResponseObject response = null;
        while (!socket.isClosed()) {
            try {
                request = receiveRequest();

                switch (request.getOperation()) {
                    case Operation.Operacija_Prijava_Radnika:
                        response = prijavaRadnika(request);
                        break;
                    case Operation.Operacija_Kreiraj_Radnika:
                        response = kreirajRadnika(request);
                        break;
                    case Operation.Operacija_Kreiraj_Korisnika:
                        response = kreirajKorisnika(request);
                        break;
                    case Operation.Operacija_Vrati_Listu_Korisnika:
                        response = vratiListuKorinika(request);
                        break;
                    case Operation.Operacija_Vrati_Tipove_Prtljaga:
                        response = vratiListuTipovaPrtljaga(request);
                        break;
                    case Operation.Operacija_Vrati_Listu_Prtljaga:
                        response = vratiListuPrtljaga(request);
                        break;
                    case Operation.Operacija_Kreiraj_Prtljag:
                        response = dodajPrtljag(request);
                        break;
                    case Operation.Operacija_Kreiraj_Prijemnicu:
                        response = dodajRacun(request);
                        break;
                    case Operation.Operacija_Vrati_TrenutnoStanje:
                        response = vratiTrenutnoStanje(request);
                        break;
                    case Operation.Operacija_Vrati_IzvestajRacuna:
                        response = vratiIstoriju(request);
                        break;
                    case Operation.Operacija_Kreiraj_Racun:
                        response = odpremiRacun(request);
                        break;
                    case Operation.Operacija_Obrisi_Prijemnicu:
                        response = obrisiPrijemnicu(request);
                        break;
                    case Operation.Operacija_Stampaj_Izvestaj:
                        response = stampajIzvestaj(request);
                        break;
                }
                sendResponse(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public RequestObject receiveRequest() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (RequestObject) in.readObject();
    }

    public void sendResponse(ResponseObject response) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(response);
        out.flush();
    }
    public ResponseObject prijavaRadnika(RequestObject request){
        ResponseObject response=null;
        Map<String, String> data=(Map)request.getData();
        String korisnicko=data.get("korisnicko");
        String sifra=data.get("sifra");
        
        try {
            response=new ResponseObject();
            Radnik radnik=Controller.getInstance().prijavaRadnika(korisnicko, sifra);
            response.setData(radnik);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    public ResponseObject kreirajRadnika(RequestObject request) {
        ResponseObject response = null;
        Radnik radnik=(Radnik)request.getData();
        
        try {
            response = new ResponseObject();
            Radnik r=Controller.getInstance().kreirajRadnika(radnik);
            response.setData(r);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    
    private ResponseObject kreirajKorisnika(RequestObject request) {
        ResponseObject response = null;
        Korisnik korisnik=(Korisnik)request.getData();
        
        try {
            response = new ResponseObject();
            Korisnik r=Controller.getInstance().kreirajKorisnika(korisnik);
            response.setData(r);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    
    private ResponseObject vratiListuKorinika(RequestObject request) {
        ResponseObject response = null;
        
        try {
            response = new ResponseObject();
            List<Korisnik> korisnici= Controller.getInstance().vratiKorisnike();
            response.setData(korisnici);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    
    private ResponseObject vratiListuTipovaPrtljaga(RequestObject request) {
        ResponseObject response = null;
        try {
            response = new ResponseObject();
            List<TipPrtljaga> tipovi= Controller.getInstance().vratiTipPrtljaga();
            response.setData(tipovi);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    
    private ResponseObject vratiListuPrtljaga(RequestObject request) {
        ResponseObject response = null;
        try {
            Radnik radnik=(Radnik)request.getData();
            response = new ResponseObject();
            List<Prtljag> prtljazi= Controller.getInstance().vratiPrtljage(radnik);
            response.setData(prtljazi);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    public Socket getSocket() {
        return socket;
    }

    private ResponseObject dodajPrtljag(RequestObject request) {
        ResponseObject response = null;
        Prtljag prtljag=(Prtljag)request.getData();
        
        try {
            response = new ResponseObject();
            Prtljag prt=Controller.getInstance().dodajPrtljag(prtljag);
            response.setData(prt);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }

    private ResponseObject dodajRacun(RequestObject request) {
        ResponseObject response = null;
        Racun racun=(Racun)request.getData();
        
        try {
            response = new ResponseObject();
            System.out.println("Handler: "+racun.getRadnik().getIdRadnik());
            Racun r=Controller.getInstance().dodajRacun(racun);
            response.setData(r);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }

    private ResponseObject vratiTrenutnoStanje(RequestObject request) {
        ResponseObject response = null;
        try {
            response = new ResponseObject();
            List<Racun> stanje= Controller.getInstance().vratiTrenutnoStanje();
            response.setData(stanje);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }
    private ResponseObject vratiIstoriju(RequestObject request) {
        ResponseObject response = null;
        try {
            response = new ResponseObject();
            List<Racun> stanje= Controller.getInstance().vratiIstoriju();
            response.setData(stanje);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }

    private ResponseObject odpremiRacun(RequestObject request) {
       ResponseObject response = null;
        Racun racun=(Racun)request.getData();
        
        try {
            response = new ResponseObject();
            Racun r=Controller.getInstance().odpremiRacun(racun);
            response.setData(r);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }

    private ResponseObject obrisiPrijemnicu(RequestObject request) {
        ResponseObject response = null;
        Racun racun=(Racun)request.getData();
        
        try {
            response = new ResponseObject();
            Racun r=Controller.getInstance().obrisiPrijemnicu(racun);
            response.setData(r);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }

    private ResponseObject stampajIzvestaj(RequestObject request) {
        ResponseObject response = null;
        List<Racun> racuni=(List<Racun>) request.getData();
        
        try {
            response = new ResponseObject();
            String resp=Controller.getInstance().stampajIzvestaj(racuni);
            response.setData(resp);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }



    
    

}
