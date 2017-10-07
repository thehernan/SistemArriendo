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
public class DetalleGuia {
    private long id;
    private Double importe;
//    private String tipoguia;
    private long idguia;
    private long maquina;
    

    public DetalleGuia() {
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

//    public String getTipoguia() {
//        return tipoguia;
//    }
//
//    public void setTipoguia(String tipoguia) {
//        this.tipoguia = tipoguia;
//    }

    public long getIdguia() {
        return idguia;
    }

    public void setIdguia(long idguia) {
        this.idguia = idguia;
    }

    public long getMaquina() {
        return maquina;
    }

    public void setMaquina(long maquina) {
        this.maquina = maquina;
    }
    
    
    
}
