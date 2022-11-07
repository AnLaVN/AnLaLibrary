package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**The SHA256 class only supports encryption a String, decryption it is impossible.
 * @author Admin
 */
public class SHA256 {
    
    
    /**Use this method to encryption a original string.
     * @param strToEncrypt is a string need encrypt.<br>
     * @return a SHA256 hash code of original string.
     */
    public static String Encrypt(final String strToEncrypt) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(strToEncrypt.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {    hexString.append('0');  }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Log.add(ex.toString());
        } return null;
    }
}