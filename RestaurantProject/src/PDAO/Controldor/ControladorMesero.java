/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.Controldor;

import DAO.IUsuarioDao;
import DAO.MeseroDao;
import DAO.MeseroDaoImpl1;
import DAO.UsuarioDaoImpl;
import PDAO.Modelo.Mesero;
import PDAO.Modelo.Modelo;
import PDAO.vistas.ViewUser;
import javax.swing.JTable;

/**
 *
 * @author MILTON
 */
public class ControladorMesero {
        private ViewUser vista= new ViewUser();
	
	public ControladorMesero() {
	}
	public void registrar(Mesero mes) {
		MeseroDao dao= new  MeseroDaoImpl1();
		dao.registrar(mes);
	}
        public void verificar(Mesero mes) {
		MeseroDao dao= new  MeseroDaoImpl1();
		dao.verificar(mes);
	}
         public void actualizar(Mesero mes) {
		MeseroDao dao= new  MeseroDaoImpl1();
		dao.actualizar(mes);
	}
          public void consultar(String cedula,JTable tabla) {
		MeseroDao dao= new  MeseroDaoImpl1();
		dao.consultar(cedula,tabla);
	}
           public void eliminar(String cedula) {
		MeseroDao dao= new  MeseroDaoImpl1();
		dao.eliminar(cedula);
	}
}
