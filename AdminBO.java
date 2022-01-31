
package systemsproject;

import java.sql.*;
import java.util.*;

/********************************************************
 Victor Bula
 Advance Systems Project
 ********************************************************/

public class AdminBO 
{    
    // =================== PROPERTIES ===================
    
    private List<ChiroBO> chiroList = new ArrayList<ChiroBO>();  
    
    private List<ScheduleBO> schedule = new ArrayList<ScheduleBO>();
    
    
    // =================== CONSTRUCTORS ===================
    
    // Constructor. Clear
    public AdminBO()
    {
        // place holder
    }

    
    // Constructor. Assign
    public AdminBO(String var1, String var2, String var3)
    {
        // place holder
    }
        
    
    // =================== METHODS ===================    
    
    //  Print Method. Chiropractor List Print
    public void printChiroList()
    {
        for(ChiroBO chiro:chiroList)  
        chiro.display(); 
    }    
    
    //  Print Method. Schedule Print
    public void printSchedule()
    {
        for(ScheduleBO shift:schedule)  
        shift.display(); 
    }    
    
    // Database Method. Get Chiropractor List
    public void getChiroListDB()
    {
        try // try block
        {
            //Step 1: Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            //Step 2: Get Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users/csywa/Desktop/AdvanceSystemsProj/MariettaSpineClinicMDB.mdb/");
            
            //Step 3: Create Statement
            Statement stmt = con.createStatement();
            
            //Step 4: Execute Statement
            String sql;            
            sql = "Select * from Chiropractors where ChiroID = ALL(Select ChiroID from Chiropractors where ChiroID != NULL)";            
            System.out.println(sql);                        
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
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
            
            //Step 6: Close Connection
            con.close();            
            
        } // end of try block // end of try block
        
        // multiple catch blocks
        catch (SQLException e)
        {
            System.out.println("SQL EXCEPTION: " + e);
        }
        catch (ClassNotFoundException e)            
        {
            System.out.println("CLASS NOT FOUND EXCEPTION: " + e);
        }
        catch (Exception e)            
        {
            System.out.println("EXCEPTION: " + e);
        }
        // end of catch blocks
    } // end of Get Chiropractor List
    
    
        
     // Database Method. Get Schedule
    public void getScheduleDB()
    {
        try // try block
        {
            //Step 1: Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            //Step 2: Get Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/victo/Desktop/Files/Spring2022/Advance Systems Project/DataBase/MariettaSpineClinicMDB.mdb");
            
            //Step 3: Create Statement
            Statement stmt = con.createStatement();
            
            //Step 4: Execute Statement
            String sql;            
            sql = "Select * from Schedule where Day = ALL(Select Day from Schedule where Day != NULL)";            
            System.out.println(sql);                        
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
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
            
            //Step 6: Close Connection
            con.close();            
            
        } // end of try block // end of try block
        
        // multiple catch blocks
        catch (SQLException e)
        {
            System.out.println("SQL EXCEPTION: " + e);
        }
        catch (ClassNotFoundException e)            
        {
            System.out.println("CLASS NOT FOUND EXCEPTION: " + e);
        }
        catch (Exception e)            
        {
            System.out.println("EXCEPTION: " + e);
        }
        // end of catch blocks
    } // end of Get Schedule
    
        
        
    
    // Main Method
    public static void main(String[] args)
    {
        AdminBO admin = new AdminBO();
        admin.getChiroListDB();
        admin.printChiroList();
        

        admin.getScheduleDB();
        admin.printSchedule();
    } // End of Main Method


} // End of class
