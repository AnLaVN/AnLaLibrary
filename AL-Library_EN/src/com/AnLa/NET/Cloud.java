package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**The Cloud class supports connected to your Cloudinary.
 *
 * @author Admin
 */
public class Cloud {
    
    private Cloudinary MyCloud = null;
    
    /**Create a default Cloudinary.
      *@see Cloud#Cloud(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Cloud() {}
    
    /**Create a Cloudinary with full information.
     * @param Clound_Name is your Cloud Name.<br>
     * @param API_Key is your API Key.<br>
     * @param API_Secret is your API Secret.<br>
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
            Log.add("!!! Your Clound is null, please use setCloundinary method. !!!"); 
            throw new RuntimeException();
        }
    }
    
    
    /**Use this method to set information your Cloudinary.
     * @param Clound_Name is your Cloud Name.<br>
     * @param API_Key is your API Key.<br>
     * @param API_Secret is your API Secret.<br>
     * @see Cloud#Cloud(java.lang.String, java.lang.String, java.lang.String) 
     */
    public void setCloudinary(String Clound_Name, String API_Key, String API_Secret) {
        this.MyCloud = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", Clound_Name,
            "api_key", API_Key,
            "api_secret", API_Secret  ));
    }
    
    
    /**Use this method to upload file into Cloudinary, support image, video, raw, auto.
     * @param filePath is a path of file.<br>Example "C:/user/Picture/yourFile.png" or "Picture/yourFile.png".<br>
     * @return a URL of file after upload successfully.
     * @see Cloud#FileUpload(java.lang.String, java.lang.String)
     */
    public String FileUpload(String filePath){
        return FileUpload(filePath, null);
    }
    
    
    /**Use this method to upload File into your Folder on Cloudinary, support image, video, raw, auto.
     * @param filePath is a path of File.<br>Example "C:/user/Picture/yourFile.png" or "Picture/yourFile.png".<br>
     * @param CloundPath is a Path of Folder on Cloudinary.<br>Example "Picture/" or "myFloder/Picture/".
     * @return a URL of File after upload successfully.
     * @see Cloud#FileUpload(java.lang.String) 
     */
    public String FileUpload(String filePath, String CloundPath){
        checkClound();
        try {
            Map uploadResult = MyCloud.uploader().upload(new File(filePath), ObjectUtils.asMap("resource_type", "auto", "use_filename", true, "folder", CloundPath));
            return (String) uploadResult.get("url");
        }catch (IOException e) {
            Log.add("!!! Error trying to upload Image to Cloundinary. !!!");
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to delete your File on Cloudinary by URL.<br><b><i>Only support image</i></b>.
     * @param url is a URL of File need delete.<br>
     * @see Cloud#FileDeleteByID(java.lang.String)
     */
    public void FileDeleteByURL(String url){
        String publicID = url.substring(url.lastIndexOf("/", url.indexOf("d/v")+14)+1, url.lastIndexOf("."));
        if(url.contains("/image/upload/")){
            Log.add("Cloundinary Public ID: "+publicID);
            FileDeleteByID(publicID);}
        else{Log.add("!!! This method only support \"image\" Resource Type. !!!");}
    }
    
    
    /**Use this method to delete your File on Cloudinary by Public ID.<br><b><i>Only support image</i></b>.
     * @param publicID is a Public ID of File need delete.<br>
     * @see Cloud#FileDeleteByURL(java.lang.String) 
     */
    public void FileDeleteByID(String publicID){
        checkClound();
        try{    MyCloud.uploader().destroy(publicID, ObjectUtils.emptyMap());   }
        catch(IOException e){  Log.add("!!! Error trying to delete File on Cloundinary. !!!");}
    }
}