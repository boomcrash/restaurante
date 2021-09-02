/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.Modelo;

/**
 *
 * @author lidia
 */
//CRUD DE LAS TABLAS - VENTANA DE INFORMACION DEL PEDIDO Y MESERO. 
public class Modelo {
    private String usuario;
    private String password;
    private String cargo;
    public Modelo(String usuario, String password,String cargo) {
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
    }
     public Modelo(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Modelo() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
	return this.usuario+", "+this.password;
    }
    
    
    
}
