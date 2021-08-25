/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertDialog;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author olugbenga
 */
public class ConfirmMessageDialog {
    // instance variables
    private String message = null;
    private JFrame parentComponent = null;
    
    // constructor
    public ConfirmMessageDialog (JFrame parent, String message)
    {
        this.message = message;
        this.parentComponent = parent;
    }
    
    // method to show message
    public boolean show ()
    {
        // display message
        int value = JOptionPane.showConfirmDialog(parentComponent, 
                this.message, "Confirmation Dialog", 
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if (value == JOptionPane.YES_OPTION)
            return true;
        
        return false;
    }
    
    // method to show message
    public static boolean show (JFrame comp, String message)
    {
        ConfirmMessageDialog dialog = new ConfirmMessageDialog (comp, message);
        return dialog.show();
    }
}
