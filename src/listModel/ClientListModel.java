/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import asconapplication.ASCONApplication;
import asconapplication.Constants;
import alertDialog.ErrorMessageDialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractListModel;
import objectScripts.Client;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public class ClientListModel extends AbstractListModel <Client>
    implements Constants {
    // instance variables
    private ResultSet mResultSet;
    private ASCONApplication parent;
    
    // constructor
    public ClientListModel (ASCONApplication parent, ResultSet set)
    {
        super ();
        this.parent = parent;
        this.mResultSet = set;
    }
    
    @Override
    public int getSize() {
        try {
            mResultSet.last();
            return mResultSet.getRow();
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, e.getMessage());
            return -1;
        }
    }

    @Override
    public Client getElementAt(int index) {
        try {
            mResultSet.absolute ((index + 1));
            return parent.getSchema().getClientById(
                    mResultSet.getLong(CLIENT.ID));
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, e.getMessage ());
            return null;
        }
    }
    
    // method to update list
    public void updateList (ResultSet set)
    {
        this.mResultSet = set;
        this.fireContentsChanged(this, 0, getSize ());
    }
}
