/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import PDAO.Modelo.Modelo;
import java.util.List;
public interface IUsuarioDao {
    public boolean registrar(Modelo user);
	public boolean verificar(Modelo user);
        public boolean actualizar(Modelo user);
}
