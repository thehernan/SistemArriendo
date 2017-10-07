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
public class Cliente {
    
    private long id;
    private String nombre;
    private String apellido;
    private String rut;
    private String telefono;
    private String domiciliopart;
    private String domiciliatrab;
    private byte[] copiacarne;
    private String tipo;
    public Cliente() {
    }

    public Cliente(long id, String nombre, String apellido, String rut, String telefono, String domiciliopart, String domiciliatrab, byte[] copiacarne) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.domiciliopart = domiciliopart;
        this.domiciliatrab = domiciliatrab;
        this.copiacarne = copiacarne;
    }

    public long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomiciliopart() {
        return domiciliopart;
    }

    public void setDomiciliopart(String domiciliopart) {
        this.domiciliopart = domiciliopart;
    }

    public String getDomiciliatrab() {
        return domiciliatrab;
    }

    public void setDomiciliatrab(String domiciliatrab) {
        this.domiciliatrab = domiciliatrab;
    }

    public byte[] getCopiacarne() {
        return copiacarne;
    }

    public void setCopiacarne(byte[] copiacarne) {
        this.copiacarne = copiacarne;
    }
    
    
    
    
}
