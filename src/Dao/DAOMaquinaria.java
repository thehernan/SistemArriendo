/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
public class DAOMaquinaria implements Interface.IntMaquinaria{
    SingletonEmpresa singletonempresa= SingletonEmpresa.getinstancia();
    @Override
    public List<Maquinaria> view(JTable tabla,String estado,String propiedad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Maquinaria> listmaquinaria= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarmaquinaria(?,?,?)");
        ps.setString(1, estado);
        ps.setLong(2,singletonempresa.getId());
        ps.setString(3, propiedad);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Maquina","Serie","Estado","Categoria"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[4];
       
             
        
        while (rs.next()){
            Maquinaria maquina = new Maquinaria();
            maquina.setId(rs.getLong("id"));
            maquina.setMaquina(rs.getString("vmaquina"));
            maquina.setMarca(rs.getString("vmarca"));
            maquina.setSerie(rs.getString("vserie"));
            maquina.setModelo(rs.getString("vmodelo"));
            maquina.setIdcategoria(rs.getLong("vidcat"));
            maquina.setEstado(rs.getString("vestado"));
            maquina.setPreciodiario(rs.getDouble("vprecio"));
            maquina.setCategoria(rs.getString("vcategoria"));
        
            datosR[0]=maquina.getMaquina();
            datosR[1]=maquina.getSerie();
            datosR[2]=maquina.getEstado();
            datosR[3]=maquina.getCategoria();
            modelo.addRow(datosR);
            listmaquinaria.add(maquina);
		
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
        
       return  listmaquinaria;
    }

    @Override
    public long insert(Maquinaria maq) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id=0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertmaquinaria(?,?,?,?,?,?,?,?)");
        ps.setString(1, maq.getMaquina());
        ps.setString(2,maq.getMarca());
        ps.setString(3, maq.getSerie());
        ps.setString(4, maq.getModelo());
        ps.setLong(5, maq.getIdcategoria());
        ps.setLong(6, maq.getIdempresa());
       
        ps.setBigDecimal(7,new  BigDecimal(maq.getPreciodiario()));
         ps.setString(8, maq.getPropietario());
        
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            id=rs.getLong("id");
            JOptionPane.showMessageDialog(null,"Maquina guardada con exito");	
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
        return id;
    }

    @Override
    public void update(Maquinaria maq) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_updatemaquinaria(?,?,?,?,?,?,?)");
        ps.setLong(1, maq.getId());
        ps.setString(2, maq.getMaquina());
        ps.setString(3,maq.getMarca());
        ps.setString(4, maq.getSerie());
        ps.setString(5, maq.getModelo());
        ps.setLong(6, maq.getIdcategoria());
//        ps.setLong(6, maq.getIdempresa());
        ps.setBigDecimal(7,new  BigDecimal(maq.getPreciodiario()));
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Maquina editada con exito");	
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_deletemaquinaria(?)");
        ps.setLong(1, id);
      
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"Maquina eliminada con exito");	
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
    public void print(Long id) {
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
        ps = c.prepareStatement("SELECT * from sp_duplicatemaquina(?,?,?)");
        ps.setLong(1, id);
        ps.setString(2, cadena);
        ps.setString(3,op);
    
        
        rs=ps.executeQuery();
     
        while (rs.next()){
//            JOptionPane.showMessageDialog(null,"Arido ya se encuentra registrado");
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
    public void movement(JTable tabla, long idmaq) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Maquinaria> listmaquinaria= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_movimientomaquinaria(?)");
        ps.setLong(1, idmaq);
        rs=ps.executeQuery();
        
        DefaultTableModel modelo= new DefaultTableModel(
                new String[]{"Contrato","Guia","Cliente","RUT","Telefono","Tiempo Prestamo","Fecha prest.","Fecha entr.","Tipo op.","Cambio"}, 0) {
 
            Class[] types = new Class[]{
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Boolean.class
            };
 
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
             public boolean isCellEditable(int row, int column) {
//        //      if (column == 5) return true;
//        //else
            return false;
            }
            };
        tabla.setModel(modelo);
        Object datosR[] = new Object[10];
       
             
        
        while (rs.next()){
          
            datosR[0]=rs.getObject("vcontrato");
            datosR[1]=rs.getObject("vguia");
            datosR[2]=rs.getObject("vcliente");
            datosR[3]=rs.getObject("vrut");
            datosR[4]=rs.getObject("vtelefono");
            datosR[5]=rs.getObject("vtiempo");
            datosR[6]=rs.getObject("vfechaprestamo");
            datosR[7]=rs.getObject("vfechaentrega");
            datosR[8]=rs.getObject("vtipoop");
            datosR[9]=rs.getBoolean("vdevuelto");
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
    public long insertmaqrepairclient(Maquinaria maq) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id=0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertmaquinariarepararclient(?,?,?,?,?,?)");
        ps.setString(1, maq.getMaquina());
        ps.setString(2,maq.getMarca());
        ps.setString(3, maq.getSerie());
        ps.setString(4, maq.getModelo());
       
        ps.setLong(5, maq.getIdempresa());
        ps.setLong(6, maq.getIdcliente());
              
        
        rs=ps.executeQuery();
      
        while (rs.next()){
            id=rs.getLong("id");
            JOptionPane.showMessageDialog(null,"Maquina guardada con exito");	
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
        return id;
    }

    @Override
    public List<Reparacion> viewrepair(JTable tabla, long idmaq) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Reparacion> listrepa= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarreparacionmaq(?)");
        ps.setLong(1, idmaq);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Descripcion","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[2];
       
             
        
        while (rs.next()){
            Reparacion repa = new Reparacion();
            repa.setDescripci(rs.getString("vdescripcion"));
            repa.setFecha(rs.getString("vfecha"));
            datosR[0]=repa.getDescripci();
            datosR[1]=repa.getFecha();
          
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
    public List<Maquinaria> searchsentitive(JTable tabla,String estado,String propiedad ,long idcategoria,String cadena) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Maquinaria> listmaquinaria= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_busquedasensitivamaquinaria(?,?,?,?,?)");
        ps.setString(1, estado);
        ps.setLong(2,singletonempresa.getId());
        ps.setString(3, propiedad);
        ps.setString(4, cadena);
        ps.setLong(5, idcategoria);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Maquina","Serie","Estado","Categoria"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[4];
       
             
        
        while (rs.next()){
            Maquinaria maquina = new Maquinaria();
            maquina.setId(rs.getLong("id"));
            maquina.setMaquina(rs.getString("vmaquina"));
            maquina.setMarca(rs.getString("vmarca"));
            maquina.setSerie(rs.getString("vserie"));
            maquina.setModelo(rs.getString("vmodelo"));
            maquina.setIdcategoria(rs.getLong("vidcat"));
            maquina.setEstado(rs.getString("vestado"));
            maquina.setPreciodiario(rs.getDouble("vprecio"));
            maquina.setCategoria(rs.getString("vcategoria"));
        
            datosR[0]=maquina.getMaquina();
            datosR[1]=maquina.getSerie();
            datosR[2]=maquina.getEstado();
            datosR[3]=maquina.getCategoria();
            modelo.addRow(datosR);
            listmaquinaria.add(maquina);
		
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
        
       return  listmaquinaria;
    }

   
    
}
