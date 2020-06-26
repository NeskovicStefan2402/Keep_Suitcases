/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.table.AbstractTableModel;
import controller.CommunicationController;
import domain.Racun;
import domain.TipPrtljaga;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.OtherMethods;

/**
 *
 * @author Stefan
 */
public class TableModelIzvestaj extends AbstractTableModel{
    List<Racun> racuni;
    String[] kolone=new String[]{"Ime korisnika","Prezime korisnika","Radnik","Cena","Tezina","Datum predavanja","Datum preuzimanja"};
    public TableModelIzvestaj(List<Racun> racuni) {
        this.racuni=racuni;
    }
    
    @Override
    public int getRowCount() {
        
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return racuni.get(rowIndex).getKlijent().getIme();
            case 1:
                return racuni.get(rowIndex).getKlijent().getPrezime();
            case 2:
                return racuni.get(rowIndex).getRadnik().getKorisnickoIme();
            case 3:
                return racuni.get(rowIndex).getCena();
            case 4:
                return OtherMethods.getInstance().getSuma(racuni.get(rowIndex));
            case 5:
                return racuni.get(rowIndex).getPredatoVreme();
            case 6:
                return racuni.get(rowIndex).getPreuzetoVreme();
            default:
                return null;
        }
    }
    
    
}
