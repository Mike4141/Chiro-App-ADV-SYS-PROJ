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

    private int CustID, CustPW;
    private String CustFN, CustLN, CustAddr, CustEmail;
    private long CustPhone;
    
    public Customer() {
        CustID = 0;
        CustPW = 0;
        CustPhone = 0000000000;
        CustFN = "";
        CustLN = "";
        CustAddr = "";
        CustEmail = "";
    }
    public Customer(int id, int pw, String fn, String ln, String addr, long phone, String email) {
        CustID = id;
        CustPW = pw;
        CustPhone = phone;
        CustFN = fn;
        CustLN = ln;
        CustAddr = addr;
        CustEmail = email;
    }
    
    public void setCustID(int id) {CustID=id;}
    public int getCustID() {return CustID;}
    public void setCustPW(int pw) {CustPW=pw;}
    public int getCustPW() {return CustPW;}
    public void setCustPhone(long phone) {CustPhone=phone;}
    public long getCustPhone() {return CustPhone;}
    public void setCustFN(String fn) {CustFN=fn;}
    public String getCustFN() {return CustFN;}
    public void setCustLN(String ln) {CustLN=ln;}
    public String getCustLN() {return CustLN;}
    public void setCustAddr(String addr) {CustAddr=addr;}
    public String getCustAddr() {return CustAddr;}
    public void setCustEmail(String email) {CustEmail=email;}
    public String getCustEmail() {return CustEmail;}
    
    public void SelectDB(int id) {
        CustID = id;
    try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jeffe/Desktop/Systems Project/MariettaSpineClinicMDB.mdb");
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
            String sql;
            sql = "select * from Customers where CustID = '" +getCustID()+"'";
            System.out.println(sql);
                ResultSet rs;
                rs = stmt.executeQuery(sql);
                rs.next();
                setCustID(rs.getInt(1));
                setCustPW(rs.getInt(2));
                setCustFN(rs.getString(3));
                setCustLN(rs.getString(4));
                setCustAddr(rs.getString(5));
                setCustPhone(rs.getLong(7));
                setCustEmail(rs.getString(6));
                con.close();
    }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    
    }
    
    public void insertDB(int id, int pw, String fn, String ln, String addr, long phone, String email) {
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
                                            " CustPhone = '"+getCustPhone()+"',"+
                                            " CustEmail = "+getCustEmail()+
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
    
    public static void main(String[] args) {
        Customer  c1 = new Customer();
        c1.SelectDB(3000);
        c1.display();
        
        Customer c2 = new Customer();
        c2.insertDB(3009, 1229, "Jeff", "B", "121 Harbor Street, Acworth, GA", 6782222222L, "jeffbehrens@gmail.com");
        c2.display();
        
        Customer c4 = new Customer();
        c4.SelectDB(3010);
        c4.setCustPW(4094);
        c4.setCustFN("Henry");
        c4.setCustLN("Lewis");
        c4.setCustAddr("120 Fall creek ave, Acworth, GA");
        c4.setCustPhone(4043732091L);
        c4.setCustEmail("lewisH@gmail.com");
        c4.updateDB();
        c4.display();
    }
}
