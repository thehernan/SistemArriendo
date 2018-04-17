/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author info2017
 */
public class Conexion {
//    private DataSource ds=null;
//
//    public Conexion() throws NamingException {
//        ds= InitialContext.doLookup("jdbc/Arriedo");
//    }
//    
//    public Connection getConexion(){
//    Connection cn= null;
//        try {
//            cn=ds.getConnection();
//        } catch (Exception e) {
//           JOptionPane.showMessageDialog(null, e, "error con la conexion "+e.getMessage(),JOptionPane.ERROR , null);
//        }
//    return cn;
//    
//    }
    
    
    public  static Connection Connect() {
        Connection conexion = null;
        try {
            //Driver JDBC
            Class.forName("org.postgresql.Driver");
            //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MySQL
            //panamahitek_text es el nombre que le dimos a la base de datos
            String servidor = "jdbc:postgresql://localhost:5432/BDArriendoMaquinaria";
            //El root es el nombre de usuario por default. No hay contraseña
            String usuario = "postgres";
            String pass = "hernan$123";
            //Se inicia la conexión
            conexion = DriverManager.getConnection(servidor, usuario, pass);
 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            return conexion;
        }
    }
    
    
    
}
