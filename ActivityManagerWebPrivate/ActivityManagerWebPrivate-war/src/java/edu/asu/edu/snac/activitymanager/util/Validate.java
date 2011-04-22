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
    private static final String PHONE_PATTERN = "^[01]?[- .]?\\(?[2-9]\\d{2}\\)?"
                                                + "[- .]?\\d{3}[- .]?\\d{4}$";
    
    private static final String DATE_PATTERN = "^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|"
                                                + "2[0-8])|(0?[13456789]|1[012])/(29|30)|"
                                                + "(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|"
                                                + "0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|"
                                                + "[13579][26])|(([2468][048]|[3579][26])00)))$";
    private static final String TIME_PATTERN = "^([0-1][0-9]|[2][0-3]):([0-5][0-9])$";
    
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
            isValid = checkMatchingRegex(USERNAME_PATTERN, username);
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
        return checkMatchingRegex(EMAIL_PATTERN, email);
    }

    /**
     * Checks if the phone number is valid
     * @param phone
     * @return true if the number is valid, otherwise false
     */
    public static boolean Phone( String phone )
    {
        return checkMatchingRegex(PHONE_PATTERN, phone);
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
    
    /**
     * Checks if the given time has valid format.
     * @param time
     * @return 
     */
    public static boolean Time( String time )
    {
        return checkMatchingRegex(TIME_PATTERN, time);
    }
    
    /**
     * Checks if the given date has valid format.
     * @param date
     * @return 
     */
    public static boolean Date( String date )
    {
        return checkMatchingRegex(DATE_PATTERN, date);
    }
    
    /**
     * Given a regex matching pattern and a target string, it'll determine if the string matches
     * the pattern.
     * @param regexPattern
     * @param targetString
     * @return true if the string matches the regex pattern, otherwise false
     */
    private static boolean checkMatchingRegex( String regexPattern, String targetString )
    {
        Pattern currentPattern = Pattern.compile(regexPattern);
        Matcher currentMatcher = currentPattern.matcher(targetString);
        return currentMatcher.matches();
    }
    
    // TODO: Remove using for testing purposes
    public static void main( String[] args )
    {
        String username = "aoeuaoue";
        System.out.println( Validate.Username(username) );
    }
}