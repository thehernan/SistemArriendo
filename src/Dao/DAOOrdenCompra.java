/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Cotizacion;
import Pojos.OrdenCompra;
import Pojos.SingletonEmpresa;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DAOOrdenCompra implements Interface.IntOrdenCompra{
    SingletonEmpresa empresa= SingletonEmpresa.getinstancia();
            
    @Override
    public long insert(OrdenCompra orden) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertordencompra(?,?,?,?,?)");

        ps.setLong(1,empresa.getId());
        ps.setLong(2, orden.getIdcliente());
        ps.setString(3,orden.getAprobada());
        ps.setString(4, orden.getDespachar());
        ps.setString(5, orden.getFormapago());
        
       
       
    
        
        rs=ps.executeQuery();
      
        while (rs.next()){
           id= rs.getLong("vid");
           JOptionPane.showMessageDialog(null,"Orden Compra guardado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }

    @Override
    public List<OrdenCompra> view(long idempre, JTable tabla) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<OrdenCompra> listorden= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarordencompra(?)");
        ps.setLong(1, idempre);

        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Codigo","Cliente","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            OrdenCompra orden = new OrdenCompra();
            orden.setId(rs.getLong("vidorden"));
           
            datosR[0]=rs.getObject("vcod");
            datosR[1]=rs.getObject("vcliente");
            datosR[2]=rs.getObject("vfecha");
         
            modelo.addRow(datosR);
            listorden.add(orden);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }
        return listorden;
    }

    @Override
    public void print(long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/OrdenCompra.jasper";
            
            Map parametros = new HashMap();
            parametros.put("idorden",  id);                 
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
    public List<OrdenCompra> searchsensitive(long idempre, JTable tabla, String cadena) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<OrdenCompra> listorden= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_busquedasensitivaordencompra(?,?)");
        ps.setLong(1, idempre);
        ps.setString(2, cadena);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Codigo","Cliente","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            OrdenCompra orden = new OrdenCompra();
            orden.setId(rs.getLong("vidorden"));
           
            datosR[0]=rs.getObject("vcod");
            datosR[1]=rs.getObject("vcliente");
            datosR[2]=rs.getObject("vfecha");
         
            modelo.addRow(datosR);
            listorden.add(orden);
		
        }
        if(modelo.getRowCount()>0){
            tabla.setRowSelectionInterval(0, 0);
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOOrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listorden;
    }
    
}
