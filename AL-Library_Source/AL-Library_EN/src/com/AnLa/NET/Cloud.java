package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;

/**The Cloud class supports connected to your Cloudinary.
 * @author AnLaVN
 */
public class Cloud {
    private Cloudinary MyCloud = null;  
    private Uploader MyUploader = null;
    private Cloud() {}
    
    
    /**Create a Cloudinary with full information. Using Cloud Name, API Key, API Secret.
     * @param Cloud_Name is your Cloud Name.<br>
     * @param API_Key is your API Key.<br>
     * @param API_Secret is your API Secret.<br>
     * @see Cloud#Cloud(java.lang.String) 
     */
    public Cloud(String Cloud_Name, String API_Key, String API_Secret){
        this.MyCloud = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", Cloud_Name,
            "api_key", API_Key,
            "api_secret", API_Secret  ));
        this.MyUploader = MyCloud.uploader();
    }
    
    
    /**Create a Cloudinary with full information. Using API Environment variable.
     * @param URL is your CLOUDINARY_URL.
     * @see Cloud#Cloud(java.lang.String, java.lang.String, java.lang.String)
     */
    public Cloud(String URL){
        this.MyCloud = new Cloudinary(URL);
        this.MyUploader = MyCloud.uploader();
    }
    
    
    /**Use this method to get your Cloudinary.
     * @return your Cloudinary.
     */
    public final Cloudinary getCloudinary(){
        return MyCloud;
    }
    
    
    /**Use this method to upload file into Cloudinary, support image, video, raw, auto.
     * @param filePath is a path of file.<br>Example "C:/user/Picture/yourFile.png" or "Picture/yourFile.png".<br>
     * @return a URL of file after upload successfully.
     * @throws java.io.IOException throw exception if there is an error like no internet connection or cloud does not exist.
     * @see Cloud#FileUpload(java.lang.String, java.lang.String)
     */
    public final String FileUpload(String filePath) throws IOException{
        return FileUpload(filePath, null);
    }
    
    
    /**Use this method to upload File into your Folder on Cloudinary, support image, video, raw, auto.
     * @param filePath is a path of File.<br>Example "C:/user/Picture/yourFile.png" or "Picture/yourFile.png".<br>
     * @param CloudPath is a Path of Folder on Cloudinary.<br>Example "Picture/" or "myFloder/Picture/".
     * @return a URL of File after upload successfully.
     * @throws java.io.IOException throw exception if there is an error like no internet connection or cloud does not exist.
     * @see Cloud#FileUpload(java.lang.String) 
     */
    public final String FileUpload(String filePath, String CloudPath) throws IOException{
        return (String) MyUploader.upload(new File(filePath), 
                ObjectUtils.asMap("resource_type", "auto", "use_filename", true, "folder", CloudPath)).get("url");
    }
    
    
    /**Use this method to delete your File on Cloudinary by URL.<br><b><i>Only support image</i></b>.
     * @param url is a URL of File need delete.<br>
     * @throws java.io.IOException throw exception if there is an error like no internet connection or cloud does not exist.
     * @see Cloud#FileDeleteByID(java.lang.String)
     */
    public final void FileDeleteByURL(String url) throws IOException{
        String publicID = url.substring(url.lastIndexOf("/", url.indexOf("d/v")+14)+1, url.lastIndexOf("."));
        if(url.contains("/image/upload/")){
            Log.add("Cloudinary Public ID: " + publicID);
            FileDeleteByID(publicID);}
        else{Log.add("!!! This method only support \"image\" Resource Type. !!!");}
    }
    
    
    /**Use this method to delete your File on Cloudinary by Public ID.<br><b><i>Only support image</i></b>.
     * @param publicID is a Public ID of File need delete.<br>
     * @throws java.io.IOException throw exception if there is an error like no internet connection or cloud does not exist.
     * @see Cloud#FileDeleteByURL(java.lang.String) 
     */
    public final void FileDeleteByID(String publicID) throws IOException{
        MyUploader.destroy(publicID, ObjectUtils.emptyMap()); 
    }
}