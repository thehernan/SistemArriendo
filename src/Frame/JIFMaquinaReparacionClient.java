/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DAOCliente;
import Dao.DAODetCaja;
import Dao.DAOEmpleado;
import Dao.DAOMaquinaria;
import Dao.DAOReparacion;
import Dao.DAORepuesto;
import Pojos.Cliente;
import Pojos.DetalleCaja;
import Pojos.Empleado;
import Pojos.Maquinaria;
import Pojos.Reparacion;
import Pojos.Repuesto;
import Pojos.SingletonEmpresa;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author info2017
 */
public class JIFMaquinaReparacionClient extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFMaquinaReparacionClient
     */
    Cliente cliente = new Cliente();
    DAOCliente daocliente = new DAOCliente();
    DAOMaquinaria daomaquina = new DAOMaquinaria();
    Maquinaria maquina = new Maquinaria();
    SingletonEmpresa singletonempresa = SingletonEmpresa.getinstancia();
    DAOReparacion daoreparair= new DAOReparacion();
    Reparacion reparacion = new Reparacion();
    DAODetCaja daodetcaja = new DAODetCaja();
    DetalleCaja detcaja = new DetalleCaja();
    List<Repuesto> listrepuesto= new ArrayList<>();
    DAORepuesto daorepuesto = new DAORepuesto();
    DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return true;
        }
        };
        String titulos[]={"Cantidad","Descripcion","Valor"};
        Object datosmaq[] = new Object[3];
    
    
        DAOEmpleado daoempleado = new DAOEmpleado();
        Empleado empleado = new Empleado();
        List<Object> listobj = new ArrayList<>();
        List<Repuesto> lisrepuestodelete = new ArrayList<>();
    public JIFMaquinaReparacionClient() {
        initComponents();
        modelo.setColumnIdentifiers(titulos);
        jtabla.setModel(modelo);
        Date date= new Date();
        jdpfecha.setDate(date);
        jtfrut.requestFocus();
        jtfrevision.setText("10000");
        jtfmanoobra.setText("0");
        calcualartotal();
    }
    public void valida(){
        String modelo= jtfmodelo.getText().replaceAll("\\s", "");
        String serie= jtfserie.getText().replaceAll("\\s", "");
        String marca= jtfmarca.getText().replaceAll("\\s", "");
        String descrip = jtfdescripcion.getText().replaceAll("\\s","");
        String obser = jtfaobservacion.getText().replaceAll("\\s", "");
    if(cliente.getId()!=0 && modelo.length()>0 && serie.length()>0 && marca.length()>0
            && descrip.length()>0 && obser.length()> 0){
        jbtnceptar.setEnabled(true);
    }else {
        jbtnceptar.setEnabled(false);
    }
    
    
    }
    public void setagregarrepuesto(Repuesto repuesto){
        NumberFormat nf=NumberFormat.getInstance();
        datosmaq[0]=nf.format(repuesto.getCantidad());
        datosmaq[1]=repuesto.getDescripcion();
        datosmaq[2]=nf.format(repuesto.getValor());
      
        modelo.addRow(datosmaq);
        listrepuesto.add(repuesto); 
     
    }
    public void calcualartotal(){
        
        Double repues=0.0;
        Double manoobra=0.0;
        Double revision=0.0;
        Double total=0.0;
        Double iva=0.0;
        Double subtotal=0.0;
        NumberFormat nf=NumberFormat.getInstance();
        try {
            if(jtfmanoobra.getText().replaceAll("\\s", "").length()>0)
                manoobra= Double.parseDouble(jtfmanoobra.getText());
            
            if(jtfrevision.getText().replaceAll("\\s", "").length()>0)
                revision=Double.parseDouble(jtfrevision.getText());
            
            for(Repuesto rep : listrepuesto)
                repues=repues+rep.getValor();
            
            total= manoobra+revision+repues;
            subtotal=total/1.19;
            iva=total-subtotal;
            
            jtfrepuestos.setValue(repues);
//            jtfrevision.setValue(revision);
//            jtfmanoobra.setValue(manoobra);
            jlblsubtotal.setValue(subtotal);
            jlbliva.setValue(iva);
            jlbltotal.setValue(total);
            
            
        } catch (Exception e) {
             jlbltotal.setValue(0);
            jlbliva.setValue(0);
            jlblsubtotal.setValue(0);
        }
 
    }
    
    public void setbuscar(long id,String codigo){
    
    listobj = daoreparair.search(id);
    System.out.println("listobj"+listobj.size());
    cliente = (Cliente)listobj.get(0);
    maquina = (Maquinaria)listobj.get(1);
    empleado= (Empleado)listobj.get(2);
    reparacion= (Reparacion)listobj.get(3);
        DecimalFormat df = new DecimalFormat("###");
    /////////////////////////////cliente
    jtfrut.setValue(cliente.getRut());
    jlblrazons.setText(cliente.getNombre());
    jlbldomiciliopart.setText(cliente.getDomiciliopart());
    jlbldomiciliotrab.setText(cliente.getDomiciliatrab());
    jlblfono.setText(cliente.getTelefono());
    //////////////////maquina
    jtfmodelo.setText(maquina.getModelo());
    jtfmarca.setText(maquina.getMaquina());
    jtfserie.setText(maquina.getSerie());
    jtfdescripcion.setText(maquina.getMaquina());
    ///////////////////////////reparacion
    jtfaobservacion.setText(reparacion.getObservacion());
    jtatrabajosrealizados.setText(reparacion.getTrabajorealizado());
    //////////////////////////////
    jlblcodigo.setText(codigo);
    jtfrevision.setText(df.format(reparacion.getRevision()));
    jtfrepuestos.setValue(reparacion.getRepuesto());
    jtfmanoobra.setText(df.format(reparacion.getManoobra()));
    jlblsubtotal.setValue(reparacion.getSubtotal());
    jlbliva.setValue(reparacion.getIva());
    jlbltotal.setValue(reparacion.getTotal());
    jdpfecha.setDate(reparacion.getFechaentrega());
    //////////////////////////// empleado
    jtfrutempleado.setValue(empleado.getRut());
    jlblnombretrabajador.setText(empleado.getNombre());
    ///////////////////////////////
    
    if(reparacion.isAcepta()==true)
        jrbtnsi.setSelected(true);
    else 
        jrbtnno.setSelected(true);
 
    jtfentradopor.setText(reparacion.getEntregadopor());
    //////////////////////////////////////
    listrepuesto=daorepuesto.view(jtabla, id);
    modelo=(DefaultTableModel) jtabla.getModel();  
     valida();
    }
    
    public void nuevo(){
    cliente = new Cliente();
    empleado= new Empleado();
    reparacion = new Reparacion();
    maquina = new Maquinaria();
    listrepuesto = new ArrayList<>();
    lisrepuestodelete= new ArrayList<>();
    ///// cliente
    jtfrut.setValue(null);
    jlblrazons.setText("* * *");
    jlbldomiciliopart.setText("* * *");
    jlbldomiciliotrab.setText("* * *");
    jlblfono.setText("* * *");
    //////// maquina
    jtfmodelo.setText("");
    jtfmarca.setText("");
    jtfserie.setText("");
    jtfdescripcion.setText("");
    //// reparacion
    jtfaobservacion.setText("");
    jtatrabajosrealizados.setText("");
    jtfentradopor.setText("");
    //
    jtfrevision.setText("10000");
    jtfrepuestos.setValue(0);
    jtfmanoobra.setText("0");
    calcualartotal();
    ///////
    jrbtnno.setSelected(true);
     for (int i = 0; i < jtabla.getRowCount(); i++) {
        modelo.removeRow(i);
        i-=1;
        }
    ////
     jtfrutempleado.setValue(null);
     jlblnombretrabajador.setText("* * *");
     jdpfecha.setDate(new Date());
     
    jlblcodigo.setText("* * *");
    jtfrut.requestFocus();
    
    
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jtfrut = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblrazons = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbldomiciliopart = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblfono = new javax.swing.JLabel();
        jlbldomiciliotrab = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfmodelo = new javax.swing.JTextField();
        jtfmarca = new javax.swing.JTextField();
        jtfserie = new javax.swing.JTextField();
        jtfdescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfaobservacion = new javax.swing.JTextArea();
        jbtnceptar = new javax.swing.JButton();
        jlblmensaje = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlblsubtotal = new javax.swing.JFormattedTextField();
        jlbltotal = new javax.swing.JFormattedTextField();
        jlbliva = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfrepuestos = new javax.swing.JFormattedTextField();
        jtfrevision = new javax.swing.JTextField();
        jtfmanoobra = new javax.swing.JTextField();
        jrbtnsi = new javax.swing.JRadioButton();
        jrbtnno = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jtfrutempleado = new javax.swing.JFormattedTextField();
        jlblmensajetrab = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jlblnombretrabajador = new javax.swing.JLabel();
        jdpfecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtabla = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jbtnbuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtatrabajosrealizados = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jbtnagregarrepuesto = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jtfentradopor = new javax.swing.JTextField();
        jlblcodigo = new javax.swing.JLabel();
        jbtncancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Orden de Trabajo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            jtfrut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfrut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfrutFocusLost(evt);
            }
        });
        jtfrut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfrutKeyReleased(evt);
            }
        });
        getContentPane().add(jtfrut, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 105, -1));

        jLabel2.setText("R.U.T. Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel3.setText("Señor(es):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jlblrazons.setText("* * *");
        getContentPane().add(jlblrazons, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 360, -1));

        jLabel5.setText("Domicilio Particular:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jlbldomiciliopart.setText("* * *");
        getContentPane().add(jlbldomiciliopart, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 310, -1));

        jLabel7.setText("Domicilio Trabajo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setText("Fono:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jlblfono.setText("* * *");
        getContentPane().add(jlblfono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, -1));

        jlbldomiciliotrab.setText("* * *");
        getContentPane().add(jlbldomiciliotrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 350, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción Maquina"));

        jLabel1.setText("Modelo:");

        jLabel4.setText("Marca:");

        jLabel6.setText("N° Serie:");

        jLabel8.setText("Descripcion:");

        jtfmodelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmodeloKeyReleased(evt);
            }
        });

        jtfmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmarcaKeyReleased(evt);
            }
        });

        jtfserie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfserieKeyReleased(evt);
            }
        });

        jtfdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfdescripcionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfserie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jtfmarca, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfmodelo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfdescripcion))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 450, 190));

        jLabel10.setText("Observación al Ingreso:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jtfaobservacion.setColumns(20);
        jtfaobservacion.setRows(5);
        jtfaobservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfaobservacionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtfaobservacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 440, 130));

        jbtnceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accept2.png"))); // NOI18N
        jbtnceptar.setText("Aceptar / Imprimir");
        jbtnceptar.setEnabled(false);
        jbtnceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 640, -1, -1));
        getContentPane().add(jlblmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 250, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor de Reparacion"));

        jLabel11.setText("Repuestos:");

        jLabel12.setText("Mano de Obra:");

        jLabel13.setText("Sub Total:");

        jLabel14.setText("I.V.A.:");

        jLabel15.setText("Total:");

        jlblsubtotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jlblsubtotal.setEnabled(false);
        jlblsubtotal.setValue(0);

        jlbltotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jlbltotal.setEnabled(false);
        jlbltotal.setValue(0);

        jlbliva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jlbliva.setEnabled(false);
        jlbliva.setValue(0);

        jLabel16.setText("Revision:");

        jtfrepuestos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtfrepuestos.setEnabled(false);
        jtfrepuestos.setValue(0);

        jtfrevision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfrevisionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfrevisionKeyTyped(evt);
            }
        });

        jtfmanoobra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmanoobraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmanoobraKeyTyped(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblsubtotal)
                            .addComponent(jlbliva, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jtfmanoobra)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfrepuestos, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jtfrevision))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtfrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtfrepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtfmanoobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jlblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbliva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 3, 390, 240));

        buttonGroup1.add(jrbtnsi);
        jrbtnsi.setText("Si");
        getContentPane().add(jrbtnsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, -1, -1));

        buttonGroup1.add(jrbtnno);
        jrbtnno.setSelected(true);
        jrbtnno.setText("No");
        getContentPane().add(jrbtnno, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        jLabel19.setText("Acepta:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabajo realizado por"));

        jLabel20.setText("R.U.T. Trabajador:");

        try {
            jtfrutempleado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfrutempleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfrutempleadoFocusLost(evt);
            }
        });
        jtfrutempleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfrutempleadoMouseExited(evt);
            }
        });
        jtfrutempleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfrutempleadoKeyReleased(evt);
            }
        });

        jLabel21.setText("Nombre:");

        jlblnombretrabajador.setText("* * *");

        jLabel22.setText("Fecha Entrega:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jtfrutempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblmensajetrab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblnombretrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jdpfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jtfrutempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblmensajetrab, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jlblnombretrabajador))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdpfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 390, 120));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtablaMousePressed(evt);
            }
        });
        jtabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtablaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtabla);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 390, 130));

        jLabel23.setText("Repuestos a Cambiar");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jbtnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search2.png"))); // NOI18N
        jbtnbuscar.setText("Buscar");
        jbtnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 30));

        jtatrabajosrealizados.setColumns(20);
        jtatrabajosrealizados.setRows(5);
        jScrollPane3.setViewportView(jtatrabajosrealizados);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 440, -1));

        jLabel24.setText("Trabajos Realizados:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        jbtnagregarrepuesto.setText("Agregar");
        jbtnagregarrepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnagregarrepuestoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnagregarrepuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, -1, -1));

        jLabel17.setText("Entregado por:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, 20));
        getContentPane().add(jtfentradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 440, -1));

        jlblcodigo.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jlblcodigo.setForeground(new java.awt.Color(255, 51, 51));
        jlblcodigo.setText("***");
        getContentPane().add(jlblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, -1));

        jbtncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jbtncancelar.setText("Cancelar");
        jbtncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        }else {

            jlblmensaje.setText("Cliente no encontrado");
            jlblrazons.setText("* * *");
            jlbldomiciliopart.setText("* * *");
            jlbldomiciliotrab.setText("* * *");
            jlblfono.setText("* * *");
           
            jlbldomiciliotrab.setEnabled(false);
            jlbldomiciliotrab.setText("");
        }
        valida();
    }//GEN-LAST:event_jtfrutKeyReleased

    private void jbtnceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnceptarActionPerformed
        // TODO add your handling code here:
        maquina.setIdempresa(singletonempresa.getId());
        maquina.setMarca(jtfmarca.getText().toUpperCase());
        maquina.setModelo(jtfmodelo.getText().toUpperCase());
        maquina.setSerie(jtfserie.getText().toUpperCase());
        maquina.setMaquina(jtfdescripcion.getText().toUpperCase());
        maquina.setIdcliente(cliente.getId());
       
        
        reparacion.setObservacion(jtfaobservacion.getText().toUpperCase());
        reparacion.setIdcliente(cliente.getId());
       
        Double manoobra=0.0,revision=0.0;
        boolean valida=true;
        try {
            revision= Double.parseDouble(jtfrevision.getText());
            manoobra = Double.parseDouble(jtfmanoobra.getText());
           
        } catch (Exception e) {
            valida=false;
        }
        
         
        Double subtotal= Double.parseDouble(jlblsubtotal.getValue().toString());
        Double iva = Double.parseDouble(jlbliva.getValue().toString());
        Double total = Double.parseDouble(jlbltotal.getValue().toString());
        
         
        
      
       
        reparacion.setObservacion(jtfaobservacion.getText().toUpperCase());
        reparacion.setRepuesto( Double.parseDouble(jtfrepuestos.getValue().toString()));
        reparacion.setManoobra(manoobra);
        reparacion.setSubtotal(subtotal);
        reparacion.setIva(iva);
        reparacion.setTotal(total);
        reparacion.setRevision(revision);
        reparacion.setTrabajorealizado(jtatrabajosrealizados.getText().toUpperCase());
        
        
        reparacion.setAcepta(jrbtnsi.isSelected());
        
            
        reparacion.setEntregadopor(jtfentradopor.getText().toUpperCase());
        reparacion.setFechaentrega(new Timestamp(jdpfecha.getDate().getTime()));
        
        long id =0;        
        
        if(valida==true){
         
            if(reparacion.getId()==0){ //// insert+
                maquina.setId(daomaquina.insertmaqrepairclient(maquina));
                reparacion.setIdmaqui(maquina.getId());
                System.out.println("idmaq"+maquina.getId());
                System.out.println("insert");
                 if(empleado.getId()!=0){
                    reparacion.setIdempleado(empleado.getId());
                    id= daoreparair.insertrepairclientemploye(reparacion);
                     System.out.println("idreoara"+id);
                }    else {
                    id= daoreparair.insertrepairclientnoemploye(reparacion);
                }  
                     System.out.println("lisrtep"+listrepuesto.size());
                daorepuesto.insert(listrepuesto, id);
                
            }else { /// update
                 if(empleado.getId()!=0){
               reparacion.setIdempleado(empleado.getId());
                   daoreparair.update(reparacion);
                }    else {
                   daoreparair.updatenoempleado(reparacion);
                }  
               daomaquina.updatenocategoria(maquina);
                System.out.println("lisrtep"+listrepuesto.size());
                daorepuesto.insert(listrepuesto, reparacion.getId());
            }
           
        
        
        }else {
        JOptionPane.showMessageDialog(null, "Ingrese cantidad valida en revision o mano de obra");
        }
        daorepuesto.delete(lisrepuestodelete);
        daoreparair.print(id);
        nuevo();
        
