/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.OrdenCompra;
import Pojos.SingletonEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
}
