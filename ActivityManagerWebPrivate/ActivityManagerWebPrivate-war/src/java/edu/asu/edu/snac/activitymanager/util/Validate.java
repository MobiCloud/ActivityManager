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
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                                                + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_PATERN = "^[01]?[- .]?\\(?[2-9]\\d{2}\\)?[- .]?\\d{3}[- .]?\\d{4}$";

    /**
     * Will receive a String with a user name and will make sure it is of
     * appropriate length which we will limit to 4 to 12 standard ASCII characters.
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
            isValid = true;
            // Then we must check that characters are within range.
            char[] usernameArray = username.toCharArray();
            for( char currentChar : usernameArray )
            {
                // Must be a letter from the alphabet if not break the loop and
                // return false. Very ugly, more elegant way?
                if(
                    !(
                        (currentChar >= Constants.ASCII_UPPERCASE_BOUNDS[0] && currentChar <= Constants.ASCII_UPPERCASE_BOUNDS[1] ) ||
                        (currentChar >= Constants.ASCII_LOWERCASE_BOUNDS[0] && currentChar <= Constants.ASCII_LOWERCASE_BOUNDS[1] )
                     )
                  )
                {
                    isValid = false;
                    break;
                }
                    
            }
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
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Checks if the phone number is valid, it should be in the following format
     * ###.###.####
     * @param phone
     * @return true if the number is valid, otherwise false
     */
    public static boolean Phone( String phone )
    {
        Pattern pattern = Pattern.compile(PHONE_PATERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

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
        String username = "999.888.1111";
        System.out.println( Validate.Phone(username) );
    }
}


