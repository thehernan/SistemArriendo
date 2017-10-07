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
public class DetalleCotizacion {
    private long id;
    private long idcotizacion;
    private long idmaq;
    private int cantidad;
    private int dias ;
    private Double valordia;

    public DetalleCotizacion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(long idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public long getIdmaq() {
        return idmaq;
    }

    public void setIdmaq(long idmaq) {
        this.idmaq = idmaq;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Double getValordia() {
        return valordia;
    }

    public void setValordia(Double valordia) {
        this.valordia = valordia;
    }
    
    
    
}
