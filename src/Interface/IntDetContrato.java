/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.DetalleContrato;
import Pojos.Maquinaria;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntDetContrato {
    public void insert (List<Maquinaria> listdet, long idcontr);
    public List<DetalleContrato>search(JTable tabla,long idcontr);
//     public List<DetalleContrato>searchedit(JTable tabla,long idcontr);
    public void update(List<DetalleContrato> listdet);
}
