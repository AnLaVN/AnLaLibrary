package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**The SHA256 class only supports object encryption, decryption it is impossible.
 * SHA256 uses the Secure Hash Algorithm 2 cryptographic hash function designed by the US National Security Agency with a 256-bit long hash value.
 * <br>Make sure your object class was "implements Serializable".
 * @author AnLaVN
 */
public class SHA256 {
    
    /**Use this method to encrypt the original object.
     * @param objToEncrypt is the object need encrypt.<br>
     * @return a SHA256 hash code of the original object.
     */
    public static final String Encrypt(final Object objToEncrypt) {
        try {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(objToEncrypt); oos.flush();
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(bos.toByteArray());
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {    hexString.append('0');  }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            Log.add("!!! Error try to Encrypt SHA256. !!!\n\tError code: " + e.toString());
        } return null;
    }
}