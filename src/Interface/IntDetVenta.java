/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Arido;
import java.util.List;

/**
 *
 * @author info2017
 */
public interface IntDetVenta {
     public void insert (List<Arido> listarido, long idventa);
     public void returnstock(long idari,double cant);
}
