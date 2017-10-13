/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.sql.Timestamp;

/**
 *
 * @author info2017
 */
public class Reparacion {
    private String descripci;
    private String fecha;
    private long idmaqui;
    private long id;
    private long idcliente;
    private String observacion;
    private Double manoobra;
    private Double subtotal;
    private Double total;
    private boolean acepta;
    private long idempleado;
    private Timestamp fechaentrega;
    private String trabajorealizado;
    private boolean entregada;
    private String entregadopor;
    private Double repuesto;
    private Double iva;
    private long idempresa;
    private Double revision;
    private String codigo;
    public Reparacion() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getRevision() {
        return revision;
    }

    public void setRevision(Double revision) {
        this.revision = revision;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Double repuesto) {
        this.repuesto = repuesto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Double getManoobra() {
        return manoobra;
    }

    public void setManoobra(Double manoobra) {
        this.manoobra = manoobra;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isAcepta() {
        return acepta;
    }

    public void setAcepta(boolean acepta) {
        this.acepta = acepta;
    }

    public long getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(long idempleado) {
        this.idempleado = idempleado;
    }

    public Timestamp getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Timestamp fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getTrabajorealizado() {
        return trabajorealizado;
    }

    public void setTrabajorealizado(String trabajorealizado) {
        this.trabajorealizado = trabajorealizado;
    }

    public boolean isEntregada() {
        return entregada;
    }

    public void setEntregada(boolean entregada) {
        this.entregada = entregada;
    }

    public String getEntregadopor() {
        return entregadopor;
    }

    public void setEntregadopor(String entregadopor) {
        this.entregadopor = entregadopor;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripci() {
        return descripci;
    }

    public void setDescripci(String descripci) {
        this.descripci = descripci;
    }

    public long getIdmaqui() {
        return idmaqui;
    }

    public void setIdmaqui(long idmaqui) {
        this.idmaqui = idmaqui;
    }
    
    
}
