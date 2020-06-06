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
public class StavkaRacuna implements Serializable{
    Long id;
    Prtljag prtljag;
    float cena;

    public StavkaRacuna() {
    }
    
    public StavkaRacuna(Long id, Prtljag prtljag, float cena) {
        this.id = id;
        this.prtljag = prtljag;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prtljag getPrtljag() {
        return prtljag;
    }

    public void setPrtljag(Prtljag prtljag) {
        this.prtljag = prtljag;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    
}
