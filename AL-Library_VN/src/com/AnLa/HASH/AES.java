package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**Lớp AES hỗ trợ mã hóa và giải mã một Chuỗi, sử dụng khóa bảo mật.
 * @author Admin
 */
public class AES {

    /**Sử dụng phương thức này để mã hóa một chuỗi gốc bằng khóa bảo mật. Không thể giải mã bằng công cụ online.
     * @param strToEncrypt là một chuỗi cần mã hóa.<br>
     * @param myKey là một khóa bảo mật.<br>
     * @return mã băm AES của chuỗi gốc.
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
            Log.add(e.toString()); 
        }
        return null;
    }
    

    /**Sử dụng phương thức này để giải mã mã băm AES bằng khóa bảo mật. Chỉ có thể giải mã bằng phương thức này.
     * @param strToDecrypt mã băm AES.<br>
     * @param myKey là một khóa bảo mật.<br>
     * @return chuỗi ban đầu.
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
            Log.add(e.toString());
        }
        return null;
    }
}