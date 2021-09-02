package Conexion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class conexion {
 Connection conexion=null;
    public conexion() {
    }
    public static final String URL="jdbc:mysql://204.2.195.213:22084/restaurante?autoReconnet=true&useSSL=false";
    public static final String USUARIO="boom";
        public static final String CONTRASEÑA="carreter1";
   
 
      
    
        
    public Connection getconection()
{
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion=(Connection) DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
            JOptionPane.showMessageDialog(null,"CONEXION EXITOSA");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR, "+ex);
            }       
        catch (SQLException ex) 
        {
            System.err.println("ERROR, "+ex);
        }
        return conexion;
}
     public void closeConnection()
{
           try {
               conexion.close();
           } catch (SQLException ex) {
               System.err.println("ERROR AL CERRAR");
           }
}
}
 