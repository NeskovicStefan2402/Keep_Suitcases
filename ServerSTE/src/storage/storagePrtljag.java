/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Prtljag;
import domain.Radnik;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storagePrtljag{
    public List<Prtljag> getAll(Radnik radnik) throws Exception;
    public Prtljag insert(Prtljag prtljag) throws Exception;
    public Prtljag getPrtljag(Long id) throws Exception;
}
