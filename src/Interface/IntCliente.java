/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Cliente;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntCliente {
    
    public List<Cliente> view (JTable tabla); 
    public List<Cliente> viewbusiness(JTable tabla,String tipo);
    public void insert (Cliente cli);
    public void update(Cliente cli);
    public void updatenophoto(Cliente cli);
    public void delete(Long id);
    public void printdebtor(Long id);
    public boolean duplicate(long id,String cadena,String op);
    public Cliente search(String rut,String tipo);
    public boolean  verifyclientdebtor(long idclient);
    
}
