/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import asconapplication.Constants;
import javax.swing.AbstractListModel;
import objectScripts.SettingsVariable;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public class SettingsListModel extends AbstractListModel <SettingsVariable>
implements Constants
{
    // instance variable
    private SettingsVariable [] variableSet;
    
    // constructor
    public SettingsListModel (SettingsVariable [] set)
    {
        super ();
        this.variableSet = set;
    }
    
    @Override
    public int getSize() {
        return variableSet.length;
    }

    @Override
    public SettingsVariable getElementAt(int index) 
    {
        return variableSet [index];
    }
    
    // method to update variable set
    public void updateModel (SettingsVariable [] set)
    {
        variableSet = set;
        this.fireContentsChanged(this, 0, getSize ());
    }
}
