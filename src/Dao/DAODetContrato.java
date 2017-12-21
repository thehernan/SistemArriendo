/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.DetalleContrato;
import Pojos.Maquinaria;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
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
public class DAODetContrato implements Interface.IntDetContrato{

    @Override
    public void insert(List<Maquinaria> listdet, long idcontr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        
        for (Maquinaria maq : listdet){
            ps = c.prepareStatement("SELECT * from sp_insertdetcontrato(?,?,?,?)");
            ps.setBigDecimal(1,new BigDecimal(maq.getPreciodiario()));
            ps.setLong(2, maq.getId());
            ps.setLong(3, idcontr);
            ps.setInt(4, maq.getDias());
            rs=ps.executeQuery();
        
        }    
//        while (rs.next()){
//           id= rs.getLong("vid");
//        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
//        return id;
 
    }

    @Override
    public List<DetalleContrato> search(JTable tabla,long idcontr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<DetalleContrato> listdetc= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_buscardetcontrato(?)");
        ps.setLong(1, idcontr);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(
                new String[]{"Maquinaria","Fecha Prestamo","Atraso","Total","Devolver"}, 0) {
 
            Class[] types = new Class[]{
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
              
            };
 
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
             public boolean isCellEditable(int row, int column) {
              if (column == 4) return true;
            else
            return false;
            }
            };
        tabla.setModel(modelo);
        Object datosR[] = new Object[5];
       NumberFormat nf = NumberFormat.getInstance();
             
        
        while (rs.next()){
            DetalleContrato detcont = new DetalleContrato();
            detcont.setId(rs.getLong("viddet"));
            detcont.setIdmaq(rs.getLong("vidmaq"));
            detcont.setIdcontr(rs.getLong("vidcont"));
            detcont.setFechaent(rs.getString("vfecha"));
            detcont.setEntregado(rs.getBoolean("ventregado"));
            detcont.setImporte(rs.getDouble("vimportdetcont"));
            datosR[0]=rs.getObject("vmaquina");
            datosR[1]=detcont.getFechaent();
            datosR[2]=rs.getObject("vatraso");
            datosR[3]=nf.format(rs.getObject("total"));
            
            datosR[4]=detcont.isEntregado();
            modelo.addRow(datosR);
            listdetc.add(detcont);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listdetc;
    }

    @Override
    public void update(List<DetalleContrato> listdet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<DetalleContrato> searchedit(JTable tabla, long idcontr) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Connection c =null;
//        PreparedStatement ps= null;
//        ResultSet rs= null;
//        
//        List<DetalleContrato> listdetc= new ArrayList<>();
//        try{
//	c = Conexion.Connect();
//        ps = c.prepareStatement("SELECT * from sp_buscardetcontrato(?)");
//        ps.setLong(1, idcontr);
//        rs=ps.executeQuery();
//        
//         DefaultTableModel modelo= new DefaultTableModel(
//                new String[]{"Maquinaria","Fecha Prestamo","Atraso","Total"}, 0) {
// 
//            Class[] types = new Class[]{
//                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
//              
//            };
// 
//            public Class getColumnClass(int columnIndex) {
//                return types[columnIndex];
//            }
//             public boolean isCellEditable(int row, int column) {
////              if (column == 4) return true;
////            else
//            return false;
//            }
//            };
//        tabla.setModel(modelo);
//        Object datosR[] = new Object[4];
//       NumberFormat nf = NumberFormat.getInstance();
//             
//        
//        while (rs.next()){
//            DetalleContrato detcont = new DetalleContrato();
//            detcont.setId(rs.getLong("viddet"));
//            detcont.setIdmaq(rs.getLong("vidmaq"));
//            detcont.setIdcontr(rs.getLong("vidcont"));
//            detcont.setFechaent(rs.getString("vfecha"));
//            detcont.setEntregado(rs.getBoolean("ventregado"));
//            detcont.setImporte(rs.getDouble("vimportdetcont"));
//            datosR[0]=rs.getObject("vmaquina");
//            datosR[1]=detcont.getFechaent();
//            datosR[2]=rs.getObject("vatraso");
//            datosR[3]=nf.format(rs.getObject("total"));
//            
////            datosR[4]=detcont.isEntregado();
//            modelo.addRow(datosR);
//            listdetc.add(detcont);
//		
//        }
//	
//        } catch(Exception e)
//            {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//            }finally{
//               if (c != null){
//                   try {
//                       c.close();
//                   } catch (SQLException ex) {
//                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
//                   }
//               }
//               if(ps!= null){
//                   try {
//                       ps.close();
//                   } catch (SQLException ex) {
//                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
//                   }
//               }
//               if(rs != null){
//                   try {
//                       rs.close();
//                   } catch (SQLException ex) {
//                       Logger.getLogger(DAODetContrato.class.getName()).log(Level.SEVERE, null, ex);
//                   }
//               }
//            }  
//        
//       return  listdetc;
//    }
//    
    
   
}
