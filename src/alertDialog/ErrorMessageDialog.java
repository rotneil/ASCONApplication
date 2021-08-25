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
 * @author Nehemiah (rotneil@yahoo.com)
 */
public class ErrorMessageDialog {
    // instance variables
    private String title;
    private String message;
    private JFrame parentComponent;
    
    // constructor
    public ErrorMessageDialog (JFrame parent, String title, String message)
    {
        this.title = title;
        this.message = message;
        this.parentComponent = parent;
    }
    
    // method to show message
    public void show ()
    {
        // display message
        JOptionPane.showMessageDialog(parentComponent, message, title,
                JOptionPane.ERROR_MESSAGE);
    }
    
    // method to show message
    public static void show (JFrame comp, String title, String message)
    {
        ErrorMessageDialog dialog = new ErrorMessageDialog (comp, 
                title, message);
        dialog.show();
    }
    
    // method to show message
    public static void show (JFrame comp, String message)
    {
        ErrorMessageDialog dialog = new ErrorMessageDialog (comp, 
                "Error Message", message);
        dialog.show();
    }
}
