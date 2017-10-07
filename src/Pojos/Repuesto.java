/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author info2017
 */
public class Repuesto {
    private long id;
    private double cantidad;
    private String descripcion;
    private double valor;
    private long idreparacion;

    public Repuesto() {
    }

    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

   

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getIdreparacion() {
        return idreparacion;
    }

    public void setIdreparacion(long idreparacion) {
        this.idreparacion = idreparacion;
    }
    
    
}
