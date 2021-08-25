/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asconapplication;

import alertDialog.ErrorMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import objectScripts.ASCONEvent;
import objectScripts.Client;
import objectScripts.SettingsVariable;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public final class SchemaHelper implements Constants {
    // instance variables
    private Connection connection;
    private ASCONApplication parent;
    
    // constructor
    public SchemaHelper (ASCONApplication parent) {
        this.parent = parent;
        
        // try to initiate connection
        try {
            connection = DriverManager.getConnection(
                    "jdbc:derby:ascon;create=true;user=ascon;password=ascon");
                //DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            
            // check for first entry by quering the database
            connection.prepareStatement(
                    "SELECT * FROM LOCATION_TABLE").executeQuery ();
        } catch (SQLException e) {
            // the code should come here when its the first time launching app
            try {
                Installer.execute ();
                connection = DriverManager.getConnection(
                        "jdbc:derby:ascon;create=false;user=ascon;password=ascon");
            } catch (SQLException ee) {
                ErrorMessageDialog.show(
                        parent, "DATABASE CONNECTION ERROR", ee.getMessage());
                System.exit(0);
            }            
        }       
    }   // end constructor
    
    /**
     * This method creates a Client in the database using the parameters
     * @param name The name of the client
     * @param company The company of the Client
     * @param address The address of the Client
     * @param accomodation
     * @param block
     * @param location
     * @param room
     * @param occupant
     * @param arrival
     * @param departure
     * @param status
     * @param remark
     * @param course
     * @param department
     * @param cost
     * @param refNumber
     * @throws SQLException 
     */
    public void createNewClient (String name, String company, String address,
            long accomodation, long block, long location, int room, 
            long occupant, long arrival, long departure, int status, 
            String remark, String course, String department, 
            double cost, String refNumber)
        throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO " + CLIENT.TABLE_NAME + "(" +
                    CLIENT.NAME + ", " + CLIENT.COMPANY + ", " +
                    CLIENT.ADDRESS + ", " + CLIENT.ACCOMODATION_TYPE + ", " +
                    CLIENT.BLOCK_NAME + ", " + CLIENT.LOCATION + ", " +
                    CLIENT.ROOM_NUMBER + ", " + CLIENT.OCCUPANTS + ", " +
                    CLIENT.ARRIVAL_DATE + ", " + CLIENT.DEPARTURE_DATE + ", " +
                    CLIENT.STATUS + ", " + CLIENT.REMARK + ", " +
                    CLIENT.COURSE_TITLE + ", " + CLIENT.DEPARTMENT + ", " +
                    CLIENT.COST + ", " + CLIENT.REF_NUMBER + ") " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        // set the variables
        statement.setString(1, name);
        statement.setString(2, company);
        statement.setString(3, address);
        statement.setLong(4, accomodation);
        statement.setLong(5, block);
        statement.setLong(6, location);
        statement.setInt(7, room);
        statement.setLong(8, occupant);
        statement.setLong(9, arrival);
        statement.setLong(10, departure);
        statement.setInt(11, status);
        statement.setString(12, remark);
        statement.setString(13, course);
        statement.setString(14, department);
        statement.setDouble(15, cost);
        statement.setString(16, refNumber);

        statement.execute();
    }
    
    /**
     * This method is used to update a client's profile
     * @param clientId
     * @param name
     * @param company
     * @param address
     * @param accomodation
     * @param block
     * @param location
     * @param room
     * @param occupant
     * @param arrival
     * @param departure
     * @param status
     * @param remark
     * @param course
     * @param department
     * @param cost
     * @param refNumber
     * @throws java.sql.SQLException
     */
    public void updateClient(long clientId,
            String name, String company, String address,
            long accomodation, long block, long location, int room, 
            long occupant, long arrival, long departure, int status, 
            String remark, String course, String department, double cost,
            String refNumber)
        throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(
        "UPDATE " + CLIENT.TABLE_NAME + 
            " SET " + 
                CLIENT.NAME + "=?," + CLIENT.COMPANY + "=?," +
                CLIENT.ADDRESS + "=?," + CLIENT.ACCOMODATION_TYPE + "=?," +
                CLIENT.BLOCK_NAME + "=?," + CLIENT.LOCATION + "=?," +
                CLIENT.ROOM_NUMBER + "=?," + CLIENT.OCCUPANTS + "=?," +
                CLIENT.ARRIVAL_DATE + "=?," + CLIENT.DEPARTURE_DATE + "=?," +
                CLIENT.STATUS + "=?," + CLIENT.REMARK + "=?," +
                CLIENT.COURSE_TITLE + "=?," + CLIENT.DEPARTMENT + "=?," +
                CLIENT.COST + "=?," + CLIENT.REF_NUMBER + "=?" +
            " WHERE " + CLIENT.ID + "=?");

        // set the variables
        statement.setString(1, name);
        statement.setString(2, company);
        statement.setString(3, address);
        statement.setLong(4, accomodation);
        statement.setLong(5, block);
        statement.setLong(6, location);
        statement.setInt(7, room);
        statement.setLong(8, occupant);
        statement.setLong(9, arrival);
        statement.setLong(10, departure);
        statement.setInt(11, status);
        statement.setString(12, remark);
        statement.setString(13, course);
        statement.setString(14, department);
        statement.setDouble(15, cost);
        statement.setString(16, refNumber);
        statement.setLong(17, clientId);

        statement.execute();
    }
    
    // method to return all clients as result set
    public ResultSet getAllClient () 
    {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT " + CLIENT.ID + " FROM " + CLIENT.TABLE_NAME,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet set = statement.executeQuery();
            return set;
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, e.getMessage());
            return null;
        }
    }
    
    // method to search for client using the constraints
    public ResultSet getClient (String name, String company, String address, 
            String course, String refNumber, int accomodation)
    {
        try {
            String query;
            query = "SELECT * FROM " + CLIENT.TABLE_NAME + " WHERE " + 
                    (!name.equals("") ?
                    CLIENT.NAME + " LIKE \'%" + name + "%\' AND " : "") +
                    (!company.equals("") ? 
                    CLIENT.COMPANY + " LIKE \'%" + company + "%\' AND " : "") +
                    (!address.equals("") ? 
                    CLIENT.ADDRESS + " LIKE \'%" + address + "%\' AND " : "") +
                    (!course.equals("") ? 
                    CLIENT.COURSE_TITLE + " LIKE \'%" + course + "%\' AND " : "") +
                    (!refNumber.equals("") ? 
                    CLIENT.REF_NUMBER + " LIKE \'%" + refNumber + "%\' AND " : "") +
                    (accomodation > 0 ? 
                    CLIENT.ACCOMODATION_TYPE + " = " + accomodation : "");
            
            // remove lagging "AND"
            if (query.endsWith(" AND "))
                query = query.substring(0, query.lastIndexOf(" AND "));
            
            // remove the WHERE clause for empty search
            if (query.endsWith(" WHERE "))
                query = query.substring(0, query.lastIndexOf(" WHERE "));
            
            PreparedStatement statement = connection.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet set = statement.executeQuery();
            return set;
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, e.getMessage());
            return null;
        }
    }   
    
    // method to return the newly registered client id
    public long getNewlyRegisteredClientId ()
    {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT " + CLIENT.ID + " FROM " + CLIENT.TABLE_NAME,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery();
            result.last();
            return result.getLong(CLIENT.ID);
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, e.getMessage());
            return -1l;
        }
    }
    
    // method to return a client's profile by id
    public Client getClientById (long clientId)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM " + CLIENT.TABLE_NAME + " WHERE " +
                            CLIENT.ID + "=?",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setLong(1, clientId);
            
            // extract client's details from ResultSet
            ResultSet result = statement.executeQuery();
            result.first();
            
            Client searchedClient = new Client (
                    result.getLong(CLIENT.ID),
                    result.getString(CLIENT.NAME), 
                    result.getString(CLIENT.COMPANY),
                    result.getString(CLIENT.ADDRESS),
                    result.getLong(CLIENT.ACCOMODATION_TYPE),
                    result.getLong(CLIENT.BLOCK_NAME),
                    result.getLong(CLIENT.LOCATION), 
                    result.getInt(CLIENT.ROOM_NUMBER),
                    result.getLong(CLIENT.OCCUPANTS), 
                    result.getLong(CLIENT.ARRIVAL_DATE),
                    result.getLong(CLIENT.DEPARTURE_DATE),
                    result.getInt(CLIENT.STATUS), 
                    result.getString(CLIENT.REMARK),
                    result.getString(CLIENT.COURSE_TITLE),
                    result.getString(CLIENT.DEPARTMENT), 
                    result.getDouble(CLIENT.COST),
                    result.getString(CLIENT.REF_NUMBER));
            return searchedClient;
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, e.getMessage());
        }
        return null;
    }
    
    // METHOD TO DELETE A CLIENT RECORD
    public boolean deleteClient (long clientId)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM " + CLIENT.TABLE_NAME + 
                            " WHERE " + CLIENT.ID + "=?");
            statement.setLong(1, clientId);
            statement.execute();
            return true;
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, "DATABASE ERROR", e.getMessage());
        }
        return false;
    }
    
    /**
     * The following are the methods that are used by the 
     * setting database. The settings are the block name, accomodation type, 
     * location and so on.
     * They look very similiar in database structure so they are grouped under
     * the same operations but are separated by names- represented with integers
     * 
     * @param setting
     * @param name
     * @throws SQLException 
     */
    // method to insert into the setting tables
    public void createNewSettingName (int setting, String name)
            throws SQLException
    {
        // define the current setting
        String settingTable;
        String variableName;
        
        // determine the operation based on setting
        switch (setting)
        {
            case 0: default: // ACCOMODATION
                settingTable = ACCOMODATION_TYPE.TABLE_NAME;
                variableName = ACCOMODATION_TYPE.NAME;
                break;
            case 1: // BLOCK_TYPE
                settingTable = BLOCK_NAME.TABLE_NAME;
                variableName = BLOCK_NAME.NAME;
                break;
            case 2: // LOCATION
                settingTable = LOCATION.TABLE_NAME;
                variableName = LOCATION.NAME;
                break;
            case 3: // OCCUPANT
                settingTable = OCCUPANT.TABLE_NAME;
                variableName = OCCUPANT.NAME;
                break;
        }
        
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + settingTable + "(" + variableName + ")" +
                " VALUES (?)");
        statement.setString(1, name);
        statement.execute();
    }
    
    // method to return settings values as array
    public SettingsVariable [] getSettings (int setting)
    {
        // define the current setting
        String settingTable;
        String variableName;
        String variableId;
        SettingsVariable [] variables = null;
        
        // determine the operation based on setting and insert variables
        try 
        {
            switch (setting)
            {
                case 0: // ACCOMODATION
                    settingTable = ACCOMODATION_TYPE.TABLE_NAME;
                    variableName = ACCOMODATION_TYPE.NAME;
                    variableId = ACCOMODATION_TYPE.ID;
                    break;
                case 1: // BLOCK_TYPE
                    settingTable = BLOCK_NAME.TABLE_NAME;
                    variableName = BLOCK_NAME.NAME;
                    variableId = BLOCK_NAME.ID;
                    break;
                case 2: // LOCATION
                    settingTable = LOCATION.TABLE_NAME;
                    variableName = LOCATION.NAME;
                    variableId = LOCATION.ID;
                    break;
                case 3: // OCCUPANT
                    settingTable = OCCUPANT.TABLE_NAME;
                    variableName = OCCUPANT.NAME;
                    variableId = OCCUPANT.ID;
                    break;
                case 4: // FRONT PAGE
                    settingTable = FRONT_PAGE.TABLE_NAME;
                    variableName = FRONT_PAGE.NAME;
                    variableId = FRONT_PAGE.ID;
                    break;
                default:
                    throw new SQLException ("Setting variable " + setting + "is not"
                            + " available.");
            }
                
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM " + settingTable,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery();

            // instantiate variables
            result.last();
            int number = result.getRow();
            variables = new SettingsVariable [number];

            // instantiate elements in varibles
            result.first();
            for (int i = 0; i < number; ++i) {
                variables [i] = new SettingsVariable (
                    result.getLong(variableId),
                    result.getString(variableName));
                result.next();
            }
            
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, "DATABASE ERROR", e.getMessage());
        }
        
        // the default return
        return variables;
    }
    
    // method to return setting variable as an object
    public SettingsVariable getSettingObjectById (int field, long id)
    {
        try {
            return new SettingsVariable (id, getSettingNameById(field, id));
        } catch (Exception e) {
            return null;
        }
    }
    
    // method to return the name of a particular setting known by id
    public String getSettingNameById (int field, long id) 
    {
        String tableName = "";
        String columnId = "";
        String columnName = "";
        
        try {
            // decide on the table
            switch (field) {
                case 0: // ACCOMODATION
                    tableName = ACCOMODATION_TYPE.TABLE_NAME;
                    columnId = ACCOMODATION_TYPE.ID;
                    columnName = ACCOMODATION_TYPE.NAME;
                    break;
                case 1: // BLOCK
                    tableName = BLOCK_NAME.TABLE_NAME;
                    columnId = BLOCK_NAME.ID;
                    columnName = BLOCK_NAME.NAME;
                    break;
                case 2: // LOCATION
                    tableName = LOCATION.TABLE_NAME;
                    columnId = LOCATION.ID;
                    columnName = LOCATION.NAME;
                    break;
                case 3: // OCCUPANT
                    tableName = OCCUPANT.TABLE_NAME;
                    columnId = OCCUPANT.ID;
                    columnName = OCCUPANT.NAME;
                    break;
                case 4: // FRONT_PAGE
                    tableName = FRONT_PAGE.TABLE_NAME;
                    columnId = FRONT_PAGE.ID;
                    columnName = FRONT_PAGE.NAME;
                    break;
                default:
            }
            
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT " + columnName + " FROM " + tableName + 
                            " WHERE " + columnId + "=?",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            set.first();
            return set.getString(columnName);
            
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, "DATABASE ERROR", e.getMessage());
        }
        return null;
    }
    
    /**
     * This method deletes a setting variable from the database
     * @param field The Parameter Setting Type
     * @param id The setting variable
     * @throws java.sql.SQLException 
     */
    public void deleteSettingsVariable (int field, long id)
            throws SQLException
    {
        // the variables
        String tableName = "";
        String columnId = "";
        
        // decide on the table
        switch (field) {
            case 0: // ACCOMODATION
                tableName = ACCOMODATION_TYPE.TABLE_NAME;
                columnId = ACCOMODATION_TYPE.ID;
                break;
            case 1: // BLOCK
                tableName = BLOCK_NAME.TABLE_NAME;
                columnId = BLOCK_NAME.ID;
                break;
            case 2: // LOCATION
                tableName = LOCATION.TABLE_NAME;
                columnId = LOCATION.ID;
                break;
            case 3: // OCCUPANT
                tableName = OCCUPANT.TABLE_NAME;
                columnId = OCCUPANT.ID;
                break;
            default:
        }

        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM " + tableName + " WHERE " + columnId + "=?");
        statement.setLong(1, id);
        statement.execute();
    }
    
    // METHOD TO MODIFY SETTINGS VARIABLE
    public void modifySettingsVariable (long id, int field, String name) 
            throws SQLException
    {
        String tableName = "";
        String columnId = "";
        String columnName = "";
        
        // decide on the table
        switch (field) {
            case 0: // ACCOMODATION
                tableName = ACCOMODATION_TYPE.TABLE_NAME;
                columnId = ACCOMODATION_TYPE.ID;
                columnName = ACCOMODATION_TYPE.NAME;
                break;
            case 1: // BLOCK
                tableName = BLOCK_NAME.TABLE_NAME;
                columnId = BLOCK_NAME.ID;
                columnName = BLOCK_NAME.NAME;
                break;
            case 2: // LOCATION
                tableName = LOCATION.TABLE_NAME;
                columnId = LOCATION.ID;
                columnName = LOCATION.NAME;
                break;
            case 3: // OCCUPANT
                tableName = OCCUPANT.TABLE_NAME;
                columnId = OCCUPANT.ID;
                columnName = OCCUPANT.NAME;
                break;
            case 4: // FRONT PAGE DISPLAY
                tableName = FRONT_PAGE.TABLE_NAME;
                columnId = FRONT_PAGE.ID;
                columnName = FRONT_PAGE.NAME;
                break;
            default:
        }

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + tableName + 
                    " SET " + columnName + " =? " +
                    " WHERE " + columnId + " =?");
        statement.setString(1, name);
        statement.setLong(2, id);
        statement.execute();
    }
    
    /**
     * This method creates a new Event
     * @param date
     * @param message
     * @throws SQLException 
     */
    public void createEvent (long date, String message) throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement (
                "INSERT INTO " + ASCON_EVENT.TABLE_NAME + 
                        "(" + ASCON_EVENT.DATE + ", " + ASCON_EVENT.MESSAGE + ")" +
                        " VALUES (?, ?)");
        statement.setLong(1, date);
        statement.setString(2, message);
        statement.execute();
    }
    
    /**
     * This method returns an arrayList of all the events in the database
     * @return
     * @throws SQLException 
     */
    public java.util.ArrayList<ASCONEvent> getEvents () throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM " + ASCON_EVENT.TABLE_NAME);
        ResultSet result = statement.executeQuery();
        
        java.util.ArrayList<ASCONEvent> events = new java.util.ArrayList<>();
        while (result.next())
            events.add(new ASCONEvent (
                result.getLong(ASCON_EVENT.ID),
                result.getLong(ASCON_EVENT.DATE),
                result.getString(ASCON_EVENT.MESSAGE)));

        return events;
    }
    
    // METHOD TO UPDATE AN EVENT
    public void updateEvent (long id, long date, String message)
            throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(
            "UPDATE " + ASCON_EVENT.TABLE_NAME +
                " SET " + 
                    ASCON_EVENT.MESSAGE + "=?," +
                    ASCON_EVENT.DATE + "=?" + 
                " WHERE " + ASCON_EVENT.ID + "=?");
        statement.setString(1, message);
        statement.setLong(2, date);
        statement.setLong(3, id);
        statement.execute();
    }
    
    // METHOD TO RETURN AN EVENT
    public ASCONEvent getEventById (long id)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM " + ASCON_EVENT.TABLE_NAME +
                            " WHERE " + ASCON_EVENT.ID + "=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            statement.setLong (1, id);
            
            ResultSet set = statement.executeQuery();
            set.first();
            
            ASCONEvent event = new ASCONEvent (
                set.getLong(ASCON_EVENT.ID),
                set.getLong(ASCON_EVENT.DATE),
                set.getString(ASCON_EVENT.MESSAGE));
            return event;
        } catch (SQLException e) {
            ErrorMessageDialog.show(parent, "DATABASE ERROR " + id, e.getMessage ());
            return null;
        }
    }
    
    // METHOD TO DELETE AN EVENT
    public void deleteEvent (long id) throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM " + ASCON_EVENT.TABLE_NAME + 
                        " WHERE " + ASCON_EVENT.ID + "=?");
        statement.setLong(1, id);
        statement.execute();
    }
}