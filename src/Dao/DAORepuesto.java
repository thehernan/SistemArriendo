/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Repuesto;
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
public class DAORepuesto implements Interface.IntRepuesto{

    @Override
    public void insert(List<Repuesto> listrepuesto, long idrepara) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        
        for (Repuesto rep : listrepuesto){
            if(rep.getId()==0){
             ps = c.prepareStatement("SELECT * from sp_insertrepuesto(?,?,?,?)");
            ps.setBigDecimal(1,new BigDecimal(rep.getCantidad()));
            ps.setString(2, rep.getDescripcion());
            ps.setBigDecimal(3,new BigDecimal(rep.getValor()));
            ps.setLong(4, idrepara);
            
            rs=ps.executeQuery();
            
            
            }
           
        
        }    
//        while (rs.next()){
//           id= rs.getLong("vid");
//        }
	
        } catch(SQLException e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
    }

    @Override
    public List<Repuesto> view(JTable tabla,long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Repuesto> listrepuesto= new ArrayList<>();
        NumberFormat nf= NumberFormat.getInstance();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarrepuestos(?)");
        ps.setLong(1,id);
        
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Cantidad","Descripcion","Valor"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
       
             
        
        while (rs.next()){
            Repuesto repuesto = new Repuesto();
            repuesto.setId(rs.getLong("vidrepuesto"));
            repuesto.setCantidad(rs.getDouble("vcantidad"));
            repuesto.setDescripcion(rs.getString("vdescrip"));
            repuesto.setValor(rs.getDouble("vvalor"));
            
            datosR[0]=nf.format(repuesto.getCantidad());
            datosR[1]=repuesto.getDescripcion();
            datosR[2]=nf.format(repuesto.getValor());
            modelo.addRow(datosR);
            listrepuesto.add(repuesto);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listrepuesto;
    }

    @Override
    public void delete(List<Repuesto> listrep) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        
        for(Repuesto rep: listrep){
            if(rep.getId()!=0){
                  ps = c.prepareStatement("SELECT * from sp_deleterepuesto(?)");
        
                    ps.setLong(1, rep.getId());

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
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAORepuesto.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
    }
    
}
