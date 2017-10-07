/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Venta;

/**
 *
 * @author info2017
 */
public interface IntVenta {
    public long insert(Venta venta);
    public long insertnoclient(Venta venta);
    public void print(long id);
    public boolean validatestock(long idprod,double canti);
}
