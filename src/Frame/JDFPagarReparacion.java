/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAODetCaja;
import Dao.DAOReparacion;
import Pojos.DetalleCaja;
import Pojos.Reparacion;

/**
 *
 * @author info2017
 */
public class JDFPagarReparacion extends javax.swing.JDialog {

    /**
     * Creates new form JDFPagarReparacion
     */
    Reparacion reparacion;
    DAOReparacion daoreparacion = new DAOReparacion();
    DAODetCaja daodetcaja= new DAODetCaja();
    public JDFPagarReparacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
     public JDFPagarReparacion(java.awt.Frame parent, boolean modal,Reparacion reparacion) {
        super(parent, modal);
        initComponents();
        this.reparacion=reparacion;
        jlblcodigo.setText(reparacion.getCodigo());
        daoreparacion.verdeuda(jlbltotal, jlblabonos, jlbldeuda, reparacion.getId());
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
        jtfimporte = new javax.swing.JTextField();
        jlbldeuda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfaobservacion = new javax.swing.JTextArea();
        jbtncobrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jlbltotal = new javax.swing.JLabel();
        jlblabonos = new javax.swing.JLabel();
        jlblcodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setText("Importe:");

        jtfimporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfimporteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfimporteKeyTyped(evt);
            }
        });

        jlbldeuda.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jlbldeuda.setText("jLabel2");

        jtfaobservacion.setColumns(20);
        jtfaobservacion.setRows(5);
        jScrollPane1.setViewportView(jtfaobservacion);

        jbtncobrar.setText("Cobrar");
        jbtncobrar.setEnabled(false);
        jbtncobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncobrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setText("Observación:");

        jlbltotal.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jlbltotal.setText("jLabel3");

        jlblabonos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jlblabonos.setText("jLabel4");

        jlblcodigo.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jlblcodigo.setForeground(new java.awt.Color(255, 51, 51));
        jlblcodigo.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("Total:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("Abonos:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setText("Deuda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblabonos, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jlbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addComponent(jbtncobrar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlblcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbldeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jlblcodigo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbltotal)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblabonos)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbldeuda)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfimporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtncobrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfimporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfimporteKeyReleased
        // TODO add your handling code here:
        try{
         Double deuda=Double.parseDouble(jlbldeuda.getText());
        Double paga = Double.parseDouble(jtfimporte.getText());
        if(paga <= deuda){
        jbtncobrar.setEnabled(true);
        
        }else {
         jbtncobrar.setEnabled(false);
        }
       
        }catch(Exception e){
        jbtncobrar.setEnabled(false);
        }
       
    }//GEN-LAST:event_jtfimporteKeyReleased

    private void jbtncobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncobrarActionPerformed
        // TODO add your handling code here:
        DetalleCaja detcaja= new DetalleCaja();
        detcaja.setImporte(Double.parseDouble(jtfimporte.getText()));
        detcaja.setObservacion(jtfaobservacion.getText().toUpperCase());
        detcaja.setIdreparir(reparacion.getId());
        
        daodetcaja.insertrepair(detcaja);
        this.dispose();
        
    }//GEN-LAST:event_jbtncobrarActionPerformed

    private void jtfimporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfimporteKeyTyped
        // TODO add your handling code here:
           char c = evt.getKeyChar();
        if (!(Character.isDigit(c) ||
        (c == evt.VK_BACK_SPACE) ||
        (c == evt.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        }  
    }//GEN-LAST:event_jtfimporteKeyTyped

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
            java.util.logging.Logger.getLogger(JDFPagarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDFPagarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDFPagarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDFPagarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDFPagarReparacion dialog = new JDFPagarReparacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtncobrar;
    private javax.swing.JLabel jlblabonos;
    private javax.swing.JLabel jlblcodigo;
    private javax.swing.JLabel jlbldeuda;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JTextArea jtfaobservacion;
    private javax.swing.JTextField jtfimporte;
    // End of variables declaration//GEN-END:variables
}