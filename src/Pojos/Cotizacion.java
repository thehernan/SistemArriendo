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
public class Cotizacion {
    private long id;
    private String condicionpago;
    private String emitidapor;
    private long idempresa;
    private long idcliente;

    public Cotizacion() {
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCondicionpago() {
        return condicionpago;
    }

    public void setCondicionpago(String condicionpago) {
        this.condicionpago = condicionpago;
    }

    public String getEmitidapor() {
        return emitidapor;
    }

    public void setEmitidapor(String emitidapor) {
        this.emitidapor = emitidapor;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }
    
    
    
}
