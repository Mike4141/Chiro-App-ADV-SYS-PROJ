package business;

import java.sql.*;
import java.util.*;

/********************************************************
 Victor Bula
 Advance Systems Project
 ********************************************************/

public class AdminBO 
{    
    // =================== PROPERTIES ===================
    // arraylists
    private List<ChiroBO> chiroList = new ArrayList<ChiroBO>();      
    private List<ScheduleBO> schedule = new ArrayList<ScheduleBO>();
    // strings
    private String adminId, adminPass;
    
    
    // =================== CONSTRUCTORS ===================    
    // Empty
    public AdminBO()
    {
        adminId = "";
        adminPass = "";
    }    
    // Assign
    public AdminBO(String adminid, String adminpass)
    {
        adminId = adminid;
        adminPass = adminpass;
    }
    
    
    // =================== GET / SET METHODS ===================     
    public String getAdminId(){ return adminId; } // get customer id
    public void setAdminId(String value){ adminId = value; } // set customer id
    public String getAdminPass(){ return adminPass; } // get customer password
    public void setAdminPass(String value){ adminPass = value; } // set customer password
    
    
    // =================== PRINT METHODS ===================       
    //  Print. Chiropractor List
    public void printChiroList()
    {
        System.out.println("\n" + "======== Printing Chiro List...");
        for(ChiroBO chiro:chiroList)  
        chiro.display(); 
    }        
    //  Print. Schedule
    public void printSchedule()
    {   
        System.out.println("\n" + "======== Printing Schedule Shifts...");
        for(ScheduleBO shift:schedule)  
        shift.display(); 
    }    
    
    //  Print. Schedule
    public void printCredentials()
    {
        System.out.println("\n" + "======== Printing Credentials...");
        System.out.println("Admin ID = " + getAdminId());
        System.out.println("Admin Password = " + getAdminPass());
        System.out.println("====================");
    }    
    
    
    // =================== DATABASE METHODS =================== 
    // ------------------- get chiropractor list --------------------
    public void logChiroListDB()
    {
        try // try block
        {
            System.out.println("\n" + "======== Logging Chiro List...");
            
            //Step 1: Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded.");
            
            //Step 2: Get Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/victo/Desktop/Files/Spring2022/Advance Systems Project/DataBase/MariettaSpineClinicMDB.mdb");
            System.out.println("Connected.");
            
            //Step 3: Create Statement
            Statement stmt = con.createStatement();
            System.out.println("Statement Created.");
            
            //Step 4: Execute Statement
            String sql;            
            sql = "SELECT * FROM Chiropractors WHERE ChiroID IS NOT NULL";            
            System.out.println(sql);                        
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            System.out.println("Statement Executed.");
            
            //Step 5: Process Data
            while (rs.next()) // check cursor position
            {
            // create and assign Database values to new ChiroBO object             
            ChiroBO chiro = new ChiroBO(
                rs.getString(1), // ID 
                rs.getString(2), // Password
                rs.getString(3), // First Name
                rs.getString(4), // Last Name
                rs.getString(5), // Phone
                rs.getString(6)  // Email
                );

            // add ChiroBO object to object list
            chiroList.add(chiro);
            }
            System.out.println("Data Processed.");
            
            //Step 6: Close Connection
            con.close();   
            System.out.println("Connection Closed.");
            System.out.println("====================");
            
        } // end of try block // end of try block
        
        // multiple catch blocks
        catch (SQLException e)
        {
            System.out.println("SQL EXCEPTION: " + e);
            System.out.println("====================");
        }
        catch (ClassNotFoundException e)            
        {
            System.out.println("CLASS NOT FOUND EXCEPTION: " + e);
            System.out.println("====================");
        }
        catch (Exception e)            
        {
            System.out.println("EXCEPTION: " + e);
            System.out.println("====================");
        }
        // end of catch blocks
    } // end of get chiroprator list
        
    // ------------------- get schedule --------------------
    public void logScheduleDB()
    {
        try // try block
        {
            System.out.println("\n" + "======== Logging Schedule...");
                        
            //Step 1: Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded.");
            
            //Step 2: Get Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/victo/Desktop/Files/Spring2022/Advance Systems Project/DataBase/MariettaSpineClinicMDB.mdb");
            System.out.println("Connected.");
            
            //Step 3: Create Statement
            Statement stmt = con.createStatement();
            System.out.println("Statement Created.");
            
            //Step 4: Execute Statement
            String sql;            
            sql = "SELECT * FROM Schedule WHERE Day IS NOT NULL";            
            System.out.println(sql);                        
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            System.out.println("Statement Executed.");
            
            //Step 5: Process Data
            while (rs.next()) // check cursor position
            {
            // create and assign Database values to new ScheduleBO object             
            ScheduleBO shift = new ScheduleBO(
                rs.getString(4), // Chiropractor ID 
                rs.getString(1), // Day of the Week
                rs.getString(2), // Start Time 
                rs.getString(3)  // End Time
                );

            // add ScheduleBO object to object list
            schedule.add(shift);
            }
            System.out.println("Data Processed.");
            
            //Step 6: Close Connection
            con.close();  
            System.out.println("Connection Closed.");
            System.out.println("====================");
            
        } // end of try block // end of try block
        
        // multiple catch blocks
        catch (SQLException e)
        {
            System.out.println("SQL EXCEPTION: " + e);
            System.out.println("====================");
        }
        catch (ClassNotFoundException e)            
        {
            System.out.println("CLASS NOT FOUND EXCEPTION: " + e);
            System.out.println("====================");
        }
        catch (Exception e)            
        {
            System.out.println("EXCEPTION: " + e);
            System.out.println("====================");
        }
        // end of catch blocks
    } // end of Get Schedule   

// -------------------- select method --------------------
    public void selectDB(String id) 
    {
    try {
            System.out.println("\n" + "======== SELECTING...");
            
            // step 1. load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded.");
            
            // step 2. get connection 
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/victo/Desktop/Files/Spring2022/Advance Systems Project/DataBase/MariettaSpineClinicMDB.mdb");
            System.out.println("Connected.");
            
            // step 3. create statement
            Statement stmt = con.createStatement();
            System.out.println("Statement Created.");
            
            // step 4. execute statement
            String sql;
            sql = "SELECT * FROM Admins WHERE AdminID = '" + id + "'";
            System.out.println(sql);
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            System.out.println("Statement Executed.");
            
            // step 5. process data
            rs.next();
            setAdminId(rs.getString(1)); // set admin id 
            setAdminPass(rs.getString(2)); // set admin password
            System.out.println("-SELECT SUCCESS-");
            
            // step 6. close connection
            con.close(); 
            System.out.println("Connection Closed.");
            System.out.println("====================");
        }
        // multiple catch blocks
        catch (SQLException e)
        {
            System.out.println("SQL EXCEPTION: " + e);
            System.out.println("====================");
        }
        catch (ClassNotFoundException e)            
        {
            System.out.println("CLASS NOT FOUND EXCEPTION: " + e);
            System.out.println("====================");
        }
        catch (Exception e)            
        {
            System.out.println("EXCEPTION: " + e);
            System.out.println("====================");
        }
        // end of catch blocks    
    } // end of select method
            
    
    // ==================== Main Method ====================
    public static void main(String[] args)
    {        
        AdminBO admin = new AdminBO();
        
        // look up and print admin credentials
        admin.selectDB("Admin07");
        admin.printCredentials();
        
        // look up and print chiropractor list
        admin.logChiroListDB();
        admin.printChiroList();        

        // look up and print schedule shifts
        admin.logScheduleDB();
        admin.printSchedule();
    } // End of Main Method


} // End of class
