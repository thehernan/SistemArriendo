/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author info2017
 */
public class DAOEmpleado implements Interface.InEmpleado{

    @Override
    public List<Empleado> view(JTable tabla) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Empleado> listaempleado= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostraempleados()");
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Nombres","Apellidos","R.U.T"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            Empleado empleado = new Empleado();
            empleado.setId(rs.getLong("id"));
            empleado.setNombre(rs.getString("vnombre"));
            empleado.setApellido(rs.getString("vapellido"));
            empleado.setRut(rs.getString("vrut"));
            empleado.setTelefono(rs.getString("vtelefono"));
            empleado.setDomicilio(rs.getString("vdomicilio"));
            datosR[0]=empleado.getNombre();
            datosR[1]=empleado.getApellido();
            datosR[2]=empleado.getRut();
            modelo.addRow(datosR);
            listaempleado.add(empleado);
		
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
        
       return  listaempleado;
        
    }

    @Override
    public void insert(Empleado emp) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertempleado(?,?,?,?,?)");
        ps.setString(1, emp.getNombre());
        ps.setString(2,emp.getApellido());
        ps.setString(3,emp.getRut());
        ps.setString(4,emp.getTelefono());
        ps.setString(5,emp.getDomicilio());
//        ps.setLong(5, arido.getIdempresa());
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Empleado guardado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
     
    }

    @Override
    public void update(Empleado emp) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updateempleado(?,?,?,?,?,?)");
        ps.setLong(1, emp.getId());
        ps.setString(2, emp.getNombre());
        ps.setString(3,emp.getApellido());
        ps.setString(4,emp.getRut());
        ps.setString(5,emp.getTelefono());
        ps.setString(6,emp.getDomicilio());
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Empleado editado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
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
        ps = c.prepareStatement("SELECT * from sp_deleteempleado(?)");
        ps.setLong(1, id);
      
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Empleado eliminado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ps = c.prepareStatement("SELECT * from sp_duplicateempleado(?,?,?)");
        ps.setLong(1, id);
        ps.setString(2, cadena);
        ps.setString(3,op);
    
        
        rs=ps.executeQuery();
     
        while (rs.next()){
//            JOptionPane.showMessageDialog(null,"Empleado ya se encuentra registrado");
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
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return duplicado;
    }

    @Override
    public Empleado search(String rut) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        Empleado empleado=new Empleado();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_buscarempleado(?)");
        ps.setString(1, rut);
   
        
        rs=ps.executeQuery();
      
        if (rs.next()){
//            JOptionPane.showMessageDialog(null,"Empleado editado con exito");	
            empleado= new Empleado();
            empleado.setId(rs.getLong("id"));
            empleado.setNombre(rs.getString("vnombre"));
            empleado.setApellido(rs.getString("vapellido"));
            empleado.setRut(rs.getString("vrut"));
            empleado.setTelefono(rs.getString("vtelefono"));
            empleado.setDomicilio(rs.getString("vdomicilio"));
            
            
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return empleado;
    }

    @Override
    public List<Empleado> searchsensitive(JTable tabla, String cadena) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Empleado> listaempleado= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_busquedasensitivaempleados(?)");
        ps.setString(1, cadena);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Nombres","Apellidos","R.U.T"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            Empleado empleado = new Empleado();
            empleado.setId(rs.getLong("id"));
            empleado.setNombre(rs.getString("vnombre"));
            empleado.setApellido(rs.getString("vapellido"));
            empleado.setRut(rs.getString("vrut"));
            empleado.setTelefono(rs.getString("vtelefono"));
            empleado.setDomicilio(rs.getString("vdomicilio"));
            datosR[0]=empleado.getNombre();
            datosR[1]=empleado.getApellido();
            datosR[2]=empleado.getRut();
            modelo.addRow(datosR);
            listaempleado.add(empleado);
		
        }
         if(modelo.getRowCount()>0)
            tabla.setRowSelectionInterval(0, 0);
	
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
        
       return  listaempleado;
    }
    
}
