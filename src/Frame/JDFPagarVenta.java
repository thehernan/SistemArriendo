/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Pojos.DetalleCaja;
import java.text.NumberFormat;

/**
 *
 * @author info2017
 */
public class JDFPagarVenta extends javax.swing.JDialog {

    /**
     * Creates new form JDFPagarVenta
     */
    Double total;
    JIFVenta jifventa;
    public JDFPagarVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDFPagarVenta(java.awt.Frame parent, boolean modal,Double total,JIFVenta jifventa) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        NumberFormat nf= NumberFormat.getInstance();
        this.total=total;
        jlbltotal.setText(nf.format(total));
        this.jifventa=jifventa;
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
        jlblvuelto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfpagocon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jlbltotal = new javax.swing.JLabel();
        jbtncobrar = new javax.swing.JButton();
        jlblmensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel1.setText("Total:");

        jlblvuelto.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jlblvuelto.setText("* * *");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel3.setText("Pago con:");

        jtfpagocon.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jtfpagocon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfpagoconActionPerformed(evt);
            }
        });
        jtfpagocon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfpagoconKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfpagoconKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel4.setText("Vuelto:");

        jlbltotal.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jlbltotal.setText("jLabel2");

        jbtncobrar.setText("Cobrar");
        jbtncobrar.setEnabled(false);
        jbtncobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncobrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtncobrar)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addComponent(jtfpagocon)
                    .addComponent(jlblvuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbltotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfpagocon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jlblvuelto))
                .addGap(18, 18, 18)
                .addComponent(jbtncobrar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfpagoconKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpagoconKeyReleased
        // TODO add your handling code here:
        try {
            Double pago = Double.parseDouble(jtfpagocon.getText());
        Double vuelto=0.0;
        NumberFormat nf = NumberFormat.getInstance();
        if(pago>=total){
            vuelto=pago-total;
            jlblvuelto.setText(nf.format(vuelto));
            jlblmensaje.setText("");
            jbtncobrar.setEnabled(true);
        }else {
            jbtncobrar.setEnabled(false);
            jlblmensaje.setText("Ingrese un monto valido");
            jlblvuelto.setText("* * *");
        }
            
            
        } catch (Exception e) {
            jbtncobrar.setEnabled(false);
            jlblmensaje.setText("Ingrese un monto valido");
            jlblvuelto.setText("* * *");
        }
        
        
    }//GEN-LAST:event_jtfpagoconKeyReleased

    private void jtfpagoconKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpagoconKeyTyped
        // TODO add your handling code here:
          char c = evt.getKeyChar();
        if (!(Character.isDigit(c) ||
        (c == evt.VK_BACK_SPACE) ||
        (c == evt.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        }  
    }//GEN-LAST:event_jtfpagoconKeyTyped

    private void jbtncobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncobrarActionPerformed
        // TODO add your handling code here:
         this.dispose();
         DetalleCaja detcaja= new DetalleCaja();
         detcaja.setImporte(total);
         
        jifventa.setvender(detcaja);
       
    }//GEN-LAST:event_jbtncobrarActionPerformed

    private void jtfpagoconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfpagoconActionPerformed
        // TODO add your handling code here:
        jbtncobrar.doClick();
    }//GEN-LAST:event_jtfpagoconActionPerformed

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
            java.util.logging.Logger.getLogger(JDFPagarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDFPagarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDFPagarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDFPagarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDFPagarVenta dialog = new JDFPagarVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtncobrar;
    private javax.swing.JLabel jlblmensaje;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JLabel jlblvuelto;
    private javax.swing.JTextField jtfpagocon;
    // End of variables declaration//GEN-END:variables
}
