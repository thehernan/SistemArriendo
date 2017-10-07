/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Venta;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author info2017
 */
public class DAOVenta implements Interface.IntVenta{

    @Override
    public long insert(Venta venta) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertventa(?,?,?)");
        ps.setLong(1, venta.getIdcliente());
        ps.setLong(2, venta.getIdempresa());
        ps.setBigDecimal(3, new BigDecimal(venta.getDescuento()));
   
    
        
        rs=ps.executeQuery();
      
        while (rs.next()){
           id= rs.getLong("vid");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }

    @Override
    public long insertnoclient(Venta venta) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertventanocliente(?,?)");
        ps.setLong(1, venta.getIdempresa());
        ps.setBigDecimal(2, new BigDecimal(venta.getDescuento()));
   
    
        
        rs=ps.executeQuery();
      
        while (rs.next()){
           id= rs.getLong("vid");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }

    @Override
    public void print(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/BoletaVenta.jasper";
            
            Map parametros = new HashMap();
            parametros.put("idventa",  id);                 
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
    public boolean validatestock(long idprod, double canti) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        boolean valida=false;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_validastockventa(?,?)");
        ps.setLong(1, idprod);
        ps.setBigDecimal(2, new BigDecimal(canti));       
        rs=ps.executeQuery();
      
        while (rs.next()){
           valida= rs.getBoolean("valida");
        }
	
        } catch(Exception e)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return valida;
    }
    }
