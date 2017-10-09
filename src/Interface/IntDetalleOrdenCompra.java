/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.DetalleOrdenCompra;
import java.util.List;

/**
 *
 * @author info2017
 */
public interface IntDetalleOrdenCompra {
    public void insert(List<DetalleOrdenCompra> detc, long idorden);
    
}
