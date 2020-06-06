/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Korisnik;
import domain.Radnik;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Prijemnica implements Serializable{
    Long idPrijemnice;
    Korisnik klijent;
    Prtljag prtljag;
    Radnik radnik;
    Date datum;
    boolean preuzeto;

   
    
    public Prijemnica() {
    }

    public Prijemnica(Long idPrijemnice, Korisnik klijent, Prtljag prtljag, Radnik radnik, Date datum,boolean preuzeto) {
        this.idPrijemnice = idPrijemnice;
        this.klijent = klijent;
        this.prtljag = prtljag;
        this.radnik = radnik;
        this.datum = datum;
        this.preuzeto = preuzeto;
    }
    
    public Long getIdPrijemnice() {
        return idPrijemnice;
    }

    public Korisnik getKlijent() {
        return klijent;
    }
    
    public boolean isPreuzeto() {
        return preuzeto;
    }

    public void setPreuzeto(boolean preuzeto) {
        this.preuzeto = preuzeto;
    }
    
    public Prtljag getPrtljag() {
        return prtljag;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public Date getDatum() {
        return datum;
    }

    public void setIdPrijemnice(Long idPrijemnice) {
        this.idPrijemnice = idPrijemnice;
    }

    public void setKlijent(Korisnik klijent) {
        this.klijent = klijent;
    }

    public void setPrtljag(Prtljag prtljag) {
        this.prtljag = prtljag;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prijemnica other = (Prijemnica) obj;
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        if (!Objects.equals(this.prtljag, other.prtljag)) {
            return false;
        }
        if (!Objects.equals(this.radnik, other.radnik)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Prijemnica{" + "idPrijemnice=" + idPrijemnice + ", klijent=" + klijent + ", prtljag=" + prtljag + ", radnik=" + radnik + ", datum=" + datum + '}';
    }
    
}
