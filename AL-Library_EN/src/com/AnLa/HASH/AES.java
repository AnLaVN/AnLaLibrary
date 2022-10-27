package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**The AES class supports encryption and decryption a String, using a security key.
 * @author Admin
 */
public class AES {

    
    /**Use this method to encryption a original string with security key. Can't be decryption by online tool.
     * @param strToEncrypt is a string need encrypt.<br>
     * @param myKey is a security key.<br>
     * @return a AES hash code of original string.
     * @see AES#Decrypt(java.lang.String, java.lang.String) 
     */
    public static String Encrypt(final String strToEncrypt, final String myKey) {
        try {
            final MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) { 
            e.toString(); 
        }
        return null;
    }

    
    /**Use this method to decryption a AES hash code with security key. Only decryption by this method.
     * @param strToDecrypt a AES hash code.<br>
     * @param myKey is a security key.<br>
     * @return a original String.
     * @see AES#Encrypt(java.lang.String, java.lang.String) 
     */
    public static String Decrypt(final String strToDecrypt, final String myKey) {
        try {
            final MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.toString();
        }
        return null;
    }
}