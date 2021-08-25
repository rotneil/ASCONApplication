/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectScripts;

/**
 *
 * @author Nehemiah Oluwafemi
 * rotenehe@gmail.com
 */
public final class ASCONEvent {
    // instance variables
    private long id;
    private long date;
    private String shortMessage;
    private String message;
    
    // constructor
    public ASCONEvent () {
        this (0l, 0l, "");
    }
    
    public ASCONEvent (long id, long date, String mssge)
    {
        setId (id);
        setDate (date);
        if (mssge.length() > 99)
            setShortMessage (mssge.substring(0, 100));
        else
            setShortMessage (mssge);
        setMessage (mssge);
    }
    
    // SET METHODS
    public void setId (long id) {this.id = id;}
    public void setDate (long date) {this.date = date;}
    public void setShortMessage (String mssg) {this.shortMessage = mssg;}
    public void setMessage (String mssg) {this.message = mssg;}
    
    // GET METHODS
    public long getId () {return this.id;}
    public long getDate () {return this.date;}
    public String getShortMesage () {return this.shortMessage;}
    public String getMessage () {return this.message;}
    
    @Override
    public String toString () {return this.getMessage();}
}
