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
public class Maquinaria {
    private long id;
    private String maquina;
    private String marca;
    private String serie;
    private String modelo;
    private long idcategoria;
    private long idempresa;
    private Double preciodiario;
    private String estado;
    private long idcliente;
    private String propietario;
    public Maquinaria(long id, String maquina, String marca, String serie, String modelo, long idcategoria, long idempresa, Double preciodiario, String estado) {
        this.id = id;
        this.maquina = maquina;
        this.marca = marca;
        this.serie = serie;
        this.modelo = modelo;
        this.idcategoria = idcategoria;
        this.idempresa = idempresa;
        this.preciodiario = preciodiario;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }
    

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

    public Maquinaria() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Double getPreciodiario() {
        return preciodiario;
    }

    public void setPreciodiario(Double preciodiario) {
        this.preciodiario = preciodiario;
    }
    
    
}
