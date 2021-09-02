/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import PDAO.Modelo.*;
import java.util.List;
import javax.swing.JTable;
public interface MeseroDao {
    public boolean registrar(Mesero mes);
	public boolean verificar(Mesero mes);
	public boolean actualizar(Mesero mes);
	public boolean eliminar(String cedula);
        public boolean consultar(String cedula,JTable tabla);
}
