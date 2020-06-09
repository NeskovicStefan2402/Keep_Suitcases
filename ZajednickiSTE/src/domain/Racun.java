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
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    float cena=0;
    List<StavkaRacuna> stavke;
    LocalDateTime predatoVreme;
    LocalDateTime preuzetoVreme;

    public Racun(float cena,Long idRacuna, Korisnik klijent, Radnik radnik, List<StavkaRacuna> stavke, LocalDateTime predatoVreme, LocalDateTime preuzetoVreme) {
        this.idRacuna = idRacuna;
        this.klijent = klijent;
        this.cena=cena;
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

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
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

    public LocalDateTime getPredatoVreme() {
        return predatoVreme;
    }

    public void setPredatoVreme(LocalDateTime predatoVreme) {
        this.predatoVreme = predatoVreme;
    }

    public LocalDateTime getPreuzetoVreme() {
        return preuzetoVreme;
    }

    public void setPreuzetoVreme(LocalDateTime preuzetoVreme) {
        this.preuzetoVreme = preuzetoVreme;
    }

    public void setPreuzetoVreme(Timestamp date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
