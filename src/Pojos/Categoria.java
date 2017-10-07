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
public class Categoria {
    private long id;
    private String categoria;
    private String tipocat;
    public Categoria(long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public String getTipocat() {
        return tipocat;
    }

    public void setTipocat(String tipocat) {
        this.tipocat = tipocat;
    }

    public Categoria() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
