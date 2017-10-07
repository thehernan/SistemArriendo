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
public class DetalleVenta {
    private long id;
    private long idarido;
    private Double cantidad;
    private Double importe;
    private long idventa;

    public DetalleVenta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdarido() {
        return idarido;
    }

    public void setIdarido(long idarido) {
        this.idarido = idarido;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public long getIdventa() {
        return idventa;
    }

    public void setIdventa(long idventa) {
        this.idventa = idventa;
    }
    
    
    
}
