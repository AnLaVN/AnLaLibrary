package com.AnLa.HASH;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**The MD5 class only supports encryption a String, decryption it is impossible.
 * @author Admin
 */
public class MD5 {
    
    /**Use this method to encryption a original string.
     * @param strToEncrypt is a string need encrypt.<br>
     * @return a SHA256 hash code of original string.
     */
    public static String Encrypt(String strToEncrypt){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(strToEncrypt.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {    
                hashtext = "0" + hashtext;
            }return hashtext;
        }catch (NoSuchAlgorithmException e) {
            e.toString();
        }return null;
    }
}