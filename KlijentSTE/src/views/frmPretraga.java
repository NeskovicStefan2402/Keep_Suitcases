/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import components.TableModelIzvestaj;
import domain.Racun;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.table.TableModel;
import controller.*;
import domain.Korisnik;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import other.OtherMethods;
/**
 *
 * @author Stefan
 */
public class frmPretraga extends javax.swing.JPanel {
    List<Racun> racuni;
    /**
     * Creates new form frmPretraga
     */
    public frmPretraga() {
        try {
            initComponents();
            racuni=CommunicationController.getInstance().vratiTrenutnoStanje();
            racuni.addAll(CommunicationController.getInstance().vratiIstoriju());
            popuniComboKlijenata();
            uPozadini(racuni);
        } catch (IOException ex) {
            Logger.getLogger(frmPretraga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxKlijenti = new javax.swing.JComboBox();
        jTxtTezina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxUslov = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Pretraga racuna");

        jComboBoxKlijenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKlijentiActionPerformed(evt);
            }
        });

        jTxtTezina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTezinaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setText("Unesite tezinu za pretragu:");

        jComboBoxUslov.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ">", "=", "<" }));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setText("Izaberite uslov za pretragu:");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setText("Izaberite klijenta za pretragu:");

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel5.setText("Filteri");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 185, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxUslov, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtTezina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxKlijenti, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxKlijenti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtTezina, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxUslov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtTezinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTezinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTezinaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Racun> racuni1=new ArrayList<>();
        if(!jComboBoxKlijenti.getSelectedItem().toString().equals("Nista")){
            racuni1=OtherMethods.getInstance().vratiKlijentRacun((Korisnik) jComboBoxKlijenti.getSelectedItem(),racuni);
            if(jTxtTezina.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Popunite polje tezina!");
            }else if(OtherMethods.getInstance().daLiJeBroj(jTxtTezina.getText())){
                if(jComboBoxUslov.getSelectedItem().toString().equals(">"))
                    racuni1=OtherMethods.getInstance().vratiVece(Integer.parseInt(jTxtTezina.getText()),racuni1);
                else if(jComboBoxUslov.getSelectedItem().toString().equals("<"))
                    racuni1=OtherMethods.getInstance().vratiManje(Integer.parseInt(jTxtTezina.getText()),racuni1);
                else if(jComboBoxUslov.getSelectedItem().toString().equals("="))
                    racuni1=OtherMethods.getInstance().vratiIste(Integer.parseInt(jTxtTezina.getText()),racuni1);
                if(racuni1.size()==0){
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje transakcije po zadatim vrednostima!");
                }else{
                    JOptionPane.showMessageDialog(this, "Sistem je nasao transakcije po zadatim vrednostima!");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Popunite polje tezina validnim vrednostima!");
            }
        }else{
            if(jTxtTezina.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Popunite polje tezina!");
            }else{
                        
                if(OtherMethods.getInstance().daLiJeBroj(jTxtTezina.getText())){
                    if(jComboBoxUslov.getSelectedItem().toString().equals(">"))
                            racuni1=OtherMethods.getInstance().vratiVece(Integer.parseInt(jTxtTezina.getText()),racuni);
                    else if(jComboBoxUslov.getSelectedItem().toString().equals("<"))
                           racuni1=OtherMethods.getInstance().vratiManje(Integer.parseInt(jTxtTezina.getText()),racuni);
                    else if(jComboBoxUslov.getSelectedItem().toString().equals("="))
                            racuni1=OtherMethods.getInstance().vratiIste(Integer.parseInt(jTxtTezina.getText()),racuni);
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Popunite polje tezina validnim vrednostima!");
                }
                
            
  
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        uPozadini(racuni1);
    }
    private void jComboBoxKlijentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKlijentiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxKlijentiActionPerformed
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxKlijenti;
    private javax.swing.JComboBox jComboBoxUslov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtTezina;
    // End of variables declaration//GEN-END:variables
    public void uPozadini(List<Racun> lista){
        
        TableModel model=new TableModelIzvestaj(lista);
//        for (int i = 0; i < lista.size(); i++) {
//            if(lista.get(i).getPreuzetoVreme()==null){
//                Promena boje reda
//            }else{
//                
//            }
//        }
        jTable1.setModel(model);
    }
    public void popuniComboKlijenata(){
        try {
            jComboBoxKlijenti.addItem("Nista");
            List<Korisnik> korisnici =CommunicationController.getInstance().vratiSveKlijente();
            for(int i=0;i<korisnici.size();i++){
                jComboBoxKlijenti.addItem(korisnici.get(i));
            }
        } catch (IOException ex) {
            Logger.getLogger(frmPretraga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
