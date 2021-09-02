/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.Controldor;
import DAO.*;
import PDAO.Modelo.Modelo;
import PDAO.vistas.ViewUser;
import java.util.ArrayList;
import java.util.List;
public class ControladorUser {
    private ViewUser vista= new ViewUser();
	
	public ControladorUser() {
	}
	public void registrar(Modelo user) {
		IUsuarioDao dao= new  UsuarioDaoImpl();
		dao.registrar(user);
	}
        public void verificar(Modelo user) {
		IUsuarioDao dao= new  UsuarioDaoImpl();
		dao.verificar(user);
	}
        public void actualizar(Modelo user) {
            IUsuarioDao dao= new  UsuarioDaoImpl();
            dao.actualizar(user);
	}
}
