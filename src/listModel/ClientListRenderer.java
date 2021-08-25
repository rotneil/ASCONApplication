/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import objectScripts.Client;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public class ClientListRenderer extends JLabel implements ListCellRenderer <Client>
{
    public ClientListRenderer ()
    {
        setOpaque (true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Client> list, 
            Client value, int index, boolean isSelected, boolean cellHasFocus) 
    {
        setText (value.toString());
        Color background;
        Color foreground;
        
        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        
        if (dropLocation != null && !dropLocation.isInsert() &&
                dropLocation.getIndex() == index) {
            background = Color.blue;
            foreground = Color.white;
        }
        
        // chechk if this cell is selected
        else if (isSelected) {
            background = Color.red;
            foreground = Color.white;
        }
        
        // unselected and not the DnD dropLocation
        else {
            background = Color.white;
            foreground = Color.black;
        }
        
        setBackground (background);
        setForeground (foreground);
        return this;
    }
    
}
