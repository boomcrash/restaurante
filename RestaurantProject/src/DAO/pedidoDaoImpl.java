/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conexion;
import static DAO.UsuarioDaoImpl.codigo;
import PDAO.Controldor.Controlador;
import PDAO.Modelo.Mesero;
import PDAO.Modelo.Modelo;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author MILTON
 */
public class pedidoDaoImpl implements pedidoDao{
    public static String cantidad=null,pre=null,nom=null;
    @Override
    public void llenar_tabla(String producto, String precio, int cant, JTable tabla) {
        if(producto!=null){
            if(Integer.parseInt(cantidad)>cant){
                String precioTotal=String.valueOf(Math.round((cant*Double.parseDouble(precio))*100.0)/100.0);
                Controlador ct=new Controlador();
                ct.tabla_pedido(tabla, producto, String.valueOf(cant), precioTotal);
            }else JOptionPane.showMessageDialog(null, "CANTIDAD SUPERA EL STOCK DEL PRODUCTO");
        }else {JOptionPane.showMessageDialog(null, "NO EXISTE ESTE PRODUCTO");cantidad=null;
        pre=null;nom=null;} 
    }

    @Override
    public void consultar(String nombre, JTable tabla) {
       try {
           String producto=null,precio=null,stock=null;
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("select * from producto where nombre=?");
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                producto=rs.getString("nombre");
                precio=rs.getString("precio");
                stock=rs.getString("stock");
            }
            if(producto!=null){
            Controlador ct=new Controlador();
            ct.tabla_producto(tabla, producto, precio, stock);
            cantidad=stock;
            pre=precio;
            nom=producto;
            }else {JOptionPane.showMessageDialog(null, "NO EXISTE ESTE PRODUCTO");cantidad=null;
            pre=null;nom=null;}
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
        } 
    }

    @Override
    public void generar_pedido(ArrayList productos, String pedido, String mesero, String mesa) {
       
    }
    
}
