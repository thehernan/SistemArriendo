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
public class Arido {
    private Long id;
    private String descripcion;
    private Double cantidad;
    private String undmed;
    private Double precio;
    private Double invinicial;
    private Long idempresa;
    private Long idcatgoria;
    private String categoria;
    private double importe;
    public Arido() {
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Arido(Long id, String descripcion, Double cantidad, String undmed, Double precio, Double invinicial, Long idempresa) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.undmed = undmed;
        this.precio = precio;
        this.invinicial = invinicial;
        this.idempresa = idempresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getIdcatgoria() {
        return idcatgoria;
    }

    public void setIdcatgoria(Long idcatgoria) {
        this.idcatgoria = idcatgoria;
    }

  

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

  

    

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

 

   

    public Double getInvinicial() {
        return invinicial;
    }

    public void setInvinicial(Double invinicial) {
        this.invinicial = invinicial;
    }

    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the undmed
     */
    public String getUndmed() {
        return undmed;
    }

    /**
     * @param undmed the undmed to set
     */
    public void setUndmed(String undmed) {
        this.undmed = undmed;
    }
    
    
    
}
