/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import domain.Korisnik;
import domain.Racun;
import domain.StavkaRacuna;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class OtherMethods {
    private static OtherMethods instance;
    private Racun racun;

    public OtherMethods() {
        racun =new Racun();
    }
    public static OtherMethods getInstance(){
        if(instance==null){
            instance=new OtherMethods();
        }
        return instance;
    }
    
    
    
    public boolean proveriFormat(String username){
        if(username.length()>7 && brojVelikihSlova(username)>0){
            return true;
        }
        return false;
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
    
    public boolean daLiJeBroj(String rec){
        try {  
            Double.parseDouble(rec);  
            return true;
        }catch(NumberFormatException e){  
            return false;  
        }
    }
    public List<Racun> vratiIste(int broj,List<Racun> lista){
        List<Racun> racuni=new ArrayList<Racun>();
        if(!lista.isEmpty()){
        for(int i=0;i<lista.size();i++){
            if(getSuma(lista.get(i))==broj){
                racuni.add(lista.get(i));
            }
        }
        }
        return racuni;
    }
    public float getSuma(Racun racun){
        float suma=0;
        for(int i = 0; i < racun.getStavke().size(); i++) {
           suma+=racun.getStavke().get(i).getPrtljag().getTezina();
        }
        return suma;
    }
    public float getUkupnaCena(Racun racun){
       float suma=0;
        for(int i = 0; i < racun.getStavke().size(); i++) {
           suma+=racun.getStavke().get(i).getCena()*((int)racun.getStavke().get(i).getPrtljag().getTezina());
        }
        float datum =racun.getPreuzetoVreme().getDayOfYear()-racun.getPredatoVreme().getDayOfYear();
        float vreme =getSecondDuration(racun.getPreuzetoVreme())-getSecondDuration(racun.getPredatoVreme());
        return (datum+vreme/3600)*suma;
    }
    private long getSecondDuration(LocalDateTime t) {
    long h = t.getHour();
    long m = t.getMinute();
    long s = t.getSecond();
    return  (h * 3600) + (m * 60) + s;
    }

    public float vratiSumuRacuna(List<Racun> racuni){
        float suma=0;
        for(int i=0;i<racuni.size();i++){
            suma+=racuni.get(i).getCena();
        }
        return suma;
    }

    public List<Racun> vratiVece(int broj,List<Racun> lista){
        List<Racun> racuni=new ArrayList<Racun>();
        if(!lista.isEmpty()){
        for(int i=0;i<lista.size();i++){
            if(getSuma(lista.get(i))>broj){
                racuni.add(lista.get(i));
            }
        }}
        return racuni;
    }
    public List<Racun> vratiManje(int broj,List<Racun> lista){
        List<Racun> racuni=new ArrayList<Racun>();
        if(!lista.isEmpty()){
        for(int i=0;i<lista.size();i++){
            if(getSuma(lista.get(i))<broj){
                racuni.add(lista.get(i));
            }
        }
        }
        return racuni;
    }
    public List<Racun> vratiKlijentRacun(Korisnik korisnik,List<Racun> lista){
        System.out.println("Korisnik: "+korisnik.getIme());
        List<Racun> racuni=new ArrayList<Racun>();
        for(int i=0;i<lista.size();i++){
            if(korisnik.getIdKorisnika().equals(lista.get(i).getKlijent().getIdKorisnika())){
                racuni.add(lista.get(i));
            }
        }
        return racuni;
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
    
}
