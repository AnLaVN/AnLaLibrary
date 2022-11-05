package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**Lớp Log hỗ trợ xuất thông tin ra tệp nhật ký và màn hình console.
 * @author Admin
 */
public class Log {
    private static final String PATH = "Log/" + new SimpleDateFormat("dd-MM-yyyy HH;mm;ss").format(new Date()) + ".txt";
    private static Raw LogFile = new Raw(PATH);

    /**Sử dụng phương thức này để viết nhật ký, nó cũng in ra bảng điều khiển. Tự động thêm dòng mới.
     * @param text là một chuỗi văn bản bạn muốn ghi vào nhật ký.
     */
    public static void add(String text){
        File path = new File("Log");
        if (!path.exists()){    
            path.mkdirs();  
            LogFile = new Raw(PATH);
        }
        text = text.trim();
        if(!text.equals("")){
            LogFile.writeData(text+"\n");
            System.out.println(text);
        }
    }
    
    /**Sử dụng phương thức này để lấy vị trí của Tệp nhật ký hiện tại.
     * @return chuỗi chứa đường dẫn tệp nhật ký.
     */
    public static String getFilePath(){ return PATH;    }
    
    /**Sử dụng phương thức này nếu bạn muốn đóng tệp nhật ký đúng cách. Nó không cần thiết phải sử dụng.
     */
    public static void closeFile(){    LogFile.closeFile();    }
}