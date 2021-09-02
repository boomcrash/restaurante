/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexion.conexion;
import static DAO.UsuarioDaoImpl.cargo;
import static DAO.UsuarioDaoImpl.codigo;
import PDAO.Controldor.Controlador;
import PDAO.Modelo.*;
import PDAO.vistas.Ventana_Opciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;



public class MeseroDaoImpl1 implements MeseroDao{
    private conexion conect;
    public static int id;
    @Override
    public boolean registrar(Mesero mes) {
         boolean x;
        
        try {
            conexion conect= new conexion();
            com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) conect.getconection();
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("insert into personal (cedula,nombres,mesa,CODUSUARIO) values(?,?,?,?)");
            ps.setString(1, mes.getnIdentificacion());
            ps.setString(2, mes.getNombres());
            ps.setString(3, mes.getAsigmesa());
            ps.setInt(4, mes.getUser());
            ps.executeUpdate();
            x=true;
            System.out.println("funciona");
            ps2=(PreparedStatement)conexion.prepareStatement("select * from personal where cedula=?");
            ps2.setString(1, mes.getnIdentificacion()); 
            rs=ps2.executeQuery();
            if(rs.next()){
                id=rs.getInt("id_mesero");
            }
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;	
    }
    @Override
    public boolean verificar(Mesero mes) {
               boolean x;
        String cedula=null,contra=null;
        try {
            conexion conect= new conexion();
            com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) conect.getconection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("select *from personal where cedula=?");
            ps.setString(1, mes.getnIdentificacion()); 
            rs=ps.executeQuery();
            if(rs.next()){
                cedula=rs.getString("cedula");
            }
            if(cedula.equals(mes.getnIdentificacion())){
                x=true;
            }else x=false;
            
        }catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;
    }

    @Override
    public boolean actualizar(Mesero mes) {
               boolean x;
        
        try {
            conexion conect= new conexion();
            com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) conect.getconection();
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
           ps2=(PreparedStatement)conexion.prepareStatement("select * from personal where cedula=?");
            ps2.setString(1, mes.getnIdentificacion()); 
            rs=ps2.executeQuery();
            if(rs.next()){
                id=rs.getInt("id_mesero");
                codigo=rs.getInt("CODUSUARIO");
            }
            ps=(PreparedStatement)conexion.prepareStatement("update personal set cedula=?,nombres=?,mesa=? where CODUSUARIO=?");
            ps.setString(1, mes.getnIdentificacion());
            ps.setString(2, mes.getNombres());
            ps.setString(3, mes.getAsigmesa());
            ps.setInt(4,codigo);
            ps.executeUpdate();
            x=true;
            System.out.println("funciona");
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;	

    }

    @Override
    public boolean eliminar(String cedula) {
        boolean x = false;
        try {
            int numero = 0;
            conexion conect= new conexion();
            com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) conect.getconection();
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
           ps2=(PreparedStatement)conexion.prepareStatement("select * from personal where cedula=?");
            ps2.setString(1, cedula); 
            rs=ps2.executeQuery();
            if(rs.next()){
                numero=rs.getInt("CODUSUARIO");
            }
              ps2=(PreparedStatement)conexion.prepareStatement("delete from personal where CODUSUARIO=?");
            ps2.setInt(1, numero); 
            ps2.execute();
              ps2=(PreparedStatement)conexion.prepareStatement("delete from user where CODUSUARIO=?");
            ps2.setInt(1, numero); 
            ps2.execute();
            JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE!");
            x=true;
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;	

    }

    @Override
    public boolean consultar(String cedula, JTable tabla) {
          boolean x = false;
        
        try {
            String nombre=null,mesa=null,usuario=null,contraseña=null;
            int numero = 0;
            conexion conect= new conexion();
            com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) conect.getconection();
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
           ps2=(PreparedStatement)conexion.prepareStatement("select * from personal where cedula=?");
            ps2.setString(1, cedula); 
            rs=ps2.executeQuery();
            if(rs.next()){
                numero=rs.getInt("CODUSUARIO");
                nombre=rs.getString("nombres");mesa=rs.getString("mesa");
            }
           ps2=(PreparedStatement)conexion.prepareStatement("select * from user where CODUSUARIO=?");
            ps2.setInt(1, numero); 
            rs=ps2.executeQuery();
            if(rs.next()){
                usuario=rs.getString("usuario");contraseña=rs.getString("contraseña");
            }
            if(numero!=0){
            Controlador ct=new Controlador();
            ct.tabla_personal(tabla, new Modelo(usuario, contraseña), new Mesero(cedula, nombre, mesa), numero);
            x=true;
            }else JOptionPane.showMessageDialog(null, "NO EXISTE ESTE EMPLEADO");
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
            x=false;
        } 
        return x;	

    }
    }
