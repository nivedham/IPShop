/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Silamparasan
 */
@WebServlet(name = "addproduct", urlPatterns = {"/addproduct"})
public class addproduct extends HttpServlet {

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
            
                                    
            List<String> ms = new ArrayList<String>();
            String finalimage = "";
            boolean isMultipart = ServletFileUpload.isMultipartContent(
                    request);
            List<String> m = new ArrayList<String>();
            File savedFile;
            // System.out.println("requestss//: "+request);
            if (!isMultipart) {
                //System.out.println("File Not Uploaded");
            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;

                try {
                    items = upload.parseRequest(request);
                    //System.out.println("items: "+items);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                Iterator itr = items.iterator();
                while (itr.hasNext()) {
                    List<String> al = new ArrayList<String>();

                    String sss = "";
                    FileItem item = (FileItem) itr.next();
                    String value = "";
                    String a[];
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        //System.out.println("name: "+name+'\n');
                        value = item.getString();
                        // System.out.println("value: "+value);
                        al.add(value);
                        for (int i = 0; i < al.size(); i++) {
                            sss += al.get(i);
                            System.out.println("is thios image" + sss);

         //System.out.println("the value sixcwe"+m.size());
                        }

                        a = sss.split("-");
                        for (int i = 0; i < a.length; i++) {

                            String am = a[i];
                            System.out.println("aaaaaaaaaaaaaaaa" + a[i]);
                            m.add(a[i]);
                        }
                    } else {

    //int size= item.size();
                        // for(int i=0;i<size;i++){
                        //System.out.println(item.getString());
                        // al.add(value);
                        // }
                        //System.out.println("ssssssssssssssssaaaaaa"+m.get(0));
//System.out.println("the value adaddasixcwe"+m.get(1));
                        String itemName = item.getName();
                        Random generator = new Random();
                        int r = Math.abs(generator.nextInt());

                        String reg = "[.*]";
                        String replacingtext = "";
                        // System.out.println("Text before replacing is:-" + itemName);
                        Pattern pattern = Pattern.compile(reg);
                        Matcher matcher = pattern.matcher(itemName);
                        StringBuffer buffer = new StringBuffer();

                        while (matcher.find()) {
                            matcher.appendReplacement(buffer, replacingtext);
                        }
                        int IndexOf = itemName.indexOf(".");
                        int Indexf = itemName.indexOf(".");
                        String domainName = itemName.substring(IndexOf);

// System.out.println("domainName: "+domainName);
                        finalimage = buffer.toString()+domainName;
                        System.out.println("Final Image===" + finalimage);
                        ms.add(finalimage);
//String path=getServletContext().getRealPath("");
                        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+path);
                        //String b="\\uplcss\\";
                        savedFile = new File("C:\\Users\\Nivedha\\Desktop\\Project\\HighUtilityItemsets\\web\\images\\" + finalimage);
                        item.write(savedFile);
//  out.println("<html>");
//  out.println("<body>");
//  out.println("<table><tr><td>");
//  out.println("<img src=images/"+finalimage+">");
//  out.println("</td></tr></table>");
                    }
                }
            }
            String strQuery = "";
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                            //get current date time with Date()
//                            Date date = new Date();
//                            //System.out.println(dateFormat.format(date)); don't print it, but save it!
//                            String yourDate = dateFormat.format(date);

            HttpSession hs = request.getSession();
 // System.out.println("itemName::::: "+itemName);
            //System.out.println("itemName::::: "+itemName);
            //String dealerid = hs.getAttribute("id").toString();
            //System.out.println(dealerid);
            
           PreparedStatement ps=DbConnection.getconnection().prepareStatement(strQuery);
          
            strQuery = "insert into addproduct (Company,Category,pid,Bname,Bprice,filename)values('" + m.get(0) + "','" + m.get(1) + "','" + m.get(2) + "','" + m.get(3) + "','" + m.get(4) + "','" + ms.get(0) + "')";
            System.out.println("itemName::::: "+strQuery);
            ps.executeUpdate(strQuery);
           
                out.println("<script>"
    					+"alert('Product Added')"
    					+"</script>");
    		
            	RequestDispatcher rd=request.getRequestDispatcher("/addproduct.jsp");
    			rd.include(request, response);
            hs.setAttribute("insert", "Uploaded SuccessFully");
                // response.sendRedirect("AddProducts.jsp"); 
           
            
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
