/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.DetalleCotizacion;
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
public class DAODetalleCotizacion implements Interface.IntDetalleCotizacion{

    @Override
    public void insert(List<DetalleCotizacion> listdetc, long idco) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
       
        try{
	c = Conexion.Connect();
        
        for (DetalleCotizacion detc : listdetc){
            ps = c.prepareStatement("SELECT * from sp_insertdetallecotizacion(?,?,?,?,?)");
             ps.setLong(1,idco);
            ps.setLong(2, detc.getIdmaq());
            ps.setInt(3, detc.getCantidad());
            ps.setInt(4,detc.getDias());
            ps.setBigDecimal(5, new BigDecimal(detc.getValordia()));
            rs=ps.executeQuery();
        
        }
       
        
     
//      
//        while (rs.next()){
//           id= rs.getLong("vid");
//        }
//	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetalleCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetalleCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetalleCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
    }
    
}
