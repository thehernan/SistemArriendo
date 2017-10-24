/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Cliente;
import java.awt.HeadlessException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
public class DAOCliente implements Interface.IntCliente{
    

    @Override
    public List<Cliente> view(JTable tabla) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Cliente> listcliente= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarclientes(?)");
        ps.setString(1, "CLIENTE");
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Nombre","Apellido","R.U.T"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNombre(rs.getString("vnombre"));
            cliente.setApellido(rs.getString("vapellido"));
            cliente.setRut(rs.getString("vrut"));
            cliente.setTelefono(rs.getString("vtelefono"));
            cliente.setDomiciliopart(rs.getString("vdomiciliopart"));
            cliente.setDomiciliatrab(rs.getString("vdomiciliotrab"));
            cliente.setCopiacarne(rs.getBytes("vcopia"));
            datosR[0]=cliente.getNombre();
            datosR[1]=cliente.getApellido();
            datosR[2]=cliente.getRut();
            modelo.addRow(datosR);
            listcliente.add(cliente);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listcliente;
    }

    @Override
    public void insert(Cliente cli) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        byte[] copia=cli.getCopiacarne();
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        InputStream copiaC = new ByteArrayInputStream(copia);
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertcliente(?,?,?,?,?,?,?,?)");
        ps.setString(1, cli.getNombre());
        ps.setString(2,cli.getApellido());
        ps.setString(3,cli.getRut());
        ps.setString(4,cli.getTelefono());
        ps.setString(5,cli.getDomiciliopart());
        ps.setString(6,cli.getDomiciliatrab());
        ps.setBinaryStream(7, copiaC);
        ps.setString(8, cli.getTipo());
       
//        ps.setLong(5, arido.getIdempresa());
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Guardado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
     
    }

    @Override
    public void update(Cliente cli) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        byte[] copia=cli.getCopiacarne();
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        InputStream copiaC = new ByteArrayInputStream(copia);
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updatecliente(?,?,?,?,?,?,?,?)");
        ps.setLong(1,cli.getId());
        ps.setString(2, cli.getNombre());
        ps.setString(3,cli.getApellido());
        ps.setString(4,cli.getRut());
        ps.setString(5,cli.getTelefono());
        ps.setString(6,cli.getDomiciliopart());
        ps.setString(7,cli.getDomiciliatrab());
        ps.setBinaryStream(8, copiaC);
       
//        ps.setLong(5, arido.getIdempresa());
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Editado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
     
    }

    @Override
    public void delete(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_deletecliente(?)");
        ps.setLong(1, id);
      
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Eliminado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public void printdebtor(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.}
         try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/EstadoPago.jasper";
            
            Map parametros = new HashMap();
            parametros.put("idcliente",  id);                 
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
         boolean duplicado= false;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_duplicatecliente(?,?,?)");
        ps.setLong(1, id);
        ps.setString(2, cadena);
        ps.setString(3,op);
    
        
        rs=ps.executeQuery();
     
        while (rs.next()){
//            JOptionPane.showMessageDialog(null,"Cliente ya se encuentra registrado");
            duplicado= rs.getBoolean("vvalida");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return duplicado;
    }

    @Override
    public Cliente search(String rut,String tipo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        Cliente cliente=new Cliente();
       
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_buscarcliente(?,?)");
        ps.setString(1, rut);
        ps.setString(2, tipo);
        rs=ps.executeQuery();
       
        if (rs.next()){
            cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNombre(rs.getString("vnombre"));
            cliente.setApellido(rs.getString("vapellido"));
            cliente.setRut(rs.getString("vrut"));
            cliente.setTelefono(rs.getString("vtelefono"));
            cliente.setDomiciliopart(rs.getString("vdomiciliopart"));
            cliente.setDomiciliatrab(rs.getString("vdomiciliotrab"));
//            cliente.setCopiacarne(rs.getBytes("vdomicilio"));
         
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  cliente;
        
    }

    @Override
    public List<Cliente> viewbusiness(JTable tabla,String tipo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Cliente> listcliente= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarclientes(?)");
        ps.setString(1, tipo);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Razon Social","R.U.T"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[2];
       
             
        
        while (rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNombre(rs.getString("vnombre"));
            cliente.setApellido(rs.getString("vapellido"));
            cliente.setRut(rs.getString("vrut"));
            cliente.setTelefono(rs.getString("vtelefono"));
            cliente.setDomiciliopart(rs.getString("vdomiciliopart"));
            cliente.setDomiciliatrab(rs.getString("vdomiciliotrab"));
            cliente.setCopiacarne(rs.getBytes("vcopia"));
            datosR[0]=cliente.getNombre();
           
            datosR[1]=cliente.getRut();
            modelo.addRow(datosR);
            listcliente.add(cliente);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listcliente;
    }

    @Override
    public void updatenophoto(Cliente cli) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        byte[] copia=cli.getCopiacarne();
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updateclientesinfoto(?,?,?,?,?,?,?)");
        ps.setLong(1,cli.getId());
        ps.setString(2, cli.getNombre());
        ps.setString(3,cli.getApellido());
        ps.setString(4,cli.getRut());
        ps.setString(5,cli.getTelefono());
        ps.setString(6,cli.getDomiciliopart());
        ps.setString(7,cli.getDomiciliatrab());
       
       
//        ps.setLong(5, arido.getIdempresa());
        
        rs=ps.executeQuery();
      
        while (rs.next()){
//            JOptionPane.showMessageDialog(null,"Cliente editado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
     
    }

    @Override
    public boolean verifyclientdebtor(long idclient) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        boolean valida=false;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_verificadeudacliente(?)");
        ps.setLong(1, idclient);
       
        rs=ps.executeQuery();
       
        if (rs.next()){
          valida=rs.getBoolean(1);
//            cliente.setCopiacarne(rs.getBytes("vdomicilio"));		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  valida; 
        
    }
    
}
