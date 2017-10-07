/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOEmpleado;
import Pojos.Empleado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class JIFempleados extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFempleados
     */
    boolean editar;
    DAOEmpleado daoempleado= new DAOEmpleado();
    Empleado empleado = new Empleado();
    List<Empleado> listempleado;
    public JIFempleados() {
        initComponents();
        bloquearjbtn(true, false,false, false, false);
        bloquearjtf(false, false, false, false, false);
        listempleado=daoempleado.view(jtabla);
    }
     public void bloquearjbtn(boolean nuevo,boolean editar,boolean guardar,boolean eliminar,boolean cancelar
     ){
    jbtnnew.setEnabled(nuevo);
    jbtneditar.setEnabled(editar);
    jbtnguardar.setEnabled(guardar);
    jbtneliminar.setEnabled(eliminar);
    jbtncancelar.setEnabled(cancelar);
//    jbtnsalir.setEnabled(salir);
     
    
    }
     public void bloquearjtf(boolean nombres,boolean apellidos,boolean telefono,boolean domicilio,
     boolean rut){
     jtfnombres.setEnabled(nombres);
     jtfapellidos.setEnabled(apellidos);
     jtftelefono.setEnabled(telefono);
     jtfdomicilio.setEnabled(domicilio);
     jtfrut.setEnabled(rut);
     
     }
     public void limpiarjtf(){
     jtfnombres.setText("");
     jtfapellidos.setText("");
     jtftelefono.setText("");
     jtfdomicilio.setText("");
     jtfrut.setText("");
     
     }
     public void validaguardar(){
     String nombre= jtfnombres.getText().replaceAll("\\s", "");
     String apell = jtfapellidos.getText().replaceAll("\\s", "");
     String rut = jtfrut.getText().replaceAll("\\s", "");
     
     if (nombre.length() > 0 && apell.length() >0 && rut.length()>0){
         jbtnguardar.setEnabled(true);
     
     }else {
         jbtnguardar.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfnombres = new javax.swing.JTextField();
        jtfapellidos = new javax.swing.JTextField();
        jtfrut = new javax.swing.JFormattedTextField();
        jtftelefono = new javax.swing.JTextField();
        jtfdomicilio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jtfbuscar = new javax.swing.JTextField();
        jbtnnew = new javax.swing.JButton();
        jbtneditar = new javax.swing.JButton();
        jbtnguardar = new javax.swing.JButton();
        jbtneliminar = new javax.swing.JButton();
        jbtncancelar = new javax.swing.JButton();
        jbtnimprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EMPLEADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("R.U.T.:");

        jLabel5.setText("Telefono.");

        jLabel6.setText("Domicilio:");

        jtfnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfnombresKeyReleased(evt);
            }
        });

        jtfapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfapellidosKeyReleased(evt);
            }
        });

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

        jLabel7.setText("Buscar:");

        jbtnnew.setBackground(new java.awt.Color(255, 255, 255));
        jbtnnew.setText("NUEVO");
        jbtnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnnewActionPerformed(evt);
            }
        });

        jbtneditar.setBackground(new java.awt.Color(255, 255, 255));
        jbtneditar.setText("EDITAR");
        jbtneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneditarActionPerformed(evt);
            }
        });

        jbtnguardar.setBackground(new java.awt.Color(255, 255, 255));
        jbtnguardar.setText("GUARDAR");
        jbtnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnguardarActionPerformed(evt);
            }
        });

        jbtneliminar.setBackground(new java.awt.Color(255, 255, 255));
        jbtneliminar.setText("ELIMINAR");
        jbtneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneliminarActionPerformed(evt);
            }
        });

        jbtncancelar.setBackground(new java.awt.Color(255, 255, 255));
        jbtncancelar.setText("CANCELAR");
        jbtncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncancelarActionPerformed(evt);
            }
        });

        jbtnimprimir.setText("IMPRIMIR");
        jbtnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(jtfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfrut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnimprimir)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jtfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnimprimir))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnnewActionPerformed
        // TODO add your handling code here:
        bloquearjtf(true, true,true,true,true );
        bloquearjbtn(true, false, false, false, true);

        limpiarjtf();

        editar=false;
    }//GEN-LAST:event_jbtnnewActionPerformed

    private void jbtneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneditarActionPerformed
        // TODO add your handling code here:
        bloquearjtf(true, false,true,true,true);

        editar=true;
        bloquearjbtn(true, false, false, false, true);
    }//GEN-LAST:event_jbtneditarActionPerformed

    private void jbtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnguardarActionPerformed
        // TODO add your handling code here:
    empleado.setNombre(jtfnombres.getText().toUpperCase());
    empleado.setApellido(jtfapellidos.getText().toUpperCase());
    empleado.setRut(jtfrut.getText().toUpperCase());
    empleado.setDomicilio(jtfdomicilio.getText().toUpperCase());
    empleado.setTelefono(jtftelefono.getText().toUpperCase());

        if(editar==false){
            //  long id=Long.parseLong(jtabla.getValueAt(jtabla.getSelectedRow(), 0).toString());
            if(daoempleado.duplicate(0, jtfrut.getValue().toString().toUpperCase(), "GUARDAR")==true){

                daoempleado.insert(empleado);

            }else {
                JOptionPane.showMessageDialog(null, "EL RUT "+jtfrut.getValue().toString().toUpperCase()+" YA SE ENCUENTRA REGISTRADA","SISTEMA",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        }    else{
            //                    usuario.setUsuario(jtfusuario.getText());

            if(daoempleado.duplicate(empleado.getId(), jtfrut.getValue().toString().toUpperCase(), "EDITAR")==true){
                daoempleado.update(empleado);

            }else {
                JOptionPane.showMessageDialog(null, "EL RUT "+jtfrut.getValue().toString().toUpperCase()+" YA SE ENCUENTRA REGISTRADA","SISTEMA",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        }

        listempleado = daoempleado.view(jtabla);
        bloquearjbtn(true, false, false, false, false);
        bloquearjtf(false, false, false,false,false);
        limpiarjtf();
    }//GEN-LAST:event_jbtnguardarActionPerformed

    private void jbtneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneliminarActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL EMPLEADO","ELIMINAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            daoempleado.delete(empleado.getId());
            listempleado = daoempleado.view(jtabla);
            limpiarjtf();
            bloquearjbtn(true, false, false, false, false);

        }

    }//GEN-LAST:event_jbtneliminarActionPerformed

    private void jbtncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncancelarActionPerformed
        // TODO add your handling code here:
        int index = jtabla.getSelectedRow();
        if(index>=0){
            jtablaMouseReleased(null);
        } else {
            limpiarjtf();
        }
        bloquearjbtn(true, false, false, false, false);
        bloquearjtf(false, false, false,false,false);
    }//GEN-LAST:event_jbtncancelarActionPerformed

    private void jbtnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnimprimirActionPerformed
        // TODO add your handling code here:
        daoempleado.print();
    }//GEN-LAST:event_jbtnimprimirActionPerformed

    private void jtablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaMouseReleased
        // TODO add your handling code here:
        empleado = listempleado.get(jtabla.getSelectedRow());
        jtfnombres.setText(empleado.getNombre());
        jtfapellidos.setText(empleado.getApellido());
        jtfrut.setText(empleado.getRut());
        jtfdomicilio.setText(empleado.getDomicilio());
        jtftelefono.setText(empleado.getTelefono());
        
                
    }//GEN-LAST:event_jtablaMouseReleased

    private void jtablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablaKeyReleased
        // TODO add your handling code here:
        empleado = listempleado.get(jtabla.getSelectedRow());
        jtfnombres.setText(empleado.getNombre());
        jtfapellidos.setText(empleado.getApellido());
        jtfrut.setText(empleado.getRut());
        jtfdomicilio.setText(empleado.getDomicilio());
        jtftelefono.setText(empleado.getTelefono());
    }//GEN-LAST:event_jtablaKeyReleased

    private void jtfnombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfnombresKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfnombresKeyReleased

    private void jtfapellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfapellidosKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfapellidosKeyReleased

    private void jtfrutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrutKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfrutKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtncancelar;
    private javax.swing.JButton jbtneditar;
    private javax.swing.JButton jbtneliminar;
    private javax.swing.JButton jbtnguardar;
    private javax.swing.JButton jbtnimprimir;
    private javax.swing.JButton jbtnnew;
    private javax.swing.JTable jtabla;
    private javax.swing.JTextField jtfapellidos;
    private javax.swing.JTextField jtfbuscar;
    private javax.swing.JTextField jtfdomicilio;
    private javax.swing.JTextField jtfnombres;
    private javax.swing.JFormattedTextField jtfrut;
    private javax.swing.JTextField jtftelefono;
    // End of variables declaration//GEN-END:variables
}