/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eas.asu.edu.snac.activitymanager.servlets;

import eas.asu.edu.snac.activitymanager.networking.MessageSender;
import edu.asu.eas.snac.activitymanager.messages.NewInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.NewInvitationPublicVMMessage;
import edu.asu.edu.snac.activitymanager.util.Constants;
import edu.asu.edu.snac.activitymanager.util.Validate;
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
public class ProcessNewInvitation extends HttpServlet {
   
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            NewInvitationPublicVMMessage invitation = new NewInvitationPublicVMMessage();
            
            /** HACK: This section is hardcoded it must changed!! */
            invitation.setVmURL("192.168.239.247");
            invitation.setPortNumber(1337);
            /** HACK */
            
            //get the logged in user's username
            invitation.setUsername((String) request.getSession().getAttribute(Constants.LOGGED_IN_TOKEN));

            // Read all POST variables first
            String sport = request.getParameter("sport");
            String date  = request.getParameter("date");
            String startTime = request.getParameter("startHour") + ":" + request.getParameter("startMinute");
            String endTime = request.getParameter("endHour") + ":" + request.getParameter("endMinute");
            String location = request.getParameter("location");
            String maxGamer = request.getParameter("maxgamer");
            
            boolean errorFlag = true;
            StringBuilder errorMessage = new StringBuilder();
            
            // Validate all parameters
            // TODO: Put all these error strings in Constants
            if( !Validate.Sport(sport) )
            {
                errorMessage.append("Invalid Activity Length");
            }
            else if( !Validate.Time(startTime) || !Validate.Time(endTime) )
            {
                errorMessage.append("Invalid Time Format");
            }
            else if( !Validate.Location(location) )
            {
                errorMessage.append("Location too long.");
            }
            else if( !Validate.Date(date) )
            {
                errorMessage.append("Invalid Date Format");
            }
            else if( !Validate.Players(maxGamer) )
            {
                errorMessage.append("Invalid number of players.");
            }
            else
            {
                errorFlag = false;
            }
            
            if( !errorFlag )
            {
                //set the invitation parameters
                invitation.setSport(sport);
                invitation.setDate(date);
                invitation.setStarttime(startTime);
                invitation.setEndtime(endTime);
                invitation.setLocation(location);
                invitation.setMaxgamer(Integer.parseInt(maxGamer));

                //send the invitation
                MessageSender.sendMessage(invitation);

                //redirect back to the menu
                response.sendRedirect("Mobile/InviteList.jsp");
            }
            else
            {
                request.getSession().setAttribute("errorMessage",errorMessage.toString());
                response.sendRedirect("Mobile/NewInvitation.jsp");
            }
        }
        finally
        {
            out.close();
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
