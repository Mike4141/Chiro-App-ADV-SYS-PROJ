import business.CustomerBO;
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

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter out = response.getWriter();
        try {
            String ID, PW;
            ID= request.getParameter("uname");
            PW= request.getParameter("psw");
            System.out.println("uname = "+ ID);
            System.out.println("psw = "+PW);
            
            CustomerBO c1 = new CustomerBO();
            c1.SelectDB(ID);
            String CustID = c1.getCustID();
            String CustPW = c1.getCustPW();
                     
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
