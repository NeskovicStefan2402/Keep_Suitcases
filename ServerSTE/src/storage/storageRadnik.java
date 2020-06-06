/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Radnik;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storageRadnik {
    public List<Radnik> getAll() throws Exception;
    public Radnik insert(Radnik radnik) throws Exception;
    public Radnik getRadnik(Long id) throws Exception;
}
