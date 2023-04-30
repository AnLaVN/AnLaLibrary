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

/**Lớp FaceRecognition hỗ trợ nhận dạng khuôn mặt trong java, sử dụng chương trình python được biên dịch.
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
    
    
    /**Sử dụng phương thức này để kiểm tra Module hỗ trợ nhận dạng khuôn mặt.<br>Chạy phương thức này trước.
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
    
    
    /**Sử dụng phương thức này để đặt ảnh cho khuôn mặt gốc từ Tệp hoặc URL.
     * @param image là vị trí cụ thể của ảnh khuôn mặt, nó có thể là đường dẫn cục bộ trong máy tính hoặc địa chỉ liên kết của hình ảnh.<br>
     * Ví dụ: "C:/Users/Admin/Pictures/funfact.jpg"<br>hoặc "https://www.onthisday.com/images/people/rowan-atkinson-medium.jpg"
     * @throws java.io.IOException ném một ngoại lệ nếu không có kết nối internet hoặc không thể tải xuống hình ảnh từ liên kết.
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageOrginal(String image) throws IOException{       setImage(image, ORG_PATH);  }
    
    
    /**Sử dụng phương thức này để đặt ảnh cho khuôn mặt kiểm thử từ Tệp hoặc URL.
     * @param image là vị trí cụ thể của ảnh khuôn mặt, nó có thể là đường dẫn cục bộ trong máy tính hoặc địa chỉ liên kết của hình ảnh.<br>
     * Ví dụ: "C:/Users/Admin/Pictures/funfact.jpg"<br>hoặc "https://www.onthisday.com/images/people/rowan-atkinson-medium.jpg"
     * @throws java.io.IOException ném một ngoại lệ nếu không có kết nối internet hoặc không thể tải xuống hình ảnh từ liên kết.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageTesting(String image) throws IOException{       setImage(image, TES_PATH);  }
    
    
    /**Sử dụng phương thức này để đặt hình ảnh cho khuôn mặt gốc từ BufferedImage.
     * @param buff là BufferedImage của ảnh khuôn mặt.
     * @throws java.io.IOException ném một ngoại lệ nếu không thể ghi BufferedImage vào tệp.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageOrginal(BufferedImage buff) throws IOException{ setImage(buff, ORG_PATH);   }

    
    /**Sử dụng phương thức này để đặt hình ảnh cho khuôn mặt kiểm thử từ BufferedImage.
     * @param buff là BufferedImage của ảnh khuôn mặt.
     * @throws java.io.IOException ném một ngoại lệ nếu không thể ghi BufferedImage vào tệp.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setRequirementPercent(java.lang.Double) 
     */
    public static final void setImageTesting(BufferedImage buff) throws IOException{ setImage(buff, TES_PATH);   }
    
    
    /**Sử dụng phương thức này để đặt phần trăm yêu cầu cho việc nhận dạng khuôn mặt. Càng cao càng khó. 65 là hiệu suất điển hình tốt nhất và cũng là giá trị mặc định.
     * @param per là tỷ lệ phần trăm cần thiết để nhận dạng khuôn mặt trả về <code>true</code>.
     * @see FaceRecognition#setImageOrginal(java.lang.String) 
     * @see FaceRecognition#setImageOrginal(java.awt.image.BufferedImage) 
     * @see FaceRecognition#setImageTesting(java.lang.String) 
     * @see FaceRecognition#setImageTesting(java.awt.image.BufferedImage) 
     */
    public static final void setRequirementPercent(Double per){    RequiPercent = (per >= 0.0 && per <= 100.0) ? per : RequiPercent;   }
    
    
    /**Sử dụng phương thức này để nhận dạng và nhận kết quả sau khi thiết lập thành công tất cả các tham số.
     * @return Kết quả sau khi nhận dạng:<br>
     * <code>[True]</code> nếu Khuôn mặt kiểm thử khớp với Khuôn mặt gốc và Phần trăm lớn hơn hoặc bằng Phần trăm yêu cầu.<br>
     * <code>[False]</code> nếu Khuôn mặt kiểm thử không khớp với Khuôn mặt gốc hoặc Phần trăm nhỏ hơn Phần trăm yêu cầu.<br>
     * <code>[Empty Error]</code> nếu Khuôn mặt gốc hoặc Khuôn mặt kiểm thử không tồn tại.<br>
     * <code>[Invalid Version]</code> nếu phiên bản FaceRecognition hiện tại không khớp với phiên bản yêu cầu. Khi đó chương trình sẽ dừng lại ngay lập tức.<br>
     * <code>[Connection Error]</code> nếu một ngoại lệ xảy ra khi kiểm tra phiên bản yêu cầu. Khi đó, chương trình sẽ dừng lại ngay lập tức.<br>
     * <code>[Face Recognition Error]</code> nếu một ngoại lệ xảy ra khi nhận dạng khuôn mặt. Như: <br>
     *      1. Không có hoặc có quá nhiều khuôn mặt trong khung hình.<br>
     *      2. Độ sáng quá thấp.<br>
     *      3. Khoảng cách giữa khuôn mặt và máy ảnh quá xa.<br>
     *      4. Có khẩu trang, kính, tóc che mặt...<br>
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
    
    
    /**Sử dụng phương thức này để có được tỷ lệ phần trăm nhận dạng khuôn mặt.
     * @return <code>Phần trăm</code> độ chính xác của khuôn mặt sau khi nhận dạng.
     * @see FaceRecognition#Recognition() 
     * @see FaceRecognition#isMatch() 
     */
    public static final Double getPercent(){  return Percent; }

    
    /**Sử dụng phương thức này để kiểm tra xem khuôn mặt có khớp với khuôn mặt ban đầu không?
     * @return <code>true</code> nếu Khuôn mặt kiểm thử khớp với Khuôn mặt gốc.<br>
      * <code>false</code> nếu Khuôn mặt kiểm thử không khớp với Khuôn mặt gốc.
     * @see FaceRecognition#Recognition() 
     * @see FaceRecognition#getPercent()
     */
    public static final Boolean isMatch(){   return Match;   }
}