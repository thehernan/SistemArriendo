/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOCategoria;
import Dao.DAOMaquinaria;
import Pojos.Categoria;
import Pojos.Maquinaria;
import Pojos.SingletonEmpresa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class JIFMaquinaria extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIMaquinaria
     */
    boolean editar;
    Maquinaria maquinaria = new Maquinaria();
    DAOMaquinaria daoMaquinaria= new DAOMaquinaria();
    List<Maquinaria> listmaquinaria;
    DAOCategoria daocategoria = new DAOCategoria();
    List<Categoria> listcategoria;
     List<Categoria> listcategoriabusc;
    Categoria categoria = new Categoria();
    Categoria categoriab = new Categoria();
    SingletonEmpresa singletonemp = SingletonEmpresa.getinstancia();
    public JIFMaquinaria() {
        initComponents();
        bloquearjbtn(true, false,false, false, false);
        bloquearjtf(false, false, false, false, false, false);
        listmaquinaria= daoMaquinaria.view(jtabla,"TODO","EMPRESA");
        listcategoria=daocategoria.jcombobox(jcbcategoria,"ARRIENDO");
        listcategoriabusc= daocategoria.jcombobox(jcbbuscarcate, "ARRIENDO");
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
     public void bloquearjtf(boolean maquina, boolean marca,boolean serie,boolean modelo,boolean categoria,
     boolean precio){
     jtfmaquina.setEnabled(maquina);
     jtfmarca.setEnabled(marca);
     jtfserie.setEnabled(serie);
     jtfmodelo.setEnabled(modelo);
     jcbcategoria.setEnabled(categoria);
     jtfprecio.setEnabled(precio);
     
             
     
     
     }
     public void limpiarjtf(){
     jtfmaquina.setText("");
     jtfmarca.setText("");
     jtfserie.setText("");
     jtfmodelo.setText("");
//     jcbcategoria.setSelectedIndex(0);
     jtfprecio.setValue(0);
     
     }
     
     public void validaguardar(){
     String maq= jtfmaquina.getText().replaceAll("\\s", "");
     String marc= jtfmarca.getText().replaceAll("\\s","");
     String seri= jtfserie.getText().replaceAll("\\s", "");
     String mod= jtfmodelo.getText().replaceAll("\\s", "");
     Double precio = Double.parseDouble(jtfprecio.getValue().toString());
     
     if (maq.length()>0 && marc.length() >0 && seri.length()>0 && mod.length()
             > 0 && precio>0){
         jbtnguardar.setEnabled(true);
     
     }else {
         jbtnguardar.setEnabled(true);
     }
     
     
     }
     public void setmovimiento(){
     JDFMovimientosMaquina movimientos = new JDFMovimientosMaquina(new JFrame(), isVisible(),maquinaria);
     movimientos.setVisible(true);
     
     
     }
     public void setvermaquina(){
     listmaquinaria= daoMaquinaria.view(jtabla,"TODO","EMPRESA");
     
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
        jcbcategoria = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfmaquina = new javax.swing.JTextField();
        jtfserie = new javax.swing.JTextField();
        jtfmarca = new javax.swing.JTextField();
        jtfmodelo = new javax.swing.JTextField();
        jtfprecio = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jtfbbuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbtnnew = new javax.swing.JButton();
        jbtneditar = new javax.swing.JButton();
        jbtnguardar = new javax.swing.JButton();
        jbtneliminar = new javax.swing.JButton();
        jbtncancelar = new javax.swing.JButton();
        jbtnimprimir = new javax.swing.JButton();
        jcbbuscarcate = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INVENTARIO ARRIENDO");

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

        jLabel2.setText("Maquina:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Serie:");

        jLabel5.setText("Modelo:");

        jLabel6.setText("Categoria:");

        jLabel7.setText("Precio por Arriendo Diario:");

        jtfmaquina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmaquinaKeyReleased(evt);
            }
        });

        jtfserie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfserieKeyReleased(evt);
            }
        });

        jtfmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmarcaKeyReleased(evt);
            }
        });

        jtfmodelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmodeloKeyReleased(evt);
            }
        });

        jtfprecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtfprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfprecioKeyReleased(evt);
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
        jtabla.setToolTipText("Doble clic para realizar mas operaciones");
        jtabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        jtfbbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbbuscarKeyReleased(evt);
            }
        });

        jLabel8.setText("Maquina:");

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

        jcbbuscarcate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbbuscarcate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbbuscarcateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfbbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbbuscarcate, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfmaquina)
                            .addComponent(jtfserie, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jtfmodelo)
                            .addComponent(jtfmarca)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnimprimir)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfbbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jcbbuscarcate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtnimprimir))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jtfmaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnnewActionPerformed
        // TODO add your handling code here:
        maquinaria =new Maquinaria();
        bloquearjtf(true,true,true,true,true,true);
        bloquearjbtn(true, false, false, false, true);

        limpiarjtf();

        editar=false;
    }//GEN-LAST:event_jbtnnewActionPerformed

    private void jbtneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneditarActionPerformed
        // TODO add your handling code here:
        bloquearjtf(true,true,true,true,true,true);

        editar=true;
        bloquearjbtn(true, false, false, false, true);
    }//GEN-LAST:event_jbtneditarActionPerformed

    private void jbtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnguardarActionPerformed
        ////// TODO add your handling code here:
        ///// CATEGORIA /////
        categoria = listcategoria.get(jcbcategoria.getSelectedIndex());
        ///////////////////////////////////
        maquinaria.setMaquina(jtfmaquina.getText().toUpperCase());
        maquinaria.setMarca(jtfmarca.getText().toUpperCase());
        maquinaria.setSerie(jtfserie.getText().toUpperCase());
        maquinaria.setModelo(jtfmodelo.getText().toUpperCase());
        maquinaria.setIdcategoria(categoria.getId());
        maquinaria.setPreciodiario(Double.parseDouble(jtfprecio.getValue().toString()));

        if(editar==false){
            //  long id=Long.parseLong(jtabla.getValueAt(jtabla.getSelectedRow(), 0).toString());
            if(daoMaquinaria.duplicate(0, jtfserie.getText().toUpperCase(), "GUARDAR")==true){
                maquinaria.setPropietario("EMPRESA");
                maquinaria.setIdempresa(singletonemp.getId());
                daoMaquinaria.insert(maquinaria);

            }else {
                JOptionPane.showMessageDialog(null, "LA SERIE "+jtfserie.getText().toUpperCase()+" YA SE ENCUENTRA REGISTRADA","SISTEMA",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        }    else{
            //                    usuario.setUsuario(jtfusuario.getText());

            if(daoMaquinaria.duplicate(maquinaria.getId(),jtfserie.getText().toUpperCase(), "EDITAR")==true){
                daoMaquinaria.update(maquinaria);

            }else {
                JOptionPane.showMessageDialog(null, "LA SERIE "+jtfserie.getText().toUpperCase()+" YA SE ENCUENTRA REGISTRADA","SISTEMA",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        }

        listmaquinaria = daoMaquinaria.view(jtabla,"TODO","EMPRESA");
        bloquearjbtn(true, false, false, false, false);
        bloquearjtf(false, false, false,false,false,false);
        limpiarjtf();
    }//GEN-LAST:event_jbtnguardarActionPerformed

    private void jbtneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneliminarActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LA TARIFA","ELIMINAR",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            daoMaquinaria.delete(maquinaria.getId());
            listmaquinaria = daoMaquinaria.view(jtabla,"TODO","EMPRESA");
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
        bloquearjtf(false, false, false,false,false,false);
    }//GEN-LAST:event_jbtncancelarActionPerformed

    private void jbtnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnimprimirActionPerformed
        // TODO add your handling code here:
        /// id empresa
     //   daoMaquinaria.print();
    }//GEN-LAST:event_jbtnimprimirActionPerformed

    private void jtablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaMouseReleased
        // TODO add your handling code here:
        maquinaria=listmaquinaria.get(jtabla.getSelectedRow());
        jtfmaquina.setText(maquinaria.getMaquina());
        jtfmarca.setText(maquinaria.getMarca());
        jtfserie.setText(maquinaria.getSerie());
        jtfmodelo.setText(maquinaria.getModelo());
        jcbcategoria.setSelectedItem(maquinaria.getCategoria());
        /// vcategoria
        jtfprecio.setValue(maquinaria.getPreciodiario());
         bloquearjbtn(true, true, false, true, false); 
       if(evt.getClickCount()==2){
       JDFTipoopMaquina tipoopmaq = new JDFTipoopMaquina(new JFrame(), isVisible(),this,maquinaria);
       tipoopmaq.setVisible(true);
       
       }
    }//GEN-LAST:event_jtablaMouseReleased

    private void jtfmaquinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmaquinaKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfmaquinaKeyReleased

    private void jtfmarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmarcaKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfmarcaKeyReleased

    private void jtfserieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfserieKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfserieKeyReleased

    private void jtfmodeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmodeloKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfmodeloKeyReleased

    private void jtfprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfprecioKeyReleased
        // TODO add your handling code here:
        validaguardar();
    }//GEN-LAST:event_jtfprecioKeyReleased

    private void jtablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablaKeyReleased
        // TODO add your handling code here:
        maquinaria=listmaquinaria.get(jtabla.getSelectedRow());
        jtfmaquina.setText(maquinaria.getMaquina());
        jtfmarca.setText(maquinaria.getMarca());
        jtfserie.setText(maquinaria.getSerie());
        jtfmodelo.setText(maquinaria.getModelo());
        jcbcategoria.setSelectedItem(maquinaria.getCategoria());
        /// vcategoria
        jtfprecio.setValue(maquinaria.getPreciodiario());
         bloquearjbtn(true, true, false, true, false); 
    }//GEN-LAST:event_jtablaKeyReleased

    private void jtfbbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbbuscarKeyReleased
        // TODO add your handling code here:
        categoriab=listcategoriabusc.get(jcbbuscarcate.getSelectedIndex());
        listmaquinaria=daoMaquinaria.searchsentitive(jtabla, title, title, categoriab.getId());
    }//GEN-LAST:event_jtfbbuscarKeyReleased

    private void jcbbuscarcateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbbuscarcateActionPerformed
        // TODO add your handling code here:
        if(listcategoriabusc.size()>0){
         System.out.println("listcstgeb"+listcategoriabusc.size());
        
        }
       
//        categoriab=listcategoriabusc.get(jcbbuscarcate.getSelectedIndex());
//        listmaquinaria=daoMaquinaria.searchsentitive(jtabla, title, title, categoriab.getId());
    }//GEN-LAST:event_jcbbuscarcateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtncancelar;
    private javax.swing.JButton jbtneditar;
    private javax.swing.JButton jbtneliminar;
    private javax.swing.JButton jbtnguardar;
    private javax.swing.JButton jbtnimprimir;
    private javax.swing.JButton jbtnnew;
    private javax.swing.JComboBox jcbbuscarcate;
    private javax.swing.JComboBox jcbcategoria;
    private javax.swing.JTable jtabla;
    private javax.swing.JTextField jtfbbuscar;
    private javax.swing.JTextField jtfmaquina;
    private javax.swing.JTextField jtfmarca;
    private javax.swing.JTextField jtfmodelo;
    private javax.swing.JFormattedTextField jtfprecio;
    private javax.swing.JTextField jtfserie;
    // End of variables declaration//GEN-END:variables
}
