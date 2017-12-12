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
public class DetalleContrato {
    private long id;
    private Double importe;
    private long idmaq;
    private long idcontr;
    private boolean  entregado;
    private String fechapres;
    private String fechaent;
   
    public DetalleContrato() {
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

    public long getIdmaq() {
        return idmaq;
    }

    public void setIdmaq(long idmaq) {
        this.idmaq = idmaq;
    }

    public long getIdcontr() {
        return idcontr;
    }

    public void setIdcontr(long idcontr) {
        this.idcontr = idcontr;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getFechapres() {
        return fechapres;
    }

    public void setFechapres(String fechapres) {
        this.fechapres = fechapres;
    }

    public String getFechaent() {
        return fechaent;
    }

    public void setFechaent(String fechaent) {
        this.fechaent = fechaent;
    }
    
    
    
}
