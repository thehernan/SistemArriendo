/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import ClasesGlobales.FechaHora;
import Dao.DAOContrato;
import Pojos.Contrato;
import Pojos.SingletonEmpresa;
import java.awt.Frame;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class JIFContratosVigentes extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFContratosVigentes
     */
    List<Contrato> listcontrcli;
    List<Contrato> listcontremp;
    DAOContrato daocontrato = new DAOContrato();
    SingletonEmpresa singletonempre = SingletonEmpresa.getinstancia();
    Contrato contrato= new Contrato();
    FechaHora fechah = new FechaHora();
    public JIFContratosVigentes() {
        initComponents();
        listcontrcli=daocontrato.view(jtablacliente, singletonempre.getId(),true,"CLIENTE");
        listcontremp=daocontrato.view(jtablaempresa, singletonempre.getId(),true,"EMPRESA");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfbuscarclientecod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablacliente = new javax.swing.JTable();
        jbtnimprimircliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfbuscarclientenombre = new javax.swing.JTextField();
        jbtneditarcliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfempresacodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablaempresa = new javax.swing.JTable();
        jbtnimprimirempresa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfbuscarempresaclient = new javax.swing.JTextField();
        jbtneditarempresa = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CONTRATOS VIGENTES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Codigo:");

        jtfbuscarclientecod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscarclientecodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfbuscarclientecodKeyTyped(evt);
            }
        });

        jtablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtablacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtablaclienteMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtablacliente);

        jbtnimprimircliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print2.png"))); // NOI18N
        jbtnimprimircliente.setText("Imprimir");
        jbtnimprimircliente.setEnabled(false);

        jLabel4.setText("Cliente / Empresa:");

        jtfbuscarclientenombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscarclientenombreKeyReleased(evt);
            }
        });

        jbtneditarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jbtneditarcliente.setText("Editar");
        jbtneditarcliente.setEnabled(false);
        jbtneditarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneditarclienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfbuscarclientecod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfbuscarclientenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtneditarcliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnimprimircliente)
                .addGap(16, 16, 16))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jtfbuscarclientenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfbuscarclientecod, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtneditarcliente)
                    .addComponent(jbtnimprimircliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTE", jPanel2);

        jLabel3.setText("Codigo:");

        jtfempresacodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfempresacodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfempresacodigoKeyTyped(evt);
            }
        });

        jtablaempresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtablaempresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtablaempresaMouseReleased(evt);
            }
        });
        jtablaempresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtablaempresaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtablaempresa);

        jbtnimprimirempresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print2.png"))); // NOI18N
        jbtnimprimirempresa.setText("Imprimir");
        jbtnimprimirempresa.setEnabled(false);

        jLabel5.setText("Cliente / Empresa:");

        jtfbuscarempresaclient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscarempresaclientKeyReleased(evt);
            }
        });

        jbtneditarempresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jbtneditarempresa.setText("Editar");
        jbtneditarempresa.setEnabled(false);
        jbtneditarempresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneditarempresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfempresacodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfbuscarempresaclient)
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 650, Short.MAX_VALUE)
                        .addComponent(jbtneditarempresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnimprimirempresa)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfempresacodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfbuscarempresaclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtneditarempresa)
                    .addComponent(jbtnimprimirempresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EMPRESA", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfbuscarclientecodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarclientecodKeyReleased
        // TODO add your handling code here:
        try {
            long cod=Long.parseLong(jtfbuscarclientecod.getText());
        daocontrato.searchsensitive(jtablacliente, singletonempre.getId(), "VIGENTECLIENTECODIGO", cod, null);
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jtfbuscarclientecodKeyReleased

    private void jtfbuscarclientecodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarclientecodKeyTyped
        // TODO add your handling code here:
          char c = evt.getKeyChar();
        if (!(Character.isDigit(c) ||
        (c == evt.VK_BACK_SPACE) ||
        (c == evt.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        }  
    }//GEN-LAST:event_jtfbuscarclientecodKeyTyped

    private void jtfbuscarclientenombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarclientenombreKeyReleased
        // TODO add your handling code here:
        daocontrato.searchsensitive(jtablacliente, singletonempre.getId(), "VIGENTECLIENTECLIENTE", 0, jtfbuscarclientenombre.getText());
    }//GEN-LAST:event_jtfbuscarclientenombreKeyReleased

    private void jtablaclienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaclienteMouseReleased
        // TODO add your handling code here:
       
        jbtneditarcliente.setEnabled(true);
        jbtnimprimircliente.setEnabled(true);
            
    }//GEN-LAST:event_jtablaclienteMouseReleased

    private void jbtneditarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneditarclienteActionPerformed
        // TODO add your handling code here:
        contrato = listcontrcli.get(jtablacliente.getSelectedRow());
        
      if(daocontrato.validateedit(contrato.getId())==true){
         JDFEditarContrato  editcontrato = new JDFEditarContrato(new Frame(), isVisible(),contrato);
         editcontrato.setVisible(true);
      } else {
          JOptionPane.showMessageDialog(null, "El contrato ya paso de 2 horas de tolerancia; Imposible editar");
        }
            
    }//GEN-LAST:event_jbtneditarclienteActionPerformed

    private void jbtneditarempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneditarempresaActionPerformed
        // TODO add your handling code here:
        contrato = listcontremp.get(jtablaempresa.getSelectedRow());
        JDFEditarContrato  editcontrato = new JDFEditarContrato(new Frame(), isVisible(),contrato);
        editcontrato.setVisible(true);
    }//GEN-LAST:event_jbtneditarempresaActionPerformed

    private void jtfbuscarempresaclientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarempresaclientKeyReleased
        // TODO add your handling code here:
        daocontrato.searchsensitive(jtablaempresa, singletonempre.getId(), "VIGENTEEMPRESACLIENTE", 0, jtfbuscarempresaclient.getText());

    }//GEN-LAST:event_jtfbuscarempresaclientKeyReleased

    private void jtablaempresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablaempresaKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jtablaempresaKeyReleased

    private void jtablaempresaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaempresaMouseReleased
        // TODO add your handling code here:

        jbtneditarempresa.setEnabled(true);
        jbtnimprimirempresa.setEnabled(true);
    }//GEN-LAST:event_jtablaempresaMouseReleased

    private void jtfempresacodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfempresacodigoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) ||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jtfempresacodigoKeyTyped

    private void jtfempresacodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfempresacodigoKeyReleased
        // TODO add your handling code here:
        try {
            long cod=Long.parseLong(jtfempresacodigo.getText());
            daocontrato.searchsensitive(jtablaempresa, singletonempre.getId(), "VIGENTEEMPRESACODIGO", cod, null);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jtfempresacodigoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtneditarcliente;
    private javax.swing.JButton jbtneditarempresa;
    private javax.swing.JButton jbtnimprimircliente;
    private javax.swing.JButton jbtnimprimirempresa;
    private javax.swing.JTable jtablacliente;
    private javax.swing.JTable jtablaempresa;
    private javax.swing.JTextField jtfbuscarclientecod;
    private javax.swing.JTextField jtfbuscarclientenombre;
    private javax.swing.JTextField jtfbuscarempresaclient;
    private javax.swing.JTextField jtfempresacodigo;
    // End of variables declaration//GEN-END:variables
}
