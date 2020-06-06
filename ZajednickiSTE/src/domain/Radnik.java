/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Radnik implements Serializable{
    private Long idRadnik;
    private String ime;
    private String prezime;
    private String JMBG;
    private String korisnickoIme;
    private String sifra;

    public Radnik() {
    }
    
    
    public Radnik(Long idRadnik, String ime, String prezime, String JMBG, String korisnickoIme, String sifra) {
        this.idRadnik = idRadnik;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }
    
    public Long getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(Long idRadnik) {
        this.idRadnik = idRadnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
    
}
