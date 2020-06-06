/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import domain.Prtljag;
import domain.StavkaRacuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class TableModelStavkeRacuna extends AbstractTableModel{
    List<StavkaRacuna> stavke;
    String[] kolone=new String[]{"id","Naziv", "Tezina", "Cena"};

    public TableModelStavkeRacuna(List<StavkaRacuna> stavke) {
       this.stavke=stavke;
    }
    @Override
    public int getRowCount() {
        return stavke.size();
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
                return stavke.get(rowIndex).getId();
            case 1:
                return stavke.get(rowIndex).getPrtljag().getTip().getNaziv();
            case 2:
                return stavke.get(rowIndex).getPrtljag().getTezina();
            case 3:
                return stavke.get(rowIndex).getPrtljag().getTip().getCena();
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object object, int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                stavke.get(rowIndex).setId(new Long(object.toString()));
                break;
            case 1:
                stavke.get(rowIndex).getPrtljag().getTip().setNaziv(object.toString());
                break;
            case 2:
                stavke.get(rowIndex).getPrtljag().setTezina(Double.valueOf(object.toString()));
                break;
            case 3:
                stavke.get(rowIndex).getPrtljag().getTip().setCena(Float.valueOf(object.toString()));
                break;
            default:
                
        }
    }
    
}
