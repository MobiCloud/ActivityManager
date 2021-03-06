/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eas.asu.edu.snac.activitymanager.servlets;

import edu.asu.eas.snac.activitymanager.messages.FeedbackMessage;
import edu.asu.eas.snac.activitymanager.messages.LoginMessage;
import eas.asu.edu.snac.activitymanager.networking.MessageSender;
import edu.asu.edu.snac.activitymanager.util.SHA1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fred
 */
public class CheckLogin extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Do not allow anyone to enter a blank username/password
        if( !username.isEmpty() || !password.isEmpty() )
        {
            out.println("Username: " + username);

            LoginMessage lm = new LoginMessage();
            lm.setUsername(username);
            lm.setPassword(SHA1.sha1(password));

            FeedbackMessage messageResponse = (FeedbackMessage) MessageSender.sendMessage(lm);
            out.println("Send the message.");

            if (messageResponse != null)
            {

                int result = messageResponse.getReturnNo();

                System.out.print("~~~~~~~~~~~~~~~~~~~~~ THE RESULT IS: " + result);
                if (result == 0)
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("loggedInUser", username);
                    response.sendRedirect("Mobile/Menu.jsp");
                }
                else
                {
                    response.sendRedirect("Mobile/Login.jsp");
                }
            }
            else
            {
                out.println("Failed to get a response.");
            }
        }
        else
        {
            out.println("Missing username/password.");
            response.sendRedirect("Mobile/Login.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
