package systemsproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*****************
 *Jefferson Behrens
 *CustAccts
 *Systems Project
 */
public class Customer {
   
/*****************
 *Creating all the Business
 * Objects with their 
 * get and set methods.
 */
    
    private String CustID, CustPW, CustZip;
    private String CustFN, CustLN, CustEmail;
    private String CustAddr, CustCity, CustState;
    private String CustPhone;
    
public Customer() {
        CustID = "";
        CustPW = "";
        CustPhone = "";
        CustFN = "";
        CustLN = "";
        CustAddr = "";
        CustCity="";
        CustZip = "";
        CustCity = "";
        CustState = "";
        CustEmail = "";
    }
    public Customer(String id, String pw, String fn, String ln, String addr, String city, String zip, String state, String phone, String email) {
        CustID = id;
        CustPW = pw;
        CustPhone = phone;
        CustFN = fn;
        CustLN = ln;
        CustAddr = addr;
        CustZip = zip;
        CustCity= city;
        CustState=state;
        CustEmail = email;
    }
    
    public void setCustID(String id) {CustID=id;}
    public String getCustID() {return CustID;}
    public void setCustPW(String pw) {CustPW=pw;}
    public String getCustPW() {return CustPW;}
    public void setCustPhone(String phone) {CustPhone=phone;}
    public String getCustPhone() {return CustPhone;}
    public void setCustFN(String fn) {CustFN=fn;}
    public String getCustFN() {return CustFN;}
    public void setCustLN(String ln) {CustLN=ln;}
    public String getCustLN() {return CustLN;}
    public void setCustAddr(String addr) {CustAddr=addr;}
    public String getCustAddr() {return CustAddr;}
    public void setCustZip(String zip) {CustZip=zip;}
    public String getCustZip() {return CustZip;}
    public void setCustCity(String city) {CustCity=city;}
    public String getCustCity() {return CustCity;}
    public void setCustState(String state) {CustState=state;}
    public String getCustState() {return CustState;}
    public void setCustEmail(String email) {CustEmail=email;}
    public String getCustEmail() {return CustEmail;}
    
    
 /*****************
 *This is where the sql code
 *begins with the main
 * select,insert,delete, and
 * update methods.
 */
    
    public void SelectDB(String id) {
        CustID = id;
    try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.accdb");
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
            String sql;
            sql = "select * from Customers where CustID = '" +getCustID()+"'";
            System.out.println(sql);
                ResultSet rs;
                rs = stmt.executeQuery(sql);
                rs.next();
                setCustID(rs.getString(1));
                setCustPW(rs.getString(2));
                setCustFN(rs.getString(3));
                setCustLN(rs.getString(4));
                setCustAddr(rs.getString(5));
                setCustZip(rs.getString(10));
                setCustCity(rs.getString(8));
                setCustState(rs.getString(9));
                setCustPhone(rs.getString(6));
                setCustEmail(rs.getString(7));
                con.close();
    }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    
    }
    
    
    public void insertDB(String id, String pw, String fn, String ln, String addr, String city, String zip, String state, String phone, String email) {
        CustID = id;
        CustPW = pw;
        CustPhone = phone;
        CustFN = fn;
        CustLN = ln;
        CustAddr = addr;
        CustZip = zip;
        CustCity= city;
        CustState=state;
        CustEmail = email;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.accdb");
            
            Statement stmt = con.createStatement();
            String sql = "Insert into Customers values('"+getCustID()+"',"+
                                                      "'"+getCustPW()+"',"+ 
                                                      "'"+getCustFN()+"',"+
                                                      "'"+getCustLN()+"',"+
                                                      "'"+getCustAddr()+"',"+
                                                      "'"+getCustCity()+"',"+
                                                      "'"+getCustZip()+"',"+
                                                      "'"+getCustState()+"',"+
                                                      "'"+getCustEmail()+"',"+
                                                        getCustPhone()+")"; 
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con.close();
        }
        catch(Exception e){
            System.out.println("Exception thrown here: " +e);
        }
    }
    
    public void deleteDB(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.accdb");
            
            Statement stmt = con.createStatement();
            String sql = "Delete from Customers where CustID='"+getCustID()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE Successful!!!");
            else
                System.out.println("DELETE FAILED***********");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void updateDB(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.accdb");
            
            Statement stmt = con.createStatement();
            String sql = "Update Customers set CustPW = '"+getCustPW() +"',"+
                                            " CustFN = '"+getCustFN()+"',"+
                                            " CustLN = '"+getCustLN()+"',"+
                                            " CustAddr = '"+getCustAddr()+"',"+
                                            " CustCity = '"+getCustCity()+"',"+
                                            " CustZip = '"+getCustZip()+"',"+
                                            " CustState = '"+getCustState()+"',"+
                                            " CustEmail = '"+getCustEmail()+"',"+
                                            " CustPhone = "+getCustPhone()+"'"+
                                            " where CustID= '"+getCustID()+"'";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            con.close();
        }
        catch(Exception e){
            System.out.println("Exception thrown here: " +e);
        }
    }
    
    public void display() {
        System.out.println("Customer ID               = " + getCustID());
        System.out.println("Customer Password         = " + getCustPW());
        System.out.println("Customer FirstName        = " + getCustFN());
        System.out.println("Customer LastName         = " + getCustLN());
        System.out.println("Customer Address          = " + getCustAddr());
        System.out.println("Customer Zipcode          = " + getCustZip());
        System.out.println("Customer City             = " + getCustCity());
        System.out.println("Customer State            = " + getCustState());
        System.out.println("Customer Phonenumber      = " + getCustPhone());
        System.out.println("Customer Email            = " + getCustEmail());
        System.out.println("=============================");
    }
    
 /*****************
 *Code below is to test
 * the sql statements 
 * and their validity.
 */
    public static void main(String[] args) {
        Customer  c1 = new Customer();
        c1.SelectDB("3000");
        c1.display();
        
        
    
    }
}
