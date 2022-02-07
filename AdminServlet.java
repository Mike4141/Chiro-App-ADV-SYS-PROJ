/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import business.AdminBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***********************************
* Name: Victor Bula
* Due Date -
* I did write this code myself...
***********************************/

@WebServlet(urlPatterns = {"/LoginServletDB"})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
            // Test Code
            System.out.println("Go Falcons"); // sends to server log / output window (GlassFish Server)
            
            
            // =================== GET LOGIN ID AND PW 
            
            // ------------------- Get ID & Password from Customer Login Page
            String idGui, pwGui;
            idGui = request.getParameter("uname"); // get id from GUI
            System.out.println("ID from GUI = " + idGui); 
            pwGui = request.getParameter("psw"); // get password from GUI
            System.out.println("Password from GUI = " + pwGui);
                        
            // ------------------- Check ID & Password against Database
            /*
            (IMPORTANT make sure import Business.Customer 
            interface for object reference to use Customer object
            in the Servlet)
            */            
            AdminBO a1 = new AdminBO(); // empty customer object
            a1.selectDB(idGui); // look up customer id in Database
            String idDb = a1.getAdminId(); // retrieve Database id
            String pwDb = a1.getAdminPass(); // retrieve Database Password
            
            if (idDb.equals("")) // first, check if id was NOT FOUND in Database
            { 
                    // sends CUSTOMER ID NOT FOUND Prompt via HTML
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>LoginServletDB</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Customer ID not found.</h1>");
                    out.println("</body>");
                    out.println("</html>");
            }
            else if (pwGui.equals(pwDb)) // id WAS FOUND, do passwords match?
            {
                    // sends VALID LOGIN Prompt via HTML
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>LoginServletDB</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Welcome Back!</h1>");
                    out.println("</body>");
                    out.println("</html>");
            }
            else
            {
                // sends INVALID LOGIN Prompt via HTML
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>LoginServletDB</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>ID and Password do not match.</h1>");
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
