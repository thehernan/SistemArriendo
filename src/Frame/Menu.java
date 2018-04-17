/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import AppPackage.AnimationClass;
import ClasesGlobales.ImagenFondo;
import Pojos.SingletonEmpresa;
import Pojos.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private Dimension dim;
    SingletonEmpresa singletonempresa = SingletonEmpresa.getinstancia();
    ////////////////////////////////////
      java.util.Calendar calendario; 
    int dia, mes, año, hora, minutos, segundos; 
    //////////////////////////////////////
    Usuario usu;
       public Menu() {
        initComponents();
          ///ADAPTAR AL TAMAÑO DE PANTALLA
       
    }
    public Menu(Usuario usu) {
        initComponents();
          ///ADAPTAR AL TAMAÑO DE PANTALLA
        dim=super.getToolkit().getScreenSize();
        super.setSize(dim);
        /////////////////////////////////
        jlblempresa.setText(singletonempresa.getRazonS()+"  "+singletonempresa.getRut());
        jlbldireccion.setText(singletonempresa.getDomicilio());
//        reloj();
        this.usu=usu;
         jlblbienvenido.setText(usu.getUsuario());
         this.getContentPane().setBackground(new Color(121, 102, 87));
    }
     public void cargarImagen(){
    try{
        InputStream fondo=this.getClass().getResourceAsStream("/img/excavador.jpg");
        BufferedImage image=ImageIO.read(fondo);
        jdesktop.setBorder(new ImagenFondo(image));}
    catch (Exception e){
            JOptionPane.showMessageDialog(null,"no se encontro");
                    
        }

    }
     public void leflabel(){
       AnimationClass animation = new AnimationClass();
        animation.jLabelXLeft(10, -65, 10, 5, jlblarriendo);
        animation.jLabelXLeft(10, -65, 10, 5, jlblventa);
         animation.jLabelXLeft(10, -65, 10, 5, jlblinventario);
         animation.jLabelXLeft(10, -65, 10, 5, jlblcaja);
         animation.jLabelXLeft(10, -65, 10, 5, jlbltaller);
         animation.jLabelXLeft(10, -65, 10, 5, jlblotros);
     
     
     }
     public void menuarriendo(){
         JLabel titulo = new JLabel("ARRIENDO");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isNuevocontrato()==true){
         JButton nuevocontrato= new JButton("NUEVO CONTRATO");
         nuevocontrato.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JDFOpcionContrato opcontrato = new JDFOpcionContrato(new Frame(),isVisible(),Menu.this);
                opcontrato.setVisible(true);
                 panelconmin();
             }
         });
         
         
         jpanelcontenedor.add(nuevocontrato);
         nuevocontrato.setBounds(20, 70, 200, 50);
         nuevocontrato.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         nuevocontrato.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////
         if(usu.isContratosvig()==true){
     
        JButton contratovig= new JButton("CONTRATOS");
         contratovig.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFContratosVigentes contvigente = new JIFContratosVigentes();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = contvigente.getSize();
                contvigente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(contvigente);
                contvigente.show();
                 panelconmin();
             }
         });
         
         
         jpanelcontenedor.add(contratovig);
         contratovig.setBounds(20, 140, 200, 50);
         contratovig.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         contratovig.setBackground(new java.awt.Color(255, 204, 51));
             
         
         }
         /////////////////////////////////////////////////////////////
         if(usu.isAbonos()==true){
             JButton abono= new JButton("ABONOS");
         abono.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JIFAbonos  abonos = new JIFAbonos();
            Dimension desktopSize = jdesktop.getSize();
            Dimension FrameSize = abonos.getSize();
            abonos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jdesktop.add(abonos);
            abonos.show();
             panelconmin();
             }
         });
         
         
         jpanelcontenedor.add(abono);
         abono.setBounds(20, 210, 200, 50);
         abono.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         abono.setBackground(new java.awt.Color(255, 204, 51));
         }
         ////////////////////////////////////////////////////////
         if(usu.isDevoluciones()==true){
         JButton devolucion= new JButton("DEVOLUCIONES");
         devolucion.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JIFRecojo  recojo = new JIFRecojo();
            Dimension desktopSize = jdesktop.getSize();
            Dimension FrameSize = recojo.getSize();
            recojo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jdesktop.add(recojo);
            recojo.show();
             panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(devolucion);
         devolucion.setBounds(20, 280, 200, 50);
         devolucion.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         devolucion.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////
           if(usu.isGuia()==true){
         JButton guia= new JButton("GUIAS");
         guia.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JIFGuias fromguia = new JIFGuias();
            Dimension desktopSize = jdesktop.getSize();
            Dimension FrameSize = fromguia.getSize();
            fromguia.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jdesktop.add(fromguia);
            fromguia.show();
             panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(guia);
         guia.setBounds(20, 350, 200, 50);
         guia.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         guia.setBackground(new java.awt.Color(255, 204, 51));
         }
     }
     
      public void menuventa(){              
         JLabel titulo = new JLabel("VENTA");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isNuevaventa()==true){
         JButton nuevaventa= new JButton("NUEVA VENTA");
         nuevaventa.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFVenta venta = new JIFVenta();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = venta.getSize();
                venta.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(venta);
                venta.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(nuevaventa);
         nuevaventa.setBounds(20, 70, 200, 50);
         nuevaventa.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         nuevaventa.setBackground(new java.awt.Color(255, 204, 51));
         }
        
     
     }
      
      public void menuiventario(){
         JLabel titulo = new JLabel("INVENTARIO");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isInvarriendo()==true){
         JButton invarriendo= new JButton("INV. ARRIENDO");
         invarriendo.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JIFMaquinaria maquinaria = new JIFMaquinaria();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = maquinaria.getSize();
                maquinaria.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(maquinaria);
                maquinaria.show();
                panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(invarriendo);
         invarriendo.setBounds(20, 70, 200, 50);
         invarriendo.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         invarriendo.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////
         if(usu.isInvventa()==true){
        JButton invventa= new JButton("INV. VENTA");
         invventa.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFAridos aridos = new JIFAridos();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = aridos.getSize();
                aridos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(aridos);
                aridos.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(invventa);
         invventa.setBounds(20, 140, 200, 50);
         invventa.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         invventa.setBackground(new java.awt.Color(255, 204, 51));
         }
      }
      
      public void menucaja(){
         JLabel titulo = new JLabel("CAJA");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isIngreso()==true){
         JButton ingresos= new JButton("INGRESOS");
         ingresos.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFIngresosCaja  ingresocaja = new JIFIngresosCaja();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = ingresocaja.getSize();
                ingresocaja.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(ingresocaja);
                ingresocaja.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(ingresos);
         ingresos.setBounds(20, 70, 200, 50);
         ingresos.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         ingresos.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////
         if(usu.isEgreso()==true){
        JButton egreso= new JButton("EGRESOS");
         egreso.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFEgresos  egresos = new JIFEgresos();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = egresos.getSize();
                egresos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(egresos);
                egresos.show();
                panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(egreso);
         egreso.setBounds(20, 140, 200, 50);
         egreso.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         egreso.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////////
         if(usu.isNuevoegreso()==true){
             JButton nuevoegreso= new JButton("NUEVO EGRESO");
         nuevoegreso.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             JIFNuevoEgreso  newegresos = new JIFNuevoEgreso();
            Dimension desktopSize = jdesktop.getSize();
            Dimension FrameSize = newegresos.getSize();
            newegresos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jdesktop.add(newegresos);
            newegresos.show();
             panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(nuevoegreso);
         nuevoegreso.setBounds(20, 210, 200, 50);
         nuevoegreso.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         nuevoegreso.setBackground(new java.awt.Color(255, 204, 51));
         }
         ////////////////////////////////////////////////////////
         if(usu.isMovimientos()==true){
         JButton movimiento= new JButton("MOVIMIENTOS");
         movimiento.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JIFMovimientos movcaja = new JIFMovimientos();
            Dimension desktopSize = jdesktop.getSize();
            Dimension FrameSize = movcaja.getSize();
            movcaja.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jdesktop.add(movcaja);
            movcaja.show();
             panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(movimiento);
         movimiento.setBounds(20, 280, 200, 50);
         movimiento.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         movimiento.setBackground(new java.awt.Color(255, 204, 51));
         }
     }
      
      public void menutaller(){
         JLabel titulo = new JLabel("TALLER");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isNuevarepcliente()==true){
         JButton repcliente= new JButton("NUE. REP. CLIENTE");
         repcliente.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JIFMaquinaReparacionClient maqrepaircli = new JIFMaquinaReparacionClient();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = maqrepaircli.getSize();
                maqrepaircli.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(maqrepaircli);
                maqrepaircli.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(repcliente);
         repcliente.setBounds(20, 70, 200, 50);
         repcliente.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         repcliente.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////
         if(usu.isReparacionpropia()==true){
        JButton reppropia= new JButton("REP. PROPIA");
         reppropia.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   JIFReparacion  reparacion = new JIFReparacion();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = reparacion.getSize();
                reparacion.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(reparacion);
                reparacion.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(reppropia);
         reppropia.setBounds(20, 140, 200, 50);
         reppropia.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         reppropia.setBackground(new java.awt.Color(255, 204, 51));
         }
          if(usu.isReparacioncliente()==true){
        JButton abono= new JButton("ABONO");
         abono.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   JIFReparacionesCliente  repcli = new JIFReparacionesCliente();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = repcli.getSize();
                repcli.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(repcli);
                repcli.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(abono);
         abono.setBounds(20, 210, 200, 50);
         abono.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         abono.setBackground(new java.awt.Color(255, 204, 51));
         }
      }
      
      
      public void menuotros(){
         JLabel titulo = new JLabel("OTROS");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isEmpresas()==true){
         JButton empresa= new JButton("EMPRESAS");
         empresa.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   JIFEmpresaRegistro  empresaregi = new JIFEmpresaRegistro();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = empresaregi.getSize();
                empresaregi.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(empresaregi);
                empresaregi.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(empresa);
         empresa.setBounds(20, 70, 200, 50);
         empresa.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         empresa.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////
         if(usu.isEmpleados()==true){
        JButton empleado= new JButton("EMPLEADOS");
         empleado.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                  JIFempleados  empleado = new JIFempleados();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = empleado.getSize();
                empleado.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(empleado);
                empleado.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(empleado);
         empleado.setBounds(20, 140, 200, 50);
         empleado.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         empleado.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////////
         if(usu.isCliente()==true){
             JButton cliente= new JButton("CLIENTES");
         cliente.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JIFClientes clientes = new JIFClientes();
              Dimension desktopSize = jdesktop.getSize();
              Dimension FrameSize = clientes.getSize();
              clientes.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
              jdesktop.add(clientes);
              clientes.show();
               panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(cliente);
         cliente.setBounds(20, 210, 200, 50);
         cliente.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         cliente.setBackground(new java.awt.Color(255, 204, 51));
         }
         ////////////////////////////////////////////////////////
         if(usu.isProveedores()==true){
           JButton provee= new JButton("PROVEEDORES");
         provee.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JIFProveedores  proveedor = new JIFProveedores();
                 Dimension desktopSize = jdesktop.getSize();
                 Dimension FrameSize = proveedor.getSize();
                 proveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                 jdesktop.add(proveedor);
                 proveedor.show();
                  panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(provee);
         provee.setBounds(20, 280, 200, 50);
         provee.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         provee.setBackground(new java.awt.Color(255, 204, 51));
         }
         //////////////////////////////////////////////////////////
         if(usu.isCategorias()==true){
         JButton catego= new JButton("CATEGORIAS");
         catego.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JIFCategorias  categoria = new JIFCategorias();
                 Dimension desktopSize = jdesktop.getSize();
                 Dimension FrameSize = categoria.getSize();
                 categoria.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                 jdesktop.add(categoria);
                 categoria.show();
                  panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(catego);
         catego.setBounds(20, 350, 200, 50);
         catego.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         catego.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////////
         if(usu.isNuevacotizacion()==true){
            JButton cotiz= new JButton("NUE. COTIZACION");
         cotiz.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JIFNuevaCotizacion  cotiza = new JIFNuevaCotizacion();
                 Dimension desktopSize = jdesktop.getSize();
                 Dimension FrameSize = cotiza.getSize();
                 cotiza.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                 jdesktop.add(cotiza);
                 cotiza.show();
                  panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(cotiz);
         cotiz.setBounds(20, 420, 200, 50);
         cotiz.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         cotiz.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////
         if(usu.isNuevaordencompra()==true){
          JButton ordenc= new JButton("NUE. ORDEN COMPRA");
         ordenc.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JIFOrdenCompra  orden = new JIFOrdenCompra();
                 Dimension desktopSize = jdesktop.getSize();
                 Dimension FrameSize = orden.getSize();
                 orden.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                 jdesktop.add(orden);
                 orden.show();
                  panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(ordenc);
         ordenc.setBounds(20, 490, 200, 50);
         ordenc.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         ordenc.setBackground(new java.awt.Color(255, 204, 51));
         ///////////////////////////////////////////////////////////
         }
         //////////////
         if(usu.isCotizaciones()==true){
         JButton cotiz= new JButton("COTIZACIONES");
         cotiz.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JIFBuscarCotizacion  bcotiza = new JIFBuscarCotizacion();
                 Dimension desktopSize = jdesktop.getSize();
                 Dimension FrameSize = bcotiza.getSize();
                 bcotiza.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                 jdesktop.add(bcotiza);
                 bcotiza.show();
                  panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(cotiz);
         cotiz.setBounds(20, 560, 200, 50);
         cotiz.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         cotiz.setBackground(new java.awt.Color(255, 204, 51));
         
         }
         if(usu.isOrdencompra()==true){
          JButton orden= new JButton("ORDENES DE COMPRA");
         orden.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFBuscarOdenCompra  borden = new JIFBuscarOdenCompra();
                 Dimension desktopSize = jdesktop.getSize();
                 Dimension FrameSize = borden.getSize();
                 borden.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                 jdesktop.add(borden);
                 borden.show();
                  panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(orden);
         orden.setBounds(20, 630, 200, 50);
         orden.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         orden.setBackground(new java.awt.Color(255, 204, 51));
         
         
         }
     
     }
      
       public void menuusuario(){              
         JLabel titulo = new JLabel("USUARIO");
         jpanelcontenedor.add(titulo);
          titulo.setBounds(60, 10, 200, 50);
         titulo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
         
         ////////////////////////////////////////////////////////
         if(usu.isUsuariobo()==true){
         JButton user= new JButton("USUARIOS");
         user.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 JIFusuarios usuario = new JIFusuarios();
                Dimension desktopSize = jdesktop.getSize();
                Dimension FrameSize = usuario.getSize();
                usuario.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                jdesktop.add(usuario);
                usuario.show();
                 panelconmin();
                 
             }
         });
         
         
         jpanelcontenedor.add(user);
         user.setBounds(20, 70, 200, 50);
         user.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         user.setBackground(new java.awt.Color(255, 204, 51));
         }
         /////////////////////////////////////////////////////////
           JButton cerrar= new JButton("CERRAR SESION");
         cerrar.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(JOptionPane.showConfirmDialog(null, "SEGURO QUE DESEA CERRAR SESIÓN","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            int componentes=jdesktop.getComponentCount();
            System.out.println("ventanas "+componentes);
            if(componentes==2){
                singletonempresa.getdestruir();
               
                Menu.this.dispose();
                JFLogin nuevaSesion = new JFLogin();
//                AWTUtilities.setWindowOpaque(nuevaSesion, false);
                nuevaSesion.setVisible(true);

            }else{
                JOptionPane.showMessageDialog(null, "IMPOSIBLE CERRAR SESION, CIERRE LAS VENTANAS ABIERTAS E INTENTE NUEVAMENTE","SISTEMA",JOptionPane.INFORMATION_MESSAGE);
            }

        }
                 
             }
         });
         
         
         jpanelcontenedor.add(cerrar);
         cerrar.setBounds(20, 140, 200, 50);
         cerrar.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
         cerrar.setBackground(new java.awt.Color(255, 204, 51));
         
        
     
     }
      
      
      public void panelconmin(){
      Dimension dimm= new Dimension(2, 0);
      jpanelcontenedor.setPreferredSize(dimm);
      jpanelcontenedor.revalidate();
      
      }
      public void panelconmax(){
      Dimension dimm= new Dimension(237, 0);
      jpanelcontenedor.setPreferredSize(dimm);
      jpanelcontenedor.revalidate();
      
      }
      
      
      
