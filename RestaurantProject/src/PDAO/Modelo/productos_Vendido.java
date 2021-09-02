/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDAO.Modelo;

/**
 *
 * @author MILTON
 */
public class productos_Vendido {
    String nombre,precio_U,cantidad,Total;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio_U() {
        return precio_U;
    }

    public void setPrecio_U(String precio_U) {
        this.precio_U = precio_U;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public productos_Vendido(String nombre, String precio_U, String cantidad, String Total) {
        this.nombre = nombre;
        this.precio_U = precio_U;
        this.cantidad = cantidad;
        this.Total = Total;
    }
    
}
