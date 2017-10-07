/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Categoria;
import Pojos.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public class DAOEmpresa implements Interface.IntEmpresa{

    @Override
    public List<Empresa> view(JTable tabla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Empresa emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Empresa emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean duplicate(long id, String cadena, String op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empresa> jcombobox(JComboBox combo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Empresa> listempresa= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarempresas()");
        rs=ps.executeQuery();
        
        DefaultComboBoxModel modelo= new DefaultComboBoxModel();
        combo.setModel(modelo);
   
        while (rs.next()){
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("vid"));
            empresa.setRazonS(rs.getString("vrazons"));
            empresa.setRut(rs.getString("vrut"));
            empresa.setDomicilio(rs.getString("vdomicilio"));
            empresa.setRepresentalegal(rs.getString("vrepresentate"));
            empresa.setTelefono(rs.getString("vtelefono"));
            empresa.setRutrepresentante(rs.getString("vrutrepre"));
            empresa.setDomiciliorepre(rs.getString("vdomiciliorepre"));
            empresa.setTelefono(rs.getString("vtelefonorepre"));
            empresa.setCelular(rs.getString("vcelular"));
           
           
        
            modelo.addElement(empresa.getRazonS()+" -  "+empresa.getRut()+" - "+empresa.getDomicilio());
            listempresa.add(empresa);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCategoria.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCategoria.class.getName()).log(Level.SEVERE, null, ex);
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
        
       return  listempresa;
    }
    
    
}
