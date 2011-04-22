package edu.asu.edu.snac.activitymanager.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * Code taken from: http://www.anyexample.com/programming/java/java_simple_class_to_compute_sha_1_hash.xml.
 */
public class SHA1 {
	
	/*
	 * This converts a byte array to a string representation of the hex.
	 */
	private static String toHex(byte[] data){
		StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
	}
	
	/**
	 * This computes the SHA-1 hash of a given string, and returns the hash in HEX form.
	 * @param text
	 * The string you wish to hash.
	 * @return
	 * The hashed string. Will be of the form [a-f0-9]+.
	 */
	public static String sha1(String text){
		MessageDigest md;
	    try {
			md = MessageDigest.getInstance("SHA-1");
		    byte[] sha1hash = new byte[40];
		    md.update(text.getBytes(), 0, text.length());
		    sha1hash = md.digest();
		    return toHex(sha1hash);
		    
	    } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    
	    return "SHA 1 Failed";
	}
	
	
//	public static void main(String[] args){
//		System.out.println(sha1("fred"));
//	}
}
