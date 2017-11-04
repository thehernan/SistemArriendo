/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Empleado;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface InEmpleado {
    public List<Empleado> view (JTable tabla); 
    public void insert (Empleado emp);
    public void update(Empleado emp);
    public void delete(Long id);
    public void print();
    public boolean duplicate(long id,String cadena,String op);
     public Empleado search(String rut);
      public List<Empleado> searchsensitive (JTable tabla,String cadena); 
    
}
