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

    public static boolean Password( String password )
    {
        boolean isValid = false;

        //if( password.length() < )
        return isValid;
    }

    // TODO: Remove using for testing purposes
    public static void main( String[] args )
    {
        String username = "fred";
        System.out.println( Validate.Username(username) );
    }
}


