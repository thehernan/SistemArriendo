/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Repuesto;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntRepuesto {
     public void insert (List<Repuesto> listrepuesto, long idrepara);
    public List<Repuesto> view (JTable tabla,long id); 
    public void delete(List<Repuesto> listrep);
}
