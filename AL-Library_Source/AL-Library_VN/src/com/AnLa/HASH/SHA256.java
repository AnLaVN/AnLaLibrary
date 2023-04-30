package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**Lớp SHA256 chỉ hỗ trợ mã hóa đối tượng, giải mã nó là bất khả thi.
 * SHA256 sử dụng hàm băm mật mã học Secure Hash Algorithm 2 được thiết kế bởi Cơ quan An ninh Quốc gia Hoa Kỳ với giá trị băm dài 256-bit.
 * <br>Đảm bảo rằng lớp đối tượng của bạn đã "implements Serializable".
 * @author AnLaVN
 */
public class SHA256 {
    
    /**Sử dụng phương thức này để mã hóa đối tượng gốc.
     * @param objToEncrypt là đối tượng cần mã hóa. <br>
     * @return mã băm SHA256 của đối tượng ban đầu.
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