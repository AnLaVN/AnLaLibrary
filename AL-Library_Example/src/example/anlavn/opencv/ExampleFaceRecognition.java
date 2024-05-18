package example.anlavn.opencv;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.opencv.FaceRecognition;

public class ExampleFaceRecognition {

    public static void main(String[] args) throws java.io.IOException {
        FaceRecognition.API_KEY = "alk~XXX...XXX";// Add api key to use
        FaceRecognition.loadModule();             // Load module default.
        //set image for original face and test face using URL.
        FaceRecognition.setImageOrginal("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTNU14t4OtvdSZf-rTJAQWI6LdTIw5nYCYT1V3SfHgWja6cYMbG");
        FaceRecognition.setImageTesting("https://nld.mediacdn.vn/2021/1/5/d9db633fe9c98429ec9025ca0950f241-16098228091571816318835.jpg");
        //set a RequirementPercent for face recognition, the higher the stricter
        FaceRecognition.setRequirementPercent(60.0);
        //recognition and get result
        FaceRecognition.Result result = FaceRecognition.recognition(); 
        System.out.println(result.state);        // Get result state
        System.out.println(result.percentMatch); // Fet percent match
        System.out.println(result.isMatch);      // true if percentMatch higher or equal RequirementPercent
    }
}