/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Cliente;
import Pojos.Empleado;
import Pojos.Maquinaria;
import Pojos.Reparacion;
import Pojos.SingletonEmpresa;
import java.math.BigDecimal;
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
public class DAOReparacion implements Interface.IntReparacion{
    SingletonEmpresa singletonempre = SingletonEmpresa.getinstancia();
    @Override
    public List<Reparacion> view(JTable tabla,boolean entregado,String tipoop ) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Reparacion> listrepa= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrareparaciones(?,?,?)");
        ps.setLong(1, singletonempre.getId());
        ps.setBoolean(2, entregado);
        ps.setString(3, tipoop);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Cod.","Cliente / Empresa","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            Reparacion repa = new Reparacion();
            repa.setId(rs.getLong("vid"));
             // repa.setDescripci(rs.getString("vdescripcion"));
            repa.setFecha(rs.getString("vfecha"));
            datosR[0]=rs.getObject("vcod");
            datosR[1]=rs.getObject("vcliente");
            datosR[2]=repa.getFecha();
          
            modelo.addRow(datosR);
            listrepa.add(repa);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listrepa;
    }

    @Override
    public void insert(Reparacion repara,String estado) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertreparacion(?,?,?,?,?)");
        ps.setString(1, repara.getDescripci());    
        ps.setLong(2, repara.getIdmaqui());
        ps.setString(3, estado);
        ps.setLong(4, singletonempre.getId());
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Reparación guardado con exito");	
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
    }

    @Override
    public long insertrepairclientnoemploye(Reparacion repara) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id=0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertreparacionclientesinempleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, repara.getDescripci());    
        ps.setLong(2, repara.getIdmaqui());
        ps.setLong(3, repara.getIdcliente());
        ps.setString(4, repara.getObservacion());
        ps.setBigDecimal(5,new BigDecimal(repara.getManoobra()));
        ps.setBigDecimal(6,new BigDecimal(repara.getSubtotal()));
        ps.setBigDecimal(7,new BigDecimal(repara.getTotal()));
        ps.setBoolean(8,repara.isAcepta());
        ps.setTimestamp(9, repara.getFechaentrega());
        ps.setString(10, repara.getTrabajorealizado());
        ps.setBigDecimal(11,new BigDecimal(repara.getRepuesto()));
        ps.setBigDecimal(12,new  BigDecimal(repara.getIva()));
        ps.setLong(13,singletonempre.getId());
        ps.setBigDecimal(14,new BigDecimal(repara.getRevision()));
        ps.setString(15, repara.getEntregadopor());
        rs=ps.executeQuery();
        
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Reparación guardado con exito");	
            id = rs.getLong("id");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return id;
    }

    @Override
    public long insertrepairclientemploye(Reparacion repara) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id=0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertreparacionclienteempleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, repara.getDescripci());    
        ps.setLong(2, repara.getIdmaqui());
        ps.setLong(3, repara.getIdcliente());
        ps.setString(4, repara.getObservacion());
        ps.setBigDecimal(5,new BigDecimal(repara.getManoobra()));
        ps.setBigDecimal(6,new BigDecimal(repara.getSubtotal()));
        ps.setBigDecimal(7,new BigDecimal(repara.getTotal()));
        ps.setBoolean(8,repara.isAcepta());
        ps.setTimestamp(9, repara.getFechaentrega());
        ps.setString(10, repara.getTrabajorealizado());
        ps.setBigDecimal(11,new BigDecimal(repara.getRepuesto()));
        ps.setBigDecimal(12,new  BigDecimal(repara.getIva()));
        ps.setLong(13, repara.getIdempleado());
        ps.setLong(14, singletonempre.getId());
        ps.setBigDecimal(15,new BigDecimal(repara.getRevision()));
        ps.setString(16,repara.getEntregadopor());
        rs=ps.executeQuery();
        
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Reparación guardado con exito");	
            id = rs.getLong("id");
        }
	
        } catch(SQLException e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return id;
    }

    @Override
    public List<Object> search(long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        Maquinaria maquina= new Maquinaria();
        Empleado empleado = new Empleado();
        Cliente cliente = new Cliente();
        Reparacion repara= new Reparacion();
        List<Object> lisobj= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_buscarreparacion(?)");
        ps.setLong(1, id);    
 
        rs=ps.executeQuery();
      
        if (rs.next()){
//            JOptionPane.showMessageDialog(null,"Reparación guardado con exito");	
            ///// cliente///////////////////
            cliente.setId(rs.getLong("vidcliente"));
            cliente.setRut(rs.getString("vrut"));
            cliente.setNombre(rs.getString("vnombre"));
            cliente.setDomiciliopart(rs.getString("vdomiciliopartcli"));
            cliente.setDomiciliatrab(rs.getString("vdomiciliotrabcli"));
            cliente.setTelefono(rs.getString("vtelefono"));
            
            //////////////////////////////////
            maquina.setId(rs.getLong("vidmaq"));
            maquina.setMaquina(rs.getString("vmaquina"));
            maquina.setMarca(rs.getString("vmarca"));
            maquina.setSerie(rs.getString("vserie"));
            maquina.setModelo(rs.getString("vmodelo"));
            //////////////////////////////
            empleado.setId(rs.getLong("videmple"));
            empleado.setRut(rs.getString("vrutemple"));
            empleado.setNombre(rs.getString("nombreemple"));
            //////////////////////////////////////////////
            repara.setId(rs.getLong("vidrepara"));
            repara.setObservacion(rs.getString("vobservacion"));
            repara.setManoobra(rs.getDouble("vmanoobra"));
            repara.setSubtotal(rs.getDouble("vsubtotal"));
            repara.setTotal(rs.getDouble("vtotal"));
            repara.setAcepta(rs.getBoolean("vacepta"));
            repara.setEntregadopor(rs.getString("ventregadapor"));
            repara.setEntregada(rs.getBoolean("ventregada"));
            repara.setTrabajorealizado(rs.getString("vtrabajoreal"));
            repara.setRepuesto(rs.getDouble("vrepuestos"));
            repara.setIva(rs.getDouble("viva"));
            repara.setRevision(rs.getDouble("vrevision"));
            repara.setFechaentrega(rs.getTimestamp("vfecha"));
            //----------------
            repara.setIdmaqui(maquina.getId());
            repara.setIdcliente(cliente.getId());
            repara.setIdempleado(empleado.getId());
            
            lisobj.add(cliente);
            lisobj.add(maquina);
            lisobj.add(empleado);
            lisobj.add(repara);
            
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        return lisobj;
        
    }

    @Override
    public void update(Reparacion repara) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
       
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updatereparacion(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setLong(1, repara.getId());
        ps.setString(2, repara.getDescripci());    
        ps.setLong(3, repara.getIdmaqui());
        ps.setLong(4, repara.getIdcliente());
        ps.setString(5, repara.getObservacion());
        ps.setBigDecimal(6,new BigDecimal(repara.getManoobra()));
        ps.setBigDecimal(7,new BigDecimal(repara.getSubtotal()));
        ps.setBigDecimal(8,new BigDecimal(repara.getTotal()));
        ps.setBoolean(9,repara.isAcepta());
        ps.setLong(10, repara.getIdempleado());
        ps.setTimestamp(11, repara.getFechaentrega());
        ps.setString(12, repara.getTrabajorealizado());
        ps.setBoolean(13, repara.isEntregada());
        ps.setString(14, repara.getEntregadopor());
        ps.setBigDecimal(15,new BigDecimal(repara.getRepuesto()));
        ps.setBigDecimal(16,new  BigDecimal(repara.getIva()));
        ps.setBigDecimal(17,new BigDecimal(repara.getRevision()));
        rs=ps.executeQuery();
        
        if (rs.next()){
            JOptionPane.showMessageDialog(null,"Reparación actualizado con exito");	
          
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
      
        
    }

    @Override
    public void updatenoempleado(Reparacion repara) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
       
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updatereparacionnoempleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
       ps.setLong(1, repara.getId());
        ps.setString(2, repara.getDescripci());    
        ps.setLong(3, repara.getIdmaqui());
        ps.setLong(4, repara.getIdcliente());
        ps.setString(5, repara.getObservacion());
        ps.setBigDecimal(6,new BigDecimal(repara.getManoobra()));
        ps.setBigDecimal(7,new BigDecimal(repara.getSubtotal()));
        ps.setBigDecimal(8,new BigDecimal(repara.getTotal()));
        ps.setBoolean(9,repara.isAcepta());
  
        ps.setTimestamp(10, repara.getFechaentrega());
        ps.setString(11, repara.getTrabajorealizado());
        ps.setBoolean(12, repara.isEntregada());
        ps.setString(13, repara.getEntregadopor());
        ps.setBigDecimal(14,new BigDecimal(repara.getRepuesto()));
        ps.setBigDecimal(15,new  BigDecimal(repara.getIva()));
        ps.setBigDecimal(16,new BigDecimal(repara.getRevision()));
        rs=ps.executeQuery();
        
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Reparación actualizado con exito");	
        
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOReparacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }   
    }
    
}
