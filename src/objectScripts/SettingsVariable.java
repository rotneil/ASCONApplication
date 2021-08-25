/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectScripts;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public final class SettingsVariable {
    private long id;
    private String name;
    
    // CONSTRUCTORS
    public SettingsVariable () {
        this (0l, "");
    }
    
    public SettingsVariable (long id, String name) {
        setSettingsId (id);
        setSettingsName (name);
    }
    
    // SET METHODS
    public void setSettingsId (long id) {
        this.id = id;
    }
    
    public void setSettingsName (String name) {
        this.name = name;
    }
    
    // GET METHODS
    public long getSettingsId () {return this.id;}
    public String getSettingsName () {return this.name;}
    public String toString () {return name;}
}
