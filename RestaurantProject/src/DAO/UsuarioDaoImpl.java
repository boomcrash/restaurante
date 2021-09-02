/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexion.conexion;
import PDAO.Modelo.Mesero;
import com.mysql.jdbc.Connection;
import PDAO.Modelo.Modelo;
import PDAO.vistas.Ventana_Opciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioDaoImpl implements IUsuarioDao{
    public static int codigo;
    public static String cargo,mesa;
    @Override
    public boolean registrar(Modelo user) {
        boolean x;
        
        try {
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            System.out.println(user.getPassword());
            ps=(PreparedStatement)conexion.prepareStatement("insert into user (usuario,contraseña,tipo) values(?,?,?)");
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCargo());
            ps.executeUpdate();
            ps=null;
            ps=(PreparedStatement)conexion.prepareStatement("select * from user where usuario=?");
            ps.setString(1, user.getUsuario());
            rs=ps.executeQuery();
            if(rs.next()){
                codigo=rs.getInt("CODUSUARIO");
                System.out.println("el code es:"+codigo);
            }
            x=true;
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;
    } //To change body of generated methods, choose Tools | Templates.

    @Override
    public boolean verificar(Modelo user) {
        boolean x;
        String usuario=null,contra=null;
        try {
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            System.out.println(user.getUsuario());
            System.out.println(user.getPassword());
            ps=(PreparedStatement)conexion.prepareStatement("select *from user where usuario=?");
            ps.setString(1, user.getUsuario()); 
            rs=ps.executeQuery();
            if(rs.next()){
                usuario=rs.getString("usuario");
                contra=rs.getString("contraseña");
                cargo=rs.getString("tipo");
                codigo=rs.getInt("CODUSUARIO");
            }
            ps=(PreparedStatement)conexion.prepareStatement("select *from personal where CODUSUARIO=?");
            ps.setInt(1, codigo); 
            rs=ps.executeQuery();
            if(rs.next()){
               
                mesa=rs.getString("mesa");
            }
            if(usuario.equals(user.getUsuario())&&contra.equals(user.getPassword())){
                x=true;
                Ventana_Opciones opcion=new Ventana_Opciones();
                opcion.setVisible(true);
            }else x=false;
            
        }catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;
    }

    @Override
    public boolean actualizar(Modelo user) {

        boolean x;
        
        try {
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement p=null,ps=null;
            ResultSet r=null,rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("update user set usuario=?,contraseña=?,tipo=? where CODUSUARIO=?");
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCargo());
            ps.setInt(4,codigo);
            ps.executeUpdate();
            x=true;
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;
    }

}
