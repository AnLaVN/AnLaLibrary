package OpenCV;

import com.AnLa.OpenCV.FaceRecognition;

public class ExampleFaceRecognition {

    public static void main(String[] args) {
        //set image for original face and test face using URL.
        //network connection is required to use the module regardless if you have set image from URL or not
        //FaceRecognition.setImageOrginal("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTNU14t4OtvdSZf-rTJAQWI6LdTIw5nYCYT1V3SfHgWja6cYMbG");
        //FaceRecognition.setImageTesting("https://nld.mediacdn.vn/2021/1/5/d9db633fe9c98429ec9025ca0950f241-16098228091571816318835.jpg");
        FaceRecognition.setRequirementPercent(60.0);//set a percentage requirement for face recognition, the higher the stricter
        
        System.out.println(FaceRecognition.Recognition());//recognition face and get result
        System.out.println(FaceRecognition.getPercent());//get percent was recognition
        System.out.println(FaceRecognition.isMatch());//get value if match, true if percent was recognition higher or equal with percentage requirement
    }
}