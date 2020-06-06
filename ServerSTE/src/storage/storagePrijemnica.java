/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Prijemnica;
import domain.Prtljag;
import domain.Radnik;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storagePrijemnica {
    public List<Prijemnica> getAll() throws Exception;
    public Prijemnica insert(Prijemnica prijemnica) throws Exception;
}
