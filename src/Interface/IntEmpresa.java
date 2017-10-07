/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Empresa;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntEmpresa {
      public List<Empresa> view (JTable tabla); 
    public void insert (Empresa emp);
    public void update(Empresa emp);
    public void delete(Long id);
    public boolean duplicate(long id,String cadena,String op);
    public List<Empresa> jcombobox(JComboBox combo);
    
}
