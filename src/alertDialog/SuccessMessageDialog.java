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
public class SuccessMessageDialog {
    // instance variables
    private String message = null;
    private JFrame parentComponent = null;
    
    // constructor
    public SuccessMessageDialog (JFrame parent, String message)
    {
        this.message = message;
        this.parentComponent = parent;
    }
    
    // method to show message
    public void show ()
    {
        // display message
        JOptionPane.showMessageDialog(parentComponent, message, "Success Message",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    // method to show message
    public static void show (JFrame comp, String message)
    {
        SuccessMessageDialog dialog = new SuccessMessageDialog (comp, message);
        dialog.show();
    }
}
