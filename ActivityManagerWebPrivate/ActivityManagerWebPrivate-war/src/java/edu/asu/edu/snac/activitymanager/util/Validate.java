/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.edu.snac.activitymanager.util;

/**
 *
 * @author Jose Trigueros
 */
public class Validate
{
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
        // TODO: Really badly coded, only checks if there is an @ and . 
        return (email.split("[@\\.]").length == 3) ? true: false;
    }

    // TODO: Remove using for testing purposes
    public static void main( String[] args )
    {
        String username = "fred@stuff..com";
        System.out.println( Validate.Email(username) );
    }
}


