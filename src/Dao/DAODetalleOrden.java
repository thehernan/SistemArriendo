/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.DetalleOrdenCompra;
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
public class DAODetalleOrden implements Interface.IntDetalleOrdenCompra{

    @Override
    public void insert(List<DetalleOrdenCompra> detc, long idorden) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
       
        try{
	c = Conexion.Connect();
        
        for (DetalleOrdenCompra deto : detc){
            ps = c.prepareStatement("SELECT * from sp_insertdetalleorden(?,?,?,?,?,?,?,?)");
            ps.setLong(1, idorden);
            ps.setString(2, deto.getCodigo());
            ps.setBigDecimal(3,new BigDecimal(deto.getCantidad()));
            ps.setString(4, deto.getUnidad());
            ps.setString(5, deto.getDescripcion());
            ps.setBigDecimal(6,new BigDecimal(deto.getPreciounid()));
            ps.setBigDecimal(7,new BigDecimal(deto.getDesc()));
            ps.setBigDecimal(8,new BigDecimal(deto.getValortotal()));
            rs=ps.executeQuery();
        
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetalleOrden.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetalleOrden.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAODetalleOrden.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
    }
    
}
