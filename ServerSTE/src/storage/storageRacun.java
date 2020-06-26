/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Racun;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storageRacun {
    public List<Racun> getAll() throws Exception;
    public Racun insert(Racun racun) throws Exception;
    public Racun update(Racun racun) throws Exception;
    public Racun delete(Racun racun) throws Exception;
}
