/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import domain.Prijemnica;
import domain.Racun;
import domain.StavkaRacuna;
import domain.TipPrtljaga;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class TableModelPrijemnica extends AbstractTableModel{
    List<Racun> prijemnice;
    String[] kolone=new String[]{"Klijent ime","Klijent prezime","Tezina","Datum"};
    
    public TableModelPrijemnica(List<Racun> prijemnice) {
        this.prijemnice=prijemnice;
    }
    
    @Override
    public int getRowCount() {
        return prijemnice.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    public float getTezina(List<StavkaRacuna> stavke){
        float suma=0;
        for (int i = 0; i < stavke.size(); i++) {
            suma+=stavke.get(i).getPrtljag().getTezina();
        }
        return suma;
    }
   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return prijemnice.get(rowIndex).getKlijent().getIme();
            case 1:
                return prijemnice.get(rowIndex).getKlijent().getPrezime();
            case 2:
                return getTezina(prijemnice.get(rowIndex).getStavke());
            case 3:
                return prijemnice.get(rowIndex).getPredatoVreme();
            default:
                return null;
        }
    }

//    @Override
//    public void setValueAt(Object object, int rowIndex, int columnIndex) {
//        
//        switch(columnIndex){
//            case 0:
//                prijemnice.get(rowIndex).getKlijent().setIme(object.toString());
//                break;
//            case 1:
//                prijemnice.get(rowIndex).getKlijent().setPrezime(object.toString());
//                break;
//            case 2:
//                prijemnice.get(rowIndex).getPrtljag().getTip().setNaziv(object.toString());
//                break;
//            case 3:
//                prijemnice.get(rowIndex).getPrtljag().setTezina(Double.parseDouble(object.toString()));
//                break;
//            case 4:
//                prijemnice.get(rowIndex).setDatum(new Date(object.toString()));
//                break;
//            default:
//                
//        }
//    }
}
