/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarriendo;

import Frame.JFLogin;
import Frame.Menu;
import com.sun.awt.AWTUtilities;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author info2017
 */
public class SistemaArriendo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//             UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//             UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//              UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//              UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");// 1
              UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//               UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//              UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
            System.err.println("Error Look GUI: "+e.getMessage());
        }
        
        
                /*Aquí crean el objeto hacía su aplicación, para hacer visible*/
                JFLogin login = new JFLogin();
                
                login.setVisible(true);
                
            
        
        
         
    }
    
   
               
                
           
          
    
}
