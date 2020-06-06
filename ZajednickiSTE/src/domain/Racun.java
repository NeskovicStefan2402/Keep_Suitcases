/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Korisnik;
import domain.Prtljag;
import domain.Radnik;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class Racun implements Serializable{
    Long idRacuna;
    Korisnik klijent;
    Radnik radnik;
    List<StavkaRacuna> stavke;
    Date predatoVreme;
    Date preuzetoVreme;

    public Racun(Long idRacuna, Korisnik klijent, Radnik radnik, List<StavkaRacuna> stavke, Date predatoVreme, Date preuzetoVreme) {
        this.idRacuna = idRacuna;
        this.klijent = klijent;
        this.radnik = radnik;
        this.stavke = stavke;
        this.predatoVreme = predatoVreme;
        this.preuzetoVreme = preuzetoVreme;
    }

    public Racun() {
        stavke=new ArrayList<>();
    }
    
    public Long getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(Long idRacuna) {
        this.idRacuna = idRacuna;
    }

    public Korisnik getKlijent() {
        return klijent;
    }

    public void setKlijent(Korisnik klijent) {
        this.klijent = klijent;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    public Date getPredatoVreme() {
        return predatoVreme;
    }

    public void setPredatoVreme(Date predatoVreme) {
        this.predatoVreme = predatoVreme;
    }

    public Date getPreuzetoVreme() {
        return preuzetoVreme;
    }

    public void setPreuzetoVreme(Date preuzetoVreme) {
        this.preuzetoVreme = preuzetoVreme;
    }
    
    
    
}
