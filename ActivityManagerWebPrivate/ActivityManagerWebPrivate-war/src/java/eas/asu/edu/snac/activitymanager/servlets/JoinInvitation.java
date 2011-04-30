/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eas.asu.edu.snac.activitymanager.servlets;

import eas.asu.edu.snac.activitymanager.networking.MessageSender;
import edu.asu.eas.snac.activitymanager.messages.AddUserToInvitationMessage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fred
 */
public class JoinInvitation extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            //get the get params
            String uname = request.getParameter("username");
            String inviteID = request.getParameter("inviteID");

            AddUserToInvitationMessage autim = new AddUserToInvitationMessage();
            autim.setInviteID(Integer.parseInt(inviteID));
            autim.setUsername(uname);
            autim.setVMURL("192.168.239.247");
            autim.setPortNumber(1337);

            MessageSender.sendMessage(autim);
            response.sendRedirect("Mobile/AllInvitations.jsp");

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
