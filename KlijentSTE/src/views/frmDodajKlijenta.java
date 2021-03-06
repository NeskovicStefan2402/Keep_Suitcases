/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.CommunicationController;

import domain.Korisnik;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import other.OtherMethods;
/**
 *
 * @author Stefan
 */
public class frmDodajKlijenta extends javax.swing.JPanel {

    /**
     * Creates new form frmDodajKlijenta
     */
    public frmDodajKlijenta() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrezimeKlijenta = new javax.swing.JTextField();
        txtJMBGKlijenta = new javax.swing.JTextField();
        txtImeKlijenta = new javax.swing.JTextField();
        jBtnKreirajKlijenta = new javax.swing.JButton();
        txtKontaktKorisnik = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setText("Kreiraj klijenta:");

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setText("Ime:");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setText("Prezime:");

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel5.setText("JMBG:");

        txtPrezimeKlijenta.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N

        txtJMBGKlijenta.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N

        txtImeKlijenta.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtImeKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeKlijentaActionPerformed(evt);
            }
        });

        jBtnKreirajKlijenta.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jBtnKreirajKlijenta.setText("Kreiraj klijenta");
        jBtnKreirajKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnKreirajKlijentaActionPerformed(evt);
            }
        });

        txtKontaktKorisnik.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtKontaktKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKontaktKorisnikActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel6.setText("Kontakt broj:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnKreirajKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtJMBGKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrezimeKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtImeKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtKontaktKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtImeKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrezimeKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJMBGKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKontaktKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnKreirajKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnKreirajKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnKreirajKlijentaActionPerformed
        if(!txtImeKlijenta.getText().isEmpty() && !txtPrezimeKlijenta.getText().isEmpty() && !txtJMBGKlijenta.getText().isEmpty()){
            try {
                if(OtherMethods.getInstance().proveriFormatJMBG(txtJMBGKlijenta.getText())){
                    Korisnik korisnik = new Korisnik();
                    korisnik.setIme(txtImeKlijenta.getText());
                    korisnik.setPrezime(txtPrezimeKlijenta.getText());
                    korisnik.setJMBG(txtJMBGKlijenta.getText());
                    korisnik.setKontaktBroj(txtKontaktKorisnik.getText());
                    korisnik.setIdRadnika(new Long(1)); //Promeniti na idRadnika
                        try{
                            Korisnik klijent=CommunicationController.getInstance().kreirajKorisnika(korisnik);
                            JOptionPane.showMessageDialog(this, "Sistem je kreirao nalog klijenta. \n"
                                    + "Klijent : "+klijent.getIme()+" "+klijent.getPrezime());
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira nalog klijenta.\n"+e.getStackTrace());
                        }
                }else{
                    JOptionPane.showMessageDialog(this,"Proverite strukturu unetih podataka!");
                }
            }catch (Exception ex) {
                Logger.getLogger(frmDodajKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        JOptionPane.showMessageDialog(this, "Popunite prazna polja!");
        }
    }//GEN-LAST:event_jBtnKreirajKlijentaActionPerformed

    private void txtImeKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeKlijentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeKlijentaActionPerformed

    private void txtKontaktKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKontaktKorisnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKontaktKorisnikActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnKreirajKlijenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtImeKlijenta;
    private javax.swing.JTextField txtJMBGKlijenta;
    private javax.swing.JTextField txtKontaktKorisnik;
    private javax.swing.JTextField txtPrezimeKlijenta;
    // End of variables declaration//GEN-END:variables
}