//        detcaja.setImporte(10000.0);
//        detcaja.setIdreparir(id);
//        
//        daodetcaja.insertrepair(detcaja);
        
        
    }//GEN-LAST:event_jbtnceptarActionPerformed

    private void jtfmodeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmodeloKeyReleased
        // TODO add your handling code here:
        valida();
    }//GEN-LAST:event_jtfmodeloKeyReleased

    private void jtfmarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmarcaKeyReleased
        // TODO add your handling code here:
        valida();
    }//GEN-LAST:event_jtfmarcaKeyReleased

    private void jtfserieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfserieKeyReleased
        // TODO add your handling code here:
        valida();
    }//GEN-LAST:event_jtfserieKeyReleased

    private void jtfdescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfdescripcionKeyReleased
        // TODO add your handling code here:
        valida();
    }//GEN-LAST:event_jtfdescripcionKeyReleased

    private void jtfaobservacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfaobservacionKeyReleased
        // TODO add your handling code here:
        valida();
    }//GEN-LAST:event_jtfaobservacionKeyReleased

    private void jbtnagregarrepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnagregarrepuestoActionPerformed
        // TODO add your handling code here:
        JDFRepuestosReparacion repuestos= new JDFRepuestosReparacion(new Frame(), isVisible(),this);
        repuestos.setVisible(true);
        
    }//GEN-LAST:event_jbtnagregarrepuestoActionPerformed

    private void jtablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablaKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtablaKeyReleased

    private void jtablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
        if(JOptionPane.showConfirmDialog(null,"Seguro que desea retirar el repuesto","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            int index = jtabla.getSelectedRow();
            Repuesto repuesto;
            NumberFormat nf= NumberFormat.getInstance();
            repuesto= listrepuesto.get(index);
            System.out.println("listrep"+listrepuesto.size());
            System.out.println("idrep"+repuesto.getId());
            lisrepuestodelete.add(repuesto);
            listrepuesto.remove(index);
            modelo.removeRow(index);
            calcualartotal();
           
        
        }
              
        
        }
    }//GEN-LAST:event_jtablaMousePressed

    private void jtfrutempleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrutempleadoKeyReleased
        // TODO add your handling code here:
        empleado=daoempleado.search(jtfrutempleado.getText());
        System.out.println(jtfrut.getText());
        if(empleado.getId()!=0){
        jlblnombretrabajador.setText(empleado.getNombre()+" "+empleado.getApellido());
        jlblmensajetrab.setText("");
        }else {
        jlblmensajetrab.setText("No encontrado");
        jlblnombretrabajador.setText("* * *");
       
        }
        
        
        
    }//GEN-LAST:event_jtfrutempleadoKeyReleased

    private void jbtnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnbuscarActionPerformed
        // TODO add your handling code here:
        JDFBuscarReparacionCliente reparacioncli =new JDFBuscarReparacionCliente(new Frame(), isVisible(),this);
        reparacioncli.setVisible(true);
    }//GEN-LAST:event_jbtnbuscarActionPerformed

    private void jtfrevisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrevisionKeyTyped
        // TODO add your handling code here:
          char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) 
        && (caracter != KeyEvent.VK_BACK_SPACE)
        && (caracter != '.' || jtfrevision.getText().contains(".")) ) {
            evt.consume();
}
        
    }//GEN-LAST:event_jtfrevisionKeyTyped

    private void jtfmanoobraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmanoobraKeyTyped
        // TODO add your handling code here:
          char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) 
        && (caracter != KeyEvent.VK_BACK_SPACE)
        && (caracter != '.' || jtfmanoobra.getText().contains(".")) ) {
            evt.consume();
}
        
    }//GEN-LAST:event_jtfmanoobraKeyTyped

    private void jtfrevisionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfrevisionKeyReleased
        // TODO add your handling code here:
        calcualartotal();
    }//GEN-LAST:event_jtfrevisionKeyReleased

    private void jtfmanoobraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmanoobraKeyReleased
        // TODO add your handling code here:
        calcualartotal();
    }//GEN-LAST:event_jtfmanoobraKeyReleased

    private void jtfrutempleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfrutempleadoMouseExited
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jtfrutempleadoMouseExited

    private void jtfrutempleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfrutempleadoFocusLost
        // TODO add your handling code here:
          System.out.println("rutempl"+jtfrutempleado.getText());
        if(empleado.getId()==0){
        jtfrutempleado.setValue(null);
        jlblmensajetrab.setText("");
        }
    }//GEN-LAST:event_jtfrutempleadoFocusLost

    private void jtfrutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfrutFocusLost
        // TODO add your handling code here:
        if(cliente.getId()==0){
        jtfrut.setValue(null);
        
        }
    }//GEN-LAST:event_jtfrutFocusLost

    private void jbtncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncancelarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"Esta seguro de cancelar la operacion","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        nuevo();
    }//GEN-LAST:event_jbtncancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnagregarrepuesto;
    private javax.swing.JButton jbtnbuscar;
    private javax.swing.JButton jbtncancelar;
    private javax.swing.JButton jbtnceptar;
    private org.jdesktop.swingx.JXDatePicker jdpfecha;
    private javax.swing.JLabel jlblcodigo;
    private javax.swing.JLabel jlbldomiciliopart;
    private javax.swing.JLabel jlbldomiciliotrab;
    private javax.swing.JLabel jlblfono;
    private javax.swing.JFormattedTextField jlbliva;
    private javax.swing.JLabel jlblmensaje;
    private javax.swing.JLabel jlblmensajetrab;
    private javax.swing.JLabel jlblnombretrabajador;
    private javax.swing.JLabel jlblrazons;
    private javax.swing.JFormattedTextField jlblsubtotal;
    private javax.swing.JFormattedTextField jlbltotal;
    private javax.swing.JRadioButton jrbtnno;
    private javax.swing.JRadioButton jrbtnsi;
    private javax.swing.JTable jtabla;
    private javax.swing.JTextArea jtatrabajosrealizados;
    private javax.swing.JTextArea jtfaobservacion;
    private javax.swing.JTextField jtfdescripcion;
    private javax.swing.JTextField jtfentradopor;
    private javax.swing.JTextField jtfmanoobra;
    private javax.swing.JTextField jtfmarca;
    private javax.swing.JTextField jtfmodelo;
    private javax.swing.JFormattedTextField jtfrepuestos;
    private javax.swing.JTextField jtfrevision;
    private javax.swing.JFormattedTextField jtfrut;
    private javax.swing.JFormattedTextField jtfrutempleado;
    private javax.swing.JTextField jtfserie;
    // End of variables declaration//GEN-END:variables
}
