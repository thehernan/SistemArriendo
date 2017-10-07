/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.DetalleContrato;
import Pojos.Maquinaria;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author info2017
 */
public interface IntDetalleGuia {
     public void insert (List<Maquinaria> listdet, long idguia,boolean entre);
     public void update(List<DetalleContrato> listdetcont,long idguia,boolean porfalla);  //, Timestamp fecha
}
