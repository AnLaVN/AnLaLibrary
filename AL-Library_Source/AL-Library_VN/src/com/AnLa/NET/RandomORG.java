package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import java.io.IOException;

/**Lớp RandomORG hỗ trợ tạo số thực sự ngẫu nhiên từ random.org
 * @author AnLaVN
 */
public class RandomORG {
    private static final String 
            RANINT = "https://www.random.org/integers/?num=1&min=MIN&max=MAX&col=1&base=BAS&format=plain&rnd=new",
            RANSEQ = "https://www.random.org/sequences/?min=MIN&max=MAX&col=1&format=plain&rnd=new",
            RANSTR = "https://www.random.org/strings/?num=1&len=LEN&digits=DIG&upperalpha=UPE&loweralpha=LOW&unique=on&format=plain&rnd=new",
            RANQUO = "https://www.random.org/quota/?format=plain";
    
    
    /**Sử dụng phương thức này để tạo các số nguyên thực sự ngẫu nhiên.
     * @param min là giá trị nhỏ nhất được phép cho mỗi số nguyên.
     * @param max là giá trị lớn nhất được phép cho mỗi số nguyên.
     * @param base là cơ số sẽ được sử dụng để in các số. Số thập phân là mặc định.<br>Ví dụ: 2(nhị phân), 8(bát phân), 10(thập phân) hoặc 16(thập lục phân).
     * @return số nguyên thực sự ngẫu nhiên.
     * @throws java.io.IOException ném ngoại lệ nếu không có kết nối internet hoặc không thể kết nối đến random.org
     */
    public static final String getInteger(int min, int max, int base) throws IOException{
        return new DocNet(RANINT
                .replaceFirst("MIN", String.valueOf(min))
                .replaceFirst("MAX", String.valueOf(max))
                .replaceFirst("BAS", String.valueOf(base != 2 && base != 8 && base != 10 && base != 16 ? 10 : base))
        ).readLine();
    }
    
    
    /**Sử dụng phương thức này để ngẫu nhiên hóa một khoảng các số nguyên nhất định và sắp xếp chúng theo thứ tự ngẫu nhiên.
     * @param min là giới hạn dưới của khoảng (bao gồm).
     * @param max là giới hạn trên của khoảng (bao gồm).
     * @return chuỗi với thứ tự ngẫu nhiên.
     * @throws java.io.IOException ném ngoại lệ nếu không có kết nối internet hoặc không thể kết nối đến random.org
     */
    public static final String getSequence(int min, int max) throws IOException{
        return new DocNet(RANSEQ
                .replaceFirst("MIN", String.valueOf(min))
                .replaceFirst("MAX", String.valueOf(max))
        ).readAllLine().trim();
    }
    
    
    /**Sử dụng phương thức này để tạo các chuỗi thực sự ngẫu nhiên có độ dài và thành phần ký tự khác nhau.
     * @param len là chiều dài của chuỗi.
     * @param digit Xác định xem các chữ số (0-9) có được phép xuất hiện trong chuỗi hay không.
     * @param upper Xác định xem các ký tự chữ hoa (A-Z) có được phép xuất hiện trong chuỗi hay không.
     * @param lower Xác định xem các ký tự chữ cái viết thường (a-z) có được phép xuất hiện trong chuỗi hay không.
     * @return chuỗi thực sự ngẫu nhiên.
     * @throws java.io.IOException ném ngoại lệ nếu không có kết nối internet hoặc không thể kết nối đến random.org
     */
    public static final String getString(int len, boolean digit, boolean upper, boolean lower) throws IOException{
        return new DocNet(RANSTR
                .replaceFirst("LEN", String.valueOf(len < 1 || len > 20 ? 10 : len))
                .replaceFirst("DIG", digit ? "on" : "off")
                .replaceFirst("UPE", upper ? "on" : "off")
                .replaceFirst("LOW", lower ? "on" : "off")
        ).readLine();
    }
    
    
    /**Sử dụng phương thức này để kiểm tra hạn ngạch của bạn. Hệ thống hạn ngạch hoạt động trên cơ sở địa chỉ IP.
     * Mỗi địa chỉ IP có hạn ngạch cơ sở là 1.000.000 bit.
     * Khi khách hàng của bạn yêu cầu số ngẫu nhiên (hoặc chuỗi, v.v.),
     * máy chủ khấu trừ số bit cần thiết để đáp ứng yêu cầu của bạn từ hạn ngạch được liên kết với địa chỉ IP của khách hàng của bạn.
     * @return số bit hạn ngạch còn lại của địa chỉ IP của bạn.
     * @throws java.io.IOException ném ngoại lệ nếu không có kết nối internet hoặc không thể kết nối đến random.org
     */
    public static final String getQuota() throws IOException{
        return new DocNet(RANQUO).readLine();
    }
}