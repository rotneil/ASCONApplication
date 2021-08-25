/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asconapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nehemiah Oluwafemi
 * rotenehe@gmail.com
 */
public class Installer implements Constants {
    public static void execute () throws SQLException
    {
        Connection con = DriverManager.getConnection(
                "jdbc:derby:ascon;create=true;user=ascon;password=ascon");
        
        // declare the statement within which the sequel commands are executed
        Statement statement = con.createStatement();
        
        // create the accomodation_table
        statement.execute("CREATE TABLE " + ACCOMODATION_TYPE.TABLE_NAME + " (" +
                ACCOMODATION_TYPE.ID + " INTEGER NOT NULL "
                    + "PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                    + "(START WITH 1, INCREMENT BY 1), " +
                ACCOMODATION_TYPE.NAME + " VARCHAR(100) NOT NULL)");
        
        // create the block name table
        statement.execute("CREATE TABLE " + BLOCK_NAME.TABLE_NAME + "(" +
                BLOCK_NAME.ID + " INTEGER NOT NULL PRIMARY KEY GENERATED " +
                    "ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                BLOCK_NAME.NAME + " VARCHAR(100) NOT NULL)");
        
        // create location table
        statement.execute("CREATE TABLE " + LOCATION.TABLE_NAME + " (" +
                LOCATION.ID + " INTEGER NOT NULL PRIMARY KEY GENERATED " +
                    "ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                LOCATION.NAME + " VARCHAR(100) NOT NULL)");
        
        // create the occupant_table
        statement.execute("CREATE TABLE " + OCCUPANT.TABLE_NAME + " (" +
                OCCUPANT.ID + " INTEGER NOT NULL "
                        + "PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                        + "(START WITH 1, INCREMENT BY 1), " +
                OCCUPANT.NAME + " VARCHAR(100) NOT NULL)");
        
        // create the client table
        statement.execute("CREATE TABLE " + CLIENT.TABLE_NAME + " (" +
                CLIENT.ID + " BIGINT NOT NULL "
                        + " PRIMARY KEY GENERATED ALWAYS AS IDENTITY"
                        + " (START WITH 1, INCREMENT BY 1)," +
                CLIENT.NAME + " VARCHAR(100) NOT NULL," +
                CLIENT.COMPANY + " VARCHAR(200) NOT NULL," +
                CLIENT.ADDRESS + " VARCHAR(200) NOT NULL," +
                CLIENT.ACCOMODATION_TYPE + " INTEGER NOT NULL," +
                CLIENT.BLOCK_NAME + " INTEGER NOT NULL," +
                CLIENT.LOCATION + " INTEGER NOT NULL," +
                CLIENT.ROOM_NUMBER + " INTEGER NOT NULL," +
                CLIENT.OCCUPANTS + " INTEGER NOT NULL," +
                CLIENT.ARRIVAL_DATE + " BIGINT NOT NULL," +
                CLIENT.DEPARTURE_DATE + " BIGINT NOT NULL," +
                CLIENT.STATUS + " INT NOT NULL," +
                CLIENT.REMARK + " VARCHAR(200) NOT NULL," +
                CLIENT.COURSE_TITLE + " VARCHAR(100) NOT NULL," +
                CLIENT.DEPARTMENT + " VARCHAR(100) NOT NULL," +
                CLIENT.COST + " REAL NOT NULL," +
                CLIENT.REF_NUMBER + " VARCHAR (20) NOT NULL, " + 
                
                "UNIQUE (" + CLIENT.REF_NUMBER + "), " +
                
                "FOREIGN KEY (" + CLIENT.ACCOMODATION_TYPE + ") REFERENCES " +
                ACCOMODATION_TYPE.TABLE_NAME + "(" + ACCOMODATION_TYPE.ID + "), " +
                
                "FOREIGN KEY (" + CLIENT.BLOCK_NAME + ") REFERENCES " + 
                BLOCK_NAME.TABLE_NAME + "(" + BLOCK_NAME.ID + "), " +
                
                "FOREIGN KEY (" + CLIENT.LOCATION + ") REFERENCES " +
                LOCATION.TABLE_NAME + "(" + LOCATION.ID + "), " +
                
                "FOREIGN KEY (" + CLIENT.OCCUPANTS + ") REFERENCES " +
                OCCUPANT.TABLE_NAME + "(" + OCCUPANT.ID + "))"
        );

        // create front_page table
        statement.execute("CREATE TABLE " + FRONT_PAGE.TABLE_NAME + " ( " +
                FRONT_PAGE.ID + " INTEGER NOT NULL "
                        + "PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                        + "(START WITH 1, INCREMENT BY 1), " +
                FRONT_PAGE.NAME + " VARCHAR(4000) NOT NULL)");
        
        // CREATE EVENT TABLE
        statement.execute("CREATE TABLE " + ASCON_EVENT.TABLE_NAME + " ( " +
                ASCON_EVENT.ID + " INTEGER NOT NULL "
                        + "PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                        + "(START WITH 1, INCREMENT BY 1), " +
                ASCON_EVENT.MESSAGE + " VARCHAR(2000) NOT NULL, " +
                ASCON_EVENT.DATE + " BIGINT NOT NULL)");
        
        // insert into tables
        statement.execute("INSERT INTO " + ACCOMODATION_TYPE.TABLE_NAME + "(" +
                ACCOMODATION_TYPE.NAME + ") VALUES ('CHALET'), ('SINGLE ROOM'), "
                + "('DOUBLE ROOM')");
        statement.execute("INSERT INTO " + BLOCK_NAME.TABLE_NAME + "(" +
                BLOCK_NAME.NAME + ") "
                + "VALUES ('DUPLEX'), ('OGUNDIPE'), ('BALOGUN'), "
                + "('ADELE JINADU'), ('SHIEHK ABUDULAHI'), ('15B'), ('15D'), "
                + "('16A'), ('16B'), ('17A')");
        statement.execute("INSERT INTO " + LOCATION.TABLE_NAME + " ("
                + LOCATION.NAME + ") VALUES "
                + "('PHASE 1'), ('PHASE 2')");
        statement.execute("INSERT INTO " + OCCUPANT.TABLE_NAME + "(" +
                OCCUPANT.NAME + ") VALUES "
                + "('STAFF'), ('PARTICIPANT'), ('FACILITY USER'), "
                + "('INDIVIDUAL'), ('OTHERS')");
        statement.execute("INSERT INTO " + FRONT_PAGE.TABLE_NAME + "(" +
                FRONT_PAGE.NAME + ") VALUES ('"
                + "The name of this application is ASCONApp which was developed to "
                + "assist the front desk personel to register clients and their details, "
                + "allocate them to their various residence, access details "
                + "of the client, search for a client, print of the payment "
                + "details and other activites that are associated with reception."
                + "\n\nASCONApp is a modular application with the top modules divided into "
                + "the functions that are required for efficient customer service"
                + " relation. The lists respond to click events, handle popups, "
                + "scrolling and are error proof. "
                + "\n\nAlthough ASCONApp is a front desk application but it has"
                + " capability of being deployed in an organizational intranet "
                + "as a Network based application where "
                + "different departments can login and have their private profile "
                + "in the System. The Network based ASCONApp would handle "
                + "Payroll, inventory, staff timers- among other things."
                + "\n\nASCONApp was developped by "
                + "Rotneil IT Consult for front desktop services of the "
                + "Administrative Staff College of Nigeria.')");
        
        statement.execute("INSERT INTO " + ASCON_EVENT.TABLE_NAME + "(" +
                ASCON_EVENT.DATE + ", " + ASCON_EVENT.MESSAGE + ") "
                + "VALUES (1457356283007, '"
                + "ASCON general staff meeting with the Director General of the"
                + "College comes up on the above mentioned date. All members "
                + "of the college are hereby encouraged and requested to be "
                + "available for this crucial meeting. Members should also "
                + "note that the promotion exercise that is sheduled to come "
                + "after the meeting is sequel on their performance before and "
                + "after the meeting.')");
        
        statement.execute("INSERT INTO " + ASCON_EVENT.TABLE_NAME + "("+ 
                ASCON_EVENT.DATE + ", " + ASCON_EVENT.MESSAGE + ")" 
                + "VALUES (1457356283007, '"
                + "ASCON general staff promotion exercise as directed by"
                + " the Director General of the "
                + "College comes up on the above mentioned date. All members "
                + "of the college are hereby encouraged and requested to be "
                + "available for this crucial meeting. Members should also "
                + "note that the promotion exercise that is sheduled to come "
                + "after the meeting is sequel on their performance before and "
                + "after the meeting.')");
        
        statement.execute("INSERT INTO " + ASCON_EVENT.TABLE_NAME + "("+ 
                ASCON_EVENT.DATE + ", " + ASCON_EVENT.MESSAGE + ")" 
                + "VALUES (1457356283007, '"
                + "ASCONApp upgrade to the recent version which will be Network "
                + "based."
                + "\n\nThe College has decided to replace the front desk "
                + "version of the ASCONApp software the the robust version of "
                + "it which enhance payrolling, staff management, paperless "
                + "community and proper documentation of the office files."
                + "\n\nTo this effect, the training of staffs will begin with "
                + "immediate effect. Management of each department should take "
                + "note and mandiate their secretaries to pertake in this "
                + "training exercise."
                + "\n\nThank you')");
        con.close();
    }
}
