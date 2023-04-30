package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**Lớp Properties hỗ trợ để lấy giá trị của các thuộc tính tại vị trí được chỉ định.
 * @author AnLaVN
 */
public class Properties {
    private static ResourceBundle Lang;
    
    
    /**Tạo một Tệp thuộc tính mặc định.
     * @see Properties#setProperties(java.lang.String)
     * @see Properties#Properties(java.lang.String) 
     */
    public Properties() {}
    
    
    /**Tạo một tệp thuộc tính tại vị trí filePath.
     * @param filePath là vị trí cụ thể của tệp Thuộc tính, phần mở rộng tệp tin phải là ".properties".
     */
    public Properties(String filePath) {    setProperties(filePath);    }
    
    
    /**Sử dụng phương thức này để thiết lập vị trí của tệp Thuộc tính.
     * @param filePath là vị trí cụ thể của tệp Thuộc tính, phần mở rộng tệp tin phải là ".properties".
     * @see Properties#Properties(java.lang.String) 
     */
    public final void setProperties(String filePath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            Lang = new PropertyResourceBundle(fis);
            fis.close();
        }catch(IOException e){
            Log.add("!!! Error trying to open properties file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    /**Sử dụng phương thức này để nhận một chuỗi giá trị từ khóa đã cho.
     * @param Key là một chuỗi Khóa trong tệp Thuộc tính.
     * @return một chuỗi giá trị của Khóa trong tệp Thuộc tính.
     */
    public String getString(String Key){    return Lang.getString(Key); }
}