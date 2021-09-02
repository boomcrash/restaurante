/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.Controldor;
import Conexion.conexion;
import static DAO.MeseroDaoImpl1.id;
import static DAO.pedidoDaoImpl.cantidad;
import static DAO.pedidoDaoImpl.pre;
import PDAO.Modelo.Mesero;
import PDAO.Modelo.Modelo;
import PDAO.Modelo.factura;
import PDAO.Modelo.productos_Vendido;
import PDAO.vistas.Ventana_Inicio;
import com.mysql.jdbc.Connection;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lidia
 */
public class Controlador {
   
    public static ArrayList<productos_Vendido> pedidos=new ArrayList<productos_Vendido>();
    DefaultTableModel modelo,modelo2;
    public static String pedido=null;
    public Controlador() {
    
    }

    public void tabla_personal(JTable tabla,Modelo user,Mesero mes,int id){
    modelo = (DefaultTableModel) tabla.getModel();
    Object[] datos = new Object[6];
    datos[0]=mes.getnIdentificacion();
    datos[1]=mes.getNombres();
    datos[2]=Integer.valueOf(id);
    datos[3]=mes.getAsigmesa();
    datos[4]=user.getUsuario();
    datos[5]=user.getPassword();
    modelo.addRow(datos);
    }
     public void tabla_producto(JTable tabla,String nombre, String precio,String stock){
    modelo = (DefaultTableModel) tabla.getModel();
    modelo.setNumRows(0);
    Object[] datos = new Object[3];
    datos[0]=nombre;
    datos[1]=precio;
    datos[2]=stock;
    modelo.addRow(datos);
    }
    public void tabla_pedido(JTable tabla,String nombre,String stock,String total){
    
    if(cantidad!=null){
    modelo = (DefaultTableModel) tabla.getModel();
    Object[] datos = new Object[4];
    datos[0]=nombre;
    datos[1]=pre;
    datos[2]=stock;
    datos[3]=total;
    modelo.addRow(datos);
    }else JOptionPane.showMessageDialog(null,"PRIMERO INGRESE EL PRODUCTO");
    }
    
    public void llenar_Array(JTable tabla,String numero,ArrayList<productos_Vendido> ped,JTable tabla2,JLabel jLabel54,JLabel iva,JLabel total){
        ped.clear();
        pedido=numero;
        double totall=0;
          System.out.println("PARTE UNO"+ped.size());
        if(tabla.getRowCount()!=0){
            
         for (int i=0;i<tabla.getRowCount();i++){
             ped.add(new productos_Vendido(String.valueOf(tabla.getValueAt(i, 0)),String.valueOf(tabla.getValueAt(i, 1)), String.valueOf(tabla.getValueAt(i, 2)),String.valueOf(tabla.getValueAt(i, 3))));
         }   
          modelo2 = (DefaultTableModel) tabla2.getModel();
            System.out.println("EL ARREGL TIENE "+ped.size());
    modelo2.setNumRows(0);
    for (int i=0;i<ped.size();i++){
            Object[] datos = new Object[4];
            datos[0]=ped.get(i).getNombre();
            datos[1]=ped.get(i).getPrecio_U();
            datos[2]=ped.get(i).getCantidad();
            datos[3]=ped.get(i).getTotal();
            totall+=Double.parseDouble(ped.get(i).getTotal());
            modelo2.addRow(datos);
    }
    jLabel54.setText(pedido);
    double ivaa=Math.round((totall*0.12)*100.0)/100.0;
    iva.setText(String.valueOf(ivaa));
    double totales=Math.round((totall+ivaa)*100.0)/100.0;
    total.setText(String.valueOf(totales));
        }else JOptionPane.showMessageDialog(null,"NO HAY PRODUCTOS PARA REALIZAR UN PEDIDO");
    }
    public void facturacion(factura fact,java.sql.Date c){
       try {
            
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("insert into facturita (mesa,pedido,CODUSUARIO,cliente,cedula,telefono,fecha,total) values(?,?,?,?,?,?,?,?)");
            ps.setString(1,fact.getMesa());
            ps.setString(2,fact.getPedido());
            ps.setString(3,fact.getMesero());
            ps.setString(4,fact.getNombre());
            ps.setString(5,fact.getCedula());
            ps.setString(6,fact.getTelefono());
            ps.setDate(7,c);
            ps.setString(8,fact.getTotal());
            
            ps.executeUpdate();
            System.out.println("perfecto");
        } catch (SQLException ex) {
            System.err.println("ERROR CONEXION DE BASE DE DATOS");
        } 
    }
    
}
