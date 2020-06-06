/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.TipPrtljaga;
import java.io.Serializable;

/**
 *
 * @author Stefan
 */

public class Prtljag implements Serializable{
    Long id;
    TipPrtljaga tip;
    boolean lomljivost;
    double tezina;
    Radnik radnik;
    
    public Prtljag() {
    }
    
    public boolean isLomljivost() {
        return lomljivost;
    }

//    public Prtljag(TipPrtljaga naziv, double tezina, boolean lomljivo, boolean preuzeto) {
//        this.tezina = tezina;
//        this.lomljivo = lomljivo;
//        this.preuzeto = preuzeto;
//    }
    public void setLomljivost(boolean lomljivost) {    
        this.lomljivost = lomljivost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipPrtljaga getTip() {
        return tip;
    }

    public void setTip(TipPrtljaga tip) {
        this.tip = tip;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    
    @Override
    public String toString() {
        return "Prtljag "+ tip.getNaziv() + ", tezina= " + tezina ;
    }
            
}
