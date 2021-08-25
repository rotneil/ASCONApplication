/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import asconapplication.Constants;
import javax.swing.AbstractListModel;
import objectScripts.ASCONEvent;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public class EventListModel extends AbstractListModel <ASCONEvent>
    implements Constants {
    // instance variables
    private java.util.ArrayList<ASCONEvent> events;
    
    // constructor
    public EventListModel (java.util.ArrayList <ASCONEvent> list)
    {
        this.events = list;
    }
    
    @Override
    public int getSize() {
        return events.size();
    }

    @Override
    public ASCONEvent getElementAt(int index) {
        return events.get(index);
    }
    
    // method to update list
    public void updateList (java.util.ArrayList<ASCONEvent> list)
    {
        this.events = list;
        this.fireContentsChanged(this, 0, getSize ());
    }
}
