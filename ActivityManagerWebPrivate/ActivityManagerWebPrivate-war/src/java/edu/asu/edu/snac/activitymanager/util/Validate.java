/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.edu.snac.activitymanager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jose Trigueros
 */
public class Validate
{
    /* Private Constants */
    private static final String USERNAME_PATTERN = "[a-zA-z]*";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                                                + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_PATTERN = "^[01]?[- .]?\\(?[2-9]\\d{2}\\)?[- .]?\\d{3}[- .]?\\d{4}$";
    
    /* Private Static Instance Variables */
    private static Pattern sCurrentPattern;
    private static Matcher sCurrentMatcher;

    /**
     * Checks if the given username is of the right length and using the right characters.
     * appropriate length.
     * TODO: Allow other characters such as numbers and/or periods.
     * @param username
     * @return true if username is valid, false otherwise
     */
    public static boolean Username( String username )
    {
        boolean isValid = false;

        // First determine if length is valid
        if( Constants.USERNAME_MIN_LENGTH <= username.length() && username.length() < Constants.USERNAME_MAX_LENGTH )
        {
            sCurrentPattern = Pattern.compile(USERNAME_PATTERN);
            sCurrentMatcher = sCurrentPattern.matcher(username);
            isValid = sCurrentMatcher.matches();
        }

        return isValid;
    }

    /**
     * Only checks if password is of the right length, it can include any other
     * type-able character.
     * TODO: Can be force only standard ASCII characters
     * @param password
     * @return true if password is of correct length
     */
    public static boolean Password( String password )
    {
        boolean isValid = false;

        if( Constants.PASSWORD_MIN_LENGTH <= password.length() && password.length() < Constants.PASSWORD_MAX_LENGTH )
            isValid = true;
        
        return isValid;
    }
    
    /**
     * Checks if the email is valid.
     * @param email
     * @return true if the email matches the given specification otherwise false
     */
    public static boolean Email( String email )
    {
        sCurrentPattern = Pattern.compile(EMAIL_PATTERN);
        sCurrentMatcher = sCurrentPattern.matcher(email);
        return sCurrentMatcher.matches();
    }

    /**
     * Checks if the phone number is valid
     * @param phone
     * @return true if the number is valid, otherwise false
     */
    public static boolean Phone( String phone )
    {
        sCurrentPattern = Pattern.compile(PHONE_PATTERN);
        sCurrentMatcher = sCurrentPattern.matcher(phone);
        return sCurrentMatcher.matches();
    }

    /**
     * Removes all non-Digit characters from the given phone number.
     * @param phone
     * @return 
     */
    public static String StripPhoneNum( String phone )
    {
        StringBuilder strippedPhone = new StringBuilder();
        for( char number : phone.toCharArray() )
        {
            if( Character.isDigit(number) )
                strippedPhone.append(number);
        }
        return strippedPhone.toString();
    }

    /**
     * Simply checks if the sport name is within valid character range.
     * @param sport
     * @return
     */
    public static boolean Sport( String sport )
    {
        return ( 0 < sport.length() && sport.length() <= Constants.SPORT_MAX_LENGTH )? true : false;
    }
    
    
    // TODO: Remove using for testing purposes
    public static void main( String[] args )
    {
        String username = "aoeuaoue";
        System.out.println( Validate.Username(username) );
    }
}