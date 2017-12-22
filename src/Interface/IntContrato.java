/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.Contrato;
import Pojos.DetalleContrato;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntContrato {
    public long insert(Contrato contrato);
    public void print(long id);
    public List<Contrato> view (JTable tabla,long idempre,boolean activo,String tipodoc); 
    public List<DetalleContrato> viewpay(List<DetalleContrato> listdetc,JTable tabla,JFormattedTextField total);
    public void debtor(long icontr,JFormattedTextField flete,JFormattedTextField total,JFormattedTextField abono, JFormattedTextField deuda
    ,JFormattedTextField descuento);
//    public void pay();
    public List<Contrato> searchsensitive(JTable tabla,long idempre,String tipoB,String cod,String cli,boolean activo);
    public boolean validateedit(long idcontr);
    
}
