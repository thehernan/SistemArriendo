/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.DetalleCaja;
import Pojos.SingletonEmpresa;
import java.awt.HeadlessException;
import java.awt.Label;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author info2017
 */
public class DAODetCaja implements Interface.IntDetalleCaja{
    SingletonEmpresa singletonempresa = SingletonEmpresa.getinstancia();

    @Override
    public long insertpaycontrato(DetalleCaja detcaja,double desc) {
//        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id=0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajaguia(?,?,?,?,?,?)");
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setBigDecimal(2,new BigDecimal(detcaja.getPago()));
        ps.setLong(3, detcaja.getIdcontrato());
        ps.setString(4, detcaja.getObservacion());
        ps.setLong(5, singletonempresa.getId());
        ps.setBigDecimal(6,new BigDecimal(desc));
       
        rs=ps.executeQuery();
      
        if (rs.next()){
            id= rs.getLong("id");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }
        return id;
    }

    @Override
    public void insetpaysale(DetalleCaja detcaja) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajaventa(?,?,?,?,?,?,?)");
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setBigDecimal(2,new BigDecimal(detcaja.getPago()));
        ps.setLong(3, detcaja.getIdventa());
        ps.setString(4, detcaja.getObservacion());
        ps.setLong(5, singletonempresa.getId());
        ps.setBigDecimal(6,new BigDecimal(detcaja.getDescuento()));
        ps.setBigDecimal(7,new BigDecimal(detcaja.getTotal()));
        rs=ps.executeQuery();
      
//        while (rs.next()){
//            JOptionPane.showMessageDialog(null,"Arido guardado con exito");	
//        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public void insertdischarge(DetalleCaja detcaja) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajaegreso(?,?,?)");
        
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setString(2, detcaja.getObservacion());
        ps.setLong(3, singletonempresa.getId());
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Egreso guardado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public long insertrepair(DetalleCaja detcaja) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id=0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajarepair(?,?,?,?)");
        
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setString(2, detcaja.getObservacion());
        ps.setLong(3, detcaja.getIdreparir());
        ps.setLong(4, singletonempresa.getId());
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Abono guardado con exito");
            id=rs.getLong("vid");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }

    @Override
    public List<DetalleCaja> view(JTable tabla,String tipob, Timestamp fecha, String mes,JLabel jtotal) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        Double total=0.0;
        Double importe=0.0;
        NumberFormat nf=  NumberFormat.getInstance();
        
        
           DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Cod. Venta","Cod. Contrato","Cod. Reparación","Importe","Descuento","Total","Observación","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        List<DetalleCaja> listdetcaja = new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarmovimientocaja(?,?,?,?)");
        ps.setLong(1, singletonempresa.getId());
        ps.setString(2, tipob);
        ps.setTimestamp(3, fecha);
        ps.setString(4, mes);
        rs=ps.executeQuery();
        
      
        Object datosR[] = new Object[8];
       
        
        
        while (rs.next()){
           importe=rs.getDouble("vtotal");
           total=total+importe;
           DetalleCaja detcaja = new DetalleCaja();
           detcaja.setId(rs.getLong("viddetcaja"));
           detcaja.setIdcontrato(rs.getLong("vidcontra"));
           detcaja.setIdventa(rs.getLong("vidventa"));
           detcaja.setIdreparir(rs.getLong("vidrepa"));
            datosR[0]=rs.getObject("vcodventa");
            datosR[1]=rs.getObject("vcodcontrato");
            datosR[2]=rs.getObject("vcodreparacion");
            datosR[3]=nf.format(rs.getDouble("vimporte"));
            datosR[4]=nf.format(rs.getDouble("vdescuento"));
            datosR[5]=nf.format(importe);
            
            datosR[6]=rs.getObject("vobservacion");
            datosR[7]=rs.getObject("vfecha");
            modelo.addRow(datosR);
            listdetcaja.add(detcaja);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetCaja.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
       jtotal.setText("Total $: "+nf.format(total));
       return listdetcaja;
    }

    @Override
    public void print(String titulo, String tipob, Timestamp fecha, String mes) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/MovimientoCaja.jasper";
            
            Map parametros = new HashMap();
            parametros.put("titulo",  titulo);
            parametros.put("idempresa",  singletonempresa.getId());
            parametros.put("tipob",  tipob);
            parametros.put("fecha",  fecha);
            parametros.put("mes",  mes);
            
            
            JasperPrint informe=null;
            informe = JasperFillManager.fillReport(rutaInforme, parametros,Conexion.Connect());
            
           // JasperPrintManager.printReport(informe, true);
            
            JasperViewer jv = new JasperViewer(informe,false);  
        
             jv.setVisible(true);
             jv.setTitle(rutaInforme);
            
          
        }catch (HeadlessException | JRException ex) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL REPORTE", "ERROR",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    @Override
    public void printabono(long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/ComprobantePago.jasper";
            
            Map parametros = new HashMap();
            parametros.put("iddetcaja",  id);
       
            
            JasperPrint informe=null;
            informe = JasperFillManager.fillReport(rutaInforme, parametros,Conexion.Connect());
            
           // JasperPrintManager.printReport(informe, true);
            
            JasperViewer jv = new JasperViewer(informe,false);  
        
             jv.setVisible(true);
             jv.setTitle(rutaInforme);
            
          
        }catch (HeadlessException | JRException ex) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL REPORTE", "ERROR",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    @Override
    public void printrepair(long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/ComprobantePagoReparacion.jasper";
            
            Map parametros = new HashMap();
            parametros.put("iddetcaja",  id);
       
            
            JasperPrint informe=null;
            informe = JasperFillManager.fillReport(rutaInforme, parametros,Conexion.Connect());
            
           // JasperPrintManager.printReport(informe, true);
            
            JasperViewer jv = new JasperViewer(informe,false);  
        
             jv.setVisible(true);
             jv.setTitle(rutaInforme);
            
          
        }catch (HeadlessException | JRException ex) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL REPORTE", "ERROR",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    
}
