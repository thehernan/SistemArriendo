/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOCliente;
import Dao.DAODetalleOrden;
import Dao.DAOOrdenCompra;
import Pojos.Cliente;
import Pojos.DetalleOrdenCompra;
import Pojos.OrdenCompra;
import java.awt.Frame;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author info2017
 */
public class JIFOrdenCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFOrdenCompra
     */
     DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Codigo","Cantidad","Unidad med.","Descripcion","P. unit","% Dscto","Valor Total"};
        Object datosmaq[] = new Object[7];
        
    Cliente cliente;
    DAOCliente daocliente = new DAOCliente();
    List<DetalleOrdenCompra> listdet = new ArrayList<>();
    DAOOrdenCompra daoordencompra= new DAOOrdenCompra();
    DAODetalleOrden daodetorden = new DAODetalleOrden();
            
    public JIFOrdenCompra() {
        initComponents();
          modelo.setColumnIdentifiers(titulos);
        jtabla.setModel(modelo);
    }
    
    public void setdetalle(DetalleOrdenCompra detorden){
        NumberFormat nf= NumberFormat.getInstance();
        datosmaq[0]=detorden.getCodigo();
        datosmaq[1]=detorden.getCantidad();
        datosmaq[2]=detorden.getUnidad();
        datosmaq[3]=detorden.getDescripcion();
        datosmaq[4]=nf.format(detorden.getPreciounid());
        datosmaq[5]="% "+ detorden.getDesc();
        Double desc= (detorden.getCantidad()*detorden.getPreciounid())* (detorden.getDesc()/100);
        Double total= (detorden.getCantidad()*detorden.getPreciounid())-desc;
        detorden.setValortotal(total);
        datosmaq[6]=nf.format(total);
        modelo.addRow(datosmaq);
        listdet.add(detorden);
        validagenerar();
    
    
    }
    public void validagenerar(){
        if(cliente != null && listdet.size()>0){
        jbtnaceptar.setEnabled(true);
        }else {
        jbtnaceptar.setEnabled(false);
        }
    
    
    }
    public void nueva(){
    cliente=null;
    jtfrut.setValue(null);
    jlblrazons.setText("* * *");
    jlbldomiciliopart.setText("* * *");
    jlbldomiciliotrab.setText("* * *");
    jlblfono.setText("* * *");
    jlbldomiciliotrab.setEnabled(false);
    jlbldomiciliotrab.setText("");
    jtfaprobadopor.setText("");
    jtfdespachar.setText("");
    jtfformadepago.setText("");
    
    listdet= new ArrayList<>();
     for (int i = 0; i < jtabla.getRowCount(); i++) {
    modelo.removeRow(i);
    i-=1;
    }
    jbtnaceptar.setEnabled(false);
    
    }
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfrut = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jlblrazons = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbldomiciliopart = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblfono = new javax.swing.JLabel();
        jlblmensaje = new javax.swing.JLabel();
        jlbldomiciliotrab = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jbtnagregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfaprobadopor = new javax.swing.JTextField();
        jtfdespachar = new javax.swing.JTextField();
        jtfformadepago = new javax.swing.JTextField();
        jbtnaceptar = new javax.swing.JButton();

        setClosable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Proveedor"));

        jLabel2.setText("R.U.T:");

        try {
            jtfrut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfrut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfrutKeyReleased(evt);
            }
        });

        jLabel3.setText("Señor(es):");

        jlblrazons.setText("* * *");

        jLabel5.setText("Domicilio Particular:");

        jlbldomiciliopart.setText("* * *");

        jLabel7.setText("Domicilio Trabajo:");

        jLabel9.setText("Fono:");

        jlblfono.setText("* * *");

        jlbldomiciliotrab.setText("* * *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbldomiciliopart, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbldomiciliotrab, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlblfono, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfrut, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jlblrazons, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jlblrazons))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlbldomiciliopart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlbldomiciliotrab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jlblfono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("NUEVA ORDEN COMPRA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jtabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtabla);

        jbtnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maquina.png"))); // NOI18N
        jbtnagregar.setText("Agregar");
        jbtnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnagregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Aprobada por:");

        jLabel4.setText("Despachar a:");

        jLabel6.setText("Forma de pago:");

        jbtnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accept2.png"))); // NOI18N
        jbtnaceptar.setText("Aceptar / Imprimir");
        jbtnaceptar.setEnabled(false);
        jbtnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnaceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnagregar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jtfdespachar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfformadepago))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfaprobadopor, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnaceptar)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfaprobadopor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfdespachar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfformadepago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnaceptar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfrutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrutKeyReleased
        // TODO add your handling code here:
        cliente=daocliente.search(jtfrut.getText(),"PROVEEDOR");
        if(cliente!=null){
            jlblrazons.setText(cliente.getNombre()+"  "+cliente.getApellido());
            jlbldomiciliopart.setText(cliente.getDomiciliopart());
            jlbldomiciliotrab.setText(cliente.getDomiciliatrab());
            jlblfono.setText(cliente.getTelefono());
            jlblmensaje.setText("");
            jlbldomiciliotrab.setEnabled(true);
        }else {

            jlblmensaje.setText("Cliente no encontrado");
            jlblrazons.setText("* * *");
            jlbldomiciliopart.setText("* * *");
            jlbldomiciliotrab.setText("* * *");
            jlblfono.setText("* * *");
            cliente=null;
            jlbldomiciliotrab.setEnabled(false);
            jlbldomiciliotrab.setText("");
        }
        validagenerar();
    }//GEN-LAST:event_jtfrutKeyReleased

    private void jbtnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnagregarActionPerformed
        // TODO add your handling code here:
        JDFDetalleOrdenCompra detc = new JDFDetalleOrdenCompra(new Frame(), isVisible(),this);
        detc.setVisible(true);
    }//GEN-LAST:event_jbtnagregarActionPerformed

    private void jbtnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnaceptarActionPerformed
        // TODO add your handling code here:
        OrdenCompra orden = new OrdenCompra();
        orden.setAprobada(jtfaprobadopor.getText().toUpperCase());
        orden.setDespachar(jtfdespachar.getText().toUpperCase());
        orden.setFormapago(jtfformadepago.getText().toUpperCase());
        orden.setIdcliente(cliente.getId());
        orden.setId(daoordencompra.insert(orden));
        
        daodetorden.insert(listdet, orden.getId());
        
    }//GEN-LAST:event_jbtnaceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnaceptar;
    private javax.swing.JButton jbtnagregar;
    private javax.swing.JLabel jlbldomiciliopart;
    private javax.swing.JLabel jlbldomiciliotrab;
    private javax.swing.JLabel jlblfono;
    private javax.swing.JLabel jlblmensaje;
    private javax.swing.JLabel jlblrazons;
    private javax.swing.JTable jtabla;
    private javax.swing.JTextField jtfaprobadopor;
    private javax.swing.JTextField jtfdespachar;
    private javax.swing.JTextField jtfformadepago;
    private javax.swing.JFormattedTextField jtfrut;
    // End of variables declaration//GEN-END:variables
}