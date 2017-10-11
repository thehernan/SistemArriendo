/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.DetalleCaja;
import Pojos.SingletonEmpresa;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author info2017
 */
public class DAODetCaja implements Interface.IntDetalleCaja{
    SingletonEmpresa singletonempresa = SingletonEmpresa.getinstancia();

    @Override
    public void insertpaycontrato(DetalleCaja detcaja) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajaguia(?,?,?,?,?)");
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setBigDecimal(2,new BigDecimal(detcaja.getPago()));
        ps.setLong(3, detcaja.getIdcontrato());
        ps.setString(4, detcaja.getObservacion());
        ps.setLong(5, singletonempresa.getId());
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
    public void insetpaysale(DetalleCaja detcaja) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajaventa(?,?,?,?,?)");
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setBigDecimal(2,new BigDecimal(detcaja.getPago()));
        ps.setLong(3, detcaja.getIdventa());
        ps.setString(4, detcaja.getObservacion());
        ps.setLong(5, singletonempresa.getId());
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
    public void insertrepair(DetalleCaja detcaja) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertdetcajarepair(?,?,?,?)");
        
        ps.setBigDecimal(1, new BigDecimal(detcaja.getImporte()));
        ps.setString(2, detcaja.getObservacion());
        ps.setLong(3, detcaja.getIdreparir());
        ps.setLong(4, singletonempresa.getId());
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
    public String view(JTable tabla,String tipob, Timestamp fecha, String mes) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        Double total=0.0;
        Double importe=0.0;
        NumberFormat nf=  NumberFormat.getInstance();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarmovimientocaja(?,?,?,?)");
        ps.setLong(1, singletonempresa.getId());
        ps.setString(2, tipob);
        ps.setTimestamp(3, fecha);
        ps.setString(4, mes);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Cod. Venta","Cod. Contrato","Cod. Reparación","Importe","Observación","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[6];
       
             
        
        while (rs.next()){
           importe=rs.getDouble("vimporte");
           total=total+importe;
                   
            datosR[0]=rs.getObject("vcodventa");
            datosR[1]=rs.getObject("vcodcontrato");
            datosR[2]=rs.getObject("vcodreparacion");
            datosR[3]=nf.format(importe);
            datosR[4]=rs.getObject("vobservacion");
            datosR[5]=rs.getObject("vfecha");
            modelo.addRow(datosR);
          
		
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
       return "Total $: "+nf.format(total);
    }
    
}
