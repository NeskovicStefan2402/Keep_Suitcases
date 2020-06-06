/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dbConnection.DBConnection;
import domain.Prtljag;
import domain.Radnik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import storage.impl.database.StorageDBPrtljag;

/**
 *
 * @author Stefan
 */
public class ServicePrtljag implements storage.storagePrtljag{
    private StorageDBPrtljag stroDBPrtljag;
    public ServicePrtljag() {
        stroDBPrtljag=new StorageDBPrtljag();
    }

    @Override
    public Prtljag insert(Prtljag prtljag) throws Exception {
      return stroDBPrtljag.insert(prtljag);
    }

    @Override
    public List<Prtljag> getAll(Radnik radnik) throws Exception {
        return stroDBPrtljag.getAll(radnik);
    }

    @Override
    public Prtljag getPrtljag(Long id) throws Exception {
        return stroDBPrtljag.getPrtljag(id);
    }
    
}
