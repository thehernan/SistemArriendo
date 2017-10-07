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
public class Guia {
    private long id;
    private long idempresa;
    private long idcliente;
    private Double total;
    private long idguia;
    private String tipoop;
    public Guia() {
    }

    public String getTipoop() {
        return tipoop;
    }

    public void setTipoop(String tipoop) {
        this.tipoop = tipoop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public long getIdguia() {
        return idguia;
    }

    public void setIdguia(long idguia) {
        this.idguia = idguia;
    }
    
    
    
}
