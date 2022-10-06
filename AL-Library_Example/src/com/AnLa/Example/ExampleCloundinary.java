package com.AnLa.Example;


// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.Cloud.Cloud;

public class ExampleCloundinary {

    public static void main(String[] args) {
        //Create cloud variable, there a 2 way
        //Way 1
        Cloud clound = new Cloud();
        clound.setCloudinary("Cloud Name", "API Key", "API Secret");
        
        //Way 2
//        Cloud clound = new Cloud("Cloud Name", "API Key", "API Secret");
        
        //Upload file, this method return a URL of file on Cloud, support many type: image, video, raw, auto
        String url = clound.FileUpload("C:/Users/Admin/Pictures/myFile.png");
        System.out.println("URL: "+url);
        
        //Delete file, this method support image only, there are 2 way
        //Way 1
        clound.FileDeleteByURL("https://res.cloudinary.com/myClound/image/upload/v1234567890/myFile.png");
        
        //Way 2
        clound.FileDeleteByID("myFile");
    }
}