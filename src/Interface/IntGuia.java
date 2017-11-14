/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Contrato;
import Pojos.DetalleContrato;
import Pojos.Guia;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntGuia {
     public long insert(Contrato contrato,String tipoop);
    
    public void print(long id);
    public List<Guia> view(JTable tabla);
    public List<Guia> searchsensitive(JTable tabla, String cadena);
}
