
package PDAO.Controldor;

import DAO.MeseroDao;
import DAO.MeseroDaoImpl1;
import DAO.pedidoDao;
import DAO.pedidoDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class ControladorPedido {
   public void llenar_tabla(String producto,String precio,int cant,JTable tabla){
        pedidoDao dao= (pedidoDao) new  pedidoDaoImpl();
       dao.llenar_tabla(producto,precio,cant,tabla);
   }

   public void consultar(String nombre,JTable tabla){  
  pedidoDao dao= (pedidoDao) new  pedidoDaoImpl();
       dao.consultar(nombre,tabla);
   } 
    public void generar_pedido(ArrayList productos,String pedido,String mesero,String mesa){
         pedidoDao dao= (pedidoDao) new  pedidoDaoImpl();
       dao.generar_pedido(productos,pedido,mesero,mesa);
   } 
}
