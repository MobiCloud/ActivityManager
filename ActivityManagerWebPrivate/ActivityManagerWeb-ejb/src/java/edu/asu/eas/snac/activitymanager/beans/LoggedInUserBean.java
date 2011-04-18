/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.asu.eas.snac.activitymanager.beans;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author Fred
 */
@Stateful
@LocalBean
public class LoggedInUserBean {
    
    private String loggedInUser;

    /**
     * Get the value of loggedInUser
     *
     * @return the value of loggedInUser
     */
    public String getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Set the value of loggedInUser
     *
     * @param loggedInUser new value of loggedInUser
     */
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
}
