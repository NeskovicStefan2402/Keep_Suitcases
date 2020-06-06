/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Korisnik;
import domain.Radnik;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storageKorisnik{
    public List<Korisnik> getAll() throws Exception;
    public Korisnik insert(Korisnik korisnik) throws Exception;
    public Korisnik getKorisnik(Long id) throws Exception;
}
