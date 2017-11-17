/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojos.Contrato;
import Pojos.DetalleContrato;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
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
public class DAOContrato implements  Interface.IntContrato{

    @Override
    public long insert(Contrato contrato) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_insertcontrato(?,?,?,?,?,?,?)");
        ps.setLong(1, contrato.getIdempresa());
        ps.setLong(2, contrato.getIdcliente());
        ps.setBigDecimal(3,new BigDecimal(contrato.getFlete()));
        ps.setBigDecimal(4,new BigDecimal(contrato.getTotal()));
        ps.setString(5, contrato.getTipodoc());
        ps.setString(6, contrato.getFecha());
        ps.setBigDecimal(7,new BigDecimal(contrato.getDescuento()));
        
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
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return id;
    }

    @Override
    public void print(long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try{
            Conexion conexion = new Conexion();
            Connection  cn = null;           
            String  rutaInforme  = "src/Reportes/Contrato.jasper";
            
            Map parametros = new HashMap();
            parametros.put("idcontrato",  id);                 
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
    public List<Contrato> view(JTable tabla, long idempre,boolean activo,String doc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Contrato> listcontrato= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_mostrarcontratos(?,?,?)");
        ps.setLong(1, idempre);
        ps.setBoolean(2, activo);
        ps.setString(3, doc);
        rs=ps.executeQuery();
        
    
        
        
        
         DefaultTableModel modelo= new DefaultTableModel(
                new String[]{"Codigo","Cliente","R.U.T","Fecha","Dias Prestamo","Tipo Contrato","Vigente"}, 0) {
 
            Class[] types = new Class[]{
                 java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
                    , java.lang.Object.class, java.lang.Object.class,java.lang.Boolean.class
              
            };
 
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
             public boolean isCellEditable(int row, int column) {
//              if (column == 4) return true;
//            else
            return false;
            }
            };
        
        
        
        tabla.setModel(modelo);
        
        Object datosR[] = new Object[7];
       
             
        
        while (rs.next()){
            Contrato contrato = new Contrato();
            contrato.setId(rs.getLong("vidcontrato"));
            contrato.setIdempresa(rs.getLong("vidempresa"));
            contrato.setIdcliente(rs.getLong("vidcliente"));
            contrato.setFecha(rs.getString("vfechatimes"));
            datosR[0]=rs.getObject("vcodigo");
            datosR[1]=rs.getObject("vcliente");
            datosR[2]=rs.getObject("vrut");
            datosR[3]=rs.getObject("vfechatext");
            datosR[4]=rs.getObject("vdiasprestamo");
            datosR[5]=rs.getObject("btipodoc");
            datosR[6]=rs.getObject("bactivo");
            modelo.addRow(datosR);
            listcontrato.add(contrato);
		
        }
	
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
        
       return  listcontrato;
    }

    @Override
    public List<DetalleContrato> viewpay(List<DetalleContrato> listdetc, JTable tabla,JFormattedTextField jtotal) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        long id= 0;
        DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Maquinaria","Atraso","Total"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[3];
        Double total=0.0;
        Double pago;
        NumberFormat nf = NumberFormat.getInstance();
        List<DetalleContrato> listdet= new ArrayList<>();
    
        try{
	c = Conexion.Connect();
        
        for (DetalleContrato detc : listdetc){
            
            if (detc.isEntregado()==true){
                ps = c.prepareStatement("SELECT * from sp_vistadepago(?)");
                ps.setLong(1, detc.getId());
                rs=ps.executeQuery();
                if(rs.next()){
                 datosR[0] = rs.getObject("vmaquina");
                 datosR[1] = rs.getObject("vatraso");
                 pago=rs.getDouble("ventregado");
                 detc.setImporte(pago);
                
                 total = total + pago;
                 datosR[2] = nf.format(pago);
                 modelo.addRow(datosR);
                 listdet.add(detc);
                }
            
            }      
        }    
        jtotal.setValue(total);
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
        return listdet;
    }

    @Override
    public void debtor(long idcont,JFormattedTextField total, JFormattedTextField abono, JFormattedTextField deuda,
    JFormattedTextField descuento) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_buscardeudacontrato(?)");
        ps.setLong(1, idcont);
       
    
        
        rs=ps.executeQuery();
      
        if (rs.next()){
           total.setValue(rs.getLong("vtotal"));
           abono.setValue(rs.getLong("vabonos"));
           deuda.setValue(rs.getLong("vdeuda"));
           descuento.setValue(rs.getLong("vdesc"));
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
    }
     @Override
     public List<Contrato> searchsensitive(JTable tabla, long idempre,String tipob,String cod,String cli,boolean activo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Contrato> listcontrato= new ArrayList<>();
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_busquedasensitivacontrato(?,?,?,?,?)");
        ps.setLong(1, idempre);
        ps.setString(2, tipob);
        ps.setString(3, cod);
        ps.setString(4, cli);
        ps.setBoolean(5, activo);
        rs=ps.executeQuery();
        
         DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
        //      if (column == 5) return true;
        //else
         return false;
        }
        };
        String titulos[]={"Codigo","Cliente","R.U.T","Fecha"};
        modelo.setColumnIdentifiers(titulos);
        tabla.setModel(modelo);
        Object datosR[] = new Object[4];
       
             
        
        while (rs.next()){
            Contrato contrato = new Contrato();
            contrato.setId(rs.getLong("vidcontrato"));
            contrato.setIdempresa(rs.getLong("vidempresa"));
            contrato.setIdcliente(rs.getLong("vidcliente"));
            datosR[0]=rs.getObject("vcodigo");
            datosR[1]=rs.getObject("vcliente");
            datosR[2]=rs.getObject("vrut");
            datosR[3]=rs.getObject("vfecha");
            modelo.addRow(datosR);
            listcontrato.add(contrato);
		
        }
        if(modelo.getRowCount()>0)
            tabla.setRowSelectionInterval(0, 0);
	
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
        
       return  listcontrato;
    }

    @Override
    public boolean validateedit(long idcontr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c =null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        boolean valida=false;
        try{
	c = Conexion.Connect();
        ps = c.prepareStatement("SELECT * from sp_validaeditarcontrato(?)");
        ps.setLong(1, idcontr);    
        rs=ps.executeQuery();
      
        if (rs.next()){
           valida=rs.getBoolean("valida");
        }
	
        } catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
               if (c != null){
                   try {
                       c.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(ps!= null){
                   try {
                       ps.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               if(rs != null){
                   try {
                       rs.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DAOContrato.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } 
        return valida;
    }
    
    
}
