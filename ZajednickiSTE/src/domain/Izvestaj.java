/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Racun;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class Izvestaj {
    Long idIzvestaja;
    BigDecimal cena;
    List<Racun> racuni;

    public Izvestaj() {
    }

    public Izvestaj(Long idIzvestaja, BigDecimal cena, List<Racun> racuni) {
        this.idIzvestaja = idIzvestaja;
        this.cena = cena;
        this.racuni = racuni;
    }
    
    public Long getIdIzvestaja() {
        return idIzvestaja;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setIdIzvestaja(Long idIzvestaja) {
        this.idIzvestaja = idIzvestaja;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }

    @Override
    public String toString() {
        return "Izvestaj{" + "idIzvestaja=" + idIzvestaja + ", cena=" + cena + ", racuni=" + racuni + '}';
    }
    
}
