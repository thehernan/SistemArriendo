/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Cliente;
import Pojos.Contrato;
import Pojos.Guia;
import Pojos.SingletonEmpresa;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author info2017
 */
public class DAOGuia implements Interface.IntGuia{
    SingletonEmpresa empresa = SingletonEmpresa.getinstancia();
    @Override
    public long insert(Contrato contrato,String tipoop) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertguia(?,?,?,?,?,?,?)");
        ps.setLong(1, contrato.getId());
        ps.setLong(2, contrato.getIdempresa());
        ps.setLong(3, contrato.getIdcliente());
       
////        ps.setBigDecimal(3,new BigDecimal(contrato.getFlete()));
//        ps.setBigDecimal(4,new BigDecimal(contrato.getTotal()));
        ps.setString(4, tipoop);
         ps.setBigDecimal(5,new BigDecimal(contrato.getFlete()));
        ps.setBigDecimal(6,new BigDecimal(contrato.getDescuento()));
        ps.setString(7, contrato.getFecha());
        
        
        rs=ps.executeQuery();
      
        while (rs.next()){
           id= rs.getLong("vid");
        }
	
        } catch(SQLException e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOGuia.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOGuia.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOGuia.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }

    @Override
    public void print(long id,String doc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/guia.jasper";
            if(doc.equals("DEVOLUCION"))
             rutaInforme  = "src/Reportes/guiadevolucion.jasper";   
            
            Map parametros = new HashMap();
            parametros.put("idguia",  id);                 
            JasperPrint informe=null;
            informe = JasperFillManager.fillReport(rutaInforme, parametros,Conexion.Connect());
            
           // JasperPrintManager.printReport(informe, true);
            
            JasperViewer jv = new JasperViewer(informe,false);  
        
             jv.setVisible(true);
             jv.setTitle(rutaInforme);
            
          
        }catch (HeadlessException | JRException ex) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL REPORTE", "ERROR",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    @Override
    public List<Guia> view(JTable tabla) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Guia> listguia= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarguias(?)");
        ps.setLong(1,empresa.getId() );
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"N° Guia","N° Contrato","Cliente","Tipo OP","R.U.T"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[5];
       
             
        
        while (rs.next()){
            Guia guia = new Guia();
            guia.setId(rs.getLong("vidguia"));
            guia.setTipoop(rs.getString("vtipoop"));
            datosR[0]=rs.getString("vcodguia");
            datosR[1]=rs.getString("vcodcontrato");
            datosR[2]=rs.getString("vcliente");
            datosR[3]=guia.getTipoop();
            datosR[4]=rs.getString("vfecha");
            modelo.addRow(datosR);
           listguia.add(guia);
		
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listguia;
    }

    @Override
    public List<Guia> searchsensitive(JTable tabla, String cadena) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Guia> listguia= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_busquedasensitivaguias(?,?)");
       
        ps.setString(1, cadena);
         ps.setLong(2,empresa.getId() );
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"N° Guia","N° Contrato","Cliente","Tipo OP","R.U.T"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[5];
       
             
        
        while (rs.next()){
            Guia guia = new Guia();
            guia.setId(rs.getLong("vidguia"));
            datosR[0]=rs.getString("vcodguia");
            datosR[1]=rs.getString("vcodcontrato");
            datosR[2]=rs.getString("vcliente");
            datosR[3]=rs.getString("vtipoop");
            datosR[4]=rs.getString("vfecha");
            modelo.addRow(datosR);
           listguia.add(guia);
		
        }
        if(modelo.getRowCount()>0){
        tabla.setRowSelectionInterval(0, 0);
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }  
        
       return  listguia;
    }
    
    
}
