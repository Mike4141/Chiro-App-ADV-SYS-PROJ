
package systemsproject;

import java.sql.*;
import javafx.beans.property.*;

/********************************************************
 Victor Bula
 Advance Systems Project
 ********************************************************/

public class ScheduleBO {
    
    // =================== PROPERTIES ===================
    
    // Define properties
    private StringProperty _chiroId = new SimpleStringProperty();
    private StringProperty _day = new SimpleStringProperty();
    private StringProperty _timeIn = new SimpleStringProperty();
    private StringProperty _timeOut = new SimpleStringProperty();

    // Define getters for the property values
    public String getChiroId(){return _chiroId.get();}
    public String getDay(){return _day.get();}
    public String getTimeIn(){ return _timeIn.get(); }
    public String getTimeOut(){ return _timeOut.get(); }
    
    // Define setters for the property values
    public void setChiroId(String value){ _chiroId.set(value); }
    public void setDay(String value){ _day.set(value); }
    public void setTimeIn(String value){ _timeIn.set(value); }
    public void setTimeOut(String value){ _timeOut.set(value); }

    // Define getters for properties themselves
    public StringProperty chiroIdProperty(){ return _chiroId; }
    public StringProperty dayProperty(){ return _day; }
    public StringProperty timeInProperty(){ return _timeIn; }
    public StringProperty timeOutProperty(){ return _timeOut; }      
    
    
    
    // =================== CONSTRUCTORS ===================
    
    // Constructor. Clear
    public ScheduleBO()
    {
        chiroIdProperty().set("");
        dayProperty().set("");
        timeInProperty().set("");
        timeOutProperty().set("");
    }

    
    // Constructor. Assign
    public ScheduleBO(String chiroId, String day, String timeIn, String timeOut)
    {
        chiroIdProperty().set(chiroId);
        dayProperty().set(day);
        timeInProperty().set(timeIn);
        timeOutProperty().set(timeOut);
    }
        
    
    
    // =================== METHODS ===================
    
    // Print Method
    public void display() 
    {
        System.out.println("Chiropractor ID :                   "+ getChiroId());
        System.out.println("Day of the Week :                   "+ getDay());
        System.out.println("Start Time      :                   "+ getTimeIn());
        System.out.println("End Time        :                   "+ getTimeOut());
        System.out.println("========================================================");
    } // end of Print Method
    
    
    
        // Database Select Method
    public void selectDB(String chiroId, String day)
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
            sql = "select * from Schedule where ChiroID = '" + chiroId + "' AND Day = '" + day + "'";          
            System.out.println(sql);                        
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            //Step 5: Process Data
            while (rs.next()) // check cursor position
            {
            setChiroId(rs.getString(4)); // Chiropractor ID
            setDay(rs.getString(1));     // Day of the Week
            setTimeIn(rs.getString(2));  // Start Time
            setTimeOut(rs.getString(3)); // End Time
            }
            
            //Step 6: Close Connection
            con.close();            
            
        } // end of try block
        
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
    } // end of Select Shift Method
    
    
    
    // Database Method. Insert Shift
    public void insertDB(String chiroId, String day, String timeIn, String timeOut)
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
            sql = "INSERT into Schedule values(" + "'" + chiroId + "'," + // Chiropractor ID
                                                   "'" + day  + "'," +    // Day of the Week
                                                   "'" + timeIn + "'," +  // Start Time
                                                   "'" + timeOut + "'"    // End Time                                          
                                                 + ")";     
            //"'CAST('" + day + "' AS DATETIME)'," +  
            System.out.println(sql);

            //Step 5: Process Data
            int n = stmt.executeUpdate(sql);               
            if (n == 1)
            {    
                System.out.println("-INSERT SUCCEEDED-");
            }
            else
            {
                System.out.println("-INSERT FAILED-");
            }
            
            //Step 6: Close Connection
            con.close();
            
        } // end of try block
        
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
    } // end of Insert Shift Method    
    
    
    // Database Method. Delete Shift
    public void deleteDB()
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
            sql = "Delete from Schedule where ChiroID = '" + getChiroId() + "' AND Day = '" + getDay() + "'";           
            System.out.println(sql);                        

            //Step 5: Process Data
            int n = stmt.executeUpdate(sql);               
            if (n == 1)
            {
                System.out.println("-DELETE SUCCEEDED-");
            }
            else
            {
                System.out.println("-DELETE FAILED-");
            }
            
            //Step 6: Close Connection
            con.close();
            
        } // end of try block
        
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
    } // end of Delete Shift Method
    
    
    
    // Database Method. Update Shift
    /*
       DUE TO THE FACT THAT THIS TABLE (Schedule) DOESN'T 
       HAVE A PRIMARY KEY (ALL VALUES MUST REPEAT, OR BE ABLE
       TO REPEAT AS SOME POINT), SQL UPDATE COMMAND CAN AND
       DOES LEAVE DUPLICATE ENTRIES. THE BETTER ALTERNATIVE 
       FOR NOW WOULD BE TO SIMPLY USE A COMBINATION OF DELETE 
       AND INSERT SQL COMMANDS.   
    */ 
    
    
    // Main Method
    public static void main(String[] args) 
    {
        ScheduleBO sched = new ScheduleBO(); // schedule object     
        //sched.insertDB("2000", "20220115", "6.5", "14.5"); // insert        
        sched.selectDB("2003", "2022-01-12 00:00:00.000000"); // select
        sched.deleteDB(); // delete (selected)       
        
        /*
        INSERT FUNCTION IS THROWING A FORMAT RELATED ERRORS
        FOR DATE/TIME VIA JDBC DRIVER. STILL WORKING ON THIS
        */
    } // end of Main MEthod
    
}
