/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import domain.Korisnik;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Stefan
 */
public class TableModelKlijenti extends AbstractTableModel{
    List<Korisnik> klijenti;
    String[] kolone=new String[]{"Ime", "Prezime", "JMBG"};

    public TableModelKlijenti(List<Korisnik> klijenti) {
       this.klijenti=klijenti;
    }
    @Override
    public int getRowCount() {
        return klijenti.size();
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
                return klijenti.get(rowIndex).getIme();
            case 1:
                return klijenti.get(rowIndex).getPrezime();
            case 2:
                return klijenti.get(rowIndex).getJMBG();
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object object, int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                klijenti.get(rowIndex).setIme(object.toString());
                break;
            case 1:
                klijenti.get(rowIndex).setPrezime(object.toString());
                break;
            case 2:
                klijenti.get(rowIndex).setJMBG(object.toString());
                break;
            default:
                
        }
    }
    

   
    
}
