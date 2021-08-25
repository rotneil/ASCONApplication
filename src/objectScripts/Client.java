/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectScripts;

import asconapplication.Constants;
import asconapplication.SchemaHelper;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Oluwafemi Nehemiah
 * @address rotenehe@gmail.com
 * 
 */
public final class Client implements Constants{
    // instance variables
    private long clientId;
    private String name;
    private String company;
    private String address;
    private long accomodation;
    private long block;
    private long location;
    private int roomNumber;
    private long occupant;
    private long arrivalDate;
    private long departureDate;
    private int status;
    private String remark;
    private String course;
    private String department;
    private double cost;
    private String refNumber;
    
    // PUBLIC fields
    public static int ID = 0;
    public static int NAME = 1;
    public static int COMPANY = 2;
    public static int ADDRESS = 3;
    public static int ACCOMODATION = 4;
    public static int BLOCK = 5;
    public static int LOCATION = 6;
    public static int ROOM_NUMBER = 7;
    public static int OCCUPANT = 8;
    public static int ARRIVAL_DATE = 9;
    public static int DEPARTURE_DATE = 10;
    public static int STATUS = 11;
    public static int REMARK = 12;
    public static int COURSE_TITLE = 13;
    public static int DEPARTMENT = 14;
    public static int COST = 15;
    public static int REFERENCE_NUMBER = 16;
    
    // no-argument constructor
    public Client () {}
    
    // constructor with all argument
    public Client (long clientId, String name, String company, String address,
            long accomodation, long block, long location, int roomNumber,
            long occupant, long arrivalDate, long departureDate, int status,
            String remark, String course, String department, double cost,
            String refNumber)
    {
        this.clientId = clientId;
        this.name = name;
        this.company = company;
        this.address = address;
        this.accomodation = accomodation;
        this.block = block;
        this.location = location;
        this.roomNumber = roomNumber;
        this.occupant = occupant;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.status = status;
        this.remark = remark;
        this.course = course;
        this.department = department;
        this.cost = cost;
        this.refNumber = refNumber;
    }
    
    // SET METHOD
    public void setClientAttribute (int field, String value)
    {
        switch (field) {
            case 0: // CLIENT_ID
                this.clientId = Long.parseLong(value);
                break;
            case 1: // NAME
                this.name = value;
                break;
            case 2: // COMPANY
                this.company = value;
                break;
            case 3: // ADDRESS
                this.address = value;
                break;
            case 4: // ACCOMODATION
                this.accomodation = Long.parseLong(value);
                break;
            case 5: // BLOCK
                this.block = Long.parseLong(value);
                break;
            case 6: // LOCATION
                this.location = Long.parseLong(value);
                break;
            case 7: // ROOM NUMBER
                this.roomNumber = Integer.parseInt(value);
                break;
            case 8: // OCCUPANT
                this.occupant = Long.parseLong(value);
                break;
            case 9: // ARRIVAL _ DATE
                this.arrivalDate = Long.parseLong(value);
                break;
            case 10:
                this.departureDate = Long.parseLong(value);
                break;
            case 11:
                this.status = Integer.parseInt(value);
                break;
            case 12:
                this.remark = value;
                break;
            case 13:
                this.course = value;
                break;
            case 14:
                this.department = value;
                break;
            case 15:
                this.cost = Double.parseDouble(value);
                break;
            case 16:
                this.refNumber = value;
                break;
            default:
        }
    }
    
    // GET METHODS
    public String getClientStringAttribute (SchemaHelper schema, int field)
    {
        // instantiate a date formater
        SimpleDateFormat f = new SimpleDateFormat ("dd MMMM, yyyy");
        
        switch (field) {
            case 0:
                return "" + Client.ID;
            case 1:
                return this.name;
            case 2:
                return this.company;
            case 3:
                return this.address;
            case 4:
                return schema.getSettingNameById(0, this.accomodation);
            case 5:
                return schema.getSettingNameById(1, this.block);
            case 6:
                return schema.getSettingNameById(2, this.location);
            case 7:
                return "" + this.roomNumber;
            case 8:
                return schema.getSettingNameById(3, occupant);
            case 9:
                return f.format(new Date (this.arrivalDate));
            case 10:
                return f.format(new Date (this.departureDate));
            case 11:
                return (status == 1 ? "AVAILABLE" : "NOT AVAILABLE");
            case 12:
                return this.remark;
            case 13:
                return this.course;
            case 14:
                return this.department;
            case 15: 
                return "" + this.cost;
            case 16:
                return this.refNumber;
                
            default:
                return "";
        }
    }
    
    public long getClientLongAttribute (int field)
    {
        switch (field) {
            case 0: // CLIENT ID
                return this.clientId;
            case 4: // ACCOMODATION
                return this.accomodation;
            case 5: // BLOCK
                return this.block;
            case 6: // LOCATION
                return this.location;
            case 8: // OCCUPANT
                return this.occupant;
            case 9: // ARRIVAL DATE
                return this.arrivalDate;
            case 10:    // DEPARTURE DATE
                return this.departureDate;
            default:
                return -1l;
        }
    }
    
    public int getClientIntegerAttribute (int field)
    {
        switch (field) {
            case 4:                 // ACCOMODATION
                return (int) this.accomodation;
            case 5:                 // BLOCK
                return (int) this.block;
            case 6:                 // LOCATION
                return (int) this.location;
            case 7:                 // ROOM NUMBER
                return this.roomNumber;
            case 8:                 // OCCUPANT
                return (int) this.occupant;
            case 11:                // availability
                return status;
            case 14:                // status
                return this.status;
            default:
                return -1;
        }
    }
    
    public SettingsVariable getClientSettingAttribute (SchemaHelper schema, int field)
    {
        switch (field) {
            case 4:
                return schema.getSettingObjectById(0, this.accomodation);
            case 5:
                return schema.getSettingObjectById(1, this.block);
            case 6:
                return schema.getSettingObjectById(2, this.location);
            case 8:
                return schema.getSettingObjectById(3, occupant);
            default:
                return null;
        }
    }
    
    public double getClientCost ()
    {
        return this.cost;
    }
    
    public String getClientName ()
    {
        return this.name;
    }
    
    @Override
    public String toString ()
    {
        return this.name;
    }
}
