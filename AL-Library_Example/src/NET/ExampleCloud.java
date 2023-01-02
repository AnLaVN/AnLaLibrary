package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.Cloud;
import java.io.IOException;

public class ExampleCloud {

    public static void main(String[] args) throws IOException {
        Cloud cloud = new Cloud("cloudinary://yoururlapi"); //setup your cloudinary api
        String url = cloud.FileUpload("myImage.png");       //get url after upload image file
        System.out.println("Link of my file: " + url);      //print url
        //cloud.FileDeleteByURL(url);                       //delete file using url
    }
}