/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.TipPrtljaga;
import java.util.List;
import storage.impl.database.StorageDBTipPrtljaga;

/**
 *
 * @author Stefan
 */
public class ServiceTipPrtljaga {
    StorageDBTipPrtljaga storageTipPrtljaga;
    public ServiceTipPrtljaga() {
        storageTipPrtljaga=new StorageDBTipPrtljaga();
    }
    
    public List<TipPrtljaga> vratiTipove(){
        return storageTipPrtljaga.getAll();
    }
    
    public TipPrtljaga getTip(Long id){
        return storageTipPrtljaga.getTip(id);
    }
}
