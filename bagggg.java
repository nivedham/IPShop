/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Silamparasan
 */
@WebServlet(name = "bagggg", urlPatterns = {"/bagggg"})
public class bagggg extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
        try {
            int a;
            String pid=request.getParameter("pid");
           String viewno=request.getParameter("viewno");
           HttpSession session=request.getSession();
           Integer count = new Integer(0);
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "myroot123");
                 
                 
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from counting");
                while (rs.next()) {
                         a=rs.getInt("count");
                if (session.isNew()) {
                    //out.println("helllo");
 
 
                    st.executeUpdate("insert into counting values (" + count + ") ");
 
 
                } else {
 
 
                    Integer oldcount = (Integer) session.getAttribute("count");
                    if (oldcount != null) {
                        count = new Integer(oldcount.intValue() + 1);
                    }
 
                    session.setAttribute("count", count);
                    st.executeUpdate("update counting set count=" + count + "");
                    while (rs.next()) {
                         a=rs.getInt("count");
                        out.println(a);
                    }
 
                }
            }
            }catch (Exception e) {
            }
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
