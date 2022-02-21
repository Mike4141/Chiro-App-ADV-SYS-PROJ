
package business;
import java.sql.*;

public class AppointmentBO {
    
    AppointmentList alist = new AppointmentList();
    private String custID, chiroID, day, timeIn, timeOut;
    
    public AppointmentBO() {
        custID = ""; 
        chiroID = "";
        day = "";
        timeIn = "";
        timeOut = "";
    }
    
    public AppointmentBO(String CustomerId, String ChiroID, String Day, String TimeIn, String TimeOut) {
        custID = CustomerId;
        chiroID = ChiroID;
        day = Day;
        timeIn = TimeIn;
        timeOut = TimeOut;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getChiroID() {
        return chiroID;
    }

    public void setChiroID(String chiroID) {
        this.chiroID = chiroID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
    
    /********************************
    SelectDB method chooses an object based on the customer id passed to it
    ********************************/
    
    
    public void selectDB(String i) {
        custID = i;
        try {
                String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
                Connection con = DriverManager.getConnection(databaseURL) ;
                System.out.println("first step db connection");
                Statement stmt = con.createStatement();
                ResultSet rs;
                System.out.println("DB Connected");
                String sql = "select * from Appointments where CustID ='"+i+"'";
                System.out.println(sql);
                rs = stmt.executeQuery(sql);
                rs.next();
                setCustID(rs.getString(1));
                setChiroID(rs.getString(2));
                setDay(rs.getString(3));
                setTimeIn(rs.getString(4));
                setTimeOut(rs.getString(5));
                
                
            }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    /***************************************
     * insert db adds a new appointment to the database 
     ***********************************88*/
    
    
    public void insertDB(String cusId, String chiroId, String dayNum, String timeIN , String timeOUT ) {
        custID = cusId;
        chiroID = chiroId;
        day = dayNum;
        timeIn = timeIN;
        timeOut = timeOUT;
        
        try {
            String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("first step db connection");
            Statement stmt = con.createStatement();
            ResultSet rs;
            System.out.println("DB Connected");
            String sql = "Insert into Appointments values('"+getCustID()+"',"+ 
                                                      "'"+getChiroID()+"',"+ 
                                                      "'"+getDay()+"',"+
                                                      "'"+getTimeIn()+"',"+
                                                      "'"+getTimeOut()+"')";
            System.out.println(sql);
            stmt.execute(sql);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    /************************************
    update allows the appointment data to be changed 
    **************************************/
    
    public void updateDB() {
        
        try {
            String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("Update Connected Connected");
            Statement stmt = con.createStatement();
            String sql = "update Appointments set CustID = '"+getCustID() + "',"+ 
                                            " ChiroID ='"+getChiroID()+"',"+
                                            " Day ='"+getDay()+"',"+  
                                            " TimeIn='"+getTimeIn()+"',"+
                                            " TimeOut = '"+getTimeOut()+ "'" +
                                            " WHERE CustID='"+getCustID()+"'";                                        
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
    /****************************
    removes an appointment from the database
    *****************************/
    
    public void deleteBO() {
        try {                       
            String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("Delete Connected");
            Statement stmt = con.createStatement();
            String sql = "Delete from Appointments where CustID='"+getCustID()+"'";
            stmt.execute(sql);
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    public void display() {
        System.out.println("Customer ID :                       "+ getCustID());
        System.out.println("Chiropractor ID :                   "+ getChiroID());
        System.out.println("Date :                              "+ getDay());
        System.out.println("Time In :                           "+ getTimeIn());
        System.out.println("Time Out :                          "+ getTimeOut());
        alist.displayList();
        System.out.println("========================================================");

    }
    
    @Override
    public String toString() {
        return ("Customer ID :                       "+this.getCustID()+"\n"+"Chiropractor ID :                   "+this.getChiroID()+"\n"+"Date :                              "+this.getDay()
                +"\n"+"Time In :                           "+this.getTimeIn()+"\n"+"Time Out :                          "+this.getTimeOut()+"\n"+"===============================================");
    }
    
    public void getAppointments(String custId) {
        custID = custId;
        String an;
        AppointmentBO a1; 
        
        try { 
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb") ;
                System.out.println("First DB Step con");
                Statement stmt = con.createStatement();
                ResultSet rs;
                System.out.println("DB Connected");
                String sql = "select * from Appointments";
                System.out.println(sql);
                rs = stmt.executeQuery(sql);
                while(rs.next()) {
                    an = rs.getString(1);
                    a1 = new AppointmentBO();
                    a1.selectDB(an);
                    if(rs.getString(1).equals(custId)){
                       alist.addPatient(a1); 
                    }
                    
                    
                }
                System.out.println(alist);
        
         }
         catch(Exception e){
             System.out.println(e);
         }
    }
    
    
    
    
    public static void main(String[] args) { 
        
        AppointmentBO a2 = new AppointmentBO();
        a2.selectDB("3001");
        a2.display();  
        /*        AppointmentBO a2 = new AppointmentBO();
        a2.insertDB("3300", "2001", "1/14/2022", "2:00", "3:00");
        a2.display();
        
        AppointmentBO a3 = new AppointmentBO();
        a3.selectDB("3300");
        a3.updateDB();
        
        AppointmentList list = new AppointmentList();
        AppointmentBO a1 = new AppointmentBO("3003", "2001", "4/4/2022", "1:00", "2:00");
        AppointmentBO a2 = new AppointmentBO("3003", "2001", "4/8/2022", "1:00", "2:00");
        AppointmentBO a3 = new AppointmentBO("3003", "2001", "4/12/2022", "1:00", "2:00");
        AppointmentBO a4 = new AppointmentBO("3003", "2001", "4/21/2022", "1:00", "2:00");
        list.addPatient(a1);
        list.addPatient(a2);
        list.addPatient(a3);
        list.addPatient(a4);
        list.displayList();
        */
        
        AppointmentBO a1 = new AppointmentBO();
        a1.selectDB("3001");
        a1.getAppointments("3001");
        a1.display();
        
        
    }
    
}
