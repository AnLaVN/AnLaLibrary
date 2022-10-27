package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**Lớp Cloud hỗ trợ kết nối tới Cloudinary của bạn.
 *
 * @author Admin
 */
public class Cloud {
    
    private Cloudinary MyCloud = null;
    
    /**Tạo một Cloudinary mặc định.
      *@see Cloud#Cloud(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Cloud() {}

    
    /**Tạo một Cloudinary với đầy đủ thông tin.
     * @param Clound_Name là tên Cloud của bạn.<br>
     * @param API_Key là API Key của bạn.<br>
     * @param API_Secret là API Secret của bạn.<br>
     * @see Cloud#setCloudinary(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Cloud(String Clound_Name, String API_Key, String API_Secret){
        this.MyCloud = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", Clound_Name,
            "api_key", API_Key,
            "api_secret", API_Secret  ));
    }
    
    
    private void checkClound(){
        if(MyCloud == null){    
            System.out.println("!!! Your Clound is null, please use setCloundinary method. !!!"); 
            throw new RuntimeException();
        }
    }
    
    
    /**Sử dụng phương thức này để đặt thông tin Cloudinary của bạn.
     * @param Clound_Name là tên Cloud của bạn.<br>
     * @param API_Key là API Key của bạn.<br>
     * @param API_Secret là API Secret của bạn.<br>
     * @see Cloud#Cloud(java.lang.String, java.lang.String, java.lang.String) 
     */
    public void setCloudinary(String Clound_Name, String API_Key, String API_Secret) {
        this.MyCloud = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", Clound_Name,
            "api_key", API_Key,
            "api_secret", API_Secret  ));
    }
    
    
    /**Sử dụng phương thức này để tải tệp lên Cloudinary, hỗ trợ hình ảnh, video, thô, tự động.
     * @param filePath là đường dẫn của tệp.<br>Ví dụ "C:/user/Picture/yourFile.png" hoặc "Picture/yourFile.png".<br>
     * @return URL của tệp sau khi tải lên thành công.
     * @see Cloud#FileUpload(java.lang.String, java.lang.String)
     */
    public String FileUpload(String filePath){
        return FileUpload(filePath, null);
    }
    
    
    /**Sử dụng phương thức này để tải Tệp vào Thư mục của bạn trên Cloudinary, hỗ trợ hình ảnh, video, thô, tự động.
     * @param filePath là đường dẫn của tệp.<br>Ví dụ "C:/user/Picture/yourFile.png" hoặc "Picture/yourFile.png".<br>
     * @param CloundPath là đường dẫn của Thư mục trên Cloudinary.<br>Ví dụ "Picture/" hoặc "myFloder/Picture/".
     * @return URL của tệp sau khi tải lên thành công.
     * @see Cloud#FileUpload(java.lang.String) 
     */
    public String FileUpload(String filePath, String CloundPath){
        checkClound();
        try {
            Map uploadResult = MyCloud.uploader().upload(new File(filePath), ObjectUtils.asMap("resource_type", "auto", "use_filename", true, "folder", CloundPath));
            return (String) uploadResult.get("url");
        }catch (IOException e) {
            System.out.println("\n!!! Error trying to upload Image to Cloundinary. !!!");
            throw new RuntimeException(e);
        }
    }
    
    
    /**Sử dụng phương thức này để xóa tệp của bạn trên Cloudinary bằng URL.<br><b><i>Chỉ hỗ trợ hình ảnh</i></b>.
     * @param url là URL của Tệp cần xóa. <br>
     * @see Cloud#FileDeleteByID(java.lang.String)
     */
    public void FileDeleteByURL(String url){
        String publicID = url.substring(url.lastIndexOf("/", url.indexOf("d/v")+14)+1, url.lastIndexOf("."));
        if(url.contains("/image/upload/")){
            System.out.println("Cloundinary Public ID: "+publicID);
            FileDeleteByID(publicID);}
        else{System.out.println("!!! This method only support \"image\" Resource Type. !!!");}
    }
    
    
    /**Sử dụng phương thức này để xóa tệp của bạn trên Cloudinary bằng Public ID.<br><b><i>Chỉ hỗ trợ hình ảnh</i></b>.
     * @param publicID là Public ID của tệp cần xóa. <br>
     * @see Cloud#FileDeleteByURL(java.lang.String) 
     */
    public void FileDeleteByID(String publicID){
        checkClound();
        try{    MyCloud.uploader().destroy(publicID, ObjectUtils.emptyMap());   }
        catch(IOException e){  System.out.println("\n!!! Error trying to delete File on Cloundinary. !!!");}
    }
}