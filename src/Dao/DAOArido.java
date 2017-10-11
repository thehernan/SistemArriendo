/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Arido;
import Pojos.SingletonEmpresa;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
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
public class DAOArido implements Interface.IntArido{
    private  Conexion cn;
    SingletonEmpresa empresa = SingletonEmpresa.getinstancia();
     
    

    @Override
    public List<Arido> view(JTable tabla) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Arido> listarido= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrararidos(?)");
        ps.setLong(1, empresa.getId());
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Descripcion","Unidad. Med","Precio","Cantidad/stock"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[4];
       
             
        
        while (rs.next()){
            NumberFormat nf= NumberFormat.getInstance();
            Arido arido = new Arido();
            arido.setId(rs.getLong("id"));
            arido.setDescripcion(rs.getString("vdescripcion"));
            arido.setCantidad(rs.getDouble("vcantidad"));
            arido.setUndmed(rs.getString("vunidmed"));
            arido.setPrecio(rs.getDouble("vprecio"));
            arido.setInvinicial(rs.getDouble("vinvinicial"));
            arido.setIdempresa(rs.getLong("videmp"));
            arido.setIdcatgoria(rs.getLong("vidcategoria"));
            arido.setCategoria(rs.getString("vcategoria"));
            datosR[0]=arido.getDescripcion();
            datosR[1]=arido.getUndmed();
            datosR[2]=nf.format(arido.getPrecio());
            datosR[3]=nf.format(arido.getCantidad());
            modelo.addRow(datosR);
            listarido.add(arido);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listarido;
    }
    @Override
    public void insert(Arido arido) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertaridos(?,?,?,?,?,?)");
        ps.setString(1, arido.getDescripcion());
        ps.setString(2,arido.getUndmed());
        ps.setBigDecimal(3,new  BigDecimal(arido.getPrecio()));
        ps.setBigDecimal(4,new BigDecimal(arido.getInvinicial()));
        ps.setLong(5,empresa.getId());
        ps.setLong(6,arido.getId());
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Arido guardado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
     
    }

    @Override
    public void update(Arido arido) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updatearidos(?,?,?,?,?,?)");
        ps.setLong(1, arido.getId());
        ps.setString(2, arido.getDescripcion());
        ps.setString(3,arido.getUndmed());
        ps.setBigDecimal(4,new  BigDecimal(arido.getPrecio()));
        ps.setBigDecimal(5,new BigDecimal(arido.getInvinicial()));
        ps.setLong(6, arido.getId());
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Arido editado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public void delete(Long id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_deletearidos(?)");
        ps.setLong(1, id);
      
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Arido eliminado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public void print() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/InventarioAridos.jasper";
            
            Map parametros = new HashMap();
                              
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
    public boolean duplicate(long id, String cadena, String op) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
         boolean duplicado= false;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_duplicatearidos(?,?,?)");
        ps.setLong(1, id);
        ps.setString(2, cadena);
        ps.setString(3,op);
    
        
        rs=ps.executeQuery();
     
        while (rs.next()){
            //JOptionPane.showMessageDialog(null,"Arido ya se encuentra registrado");
            duplicado= rs.getBoolean("vvalida");
        }
	
        } catch(SQLException e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return duplicado;
    }

    @Override
    public List<Arido> searchsensitive(JTable tabla,  long idcat,String op,String cadena) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Arido> listarido= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_busquedasensitivaaridos(?,?,?,?)");
        ps.setLong(1, empresa.getId());
        ps.setLong(2, idcat);
        ps.setString(3, op);
        ps.setString(4, cadena);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Descripcion","Unidad. Med","Precio","Cantidad/stock"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[4];
       
             
        
        while (rs.next()){
            NumberFormat nf= NumberFormat.getInstance();
            Arido arido = new Arido();
            arido.setId(rs.getLong("id"));
            arido.setDescripcion(rs.getString("vdescripcion"));
            arido.setCantidad(rs.getDouble("vcantidad"));
            arido.setUndmed(rs.getString("vunidmed"));
            arido.setPrecio(rs.getDouble("vprecio"));
            arido.setInvinicial(rs.getDouble("vinvinicial"));
            arido.setIdempresa(rs.getLong("videmp"));
            arido.setIdcatgoria(rs.getLong("vidcategoria"));
            arido.setCategoria(rs.getString("vcategoria"));
            datosR[0]=arido.getDescripcion();
            datosR[1]=arido.getUndmed();
            datosR[2]=nf.format(arido.getPrecio());
            datosR[3]=nf.format(arido.getCantidad());
            modelo.addRow(datosR);
            listarido.add(arido);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOArido.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listarido; 
    }
   
    
}
