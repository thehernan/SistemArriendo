/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Pojos.DetalleCaja;
import java.sql.Timestamp;
import javax.swing.JTable;

/**
 *
 * @author info2017
 */
public interface IntDetalleCaja {
    public long insertpaycontrato(DetalleCaja detcaja,double desc);
    public void insetpaysale(DetalleCaja detcaja);
    public void insertdischarge(DetalleCaja detcaja);
    public long insertrepair(DetalleCaja detcaja);
    public String view(JTable tabla,String tipob,Timestamp fecha,String mes);
    public void print(String titulo,String tipob,Timestamp fecha,String mes);   
    public void printabono(long id);
    public void printrepair(long id);
}
