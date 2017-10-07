/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import Dao.Conexion;
import java.sql.Connection;
import java.util.Date;
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
public class FechaHora {
 
    
public Date extraer(){ 
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        Date fecha = null;
     try{

      c = Conexion.Connect();
      String sql=("SELECT * from sp_fechasistema()"); 
       ps=c.prepareStatement(sql);
      rs = ps.executeQuery();
   
        if (rs.next()){
                 fecha = rs.getDate("fecha");
        }
//	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(FechaHora.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(FechaHora.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(FechaHora.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
     
     
return fecha;
}    

     
    
    
}
