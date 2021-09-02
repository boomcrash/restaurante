/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.vistas;

import PDAO.Modelo.Modelo;

import java.util.List;
public class ViewUser {
    public void verUsuario(Modelo user) {
		System.out.println("Datos del Cliente: "+user);
	}
	
	public void verUsuarios(List<Modelo> usuarios) {
		for (Modelo user : usuarios) {
			System.out.println("Datos del Cliente: "+user);
		}		
	}
}
