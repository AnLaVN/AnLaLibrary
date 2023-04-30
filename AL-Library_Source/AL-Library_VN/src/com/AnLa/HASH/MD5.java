package com.AnLa.HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**Lớp MD5 chỉ hỗ trợ mã hóa đối tượng, giải mã nó là bất khả thi.
 * MD5 sử dụng hàm băm mật mã học Message-Digest algorithm 5 với giá trị băm dài 128-bit.
 * <br>Đảm bảo rằng lớp đối tượng của bạn đã "implements Serializable".
 * @author AnLaVN
 */
public class MD5 {
    /**Sử dụng phương thức này để mã hóa đối tượng gốc.
     * @param objToEncrypt là đối tượng cần mã hóa. <br>
     * @return mã băm MD5 của đối tượng ban đầu.
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