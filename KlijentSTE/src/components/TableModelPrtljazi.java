/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import domain.Korisnik;
import domain.Prtljag;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Stefan
 */
public class TableModelPrtljazi extends AbstractTableModel{
    List<Prtljag> prtljazi;
    String[] kolone=new String[]{"id","Naziv", "Tezina", "Cena"};

    public TableModelPrtljazi(List<Prtljag> prtljazi) {
       this.prtljazi=prtljazi;
    }
    @Override
    public int getRowCount() {
        return prtljazi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return prtljazi.get(rowIndex).getId();
            case 1:
                return prtljazi.get(rowIndex).getTip().getNaziv();
            case 2:
                return prtljazi.get(rowIndex).getTezina();
            case 3:
                return prtljazi.get(rowIndex).getTip().getCena();
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object object, int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                prtljazi.get(rowIndex).setId(new Long(object.toString()));
                break;
            case 1:
                prtljazi.get(rowIndex).getTip().setNaziv(object.toString());
                break;
            case 2:
                prtljazi.get(rowIndex).setTezina(Double.valueOf(object.toString()));
                break;
            case 3:
                prtljazi.get(rowIndex).getTip().setCena(Float.valueOf(object.toString()));
                break;
            default:
                
        }
    }
    

   
    
}
