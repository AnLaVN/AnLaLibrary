package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;

/**Lớp Cloud hỗ trợ kết nối tới Cloudinary của bạn.
 * @author AnLaVN
 */
public class Cloud {
    private Cloudinary MyCloud = null;
    private Uploader MyUploader = null;
    private Cloud(){}
    
    
    /**Tạo một Cloudinary với đầy đủ thông tin. Sử dụng Cloud Name, API Key, API Secret.
     * @param Cloud_Name là tên Cloud của bạn.<br>
     * @param API_Key là API Key của bạn.<br>
     * @param API_Secret là API Secret của bạn.<br>
     * @see Cloud#Cloud(java.lang.String) 
     */
    public Cloud(String Cloud_Name, String API_Key, String API_Secret){
        this.MyCloud = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", Cloud_Name,
            "api_key", API_Key,
            "api_secret", API_Secret  ));
        this.MyUploader = MyCloud.uploader();
    }
    
    
    /**Tạo một Cloudinary với đầy đủ thông tin. Sử dụng Biến Môi Trường API.
     * @param URL là CLOUDINARY_URL của bạn.
     * @see Cloud#Cloud(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Cloud(String URL){
        this.MyCloud = new Cloudinary(URL);
        this.MyUploader = MyCloud.uploader();
    }
    
    
    /**Sử dụng phương thức này để lấy Cloudinary của bạn.
     * @return Cloudinary của bạn.
     */
    public final Cloudinary getCloudinary(){
        return MyCloud;
    }
    
    
    /**Sử dụng phương thức này để tải tệp lên Cloudinary, hỗ trợ hình ảnh, video, thô, tự động.
     * @param filePath là đường dẫn của tệp.<br>Ví dụ "C:/user/Picture/yourFile.png" hoặc "Picture/yourFile.png".<br>
     * @return URL của tệp sau khi tải lên thành công.
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc đám mây không tồn tại.
     * @see Cloud#FileUpload(java.lang.String, java.lang.String)
     */
    public final String FileUpload(String filePath) throws IOException{
        return FileUpload(filePath, null);
    }
    
    
    /**Sử dụng phương thức này để tải Tệp vào Thư mục của bạn trên Cloudinary, hỗ trợ hình ảnh, video, thô, tự động.
     * @param filePath là đường dẫn của tệp.<br>Ví dụ "C:/user/Picture/yourFile.png" hoặc "Picture/yourFile.png".<br>
     * @param CloudPath là đường dẫn của Thư mục trên Cloudinary.<br>Ví dụ "Picture/" hoặc "myFloder/Picture/".
     * @return URL của tệp sau khi tải lên thành công.
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc đám mây không tồn tại.
     * @see Cloud#FileUpload(java.lang.String) 
     */
    public final String FileUpload(String filePath, String CloudPath) throws IOException{
        return (String) MyUploader.upload(new File(filePath), 
                ObjectUtils.asMap("resource_type", "auto", "use_filename", true, "folder", CloudPath)).get("url");
    }
    
    
    /**Sử dụng phương thức này để xóa tệp của bạn trên Cloudinary bằng URL.<br><b><i>Chỉ hỗ trợ hình ảnh</i></b>.
     * @param url là URL của Tệp cần xóa. <br>
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc đám mây không tồn tại.
     * @see Cloud#FileDeleteByID(java.lang.String)
     */
    public final void FileDeleteByURL(String url) throws IOException{
        String publicID = url.substring(url.lastIndexOf("/", url.indexOf("d/v")+14)+1, url.lastIndexOf("."));
        if(url.contains("/image/upload/")){
            Log.add("Cloudinary Public ID: " + publicID);
            FileDeleteByID(publicID);}
        else{Log.add("!!! This method only support \"image\" Resource Type. !!!");}
    }
    
    
    /**Sử dụng phương thức này để xóa tệp của bạn trên Cloudinary bằng Public ID.<br><b><i>Chỉ hỗ trợ hình ảnh</i></b>.
     * @param publicID là Public ID của tệp cần xóa. <br>
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc đám mây không tồn tại.
     * @see Cloud#FileDeleteByURL(java.lang.String) 
     */
    public final void FileDeleteByID(String publicID) throws IOException{
        MyUploader.destroy(publicID, ObjectUtils.emptyMap()); 
    }
}