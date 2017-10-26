/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Cotizacion;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntCotizacion {
    public long insert(Cotizacion cotizacion);
    public List<Cotizacion> view(long idempre,JTable tabla);
    public void print(long id);
    public List<Cotizacion> searchsensitive(long idempre,JTable tabla,String cadena);        
    
}
