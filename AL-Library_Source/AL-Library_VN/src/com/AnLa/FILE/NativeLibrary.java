package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;

/**Lớp NativeLibrary hỗ trợ tải các thư viện động. 
 * @author AnLaVN
 */
public class NativeLibrary {
    
    /**Sử dụng phương pháp này để tải thư viện từ vị trí cụ thể.
     * @param filePath là vị trí cụ thể của tệp thư viện.<br>Ví dụ: "package/File.dll".
     */
    public static final void load(String filePath){     System.load(new File(filePath).getAbsolutePath());  }
}