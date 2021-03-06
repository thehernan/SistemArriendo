/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOCliente;
import Pojos.Cliente;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author info2017
 */
public class JIFClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFClientes
     */
    DAOCliente daocliente= new DAOCliente();
    Cliente cliente = new Cliente();
    boolean editar;
    List<Cliente> listcliente;
    String rutaimagen=null;
//    byte[]  fotoB=new  byte[0];
    public JIFClientes() {
        initComponents();
        bloquearjbtn(true, false, false, false, false,false,false);
        bloquearjtf(false, false, false, false,false, false);
        listcliente = daocliente.view(jtabla);
    }
    
     public void bloquearjbtn(boolean nuevo,boolean editar,boolean guardar,boolean eliminar,boolean cancelar,
             boolean  adjuntar,boolean print
     ){
    jbtnnew.setEnabled(nuevo);
    jbtneditar.setEnabled(editar);
    jbtnguardar.setEnabled(guardar);
    jbtneliminar.setEnabled(eliminar);
    jbtncancelar.setEnabled(cancelar);
//    jbtnsalir.setEnabled(salir);
    jbtnadjuntar.setEnabled(adjuntar);
     jbtnimprimir.setEnabled(print);
    
    }
     public void bloquearjtf(boolean nombre,boolean apellidos,boolean rut,boolean telefono,boolean domiciliopart,
     boolean domiciliotrab){
     jtfnombre.setEnabled(nombre);
     jtfapellidos.setEnabled(apellidos);
     jtfrut.setEnabled(rut);
     jtftelefono.setEnabled(telefono);
     jtfdomiciliopart.setEnabled(domiciliopart);
     jtfdomiciliotrab.setEnabled(domiciliotrab);
     
     }
     public void limpiarjtf(){
     jtfnombre.setText("");
     jtfapellidos.setText("");
     jtfrut.setText("");
     jtftelefono.setText("");
     jtfdomiciliopart.setText("");
     jtfdomiciliotrab.setText(""); 
     jlblruta.setText("* * *");
     }
     public void validaguardar(){
     String nomb= jtfnombre.getText().replaceAll("\\s", "");
     String apell= jtfapellidos.getText().replaceAll("\\s", "");
     String rut= jtfrut.getText().replaceAll("\\s", "");
     String tel = jtftelefono.getText().replaceAll("\\s", "");
     String dompart= jtfdomiciliopart.getText().replaceAll("\\s", "");
     String domtrab = jtfdomiciliotrab.getText().replaceAll("\\s", "");
     if (nomb.length()>0 && apell.length()>0 && rut.length()>0 && tel.length() >0 && dompart.length() >0  &&
         domtrab.length() >0){
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
        jLabel7 = new javax.swing.JLabel();
        jtfnombre = new javax.swing.JTextField();
        jtfapellidos = new javax.swing.JTextField();
        jtfrut = new javax.swing.JFormattedTextField();
        jtftelefono = new javax.swing.JTextField();
        jtfdomiciliopart = new javax.swing.JTextField();
        jtfdomiciliotrab = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jtfbuscar = new javax.swing.JTextField();
        jbtnnew = new javax.swing.JButton();
        jbtneditar = new javax.swing.JButton();
        jbtnguardar = new javax.swing.JButton();
        jbtneliminar = new javax.swing.JButton();
        jbtncancelar = new javax.swing.JButton();
        jbtnimprimir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jbtnadjuntar = new javax.swing.JButton();
        jlblruta = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("REGISTRO DE CLIENTES");

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

        jLabel4.setText("R.U.T:");

        jLabel5.setText("Telefono:");

        jLabel6.setText("Domicilio Part.:");

        jLabel7.setText("Domicilio Trab.:");

        jtfnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfnombreKeyReleased(evt);
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

        jtftelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtftelefonoKeyReleased(evt);
            }
        });

        jtfdomiciliopart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfdomiciliopartKeyReleased(evt);
            }
        });

        jtfdomiciliotrab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfdomiciliotrabKeyReleased(evt);
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

        jLabel8.setText("Buscar:");

        jtfbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscarKeyReleased(evt);
            }
        });

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

        jLabel9.setText("Adjuntar Copia:");

        jbtnadjuntar.setText("ADJUNTAR...");
        jbtnadjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnadjuntarActionPerformed(evt);
            }
        });

        jlblruta.setText("* * *");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfbuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfapellidos)
                                    .addComponent(jtfrut)
                                    .addComponent(jtftelefono)
                                    .addComponent(jtfdomiciliopart)
                                    .addComponent(jtfnombre)
                                    .addComponent(jtfdomiciliotrab)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblruta)
                                    .addComponent(jbtnadjuntar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jbtnimprimir)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtnimprimir))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfdomiciliopart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfdomiciliotrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jbtnadjuntar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblruta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnnewActionPerformed
        // TODO add your handling code here:
        cliente = new Cliente();
        cliente.setCopiacarne(new  byte[0]);
        bloquearjtf(true,true,true,true,true,true);
        bloquearjbtn(true, false, false, false, true,true,false);

        limpiarjtf();

        editar=false;
    }//GEN-LAST:event_jbtnnewActionPerformed

    private void jbtneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneditarActionPerformed
        // TODO add your handling code here:
        bloquearjtf(true,true,true,true,true,true);

        editar=true;
        bloquearjbtn(true, false, false, false, true,true,false);
    }//GEN-LAST:event_jbtneditarActionPerformed

    private void jbtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnguardarActionPerformed
        // TODO add your handling code here:
       cliente.setNombre(jtfnombre.getText().toUpperCase());
       cliente.setApellido(jtfapellidos.getText().toUpperCase());
       cliente.setRut(jtfrut.getText().toUpperCase());
       cliente.setTelefono(jtftelefono.getText());
       cliente.setDomiciliatrab(jtfdomiciliotrab.getText().toUpperCase());
       cliente.setDomiciliopart(jtfdomiciliopart.getText().toUpperCase());

        if(editar==false){
            //  long id=Long.parseLong(jtabla.getValueAt(jtabla.getSelectedRow(), 0).toString());
            if(daocliente.duplicate(0, jtfrut.getText().toUpperCase(), "GUARDAR")==true){
                cliente.setTipo("CLIENTE");
                daocliente.insert(cliente);

            }else {
                JOptionPane.showMessageDialog(null, "EL RUT "+jtfrut.getText().toUpperCase()+" YA SE ENCUENTRA REGISTRADA","SISTEMA",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        }    else{
            //                    usuario.setUsuario(jtfusuario.getText());

            if(daocliente.duplicate(cliente.getId(), jtfrut.getText().toUpperCase(), "EDITAR")==true){
                daocliente.update(cliente);

            }else {
                JOptionPane.showMessageDialog(null, "LA RUT "+jtfrut.getText().toUpperCase()+" YA SE ENCUENTRA REGISTRADA","SISTEMA",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        }

        listcliente = daocliente.view(jtabla);
        bloquearjbtn(true, false, false, false, false,false,false);
        bloquearjtf(false, false, false,false,false,false);
        limpiarjtf();
    }//GEN-LAST:event_jbtnguardarActionPerformed

    private void jbtneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneliminarActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LA TARIFA","ELIMINAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            daocliente.delete(cliente.getId());
            listcliente = daocliente.view(jtabla);
            limpiarjtf();
            bloquearjbtn(true, false, false, false, false,false,false);

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
        bloquearjbtn(true, false, false, false, false,false,false);
        bloquearjtf(false, false, false,false,false,false);
    }//GEN-LAST:event_jbtncancelarActionPerformed

    private void jbtnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnimprimirActionPerformed
        // TODO add your handling code here:
        System.out.println("cliente"+cliente.getId());
        daocliente.print(cliente.getId());
    }//GEN-LAST:event_jbtnimprimirActionPerformed

    private void jtablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaMouseReleased
        // TODO add your handling code here:
        cliente = listcliente.get(jtabla.getSelectedRow());
        jtfnombre.setText(cliente.getNombre());
        jtfapellidos.setText(cliente.getApellido());
        jtfrut.setText(cliente.getRut());
        jtfdomiciliopart.setText(cliente.getDomiciliopart());
        jtfdomiciliotrab.setText(cliente.getDomiciliatrab());
        jtftelefono.setText(cliente.getTelefono());
        bloquearjbtn(true, true, false, true, false,false,true); 
        
                
    }//GEN-LAST:event_jtablaMouseReleased

    private void jtablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablaKeyReleased
        // TODO add your handling code here:
         cliente = listcliente.get(jtabla.getSelectedRow());
        jtfnombre.setText(cliente.getNombre());
        jtfapellidos.setText(cliente.getApellido());
        jtfrut.setText(cliente.getRut());
        jtfdomiciliopart.setText(cliente.getDomiciliopart());
        jtfdomiciliotrab.setText(cliente.getDomiciliatrab());
        jtftelefono.setText(cliente.getTelefono());
          bloquearjbtn(true, true, false, true, false,false,true); 
    }//GEN-LAST:event_jtablaKeyReleased

    private void jbtnadjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnadjuntarActionPerformed
        // TODO add your handling code here:
       
   
       
    JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Archivos png & jpg", "png", "jpg");
        chooser.setFileFilter(filter);
        String userHome = System.getProperty( "user.home" );
        chooser.setCurrentDirectory(new File(userHome));
        chooser.setAcceptAllFileFilterUsed(false);
        int retrival = chooser.showOpenDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {                        
                try {
                    rutaimagen = chooser.getSelectedFile().getAbsolutePath();
                    File file = new File(rutaimagen);
                    byte[]  fotobys= Files.readAllBytes(file.toPath());
                    cliente.setCopiacarne(fotobys);
                    jlblruta.setText(rutaimagen);
                    
//                    Image icono=ImageIO.read(chooser.getSelectedFile()).getScaledInstance
//                    (jlblImageUser.getWidth(),jlblImageUser.getHeight(),Image.SCALE_DEFAULT);
//                    jlblImageUser.setIcon(new ImageIcon(icono));
//                    jlblImageUser.updateUI();

//                   validaguardar();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }
        validaguardar();
    }//GEN-LAST:event_jbtnadjuntarActionPerformed

    private void jtfnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfnombreKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfnombreKeyReleased

    private void jtfapellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfapellidosKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfapellidosKeyReleased

    private void jtfrutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrutKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfrutKeyReleased

    private void jtftelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtftelefonoKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtftelefonoKeyReleased

    private void jtfdomiciliopartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfdomiciliopartKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfdomiciliopartKeyReleased

    private void jtfdomiciliotrabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfdomiciliotrabKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfdomiciliotrabKeyReleased

    private void jtfbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarKeyReleased
        // TODO add your handling code here:
       listcliente= daocliente.searchsensitive(jtabla,"CLIENTE", jtfbuscar.getText().toUpperCase());
       if(jtabla.getSelectedRow()>=0){
             cliente = listcliente.get(jtabla.getSelectedRow());
            jtfnombre.setText(cliente.getNombre());
            jtfapellidos.setText(cliente.getApellido());
            jtfrut.setText(cliente.getRut());
            jtfdomiciliopart.setText(cliente.getDomiciliopart());
            jtfdomiciliotrab.setText(cliente.getDomiciliatrab());
            jtftelefono.setText(cliente.getTelefono());
            bloquearjbtn(true, true, false, true, false,false,true); 
       }else {
            limpiarjtf();

             bloquearjbtn(true, false, false, false, false,false,false);
             bloquearjtf(false, false, false,false,false,false);
       
       }
    }//GEN-LAST:event_jtfbuscarKeyReleased


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnadjuntar;
    private javax.swing.JButton jbtncancelar;
    private javax.swing.JButton jbtneditar;
    private javax.swing.JButton jbtneliminar;
    private javax.swing.JButton jbtnguardar;
    private javax.swing.JButton jbtnimprimir;
    private javax.swing.JButton jbtnnew;
    private javax.swing.JLabel jlblruta;
    private javax.swing.JTable jtabla;
    private javax.swing.JTextField jtfapellidos;
    private javax.swing.JTextField jtfbuscar;
    private javax.swing.JTextField jtfdomiciliopart;
    private javax.swing.JTextField jtfdomiciliotrab;
    private javax.swing.JTextField jtfnombre;
    private javax.swing.JFormattedTextField jtfrut;
    private javax.swing.JTextField jtftelefono;
    // End of variables declaration//GEN-END:variables
}
