/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOCliente;
import Dao.DAODetVenta;
import Dao.DAOVenta;
import Pojos.Arido;
import Pojos.Cliente;
import Pojos.SingletonEmpresa;
import Pojos.Venta;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author info2017
 */

public class JIFVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFVenta
     */
    Arido arido;
    List<Arido> listarido = new ArrayList<>();
    
    DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Descripcion","Cantidad","Precio und.","Importe"};
        Object datos[] = new Object[4];
    
        Double total;
        DAOCliente daocliente = new DAOCliente();
        Cliente cliente;
        DAOVenta daoventa= new DAOVenta();
        DAODetVenta daodetventa= new DAODetVenta();
        Venta venta = new Venta();
        SingletonEmpresa singletonempresa= SingletonEmpresa.getinstancia();
    public JIFVenta() {
        initComponents();
        modelo.setColumnIdentifiers(titulos);
        jtabla.setModel(modelo);
        total=0.0;
    }
    
    public void setarido(Arido arido){
        this.arido=arido;
        listarido.add(arido);
        Double importe;
        NumberFormat nf = NumberFormat.getInstance();
        importe = arido.getCantidad() * arido.getPrecio();
        datos[0] = arido.getDescripcion();
        datos[1] = arido.getCantidad();
        datos[2] = nf.format(arido.getPrecio());
        datos[3] = nf.format(importe);
        modelo.addRow(datos);
        total=total+importe;
        jlbltotal.setText(nf.format(total));
                
    
    }
    public void setvender(){
        venta.setIdempresa(singletonempresa.getId());
        venta.setDescuento(0.0);
    if(cliente!=null){
        /// insert venta con cliente
        venta.setIdcliente(cliente.getId());
        venta.setId(daoventa.insert(venta));
        
    }else {
        /// insert venta sin cliente
        venta.setId(daoventa.insertnoclient(venta));
        
        }
    daodetventa.insert(listarido, venta.getId());
    daoventa.print(venta.getId());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfrut = new javax.swing.JFormattedTextField();
        jlblrazonsocial = new javax.swing.JLabel();
        jlbldominiciliopart = new javax.swing.JLabel();
        jlbldirecciontrab = new javax.swing.JLabel();
        jlblmensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jbtnagregar = new javax.swing.JButton();
        jbtnvender = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jlbltotal = new javax.swing.JLabel();
        jbtncancelar = new javax.swing.JButton();
        jlblmensajeventa = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NUEVA VENTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel2.setText("R.U.T");

        jLabel3.setText("Nombre / Razon Social:");

        jLabel4.setText("Dirección Particular:");

        jLabel5.setText("Dirección Trabajo:");

        try {
            jtfrut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfrut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfrutKeyReleased(evt);
            }
        });

        jlblrazonsocial.setText("* * *");

        jlbldominiciliopart.setText("* * *");

        jlbldirecciontrab.setText("* * *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(78, 78, 78)
                .addComponent(jtfrut, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblrazonsocial, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addComponent(jlbldominiciliopart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbldirecciontrab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jlblrazonsocial, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlbldominiciliopart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlbldirecciontrab))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtablaMouseReleased(evt);
            }
        });
        jtabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtabla);

        jbtnagregar.setText("Agregar");
        jbtnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnagregarActionPerformed(evt);
            }
        });

        jbtnvender.setText("Vender");
        jbtnvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnvenderActionPerformed(evt);
            }
        });

        jLabel6.setText("Total:");

        jlbltotal.setForeground(new java.awt.Color(255, 51, 51));
        jlbltotal.setText("* * *");

        jbtncancelar.setText("Cancelar");
        jbtncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncancelarActionPerformed(evt);
            }
        });

        jlblmensajeventa.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnagregar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblmensajeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtncancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbtnvender))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnvender)
                            .addComponent(jLabel6)
                            .addComponent(jlbltotal)
                            .addComponent(jbtncancelar))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlblmensajeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnagregarActionPerformed
        // TODO add your handling code here:
        JDFBuscarAridoVenta barido = new JDFBuscarAridoVenta(new JFrame(), isVisible(),this);
        barido.setVisible(true);
    }//GEN-LAST:event_jbtnagregarActionPerformed

    private void jtfrutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrutKeyReleased
        // TODO add your handling code here:
        cliente=daocliente.search(jtfrut.getText());
        if(cliente!=null){
        jlblrazonsocial.setText(cliente.getNombre()+"  "+cliente.getApellido());
        jlbldominiciliopart.setText(cliente.getDomiciliopart());
        jlbldirecciontrab.setText(cliente.getDomiciliatrab());
       
        jlblmensaje.setText("");
       
        }else {
        
        jlblmensaje.setText("Cliente no encontrado");
        jlblrazonsocial.setText("* * *");
        jlbldominiciliopart.setText("* * *");
        jlbldirecciontrab.setText("* * *");
        cliente=null;
        
        }
        
    }//GEN-LAST:event_jtfrutKeyReleased

    private void jbtnvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnvenderActionPerformed
        // TODO add your handling code here:
       if(listarido.size()>0){
           JDFPagarVenta pagar=new JDFPagarVenta(new JFrame(),isVisible(),total,this);
            pagar.setVisible(true);
            jlblmensajeventa.setText("");
       }else {
           jlblmensajeventa.setText("Ingrese datos e intente nuevamente");
       }
        
    }//GEN-LAST:event_jbtnvenderActionPerformed

    private void jtablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablaKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtablaKeyReleased

    private void jtablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaMouseReleased
        // TODO add your handling code here:
        Arido arido= new Arido();
        if(evt.getClickCount()==2){
            if(JOptionPane.showConfirmDialog(null, "Esta seguro de retirar el producto de la venta","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                int index = jtabla.getSelectedRow();
                arido=listarido.get(index);
                daodetventa.returnstock(arido.getId(),arido.getCantidad());
                listarido.remove(index);
                modelo.removeRow(index);
            }
            
            
        }
    }//GEN-LAST:event_jtablaMouseReleased

    private void jbtncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncancelarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar la venta","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        for (Arido arido: listarido){
            daodetventa.returnstock(arido.getId(),arido.getCantidad());
        }
        this.dispose();
        }
    }//GEN-LAST:event_jbtncancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnagregar;
    private javax.swing.JButton jbtncancelar;
    private javax.swing.JButton jbtnvender;
    private javax.swing.JLabel jlbldirecciontrab;
    private javax.swing.JLabel jlbldominiciliopart;
    private javax.swing.JLabel jlblmensaje;
    private javax.swing.JLabel jlblmensajeventa;
    private javax.swing.JLabel jlblrazonsocial;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JTable jtabla;
    private javax.swing.JFormattedTextField jtfrut;
    // End of variables declaration//GEN-END:variables
}
