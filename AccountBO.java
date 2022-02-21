
package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Christopher Sywak
 */
public class AccountBO {
    
    private String accNum, custID, insurance, policyNum, balance; 
    
    
    public AccountBO() {
        accNum = "";
        custID = "";
        insurance = "";
        policyNum = "";
        balance = "";
    }
    
    public AccountBO(String AccNum, String CustID, String Insurance, String PolicyNum, String Balance) {
        accNum = AccNum;
        custID = CustID;
        insurance = Insurance;
        policyNum = PolicyNum;
        balance = Balance;
    } 

    /**
     * @return the accNum
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     * @param accNum the accNum to set
     */
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the insurance
     */
    public String getInsurance() {
        return insurance;
    }

    /**
     * @param insurance the insurance to set
     */
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    /**
     * @return the policyNum
     */
    public String getPolicyNum() {
        return policyNum;
    }

    /**
     * @param policyNum the policyNum to set
     */
    public void setPolicyNum(String policyNum) {
        this.policyNum = policyNum;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }
    
     public void selectDB(String i) {
        custID = i;
        try {
                String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
                Connection con = DriverManager.getConnection(databaseURL) ;
                System.out.println("first step db connection");
                Statement stmt = con.createStatement();
                ResultSet rs;
                System.out.println("DB Connected");
                String sql = "select * from Accounts where CustID ='"+i+"'";
                System.out.println(sql);
                rs = stmt.executeQuery(sql);
                rs.next();
                setAccNum(rs.getString(1));
                setCustID(rs.getString(2));
                setInsurance(rs.getString(3));
                setPolicyNum(rs.getString(4));
                setBalance(rs.getString(5));
            }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
     public void insertDB(String AccountNum, String cusID, String Insurance, String PolicyNum , String Balance ) {
        accNum = AccountNum;
        custID = cusID;
        insurance = Insurance;
        policyNum = PolicyNum;
        balance = Balance;
        
        
        try {
            String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("first step db connection");
            Statement stmt = con.createStatement();
            ResultSet rs;
            System.out.println("DB Connected");
            String sql = "Insert into Accounts values('"+getAccNum()+"',"+ 
                                                      "'"+getCustID()+"',"+ 
                                                      "'"+getInsurance()+"',"+
                                                      "'"+getPolicyNum()+"',"+
                                                      "'"+getBalance()+"')";
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
        
        String i = "Ambetter";
        
        try {
            String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("Update Connected Connected");
            Statement stmt = con.createStatement();
            String sql = "update Accounts set AccNo ='"+getAccNum()+ "',"+ 
                                            " CustID ='"+getCustID()+"',"+
                                            " InsurerName ='"+i+"',"+  
                                            " PolicyNo ='"+getPolicyNum()+"',"+
                                            " Balance ='"+getBalance()+ "'" +
                                            " WHERE AccNo ='"+getAccNum()+"'";                                        
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
     
     
    public void display() {
        System.out.println("Account Number :                   "+ getAccNum());
        System.out.println("Customer ID :                      "+ getCustID());
        System.out.println("Insurance :                        "+ getInsurance());
        System.out.println("Policy Number :                    "+ getPolicyNum());
        System.out.println("Balance :                          "+ getBalance());
        System.out.println("========================================================");

    }
    
    public void deleteBO() {
        try {                       
            String databaseURL = "jdbc:ucanaccess://C:/Users/csywa/OneDrive/Desktop/System Project Source/Chiro-App-ADV-SYS-PROJ-f0206791a8aa6767c7ca9e9118731ac6bfa9d26f/MariettaSpineClinicMDB.accdb";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("Delete Connected");
            Statement stmt = con.createStatement();
            String sql = "Delete from Accounts where AccNo='"+getAccNum()+"'";
            stmt.execute(sql);
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) { 
        AccountBO a1 = new AccountBO();
        a1.selectDB("3003");
        a1.display();
        
        
        /*
        AccountBO a2 = new AccountBO();
        a2.insertDB("90011", "3011", "Aetna", "129086543", "10,000.00");
        
        
        AccountBO a3 = new AccountBO();
        a3.selectDB("3002");
        a3.updateDB();
        */
        
        AccountBO a2 = new AccountBO();
        a2.selectDB("3011");
        a2.deleteBO();
        
    
    }
}
