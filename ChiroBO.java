import java.sql.*; 
public class ChiroBO {

    private String id, pw, fName, lName, phone, email;

    public ChiroBO() {
        id = "";
        pw = "";
        fName = "";
        lName = "";
        phone = "";
        email = "";
    } 
    public ChiroBO(String ID, String password, String firstName, String lastName, String Phone, String Email) {
        id = ID;
        pw = password;
        fName = firstName;
        lName = lastName;
        phone = Phone;
        email = Email; 
    }
    
    public void setChiroId(String i) {
        id = i; 
    }
    public String getChiroId(){
        return id; 
    }
    
    public void setChrioPw(String pas)  {
        pw = pas;
    }
    public String getChiroPw(){
        return pw;
    }

    public void setChiroFn(String fn) {
        fName = fn;
    }
    public String getChiroFn(){
        return fName;
    }

    public void setChiroLn(String ln) {
        lName = ln;
    }
    public String getChiroLn(){
        return lName;
    }

    public void setChiroPhone(String n) {
        phone = n;
    }
    public String getChiroPhone() {
        return phone;
    }

    public void setChiroEmail(String e) {
        email = e;
    }
    public String getChiroEmail() {
        return email;
    }
    
    /******************************
     * selects a chiropractor from the database 
     * 
     *******************************/

    public void selectDB(String i) {
        id = i;
        try {
                String databaseURL = "jdbc:ucanaccess://C://Users/csywa/Desktop/AdvanceSystemsProj/MariettaSpineClinicMDB.mdb/";
                Connection con = DriverManager.getConnection(databaseURL) ;
                System.out.println("first step db connection");
                Statement stmt = con.createStatement();
                ResultSet rs;
                System.out.println("DB Connected");
                String sql = "select * from Chiropractors where ChiroID ='"+i+"'";
                System.out.println(sql);
                rs = stmt.executeQuery(sql);
                rs.next();
                setChiroId(rs.getString(1));
                setChrioPw(rs.getString(2));
                setChiroFn(rs.getString(3));
                setChiroLn(rs.getString(4));
                setChiroPhone(rs.getString(5));
                setChiroEmail(rs.getString(6));
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    /******************************************
     * insert adds a new chiropractor to the database 
     * 
     *****************************************/
    
    
    
    public void insertDB(String ID, String PW, String Fn, String Ln, String Phone, String Email) {
        id = ID;
        pw = PW;
        fName = Fn;
        lName = Ln;
        phone = Phone;
        email = Email;
        
        try {
            
            String databaseURL = "jdbc:ucanaccess://C://Users/csywa/Desktop/AdvanceSystemsProj/MariettaSpineClinicMDB.mdb/";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("first step db connection");
            Statement stmt = con.createStatement();
            ResultSet rs;
            System.out.println("DB Connected");
            String sql = "Insert into Chiropractors values('"+getChiroId()+"',"+ 
                                                      "'"+getChiroPw()+"',"+ 
                                                      "'"+getChiroFn()+"',"+
                                                      "'"+getChiroLn()+"',"+
                                                      "'"+getChiroPhone()+"',"+
                                                      "'"+getChiroEmail()+"')";
            System.out.println(sql);
            stmt.execute(sql);
            
        }
        catch(Exception e) {
            System.out.println(e);
        }  
    }
    
    /********************************************
     * Delete removes a chiropractors information from the database
     * 
     ********************************************/
    
    public void deleteBO() {
        try {
            String databaseURL = "jdbc:ucanaccess://C://Users/csywa/Desktop/AdvanceSystemsProj/MariettaSpineClinicMDB.mdb/";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("Delete Connected");
            Statement stmt = con.createStatement();
            String sql = "Delete from Chiropractors where ChiroID='"+getChiroId()+"'";
            stmt.execute(sql);
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void updateDB() {
        String fName = "Thomas";
        try {
            String databaseURL = "jdbc:ucanaccess://C://Users/csywa/Desktop/AdvanceSystemsProj/MariettaSpineClinicMDB.mdb/";
            Connection con = DriverManager.getConnection(databaseURL) ;
            System.out.println("Delete Connected");
            Statement stmt = con.createStatement();
            String sql = "update Chiropractors set ChiroID = '"+getChiroId() + "',"+ 
                                            " ChiroPW ='"+getChiroPw()+"',"+
                                            " ChiroFN ='"+fName+"',"+  
                                            " ChiroLN ='"+getChiroLn()+"',"+
                                            " ChiroPhone ='"+getChiroPhone()+"',"+
                                            " ChiroEmail = "+getChiroEmail() +
                                            " WHERE ChiroID='"+getChiroId()+"'";                                        
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    

    
    /**************************************
     * displays information about chiropractor
     * 
     ***************************************/
    
    public void display() {
        System.out.println("Chiropractor ID :                   "+ getChiroId());
        System.out.println("Chiropractor PW :                   "+ getChiroPw());
        System.out.println("Chiropractor First Name             "+ getChiroFn());
        System.out.println("Chiropractor Last Name              "+ getChiroLn());
        System.out.println("Chiropractor Phone                  "+ getChiroPhone());
        System.out.println("Chiropractor Email                  "+ getChiroEmail());
        System.out.println("========================================================");

    }

    public static void main(String[] args) {
        ChiroBO c1 = new ChiroBO();
        c1.selectDB("2000");
        c1.display();
        
        ChiroBO c2 = new ChiroBO();
        c2.insertDB("2500", "123456", "leo", "Johnson", "6781234567", "email@dctor.com");
        c2.display();
        
        /*
        ChiroBO c3 = new ChiroBO();
        c3.selectDB("2500");
        c3.deleteBO();
        */
        
        ChiroBO c3 = new ChiroBO();
        c1.selectDB("2000");
        c1.updateDB();
        


    }

}
    

