package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.Cloud;

public class ExampleCloud {

    public static void main(String[] args) {
        Cloud cloud = new Cloud("cloudinary://985969511487375:1zJ0Tonfsk5m3-asd9PotnkhiTc@anlavn");//setup your cloudinary api
        String url = cloud.FileUpload("myImage.png");   //get url after upload image file
        System.out.println("Link of my file: " + url);  //print url
        //cloud.FileDeleteByURL(url);                   //delete file using url
    }
    
}