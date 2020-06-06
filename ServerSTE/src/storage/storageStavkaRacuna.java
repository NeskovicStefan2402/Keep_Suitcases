/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.StavkaRacuna;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storageStavkaRacuna {
    public List<StavkaRacuna> getAll(Long idRacuna) throws Exception;
    public StavkaRacuna insert(StavkaRacuna stavka,Long idRacina) throws Exception;
}
