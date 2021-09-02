/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.Controldor;

import Conexion.conexion;
import static DAO.UsuarioDaoImpl.cargo;
import static DAO.UsuarioDaoImpl.codigo;
import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MILTON
 */
public class ControladoEstadistica {
    java.sql.Date date2;
    public void todos(){
        try {
            int cont=0;
            
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("select * from facturita ");
            rs=ps.executeQuery();
            while(rs.next()){
                cont++;
            }
             JOptionPane.showMessageDialog(null,"EXISTEN "+cont+" PEDIDOS EN TOTAL");
        } catch (SQLException ex) {
            Logger.getLogger(ControladoEstadistica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void dia(java.sql.Date data){
                try {
                     int cont=0;
            conexion conect= new conexion();
            Connection conexion=(Connection) conect.getconection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            ps=(PreparedStatement)conexion.prepareStatement("select * from facturita where fecha=?");    
            ps.setDate(1,data); 
            rs=ps.executeQuery();
            while(rs.next()){
                cont++;
            }
            JOptionPane.showMessageDialog(null,"EXISTEN "+cont+" PEDIDOS EN ESTE DIA");
        } catch (SQLException ex) {
            Logger.getLogger(ControladoEstadistica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
