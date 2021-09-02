/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author MILTON
 */
public interface pedidoDao {

    public void llenar_tabla(String producto, String precio, int cant, JTable tabla);

    public void consultar(String nombre, JTable tabla);

    public void generar_pedido(ArrayList productos, String pedido, String mesero, String mesa);


    
}
