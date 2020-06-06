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
public class Korisnik implements Serializable{
    private Long idKorisnika;
    private Long idRadnika;
    private String ime;
    private String prezime;
    private String JMBG;
    private String kontaktBroj;
    private String sifra;

    public Korisnik(Long idKorisnika, Long idRadnika, String ime, String prezime, String JMBG, String kontaktBroj, String sifra) {
        this.idKorisnika = idKorisnika;
        this.idRadnika = idRadnika;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.kontaktBroj = kontaktBroj;
        this.sifra = sifra;
    }

    public Korisnik() {
    }
    
    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Long getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(Long idRadnika) {
        this.idRadnika = idRadnika;
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

    public String getKontaktBroj() {
        return kontaktBroj;
    }

    public void setKontaktBroj(String kontaktBroj) {
        this.kontaktBroj = kontaktBroj;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    
    
    
}
