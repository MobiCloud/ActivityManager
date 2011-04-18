/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.asu.edu.snac.activitymanager.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fred
 */
public class CheckLoggedIn {
    public static String checkLoggedIn(HttpServletRequest request, HttpServletResponse response){
        String loggedInUser = (String) request.getSession().getAttribute(Constants.LOGGED_IN_TOKEN);

        if(loggedInUser == null){
            try {
                response.sendRedirect("Login.jsp");
            } catch (IOException ex) {
                Logger.getLogger(CheckLoggedIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return loggedInUser;
    }
}
