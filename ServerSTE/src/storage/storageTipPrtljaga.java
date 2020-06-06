/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.TipPrtljaga;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface storageTipPrtljaga {
    public List<TipPrtljaga> getAll();
    public TipPrtljaga getTip(Long id);
}
