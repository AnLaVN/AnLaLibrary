package com.AnLa.HASH;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**Lớp MD5 chỉ hỗ trợ mã hóa một Chuỗi, giải mã nó là bất khả thi.
 * @author Admin
 */
public class MD5 {
    
    /**Sử dụng phương thức này để mã hóa một chuỗi gốc.
     * @param strToEncrypt là một chuỗi cần mã hóa. <br>
     * @return mã băm SHA256 của chuỗi gốc.
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