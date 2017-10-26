/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Usuario;
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
public class DAOUsuario implements Interface.IntUsuario{

    @Override
    public void insert(Usuario user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertusuarios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
  
        ps.setString(1,user.getUsuario());
        ps.setString(2,user.getClave());
        ps.setBoolean(3,user.isNuevocontrato());
        ps.setBoolean(4,user.isContratosvig());
        ps.setBoolean(5,user.isAbonos());
        ps.setBoolean(6,user.isDevoluciones());
        ps.setBoolean(7,user.isNuevaventa());
        ps.setBoolean(8,user.isInvarriendo());
        ps.setBoolean(9,user.isInvventa());
        ps.setBoolean(10,user.isIngreso());
        ps.setBoolean(11,user.isEgreso());
        ps.setBoolean(12,user.isNuevoegreso());
        ps.setBoolean(13,user.isMovimientos());
        ps.setBoolean(14,user.isNuevarepcliente());
        ps.setBoolean(15,user.isReparacionpropia());
        
        ps.setBoolean(16,user.isReparacioncliente());
        ps.setBoolean(17,user.isEmpresas());
        ps.setBoolean(18,user.isEmpleados());
        ps.setBoolean(19,user.isCliente());
        ps.setBoolean(20,user.isProveedores());
        ps.setBoolean(21,user.isCategorias());
        ps.setBoolean(22,user.isNuevacotizacion());
        ps.setBoolean(23,user.isNuevaordencompra());
        ps.setBoolean(24,user.isCotizaciones());
        ps.setBoolean(25,user.isOrdencompra());
        ps.setBoolean(26,user.isUsuariobo());
        ps.setBoolean(27,user.isMiempresa());


       
//        ps.setLong(5, arido.getIdempresa());
        
        rs=ps.executeQuery();
      
        if (rs.next()){
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
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public void delete(long id) {
        //row new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Usuario> listuser= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_deleteusuario(?)");
        ps.setLong(1, id);
        rs=ps.executeQuery();
                
        
        if (rs.next()){
           JOptionPane.showMessageDialog(null ,"Eliminado con exito");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
    }

    @Override
    public List<Usuario> view(JTable tabla) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Usuario> listuser= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrausuarios()");
 
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Usuario","Clave"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[2];
       
             
        
        while (rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setUsuario(rs.getString("vusuario"));
            usuario.setClave(rs.getString("vclave"));
            usuario.setNuevocontrato(rs.getBoolean("vnuevocontrato"));
            usuario.setContratosvig(rs.getBoolean("vcontratosvigentes"));
            usuario.setAbonos(rs.getBoolean("vabonos"));
            usuario.setDevoluciones(rs.getBoolean("vdevoluciones"));
            usuario.setNuevaventa(rs.getBoolean("vnuevaventa"));
            usuario.setInvarriendo(rs.getBoolean("vinvarriendo"));
            usuario.setInvventa(rs.getBoolean("vinvventa"));
            usuario.setIngreso(rs.getBoolean("vingreso"));
            usuario.setEgreso(rs.getBoolean("vegreso"));
            usuario.setNuevoegreso(rs.getBoolean("vnuevoeegreso"));
            usuario.setMovimientos(rs.getBoolean("vmovimientos"));
            usuario.setNuevarepcliente(rs.getBoolean("vnuevarepcliente"));
            usuario.setReparacionpropia(rs.getBoolean("vreparacionpropia"));
            usuario.setReparacioncliente(rs.getBoolean("vreparacioncliente"));
            usuario.setEmpresas(rs.getBoolean("vempresas"));
            usuario.setEmpleados(rs.getBoolean("vempleados"));
            usuario.setCliente(rs.getBoolean("vclientes"));
            usuario.setProveedores(rs.getBoolean("vproveedores"));
            usuario.setCategorias(rs.getBoolean("vcategorias"));
            usuario.setNuevacotizacion(rs.getBoolean("vnuevacotizacion"));
            usuario.setNuevaordencompra(rs.getBoolean("vnuevaordencompra"));
            usuario.setCotizaciones(rs.getBoolean("vcotizaciones"));
            usuario.setOrdencompra(rs.getBoolean("vordenescompra"));
            usuario.setUsuariobo(rs.getBoolean("vusuariobo"));
            usuario.setMiempresa(rs.getBoolean("vmiempresa"));
                    
            
            
            
            datosR[0]=usuario.getUsuario();
            datosR[1]="*******************";
          
            modelo.addRow(datosR);
            listuser.add(usuario);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listuser;
    }

    @Override
    public void update(Usuario user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updateusuarios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setLong(1, user.getId());
        ps.setString(2,user.getUsuario());
        ps.setString(3,user.getClave());
        ps.setBoolean(4,user.isNuevocontrato());
        ps.setBoolean(5,user.isContratosvig());
        ps.setBoolean(6,user.isAbonos());
        ps.setBoolean(7,user.isDevoluciones());
        ps.setBoolean(8,user.isNuevaventa());
        ps.setBoolean(9,user.isInvarriendo());
        ps.setBoolean(10,user.isInvventa());
        ps.setBoolean(11,user.isIngreso());
        ps.setBoolean(12,user.isEgreso());
        ps.setBoolean(13,user.isNuevoegreso());
        ps.setBoolean(14,user.isMovimientos());
        ps.setBoolean(15,user.isNuevarepcliente());
        ps.setBoolean(16,user.isReparacionpropia());
        
        ps.setBoolean(17,user.isReparacioncliente());
        ps.setBoolean(18,user.isEmpresas());
        ps.setBoolean(19,user.isEmpleados());
        ps.setBoolean(20,user.isCliente());
        ps.setBoolean(21,user.isProveedores());
        ps.setBoolean(22,user.isCategorias());
        ps.setBoolean(23,user.isNuevacotizacion());
        ps.setBoolean(24,user.isNuevaordencompra());
        ps.setBoolean(25,user.isCotizaciones());
        ps.setBoolean(26,user.isOrdencompra());
        ps.setBoolean(27,user.isUsuariobo());
        ps.setBoolean(28,user.isMiempresa());


       
//        ps.setLong(5, arido.getIdempresa());
        
        rs=ps.executeQuery();
      
        if (rs.next()){
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
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
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
        ps = c.prepareStatement("SELECT * from sp_duplicateusuario(?,?,?)");
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
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return duplicado;
    }

    @Override
    public Usuario valida(String usu, String clave) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
         Usuario usuario=null;
      
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_validausuario(?,?)");
        ps.setString(1, usu);
        ps.setString(2,clave);
        rs=ps.executeQuery();
    
        while (rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setUsuario(rs.getString("vusuario"));
            usuario.setClave(rs.getString("vclave"));
            usuario.setNuevocontrato(rs.getBoolean("vnuevocontrato"));
            usuario.setContratosvig(rs.getBoolean("vcontratosvigentes"));
            usuario.setAbonos(rs.getBoolean("vabonos"));
            usuario.setDevoluciones(rs.getBoolean("vdevoluciones"));
            usuario.setNuevaventa(rs.getBoolean("vnuevaventa"));
            usuario.setInvarriendo(rs.getBoolean("vinvarriendo"));
            usuario.setInvventa(rs.getBoolean("vinvventa"));
            usuario.setIngreso(rs.getBoolean("vingreso"));
            usuario.setEgreso(rs.getBoolean("vegreso"));
            usuario.setNuevoegreso(rs.getBoolean("vnuevoeegreso"));
            usuario.setMovimientos(rs.getBoolean("vmovimientos"));
            usuario.setNuevarepcliente(rs.getBoolean("vnuevarepcliente"));
            usuario.setReparacionpropia(rs.getBoolean("vreparacionpropia"));
            usuario.setReparacioncliente(rs.getBoolean("vreparacioncliente"));
            usuario.setEmpresas(rs.getBoolean("vempresas"));
            usuario.setEmpleados(rs.getBoolean("vempleados"));
            usuario.setCliente(rs.getBoolean("vclientes"));
            usuario.setProveedores(rs.getBoolean("vproveedores"));
            usuario.setCategorias(rs.getBoolean("vcategorias"));
            usuario.setNuevacotizacion(rs.getBoolean("vnuevacotizacion"));
            usuario.setNuevaordencompra(rs.getBoolean("vnuevaordencompra"));
            usuario.setCotizaciones(rs.getBoolean("vcotizaciones"));
            usuario.setOrdencompra(rs.getBoolean("vordenescompra"));
            usuario.setUsuariobo(rs.getBoolean("vusuariobo"));
            usuario.setMiempresa(rs.getBoolean("vmiempresa"));  
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  usuario;
    }
    
    
}
