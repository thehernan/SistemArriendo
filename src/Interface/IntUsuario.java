/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Usuario;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntUsuario {
    public void insert(Usuario user);
    public void delete(long id);
    public List<Usuario> view (JTable tabla);
     public boolean duplicate(long id,String cadena,String op);
    public void update(Usuario user);
    public Usuario valida(String usu,String clave);
}
