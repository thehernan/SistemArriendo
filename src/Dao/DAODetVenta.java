/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Arido;
import Pojos.Maquinaria;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class DAODetVenta implements Interface.IntDetVenta{

    @Override
    public void insert(List<Arido> listarido, long idventa) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
       // long id= 0;
        try{
	c = Conexion.Connect();
        
        for (Arido arido : listarido){
            ps = c.prepareStatement("SELECT * from sp_insertdetventa(?,?,?,?)");
            ps.setLong(1, arido.getId());
            ps.setBigDecimal(2,new BigDecimal(arido.getCantidad()));
            ps.setBigDecimal(3,new  BigDecimal(arido.getPrecio()));
            ps.setLong(4, idventa);
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
                       Logger.getLogger(DAODetVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
//        return id;
    }

    @Override
    public void returnstock(long idari, double cant) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
//        boolean valida=false;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_retornarstockventa(?,?)");
        ps.setLong(1, idari);
        ps.setBigDecimal(2, new BigDecimal(cant));       
        rs=ps.executeQuery();
      
//        while (rs.next()){
//           valida= rs.getBoolean("valida");
//        }
	
        } catch(Exception e)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetVenta.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
//        return valida;
    
    }
    
    
    
}
