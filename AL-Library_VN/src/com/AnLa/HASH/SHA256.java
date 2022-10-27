package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**Lớp SHA256 chỉ hỗ trợ mã hóa một Chuỗi, giải mã nó là bất khả thi.
 * @author Admin
 */
public class SHA256 {

    
    /**Sử dụng phương thức này để mã hóa một chuỗi gốc.
     * @param strToEncrypt là một chuỗi cần mã hóa. <br>
     * @return mã băm SHA256 của chuỗi gốc.
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
            ex.toString();
        } return null;
    }
    
}