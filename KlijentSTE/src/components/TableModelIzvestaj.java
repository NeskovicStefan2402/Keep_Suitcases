/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import domain.Izvestaj;
import javax.swing.table.AbstractTableModel;
import controller.CommunicationController;
import domain.Prijemnica;
import domain.Racun;
import domain.TipPrtljaga;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class TableModelIzvestaj extends AbstractTableModel{
    Izvestaj izvestaj;
    String[] kolone=new String[]{"Ime klijenta","Prezime klijenta","Radnik","Tip prtljaga","Tezina","Datum izdavanja","Cena"};
    public TableModelIzvestaj(List<Racun> racuni) {
        izvestaj=new Izvestaj();
        izvestaj.setRacuni(racuni);
        
    }
    
    @Override
    public int getRowCount() {
        return izvestaj.getRacuni().size();
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
                return izvestaj.getRacuni().get(rowIndex).getKlijent().getIme();
            case 1:
                return izvestaj.getRacuni().get(rowIndex).getKlijent().getPrezime();
            case 2:
                return izvestaj.getRacuni().get(rowIndex).getRadnik().getKorisnickoIme();
            case 3:
                return izvestaj.getRacuni().get(rowIndex).getPrtljag().getNaziv();
            case 4:
                return izvestaj.getRacuni().get(rowIndex).getPrtljag().getTezina();
            case 5:
                return izvestaj.getRacuni().get(rowIndex).getDatum();
            case 6:
                return izvestaj.getRacuni().get(rowIndex).getCena();
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object object,int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                izvestaj.getRacuni().get(rowIndex).getKlijent().setIme(object.toString());
                break;
            case 1:
                izvestaj.getRacuni().get(rowIndex).getKlijent().setPrezime(object.toString());
                break;
            case 2:
                izvestaj.getRacuni().get(rowIndex).getRadnik().setKorisnickoIme(object.toString());
                break;
            case 3:
                izvestaj.getRacuni().get(rowIndex).getPrtljag().setNaziv((TipPrtljaga)object);
                break;
            case 4:
                izvestaj.getRacuni().get(rowIndex).getPrtljag().setTezina(Double.parseDouble(object.toString()));
                break;
            case 5:
                izvestaj.getRacuni().get(rowIndex).setDatum(new Date(object.toString()));
                break;
            case 6:
                izvestaj.getRacuni().get(rowIndex).setCena(new BigDecimal(object.toString()));
                break;
            default:
                break;
        }
    }
    
}
