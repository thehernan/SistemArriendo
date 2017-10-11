/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Categoria;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntCategoria {
    public List<Categoria> view (JTable tabla); 
    public void insert (Categoria cat);
    public void update(Categoria cat);
    public void delete(Long id);
    public boolean duplicate(long id,String cadena,String op);
    public List<Categoria> jcombobox(JComboBox combo,String tipo,String vista);
    
}
