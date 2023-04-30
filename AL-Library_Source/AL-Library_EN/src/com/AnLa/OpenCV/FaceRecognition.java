package com.AnLa.OpenCV;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.AnLa.FILE.Zip;
import com.AnLa.NET.DocNet;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.imageio.ImageIO;

/**The FaceRecognition class supports to face recognition in java, using python program compiled.
 * @author AnLaVN
 */
public final class FaceRecognition {
    private static final String ORG_PATH = "FaceRecognition/Image/orginal.png", TES_PATH = "FaceRecognition/Image/testing.png";
    private static Double Percent = null, RequiPercent = 65.0;
    private static boolean Match = false;
    private static void setImage(String image, String filePath) throws IOException{
        if(image == null || image.isBlank()) return;
        image = image.replaceAll("\\\\", "/").trim();
        boolean isNet = image.startsWith("http");
        ImageIO.write(isNet ? ImageIO.read(new URL(image)) : ImageIO.read(new File(image)), "png", new File(filePath)); 
        Log.add("FaceRecognition - Set Image from " + (isNet ? "URL" : "File" ) +" \"" + image + "\" to \"" + filePath +"\" successfully.");
    }
    private static void setImage(BufferedImage buff, String filePath) throws IOException{
        ImageIO.write(buff, "png", new File(filePath)); 
        Log.add("FaceRecognition - Set Image from BufferedImage to \"" + filePath +"\" successfully.");
    }
    
    
    /**Use this method to check Module support for face recognition.<br>Run this method first.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void checkModule(){
        if(!new File("FaceRecognition/FaceRecognition.exe").exists()){
            Log.add("!!! Error try to Face Recognition: No module FaceRecognition, trying to download it. !!!");
            try {   String zipFace = "FaceRecognition.zip";
                if(!new File(zipFace).exists()) new DocNet("https://github.com/AnLaVN/AL-Library/releases/download/v3.68.11/FaceRecognition.zip").saveAs(zipFace);
                Zip.Extract(zipFace, "");
            } catch (IOException e) {
                Log.add("!!! Error try to Face Recognition: Can not download module FaceRecognition. Please check your connecttion. !!!\n\t\tError code: " + e.toString());
                throw new RuntimeException(e);
            }
        }
    }
    
    
    /**Use this method to set image for original face from File or URL.
     * @param image is specific location of face image, it can be local path in computer or link address of image.<br>
     * Example: "C:/Users/Admin/Pictures/funfact.jpg"<br>or "https://www.onthisday.com/images/people/rowan-atkinson-medium.jpg"
     * @throws java.io.IOException throw an exception if there is no internet connection or can't download image from link.
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageOrginal(String image) throws IOException{       setImage(image, ORG_PATH);  }
    
    
    /**Use this method to set image for testing face from File or URL.
     * @param image is specific location of face image, it can be local path in computer or link address of image.<br>
     * Example: "C:/Users/Admin/Pictures/funfact.jpg"<br>or "https://www.onthisday.com/images/people/rowan-atkinson-medium.jpg"
     * @throws java.io.IOException throw an exception if there is no internet connection or can't download image from link.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageTesting(String image) throws IOException{       setImage(image, TES_PATH);  }
    
    
    /**Use this method to set image for original face from BufferedImage.
     * @param buff is BufferedImage of face image.
     * @throws java.io.IOException throw an exception if can't write BufferedImage to file.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageOrginal(BufferedImage buff) throws IOException{ setImage(buff, ORG_PATH);   }
    
    
    /**Use this method to set image for testing face from BufferedImage.
     * @param buff is BufferedImage of face image.
     * @throws java.io.IOException throw an exception if can't write BufferedImage to file.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageTesting(BufferedImage buff) throws IOException{ setImage(buff, TES_PATH);   }
    
    
    /**Use this method to set the required percentage for face recognition. More high more hard. 65 is typical best performance and the default value also.
     * @param per is percentage required for face recognition to return <code>true</code>.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     */
    public static final void setRequirementPercent(Double per){    RequiPercent = (per >= 0.0 && per <= 100.0) ? per : RequiPercent;   }
    
    
    /**Use this method to recognition and get result after setup successfully all parameter.
     * @return Result after recognition:<br>
     * <code>[True]</code> if Testing Face match Original Face and Percent greater than or equal to RequirementPercent.<br>
     * <code>[False]</code> if Testing Face does not match Original Face or Percent less than RequirementPercent.<br>
     * <code>[Empty Error]</code> if Original Face or Testing Face not exists.<br>
     * <code>[Invalid Version]</code> if the current version of FaceRecognition does not match the requirements version. Then the program will stop immediately.<br>
     * <code>[Connection Error]</code> if an exception occurs when checking the requirements version. Then the program will stop immediately.<br>
     * <code>[Face Recognition Error]</code> if an exception occurs when recognizing face. Like: <br>
     *      1. No or too many faces in the frame.<br>
     *      2. Brightness is too low.<br>
     *      3. The distance between the face and the camera is too far.<br>
     *      4. There are masks, glasses, hair covering the face...<br>
     * @see FaceRecognition#getPercent() 
     * @see FaceRecognition#isMatch() 
     */
    public static final String Recognition(){
        String Result = null;   Percent = null; Match = false;
        try {
            if(!new File(ORG_PATH).exists() || !new File(TES_PATH).exists())    return "[Empty Error]";
            Process process = new ProcessBuilder("FaceRecognition/FaceRecognition.exe").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            Result = reader.readLine();
            if(!Result.contains("Invalid") && !Result.contains("Error")){
                String doub = reader.readLine();
                Percent = 100 - Double.parseDouble(doub.substring(1, doub.length() -1 )) * 100;
                Match = Percent >= RequiPercent;
                Result = !Match ? "[False]" : Result;
            }else Log.add("!!! Error try to Face Recognition: " + reader.readLine() + " !!!");
        } catch (IOException ex) {Log.add("!!! Error try to Face Recognition: " + ex.toString());}
        return Result;
    }
    
    
    /**Use this method to get facial recognition percentage.
     * @return <code>Percent</code> accuracy of face after recognition.
     * @see FaceRecognition#Recognition() 
     * @see FaceRecognition#isMatch() 
     */
    public static final Double getPercent(){  return Percent; }

    
    /**Use this method to check if the face matches the original face?
     * @return <code>true</code> if Testing Face match Original Face.<br>
     * <code>false</code> if Testing Face does not match Original Face
     * @see FaceRecognition#Recognition() 
     * @see FaceRecognition#getPercent()
     */
    public static final Boolean isMatch(){   return Match;   }
}