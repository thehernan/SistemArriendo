/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Cotizacion;
import Pojos.SingletonEmpresa;
import java.math.BigDecimal;
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
public class DAOCotizacion implements Interface.IntCotizacion{
    SingletonEmpresa empresa= SingletonEmpresa.getinstancia();
    @Override
    public long insert(Cotizacion cotizacion) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertcotizacion(?,?,?,?)");
         ps.setString(1, cotizacion.getCondicionpago());
          ps.setString(2, cotizacion.getEmitidapor());
           ps.setLong(3,empresa.getId());
        ps.setLong(4,cotizacion.getIdcliente());
       
       
    
        
        rs=ps.executeQuery();
      
        while (rs.next()){
           id= rs.getLong("vid");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCotizacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }
    
    
    
}
