package business;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*****************
 *Jefferson Behrens
 *CustAccts
 *Systems Project
 */
public class CustomerBO {
   
/*****************
 *Creating all the Business
 * Objects with their 
 * get and set methods.
 */
    
    private String CustID, CustPW;
    private String CustFN, CustLN, CustEmail;
    private String CustAddr;
    private String CustPhone;
    
public CustomerBO() {
        CustID = "";
        CustPW = "";
        CustPhone = "";
        CustFN = "";
        CustLN = "";
        CustAddr = "";
        CustEmail = "";
    }
    public CustomerBO(String id, String pw, String fn, String ln, String addr, String phone, String email) {
        CustID = id;
        CustPW = pw;
        CustPhone = phone;
        CustFN = fn;
        CustLN = ln;
        CustAddr = addr;
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
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/victo/Desktop/Files/Spring2022/Advance Systems Project/DataBase/MariettaSpineClinicMDB.mdb");
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
                setCustPhone(rs.getString(7));
                setCustEmail(rs.getString(6));
                
                con.close();
    }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    
    }
    
    
    public void insertDB(String id, String pw, String fn, String ln, String addr, String phone, String email) {
        CustID = id;
        CustPW = pw;
        CustPhone = phone;
        CustFN = fn;
        CustLN = ln;
        CustAddr = addr;
        CustEmail = email;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.mdb");
            
            Statement stmt = con.createStatement();
            String sql = "Insert into Customers values('"+getCustID()+"',"+
                                                      "'"+getCustPW()+"',"+ 
                                                      "'"+getCustFN()+"',"+
                                                      "'"+getCustLN()+"',"+
                                                      "'"+getCustAddr()+"',"+
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
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.mdb");
            
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
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.mdb");
            
            Statement stmt = con.createStatement();
            String sql = "Update Customers set CustPW = '"+getCustPW() +"',"+
                                            " CustFN = '"+getCustFN()+"',"+
                                            " CustLN = '"+getCustLN()+"',"+
                                            " CustAddr = '"+getCustAddr()+"',"+
                                            " CustEmail = '"+getCustEmail()+"',"+
                                            " CustPhone = "+getCustPhone()+""+
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
        CustomerBO  c1 = new CustomerBO();
        c1.SelectDB("3000");
        c1.display();
        
        /*CustomerBO c2 = new CustomerBO();
        c2.insertDB("3010", "1229", "Jeff", "B", "121 Harbor Street", "6782222222", "jeffbehrens@gmail.com");
        c2.display();
        */
        
        CustomerBO c3 = new CustomerBO();
        c3.SelectDB("3010");
        c3.deleteDB();
        
        /*CustomerBO c4 = new CustomerBO();
        c4.SelectDB("3010");
        c4.setCustPW("4094");
        c4.setCustFN("Henry");
        c4.setCustLN("Lewis");
        c4.setCustAddr("120 Fall creek ave");
        c4.setCustPhone("4043732091");
        c4.setCustEmail("lewisH@gmail.com");
        c4.updateDB();
        c4.display();
        */
        
        
    
    }
}
