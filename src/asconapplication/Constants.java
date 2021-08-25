package asconapplication;

public interface Constants {
    // DATABASE VARIABLES
    public final String DATABASE_URL = "jdbc:derby:ascon";
    public final String DATABASE_USER = "ascon";
    public final String DATABASE_PASSWORD = "ascon";
    public final int YEAR_START = 1960;
    public final String CURRENCY = "naira";
    
    // CLIENT STATUS VARIABLES
    public final class STATUS {
        public static int AVAILABLE = 1;
        public static int NOT_AVAILABLE = 0;
    }
    
    // SETTING VARIABLES
    public final class SETTING {
        public static int ACCOMODATION = 0;
        public static int BLOCK_NAME = 1;
        public static int LOCATION = 2;
        public static int OCCUPANT = 3;
        public static int FRONT_PAGE = 4;
    }
    
    // HOME PAGE- ACTION CONTROLLER VARIABLES
    public final class ACTION_CONTROLLER {
        public static int HOME_PAGE = 0;
        public static int REGRISTRATION_PAGE = 1;
        public static int CLIENT_PAGE = 2;
        public static int SETTINGS_PAGE = 3;
        public static int CLIENT_EDIT_PAGE = 4;
        public static int CLIENT_PRINT_VIEW = 5;
    }
    
    // VARIABLE USED FOR CLIENT TABLE
    public final class CLIENT {
        public static String TABLE_NAME = "client_table";
        public static String ID = "client_id";
        public static String NAME = "client_name";
        public static String COMPANY = "client_company";
        public static String ADDRESS = "client_address";
        public static String ACCOMODATION_TYPE = "accomodation_type";
        public static String BLOCK_NAME = "block_name";
        public static String LOCATION = "client_location";
        public static String ROOM_NUMBER = "client_room_number";
        public static String OCCUPANTS = "occupants";
        public static String ARRIVAL_DATE = "client_arrival_date";
        public static String DEPARTURE_DATE = "client_departure_date";
        public static String STATUS = "client_status";
        public static String REMARK = "remark";
        public static String COURSE_TITLE = "course_title";
        public static String DEPARTMENT = "department";
        public static String COST = "program_cost";
        public static String REF_NUMBER = "reference_number";
    }
    
    // VARIABLES FOR ACCOMODATION TYPE
    public final class ACCOMODATION_TYPE {
        public static String TABLE_NAME = "accomodation_table";
        public static String ID = "accomodation_id";
        public static String NAME = "accomodation_name";
    }
    
    // VARIABLES FOR BLOCK NAME
    public final class BLOCK_NAME {
        public static String TABLE_NAME = "block_name_table";
        public static String ID = "block_id";
        public static String NAME = "block_name";
    }
    
    // VARIABLES FOR LOCATION
    public final class LOCATION {
        public static String TABLE_NAME = "location_table";
        public static String ID = "location_id";
        public static String NAME = "location_name";
    }
    
    // VARIABLES FOR OCCUPANT
    public final class OCCUPANT {
        public static String TABLE_NAME = "occupant_table";
        public static String ID = "occupant_id";
        public static String NAME = "occupant_name";
    }
    
    // FRONT PAGE VARIABLES
    public final class FRONT_PAGE {
        public static String TABLE_NAME = "front_page_table";
        public static String ID = "front_page_id";
        public static String NAME = "front_page_name";
    }
    
    // EVENT VARIABLES
    public final class ASCON_EVENT {
        public static String TABLE_NAME = "ascon_event_table";
        public static String ID = "ascon_event_id";
        public static String DATE = "ascon_event_date";
        public static String MESSAGE = "ascon_event_message";
    }
}