/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Pojos.Contrato;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class JDFClaveEdicionContrato extends javax.swing.JDialog {

    /**
     * Creates new form JDFClaveEdicionContrato
     */
    Contrato contrato;
    public JDFClaveEdicionContrato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
     public JDFClaveEdicionContrato(java.awt.Frame parent, boolean modal,Contrato contrato) {
        super(parent, modal);
        initComponents();
        this.contrato=contrato;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtnaceptar = new javax.swing.JButton();
        jtfclave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("El contrato ya paso las 2 horas de tolerancia, ingrese clave de validación:");

        jbtnaceptar.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jbtnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accept2.png"))); // NOI18N
        jbtnaceptar.setText("Aceptar");
        jbtnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnaceptarActionPerformed(evt);
            }
        });

        jtfclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfclaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jtfclave)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnaceptar)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(111, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnaceptar)
                    .addComponent(jtfclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnaceptarActionPerformed
        // TODO add your handling code here:
        if(new String(jtfclave.getPassword()).equals("seringco2017")){
        JDFEditarContrato  editcontrato = new JDFEditarContrato(new Frame(), isVisible(),contrato);
         editcontrato.setVisible(true);
        this.dispose();
        }else {
            JOptionPane.showMessageDialog(null,"Clave erronea" );
            
        }
         
    }//GEN-LAST:event_jbtnaceptarActionPerformed

    private void jtfclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfclaveActionPerformed
        // TODO add your handling code here:
        jbtnaceptar.doClick();
    }//GEN-LAST:event_jtfclaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDFClaveEdicionContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDFClaveEdicionContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDFClaveEdicionContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDFClaveEdicionContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDFClaveEdicionContrato dialog = new JDFClaveEdicionContrato(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtnaceptar;
    private javax.swing.JPasswordField jtfclave;
    // End of variables declaration//GEN-END:variables
}
