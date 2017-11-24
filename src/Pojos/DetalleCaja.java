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
public class DetalleCaja {
    private long id;
    private Double importe;
    private Double pago;
    private long idcontrato;
    private long idventa;
    private String observacion;
    private long idreparir;
    private String fecha;
    private Double descuento;
    private Double total;
    public String getObservacion() {
        return observacion;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getIdreparir() {
        return idreparir;
    }

    public void setIdreparir(long idreparir) {
        this.idreparir = idreparir;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public DetalleCaja() {
    }

    public long getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(long idcontrato) {
        this.idcontrato = idcontrato;
    }

   

    public long getIdventa() {
        return idventa;
    }

    public void setIdventa(long idventa) {
        this.idventa = idventa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    
    
    
}
