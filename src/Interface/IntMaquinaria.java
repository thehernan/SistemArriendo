/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import Pojos.Maquinaria;
import Pojos.Reparacion;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntMaquinaria {
    public List<Maquinaria> view (JTable tabla,String estado,String propiedad); 
    public long insert (Maquinaria maq);
   public List<Reparacion> viewrepair(JTable tabla,long idmaq);
    public long insertmaqrepairclient(Maquinaria maq);
    public void update(Maquinaria maq);
    public void updatenocategoria(Maquinaria maq);
    public void delete(Long id);
    public void print();
    public boolean duplicate(long id,String cadena,String op,long idcat);
    public void movement(JTable tabla, long idmaq);
    public List<Maquinaria> searchsentitive(JTable tabla,String estado,String propiedad, long idcategoria,String cadena);
    
}
