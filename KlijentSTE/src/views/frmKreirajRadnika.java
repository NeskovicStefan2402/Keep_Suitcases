/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.CommunicationController;
import domain.Radnik;
import java.awt.Dialog;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import other.OtherMethods;

/**
 *
 * @author Stefan
 */
public class frmKreirajRadnika extends javax.swing.JPanel {

    /**
     * Creates new form frmKreirajRadnika
     */
    public frmKreirajRadnika() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTxtKorisnickoIme3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKorisnicko = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtnKreirajNalogRadnika = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtPotvrda = new javax.swing.JPasswordField();
        txtJMBG = new javax.swing.JTextField();

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Korisnicko ime:");

        jTxtKorisnickoIme3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtKorisnickoIme3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Kreiraj nalog radniku:");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setText("Korisnicko ime:");

        txtKorisnicko.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtKorisnicko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKorisnickoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setText("Ime:");

        txtIme.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setText("Prezime:");

        txtPrezime.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel6.setText("JMBG:");

        jBtnKreirajNalogRadnika.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jBtnKreirajNalogRadnika.setText("Kreiraj");
        jBtnKreirajNalogRadnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnKreirajNalogRadnikaActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel8.setText("Sifra:");

        txtSifra.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel9.setText("Potvrdi sifru:");

        txtPotvrda.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPotvrda, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtSifra, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtKorisnicko)
                            .addComponent(txtIme, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtJMBG)))
                    .addComponent(jLabel1))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtnKreirajNalogRadnika, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtKorisnicko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPotvrda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jBtnKreirajNalogRadnika, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtKorisnickoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKorisnickoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKorisnickoActionPerformed

    private void txtImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeActionPerformed

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void jTxtKorisnickoIme3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtKorisnickoIme3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtKorisnickoIme3ActionPerformed

    private void jBtnKreirajNalogRadnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnKreirajNalogRadnikaActionPerformed
        if(!txtIme.getText().isEmpty() && !txtPrezime.getText().isEmpty() && !txtKorisnicko.getText().isEmpty() && !txtJMBG.getText().isEmpty()){
            try {
                if(OtherMethods.getInstance().proveriFormat(txtKorisnicko.getText()) && OtherMethods.getInstance().proveriFormatJMBG(txtJMBG.getText())){
                    if(txtSifra.getText().equals(txtPotvrda.getText())){
                    Radnik radnik=new Radnik();
                    radnik.setKorisnickoIme(txtKorisnicko.getText());
                    radnik.setIme(txtIme.getText());
                    radnik.setPrezime(txtPrezime.getText());
                    radnik.setJMBG(txtJMBG.getText());
                    radnik.setSifra(txtSifra.getText());
                        try{
                            Radnik radnikRez=CommunicationController.getInstance().kreirajRadnika(radnik);
                            JOptionPane.showMessageDialog(this, "Sistem je kreirao nalog radnika.\n Radnik : "+radnikRez.getKorisnickoIme());
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira nalog radnika."+e.getStackTrace());
                        }
                    }else{
                        txtSifra.setText("");
                        txtPotvrda.setText("");
                        JOptionPane.showMessageDialog(this,"Niste adekvatno potvrdili sifru. Uradite to opet!");
                    }
                }else{
                    System.out.println("Korisnicko: "+txtKorisnicko.getText().toString());
                    JOptionPane.showMessageDialog(this,"Proverite strukturu unetih podataka!");
                }
            }catch (Exception ex) {
                Logger.getLogger(frmKreirajRadnika.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        JOptionPane.showMessageDialog(this, "Popunite prazna polja!");
        }
    }//GEN-LAST:event_jBtnKreirajNalogRadnikaActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnKreirajNalogRadnika;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtKorisnickoIme3;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtKorisnicko;
    private javax.swing.JPasswordField txtPotvrda;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration//GEN-END:variables
}
