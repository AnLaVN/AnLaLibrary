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

/**Lớp AES hỗ trợ mã hóa và giải mã một Chuỗi, sử dụng khóa bảo mật. 
 * AES sử dụng thuật toán mã hóa khối Advanced Encryption Standard được chính phủ Hoa Kỳ áp dụng làm tiêu chuẩn mã hóa.
 * @author AnLaVN
 */
public class AES {
    /**Sử dụng phương thức này để mã hóa chuỗi gốc bằng khóa bảo mật. Không thể giải mã bằng công cụ online.
     * @param strToEncrypt là chuỗi cần mã hóa.<br>
     * @param myKey là khóa bảo mật.<br>
     * @return mã băm AES của chuỗi gốc.
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
    /**Sử dụng phương thức này để giải mã mã băm AES bằng khóa bảo mật. Chỉ có thể giải mã bằng phương thức này.
     * @param strToDecrypt là mã băm AES.<br>
     * @param myKey là khóa bảo mật.<br>
     * @return chuỗi ban đầu.
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