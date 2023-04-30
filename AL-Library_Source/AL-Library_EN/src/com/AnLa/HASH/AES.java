package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**The AES class supports encryption and decryption a String, using a security key.
 * AES using the Advanced Encryption Standard block cipher algorithm adopted by the US government as the encryption standard.
 * @author AnLaVN
 */
public class AES {
    /**Use this method to encrypt a original string with security key. Can't be decryption by online tool.
     * @param strToEncrypt the string need encrypt.<br>
     * @param myKey is the security key.<br>
     * @return a AES hash code of original string.
     * @see AES#Decrypt(java.lang.String, java.lang.String) 
     */
    public static final String Encrypt(final String strToEncrypt, final String myKey) {
        try {
            final MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);  key = Arrays.copyOf(key, 16);
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) { 
            Log.add("!!! Error try to Encrypt AES. !!!\n\tError code: " + e.toString());    }
        return null;
    }
    /**Use this method to decrypt a AES hash code with security key. Only decryption by this method.
     * @param strToDecrypt is the AES hash code.<br>
     * @param myKey is the security key.<br>
     * @return a original String.
     * @see AES#Encrypt(java.lang.String, java.lang.String) 
     */
    public static final String Decrypt(final String strToDecrypt, final String myKey) {
        try {
            final MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);  key = Arrays.copyOf(key, 16);
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            Log.add("!!! Error try to Decrypt AES. !!!\n\tError code: " + e.toString());    }
        return null;
    }
}