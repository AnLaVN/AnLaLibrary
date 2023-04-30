package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Lớp Log hỗ trợ xuất thông tin ra tệp nhật ký và màn hình console.
 * @author AnLaVN
 */
public class Log {
    private static String PATTERN = "dd-MM-yyyy___HH꞉mm꞉ss";
    private static Raw LogFile = null;

    
    /**Sử dụng phương thức này để viết nhật ký, nó cũng in ra bảng điều khiển. Tự động thêm dòng mới.
     * @param text là một chuỗi văn bản bạn muốn ghi vào nhật ký.
     */
    public static final void add(String text){
        if(LogFile == null){    
            new File("Logs").mkdirs();  
            LogFile = new Raw("Logs/" + new SimpleDateFormat(PATTERN).format(new Date()) + ".txt");
        }
        if(text != null && !text.isBlank()){
            text = "[" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "]\t" + text.trim();
            LogFile.writeData(text+"\n");
            System.out.println(text);
        }
    }
    
    /**Sử dụng phương thức này để đặt mẫu tên tệp. Giá trị mặc định là 'dd-MM-yyyy___HH꞉mm꞉ss'.<br>
     * Chạy phương thức này trước.
     * @param pattern là mẫu tên tệp bạn muốn. Tuân thủ theo các mẫu SimpleDateFormat.
     */
    public static final void setPattern(String pattern){    PATTERN = pattern;  }
    
    /**Sử dụng phương thức này để lấy vị trí của Tệp nhật ký hiện tại.
     * @return chuỗi chứa đường dẫn tệp nhật ký.
     */
    public static final String getFilePath(){   return LogFile.getFilePath();   }
    
    /**Sử dụng phương thức này nếu bạn muốn đóng tệp nhật ký đúng cách. Nó không cần thiết phải sử dụng.
     */
    public static final void closeFile(){    LogFile.closeFile();    }
}