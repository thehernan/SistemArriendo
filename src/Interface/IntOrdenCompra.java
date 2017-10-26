/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.OrdenCompra;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntOrdenCompra {
    public long insert(OrdenCompra orden);
    public List<OrdenCompra> view(long idempre,JTable tabla);
    public void print(long id);
    public List<OrdenCompra> searchsensitive(long idempre,JTable tabla,String cadena);        
}
