/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Reparacion;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntReparacion {
     public List<Reparacion> view (JTable tabla,boolean entreg,String tiop); 
    public void insert (Reparacion repara,String estado);
    public long insertrepairclientnoemploye(Reparacion repara);
    public long insertrepairclientemploye(Reparacion repara);
    public List<Object> search(long id);
    public void update(Reparacion repa);
    public void updatenoempleado(Reparacion repa);
    public List<Reparacion> searchsensitive (JTable tabla,boolean entreg,String tiop,String cadena); 
}
