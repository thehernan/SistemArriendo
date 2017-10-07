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
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class DAODetGuia implements Interface.IntDetalleGuia{

    @Override
    public void insert(List<Maquinaria> listdet, long idguia,boolean entre) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        
        for (Maquinaria maq : listdet){
            ps = c.prepareStatement("SELECT * from sp_insertdetguia(?,?,?,?)");
            ps.setBigDecimal(1,new BigDecimal(maq.getPreciodiario()));
            ps.setLong(2, idguia);
            ps.setLong(3, maq.getId());
            ps.setBoolean(4, entre);
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
    public void update(List<DetalleContrato> listdetcont,long idguia,boolean porfalla) {  //,Timestamp fecha
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        
        for (DetalleContrato det : listdetcont){
            if(det.isEntregado()==true){
                ps = c.prepareStatement("SELECT * from sp_insertdevolucion(?,?,?,?,?,?)");
                ps.setLong(1,idguia);
                ps.setLong(2, det.getIdmaq());
                ps.setLong(3, det.getId());
                ps.setLong(4, det.getIdcontr());
                ps.setBigDecimal(5, new BigDecimal(det.getImporte()));
                ps.setBoolean(6, porfalla);
    //            ps.setBigDecimal(5, new BigDecimal(pago));
    //            ps.setBigDecimal(6, new BigDecimal(total));
    //            ps.setTimestamp(5, fecha);
                rs=ps.executeQuery();
            
            
            }
            
        
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
                       Logger.getLogger(DAODetGuia.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetGuia.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetGuia.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
    }
    
}
