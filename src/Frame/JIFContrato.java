/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOCliente;
import Dao.DAOContrato;
import Dao.DAODetCaja;
import Dao.DAODetContrato;
import Dao.DAODetGuia;
import Dao.DAOGuia;
import Pojos.Cliente;
import Pojos.Contrato;
import Pojos.DetalleCaja;
import Pojos.DetalleContrato;
import Pojos.Maquinaria;
import Pojos.SingletonEmpresa;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author info2017
 */
public class JIFContrato extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFContrato
     */
    List<Maquinaria> listmaquinaria = new ArrayList<>();
    DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Maquina","Serie","Valor Dia","Dias Arriendo","Importe"};
        Object datosmaq[] = new Object[5];
        DAOCliente daocliente = new DAOCliente();
        Cliente cliente= new Cliente() ;
        Double total;
        DAOContrato daocontrato = new DAOContrato();
        DAODetContrato daodetcontrato = new DAODetContrato();
        Contrato contrato = new Contrato();
        DetalleContrato detcontrato = new DetalleContrato();
        SingletonEmpresa singletonemp = SingletonEmpresa.getinstancia();
        DAOGuia daoguia= new DAOGuia();
        DAODetGuia daodetguia = new DAODetGuia();
        DAODetCaja daodetcaja= new DAODetCaja();
        String tipodoc;
        
    
    public JIFContrato(String tipodoc) {
        initComponents();
        modelo.setColumnIdentifiers(titulos);
        jtabla.setModel(modelo);
        jbtngenerar.setEnabled(false);
        total=0.0;
        jlbltipoop.setText(tipodoc);
        this.tipodoc = tipodoc;
        jlblmensajedeudor.setVisible(false);
        jdpfecha.setDate(new Date());
        
        ///// hora actual
        Date fecha = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        jtfhora.setValue(df.format(fecha));
        
    }
    
    public void setllenarmaquinaria(Maquinaria maq){
    boolean valida=true;    
    for(Maquinaria maqui:listmaquinaria){
        if(maqui.getId()==maq.getId()){
        valida=false;
        }
    
    }
    if(valida==true){
    listmaquinaria.add(maq);
    NumberFormat nf= NumberFormat.getInstance();
    double importe = maq.getDias()*maq.getPreciodiario();
    maq.setImporte(importe);
    datosmaq[0]=maq.getMaquina()+" "+maq.getMarca()+" "+maq.getModelo();
    datosmaq[1]=maq.getSerie();
    datosmaq[2]=nf.format(maq.getPreciodiario());
    datosmaq[3]=maq.getDias();
    datosmaq[4]=nf.format(importe);
    modelo.addRow(datosmaq);
    validagenerar();
    total = total + importe;
    jlbltotal.setText(nf.format(total));
    
    }else{
    JOptionPane.showMessageDialog(null,"La maquina: "+ maq.getMaquina()+" "+maq.getMarca()+" "+maq.getModelo()+" ya se encuentra ingresada");
    }
    
    }
    
    public void validagenerar(){
    if (cliente.getId()!=0 && modelo.getRowCount()>0 && jdpfecha.getDate()!=null){
        jbtngenerar.setEnabled(true);
    }else {
        jbtngenerar.setEnabled(false);
    }
    }
    
    public void setpagar(DetalleCaja detcaja,Double desc){
        cliente.setDomiciliatrab(jlbldomiciliotrab.getText().toUpperCase());
        daocliente.updatenophoto(cliente);
        contrato.setTipodoc(tipodoc);
        contrato.setDescuento(desc);
        
        System.out.println("fechacontratopagar "+contrato.getFecha());
        System.out.println("flete"+contrato.getFlete());
        contrato.setId(daocontrato.insert(contrato));  /// devolver el id para poder imprimir      
        
        daodetcontrato.insert(listmaquinaria,contrato.getId());
        daocontrato.print(contrato.getId()); 
        
        long id=daoguia.insert(contrato, "DESPACHO");
        daodetguia.insert(listmaquinaria, id, true);
         daoguia.print(id,"DESPACHO");
         
        detcaja.setIdcontrato(contrato.getId());
        daodetcaja.insertpaycontrato(detcaja,0.0);  
    }
    public void nuevo(){
        jtfrut.setText("");
        jlblrazons.setText("* * *");
        jlbldomiciliopart.setText("* * *");        
        jlbldomiciliotrab.setText("");
        jlblfono.setText("");
        contrato=new Contrato();
        cliente = new Cliente();
        listmaquinaria = new ArrayList<>();
         for (int i = 0; i < jtabla.getRowCount(); i++) {
        modelo.removeRow(i);
        i-=1;
        }
        jbtngenerar.setEnabled(false);
        jlbltotal.setText("* * *");
        total=0.0;
        jtflete.setValue(0);
        jdpfecha.setDate(new Date());
        jlblmensajedeudor.setText("");
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
        jlbltipoop = new javax.swing.JLabel();
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
        jlbldomiciliotrab = new javax.swing.JTextField();
        jlblmensajedeudor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jbtnmaquinaria = new javax.swing.JButton();
        jbtngenerar = new javax.swing.JButton();
        jtflete = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlbltotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdpfecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel10 = new javax.swing.JLabel();
        jtfhora = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CONTRATO");

        jlbltipoop.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jlbltipoop.setForeground(new java.awt.Color(0, 0, 0));
        jlbltipoop.setText("***");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbltipoop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbltipoop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

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

        jlbldomiciliotrab.setEnabled(false);

        jlblmensajedeudor.setForeground(new java.awt.Color(255, 51, 51));
        jlblmensajedeudor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblmensajedeudor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblmensajedeudor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlblmensajedeudorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlblmensajedeudorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblmensajedeudorMouseReleased(evt);
            }
        });

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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfrut, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jlblrazons, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jlblfono, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlblmensajedeudor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jlbldomiciliotrab, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
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
                    .addComponent(jlbldomiciliotrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jlblfono))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jlblmensajedeudor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
        jtabla.setToolTipText("Doble clic para retirar maquina del contrato");
        jtabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtabla);

        jbtnmaquinaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maquina.png"))); // NOI18N
        jbtnmaquinaria.setText("Maquinaria");
        jbtnmaquinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnmaquinariaActionPerformed(evt);
            }
        });

        jbtngenerar.setText("Cobrar");
        jbtngenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtngenerarActionPerformed(evt);
            }
        });

        jtflete.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtflete.setValue(0.0);

        jLabel4.setText("Flete:");

        jLabel6.setText("Total Maquinaria:");

        jlbltotal.setText("* * *");

        jLabel8.setText("Este contrato entrega en vigencia el dia:");

        jdpfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdpfechaActionPerformed(evt);
            }
        });

        jLabel10.setText("Hora:");

        try {
            jtfhora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfhora.setText("");

        jLabel11.setText("H24:MM:SS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jtflete, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtngenerar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jdpfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfhora, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addComponent(jbtnmaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jdpfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtfhora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnmaquinaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtngenerar)
                    .addComponent(jtflete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jlbltotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnmaquinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnmaquinariaActionPerformed
        // TODO add your handling code here:
        JDFBuscarMaquinaria buscarmaq = new JDFBuscarMaquinaria(new JFrame(), isVisible(),this);
        buscarmaq.setVisible(true);
    }//GEN-LAST:event_jbtnmaquinariaActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_F1){
            jbtnmaquinaria.doClick();
        }
    }//GEN-LAST:event_formKeyReleased

    private void jtablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaMouseReleased
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
         int index = jtabla.getSelectedRow();
        if(index >=0){
        if(JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE RETIRAR LA MAQUINA DEL CONTRATO","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
         
        Maquinaria maq= listmaquinaria.get(index);
        total = total - maq.getImporte();
        NumberFormat nf= NumberFormat.getInstance();
        jlbltotal.setText(nf.format(total));
        listmaquinaria.remove(index);
        modelo.removeRow(index);
        }
       
        
        }
        validagenerar();
        
        
        
        }
       
    }//GEN-LAST:event_jtablaMouseReleased

    private void jtfrutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrutKeyReleased
        // TODO add your handling code here:
        cliente=daocliente.search(jtfrut.getText(),"CLIENTEEMPRESA");
        if(cliente.getId()!=0){
        jlblrazons.setText(cliente.getNombre()+"  "+cliente.getApellido());
        jlbldomiciliopart.setText(cliente.getDomiciliopart());
        jlbldomiciliotrab.setText(cliente.getDomiciliatrab());
        jlblfono.setText(cliente.getTelefono());
        jlblmensaje.setText("");
        jlbldomiciliotrab.setEnabled(true);
        jlblmensajedeudor.setVisible(true);
         if(daocliente.verifyclientdebtor(cliente.getId())==true){
           jlblmensajedeudor.setText("El cliente registra deuda clic aqui para generar reporte");
       }else {
           jlblmensajedeudor.setText("El cliente no registra deuda");
       }
        }else {
        
        jlblmensaje.setText("Cliente no encontrado");
        jlblrazons.setText("* * *");
        jlbldomiciliopart.setText("* * *");
        jlbldomiciliotrab.setText("* * *");
        jlblfono.setText("* * *");
      
        jlbldomiciliotrab.setEnabled(false);
        jlbldomiciliotrab.setText("");
        
        jlblmensajedeudor.setVisible(false);
        jlblmensajedeudor.setText("");
        }
        validagenerar();
    }//GEN-LAST:event_jtfrutKeyReleased

    private void jbtngenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtngenerarActionPerformed
        // TODO add your handling code here:
        Double flete = Double.parseDouble(jtflete.getValue().toString());
        contrato.setIdcliente(cliente.getId());
        contrato.setIdempresa(singletonemp.getId());
        contrato.setFlete(flete);
        contrato.setTotal(total + flete);
        
        
         contrato.setFecha(new SimpleDateFormat("yyyy-MM-dd").format(jdpfecha.getDate())+" "+jtfhora.getValue());
        
         System.out.println("fecha"+contrato.getFecha());
        JDFPagarDespacho pagar = new JDFPagarDespacho(new Frame(), isVisible(),contrato, this);
        pagar.setVisible(true);
        
       
       
        
        
        
        
        
        //cobrar
        
       
        
        
    }//GEN-LAST:event_jbtngenerarActionPerformed

    private void jlblmensajedeudorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblmensajedeudorMousePressed
        // TODO add your handling code here:
          if(daocliente.verifyclientdebtor(cliente.getId())==true){
            jlblmensajedeudor.setText("Generando Reporte ....");
       }
       
    }//GEN-LAST:event_jlblmensajedeudorMousePressed

    private void jlblmensajedeudorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblmensajedeudorMouseReleased
        // TODO add your handling code here:
         if(daocliente.verifyclientdebtor(cliente.getId())==true){
        daocliente.printdebtor(cliente.getId());
        jlblmensajedeudor.setText("Reporte generado correctamente");
         }
    }//GEN-LAST:event_jlblmensajedeudorMouseReleased

    private void jlblmensajedeudorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblmensajedeudorMouseExited
        // TODO add your handling code here:
       if(daocliente.verifyclientdebtor(cliente.getId())==true){
           jlblmensajedeudor.setText("El cliente registra deuda clic aqui para generar reporte");
       }else {
           jlblmensajedeudor.setText("El cliente no registra deuda");
       }
    }//GEN-LAST:event_jlblmensajedeudorMouseExited

    private void jdpfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdpfechaActionPerformed
        // TODO add your handling code here:
        validagenerar();
        
    }//GEN-LAST:event_jdpfechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtngenerar;
    private javax.swing.JButton jbtnmaquinaria;
    private org.jdesktop.swingx.JXDatePicker jdpfecha;
    private javax.swing.JLabel jlbldomiciliopart;
    private javax.swing.JTextField jlbldomiciliotrab;
    private javax.swing.JLabel jlblfono;
    private javax.swing.JLabel jlblmensaje;
    private javax.swing.JLabel jlblmensajedeudor;
    private javax.swing.JLabel jlblrazons;
    private javax.swing.JLabel jlbltipoop;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JTable jtabla;
    private javax.swing.JFormattedTextField jtfhora;
    private javax.swing.JFormattedTextField jtflete;
    private javax.swing.JFormattedTextField jtfrut;
    // End of variables declaration//GEN-END:variables
}
