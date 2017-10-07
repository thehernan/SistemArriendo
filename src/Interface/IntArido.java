/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Arido;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntArido {
    
    public List<Arido> view (JTable tabla,long idempre); 
    public void insert (Arido arido);
    public void update(Arido arido);
    public void delete(Long id);
    public void print();
    public boolean duplicate(long id,String cadena,String op);
    
}
