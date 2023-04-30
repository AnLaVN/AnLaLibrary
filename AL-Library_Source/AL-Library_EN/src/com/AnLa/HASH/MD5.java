package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**The MD5 class only supports object encryption, decryption it is impossible.
 * MD5 uses the Message-Digest algorithm 5 cryptographic hash function with a 128-bit long hash value.
 * <br>Make sure your object class was "implements Serializable".
 * @author AnLaVN
 */
public class MD5 {
    /**Use this method to encrypt the original object.
     * @param objToEncrypt is the object need encrypt.<br>
     * @return a MD5 hash code of the original object.
     */
    public static final String Encrypt(final Object objToEncrypt){
        try {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(objToEncrypt); oos.flush();
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] hash = md.digest(bos.toByteArray());
            final BigInteger no = new BigInteger(1, hash);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }catch (IOException | NoSuchAlgorithmException e) {
            Log.add("!!! Error try to Encrypt MD5. !!!\n\tError code: " + e.toString());
        }
        return null;
    }
}