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
public class SingletonEmpresa {
    private long id;
    private String razonS;
    private String rut;
    private String domicilio;
    private String representalegal;
    private String telefono;
    private String rutrepresentante;
    private String domiciliorepre;
    private String telefrepre;
    private String celular;
    private static SingletonEmpresa singletonempre;

    private SingletonEmpresa() {
    }
    
    public static SingletonEmpresa getinstancia(){
    if (singletonempre == null){
        singletonempre = new SingletonEmpresa();
    
    }
    return singletonempre;
    }
    public  void  getdestruir(){
    if (singletonempre != null){
        singletonempre = null;
    
    }
           
    
    }
    public SingletonEmpresa setcargarempresa(Empresa emp){
        singletonempre.setId(emp.getId());
        singletonempre.setRazonS(emp.getRazonS());
        singletonempre.setRut(emp.getRut());
        singletonempre.setDomicilio(emp.getDomicilio());
        singletonempre.setRepresentalegal(emp.getRepresentalegal());
        singletonempre.setTelefono(emp.getTelefono());
        singletonempre.setRutrepresentante(emp.getRutrepresentante());
        singletonempre.setDomiciliorepre(emp.getDomiciliorepre());
        singletonempre.setTelefrepre(emp.getTelefono());
        singletonempre.setCelular(emp.getCelular());
    return singletonempre;
    
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRazonS() {
        return razonS;
    }

    public void setRazonS(String razonS) {
        this.razonS = razonS;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRepresentalegal() {
        return representalegal;
    }

    public void setRepresentalegal(String representalegal) {
        this.representalegal = representalegal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRutrepresentante() {
        return rutrepresentante;
    }

    public void setRutrepresentante(String rutrepresentante) {
        this.rutrepresentante = rutrepresentante;
    }

    public String getDomiciliorepre() {
        return domiciliorepre;
    }

    public void setDomiciliorepre(String domiciliorepre) {
        this.domiciliorepre = domiciliorepre;
    }

    public String getTelefrepre() {
        return telefrepre;
    }

    public void setTelefrepre(String telefrepre) {
        this.telefrepre = telefrepre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public static SingletonEmpresa getSingletonempre() {
        return singletonempre;
    }

    public static void setSingletonempre(SingletonEmpresa singletonempre) {
        SingletonEmpresa.singletonempre = singletonempre;
    }
    

    
    
    
}
