import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeffe
 */
@WebServlet(urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

    private String CustID, CustPW, CustZip;
    private String CustFN, CustLN, CustEmail;
    private String CustAddr, CustCity, CustState;
    private String CustPhone;
    
public CustomerServlet() {
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
    public CustomerServlet(String id, String pw, String fn, String ln, String addr, String city, String zip, String state, String phone, String email) {
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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter out = response.getWriter();
        try {
            String ID, PW;
            ID= request.getParameter("uname");
            PW= request.getParameter("psw");
            System.out.println("ID = "+ ID);
            System.out.println("PW = "+PW);
            CustID = ID;
            CustPW = PW;
            
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
            
                     
            if (CustID.equals(ID)&&CustPW.equals(PW)) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServletDB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login Servlet Running...</h1>");
            out.println("</body>");
            out.println("</html>");
            } else if (!CustID.equals(ID)|| !CustPW.equals(PW)){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServletDB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Invalid Login</h1>");
            out.println("</body>");
            out.println("</html>");
            
        } 
        }
            catch(Exception e) {
            System.out.println("Exception: " + e);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServletDB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Invalid Login</h1>");
            out.println("</body>");
            out.println("</html>");
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