//      private void reloj() { 
//        calendario = new java.util.GregorianCalendar(); 
//        segundos = calendario.get(Calendar.SECOND); 
//        javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() { 
//        @ Override 
//        public void actionPerformed(java.awt.event.ActionEvent ae) { 
//        java.util.Date actual = new java.util.Date(); 
//        calendario.setTime(actual); 
//        dia = calendario.get(Calendar.DAY_OF_MONTH); 
//        mes = (calendario.get(Calendar.MONTH) + 1); 
//        año = calendario.get(Calendar.YEAR); 
//        hora = calendario.get(Calendar.HOUR_OF_DAY); 
//        minutos = calendario.get(Calendar.MINUTE); 
//        segundos = calendario.get(Calendar.SECOND); 
//        String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
//        String date = String.format("%02d / %02d / %02d", dia, mes, año); 
//        jlblhora.setText("<html><center>" + hour + "<br>" + date); 
//           } 
//        }); 
//        timer.start(); 
//}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdesktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblbienvenido = new javax.swing.JLabel();
        jlblempresa = new javax.swing.JLabel();
        jlbldireccion = new javax.swing.JLabel();
        jlblminimizar = new javax.swing.JLabel();
        jbtnmenu = new javax.swing.JLabel();
        jpanelmenu = new javax.swing.JPanel();
        jlblarriendo = new javax.swing.JLabel();
        jlblventa = new javax.swing.JLabel();
        jlblinventario = new javax.swing.JLabel();
        jlblcaja = new javax.swing.JLabel();
        jlbltaller = new javax.swing.JLabel();
        jlblotros = new javax.swing.JLabel();
        jlblusuarios = new javax.swing.JLabel();
        jpanelcontenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(121, 102, 87));
        setUndecorated(true);

        jdesktop.setBackground(new java.awt.Color(255, 255, 255));
        jdesktop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jdesktopMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(237, 197, 72));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(121, 102, 87));
        jLabel1.setText("BIENVENIDO:");

        jlblbienvenido.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jlblbienvenido.setForeground(new java.awt.Color(121, 102, 87));
        jlblbienvenido.setText("jLabel9");

        jlblempresa.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jlblempresa.setForeground(new java.awt.Color(121, 102, 87));
        jlblempresa.setText("jLabel12");

        jlbldireccion.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jlbldireccion.setForeground(new java.awt.Color(121, 102, 87));
        jlbldireccion.setText("jLabel13");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblempresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblbienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlblbienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbldireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblempresa)
                .addGap(234, 234, 234))
        );

        jlblminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize2.png"))); // NOI18N
        jlblminimizar.setToolTipText("Minimizar");
        jlblminimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblminimizarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jdesktopLayout = new javax.swing.GroupLayout(jdesktop);
        jdesktop.setLayout(jdesktopLayout);
        jdesktopLayout.setHorizontalGroup(
            jdesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdesktopLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1371, Short.MAX_VALUE)
                .addComponent(jlblminimizar)
                .addContainerGap())
        );
        jdesktopLayout.setVerticalGroup(
            jdesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdesktopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jdesktopLayout.createSequentialGroup()
                .addComponent(jlblminimizar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jdesktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdesktop.setLayer(jlblminimizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jbtnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jbtnmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbtnmenuMouseReleased(evt);
            }
        });

        jpanelmenu.setBackground(new java.awt.Color(237, 197, 72));
        jpanelmenu.setForeground(new java.awt.Color(231, 76, 60));
        jpanelmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblarriendo.setBackground(new java.awt.Color(26, 188, 156));
        jlblarriendo.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jlblarriendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoarriendo.png"))); // NOI18N
        jlblarriendo.setToolTipText("ARRIENDO");
        jlblarriendo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlblarriendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblarriendo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlblarriendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblarriendoMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlblarriendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 10, -1, -1));

        jlblventa.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jlblventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoventa.png"))); // NOI18N
        jlblventa.setToolTipText("VENTA");
        jlblventa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblventa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlblventa.setVerifyInputWhenFocusTarget(false);
        jlblventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblventaMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlblventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 60, -1, -1));

        jlblinventario.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jlblinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoinventario.png"))); // NOI18N
        jlblinventario.setToolTipText("INVENTARIO");
        jlblinventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblinventario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlblinventario.setPreferredSize(new java.awt.Dimension(111, 40));
        jlblinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblinventarioMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlblinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 110, -1, -1));

        jlblcaja.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jlblcaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconocaja.png"))); // NOI18N
        jlblcaja.setToolTipText("CAJA ");
        jlblcaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblcaja.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlblcaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblcajaMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlblcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 160, -1, -1));

        jlbltaller.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jlbltaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconotaller.png"))); // NOI18N
        jlbltaller.setToolTipText("TALLER  ");
        jlbltaller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbltaller.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlbltaller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlbltallerMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlbltaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 210, -1, -1));

        jlblotros.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jlblotros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconootros.png"))); // NOI18N
        jlblotros.setToolTipText("OTROS");
        jlblotros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblotros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlblotros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblotrosMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlblotros, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 260, 110, -1));

        jlblusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconouser.png"))); // NOI18N
        jlblusuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlblusuariosMouseReleased(evt);
            }
        });
        jpanelmenu.add(jlblusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-65, 310, -1, -1));

        jpanelcontenedor.setBackground(new java.awt.Color(121, 102, 87));
        jpanelcontenedor.setForeground(new java.awt.Color(41, 128, 185));
        jpanelcontenedor.setPreferredSize(new java.awt.Dimension(2, 0));

        javax.swing.GroupLayout jpanelcontenedorLayout = new javax.swing.GroupLayout(jpanelcontenedor);
        jpanelcontenedor.setLayout(jpanelcontenedorLayout);
        jpanelcontenedorLayout.setHorizontalGroup(
            jpanelcontenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jpanelcontenedorLayout.setVerticalGroup(
            jpanelcontenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnmenu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanelcontenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdesktop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbtnmenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addComponent(jpanelcontenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)))
            .addComponent(jdesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnmenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnmenuMouseReleased
        // TODO add your handling code here:
        AnimationClass animation = new AnimationClass();
        
        animation.jLabelXRight(-65, 10, 10, 5, jlblarriendo);
        animation.jLabelXLeft(10, -65, 10, 5, jlblarriendo);
        
        animation.jLabelXRight(-65, 10, 10, 5, jlblventa);
        animation.jLabelXLeft(10, -65, 10, 5, jlblventa);
        
        animation.jLabelXRight(-65, 10, 10, 5, jlblinventario);
        animation.jLabelXLeft(10, -65, 10, 5, jlblinventario);
        
         animation.jLabelXRight(-65, 10, 10, 5, jlblcaja);
        animation.jLabelXLeft(10, -65, 10, 5, jlblcaja);
        
        animation.jLabelXRight(-65, 10, 10, 5, jlbltaller);
        animation.jLabelXLeft(10, -65, 10, 5, jlbltaller);
        
        animation.jLabelXRight(-65, 10, 10, 5, jlblotros);
        animation.jLabelXLeft(10, -65, 10, 5, jlblotros);
        
        animation.jLabelXRight(-65, 10, 10, 5, jlblusuarios);
        animation.jLabelXLeft(10, -65, 10, 5, jlblusuarios);
        
        
        panelconmin();
        
        
    }//GEN-LAST:event_jbtnmenuMouseReleased

    private void jlblarriendoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblarriendoMouseReleased
        // TODO add your handling code here:
      leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menuarriendo();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
          menuarriendo();
      }
       panelconmax();
    }//GEN-LAST:event_jlblarriendoMouseReleased

    private void jlblventaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblventaMouseReleased
        // TODO add your handling code here:
        leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menuventa();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
         menuventa();
      }
       panelconmax();
        
    }//GEN-LAST:event_jlblventaMouseReleased

    private void jlblinventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblinventarioMouseReleased
        // TODO add your handling code here:
        leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menuiventario();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
          menuiventario();
      }
       panelconmax();
    }//GEN-LAST:event_jlblinventarioMouseReleased

    private void jlblcajaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblcajaMouseReleased
        // TODO add your handling code here:
         leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menucaja();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
          menucaja();
      }
       panelconmax();
    }//GEN-LAST:event_jlblcajaMouseReleased

    private void jlbltallerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbltallerMouseReleased
        // TODO add your handling code here:
        leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menutaller();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
          menutaller();
      }
       panelconmax();
    }//GEN-LAST:event_jlbltallerMouseReleased

    private void jlblotrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblotrosMouseReleased
        // TODO add your handling code here:
        leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menuotros();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
            menuotros();
      }
       panelconmax();
    }//GEN-LAST:event_jlblotrosMouseReleased

    private void jlblusuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblusuariosMouseReleased
        // TODO add your handling code here:
          leflabel();
        System.out.println(jpanelcontenedor.getComponentCount());
      if(jpanelcontenedor.getComponentCount()==0){
          menuusuario();
      }else {
          jpanelcontenedor.removeAll();
          jpanelcontenedor.repaint();
           menuusuario();
      }
       panelconmax();
    }//GEN-LAST:event_jlblusuariosMouseReleased

    private void jdesktopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdesktopMouseReleased
        // TODO add your handling code here:
         panelconmin();
    }//GEN-LAST:event_jdesktopMouseReleased

    private void jlblminimizarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblminimizarMouseReleased
        // TODO add your handling code here:
          setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jlblminimizarMouseReleased

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbtnmenu;
    public javax.swing.JDesktopPane jdesktop;
    private javax.swing.JLabel jlblarriendo;
    private javax.swing.JLabel jlblbienvenido;
    private javax.swing.JLabel jlblcaja;
    private javax.swing.JLabel jlbldireccion;
    private javax.swing.JLabel jlblempresa;
    private javax.swing.JLabel jlblinventario;
    private javax.swing.JLabel jlblminimizar;
    private javax.swing.JLabel jlblotros;
    private javax.swing.JLabel jlbltaller;
    private javax.swing.JLabel jlblusuarios;
    private javax.swing.JLabel jlblventa;
    private javax.swing.JPanel jpanelcontenedor;
    private javax.swing.JPanel jpanelmenu;
    // End of variables declaration//GEN-END:variables
}
