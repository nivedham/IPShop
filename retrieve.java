/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "retrieve", urlPatterns = {"/retrieve"})
public class retrieve extends HttpServlet {

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
            
            
           // String username=request.getParameter("username");
            String username=request.getParameter("username");
            //String password=request.getParameter("password");
            String password=request.getParameter("password");
            System.out.println(username + " "+ password );
            
        if(username.equals("admin")&&password.equals("admin")){

                    response.sendRedirect("adminhome.jsp");
                      
                        }

           
        else{
             if(username=="" || password=="" )
             {
                 out.println("<script>"+"alert('Enter Valid User Name & Password')"+"</script>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
             //response.sendRedirect("Login.jsp");
            }
             else{
                String qua="select * from register where username='"+username+"' and password='"+password+"'";
                PreparedStatement psa = DbConnection.getconnection().prepareStatement(qua);
                ResultSet rs1=psa.executeQuery();
                 HttpSession hs2=request.getSession();
            hs2.setAttribute("username", username);
                //System.out.println("hello");
                if(rs1.next()){
//                     out.println("<script>"+"alert('Valid User Name & Password')"+"</script>");
//                   
//                    
//			RequestDispatcher rd=request.getRequestDispatcher("/UserHome.jsp");
//			rd.include(request, response);
                    
                 response.sendRedirect("userhome.jsp");
                    //response.sendRedirect("Products.jsp");
           
                }
            
            else
            {
             out.println("<script>"+"alert('Enter Valid User Name & Password')"+"</script>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
             //response.sendRedirect("Login.jsp");
            }
            
            
             }
             
        }
        }
         catch(Exception e)
        {
            
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
