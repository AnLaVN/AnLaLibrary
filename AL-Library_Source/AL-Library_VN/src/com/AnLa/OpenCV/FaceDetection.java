package com.AnLa.OpenCV;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.AnLa.FILE.NativeLibrary;
import com.AnLa.FILE.Zip;
import com.AnLa.NET.DocNet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static org.opencv.imgproc.Imgproc.rectangle;
import static org.opencv.imgcodecs.Imgcodecs.imencode;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

/**Lớp FaceDetection hỗ trợ nhận diện khuôn mặt bằng thư viện thị giác máy tính lớn nhất thế giới - OpenCV.
 * @author AnLaVN
 */
public final class FaceDetection {
    private static boolean DetectFace = false;
    private static JPanel panCam = null;
    private static int BorderRadius = 0, Thickness = 2, width = 0, height = 0;
    private static final String XML_PATH = "FaceDetection/FaceDetection.xml", 
                                DLL32_PATH = "FaceDetection/opencv_java460_32.dll", 
                                DLL64_PATH = "FaceDetection/opencv_java460_64.dll";
    private static File xmlFaceDetection = null;
    private static DaemonThread myThread = null;
    private static VideoCapture webSource = null;
    private static Mat frame = null;
    private static MatOfByte mem = null;
    private static CascadeClassifier faceDetector = null;
    private static MatOfRect faceDetections = null;
    private static BufferedImage buff;
    private static Scalar scalar = new Scalar(0, 255,0);
    private static class DaemonThread implements Runnable {
        protected volatile boolean runnable = false;
        @Override public void run() { synchronized (this) {
            RoundRectangle2D.Double panBoder = new RoundRectangle2D.Double(0, 0, width, height, BorderRadius, BorderRadius);
            while (runnable) {  if (webSource.grab()) {
                try {
                    webSource.retrieve(frame);
                    Graphics g = panCam.getGraphics();
                    if(DetectFace){
                        faceDetector.detectMultiScale(frame, faceDetections);
                        for (Rect rect : faceDetections.toArray()) {
                            rectangle(frame, 
                                      new Point(rect.x, rect.y), 
                                      new Point(rect.x + rect.width, rect.y + rect.height), 
                                      scalar, Thickness);}}
                    imencode(".bmp", frame, mem);
                    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                    buff = (BufferedImage) im;
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setClip(panBoder);
                    g.drawImage(buff, 0, 0, width, height, 0, 0, buff.getWidth(), buff.getHeight(), null);
                    if (runnable == false) {    this.wait();    }}
                catch (IOException | InterruptedException ex) { 
                    Log.add("!!! Error trying to Face Detection. !!!\n" + ex.toString());
                }
            }}}}}
    private static void loadXMLFile()   throws FileNotFoundException{
        xmlFaceDetection = new File(XML_PATH);
        if(!xmlFaceDetection.exists())  throw new FileNotFoundException("File not found \"" + XML_PATH + "\".");
    }
    private static void loadDLLFile()   throws FileNotFoundException{
        String bitLib = System.getProperty("sun.arch.data.model");
        Log.add("Face Detection Module - Load Computer architecture: " + bitLib + "-bit computing.");
        bitLib = bitLib.equals("64") ? DLL64_PATH : DLL32_PATH;
        if(!new File(bitLib).exists())  throw new FileNotFoundException("File not found \"" + bitLib + "\".");
        NativeLibrary.load(bitLib);
        Log.add("Face Detection Module - Load Native Library \"" + bitLib + "\" successfully.");
    }
    private static boolean isLoad(){
        return frame!=null && mem!=null && faceDetector!=null && faceDetections!=null && panCam!=null;
    }
    /**Sử dụng phương thức này để tải Module hỗ trợ nhận diện khuôn mặt.<br>
     * Chạy phương thức này trước.
     * @see FaceDetection#setDetectPanel(javax.swing.JPanel) 
     * @see FaceDetection#setDetectPanel(javax.swing.JPanel, int) 
     */
    public static final void loadModule(){
        try{
            loadXMLFile();
            loadDLLFile();
        }catch(FileNotFoundException e){
            Log.add("!!! Error try to Face Detection: No module FaceDetection, trying to download it. !!!");
            try {
                if(!new File("FaceDetection.zip").exists()) 
                    new DocNet("https://github.com/AnLaVN/AL-Library/releases/download/v3.68.11/FaceDetection.zip").saveAs("FaceDetection.zip");
                Zip.Extract("FaceDetection.zip", "");
                loadXMLFile();
                loadDLLFile();
            } catch (IOException ex) {
                Log.add("!!! Error try to Face Detection: Can not download module FaceDetection. Please check your connecttion. !!!\n\t\tError code: " + e.toString());
                System.exit(0);
            }
        }
        frame = new Mat();
        mem = new MatOfByte();
        faceDetector = new CascadeClassifier(xmlFaceDetection.getAbsolutePath());
        faceDetections = new MatOfRect();
        Log.add("Face Detection Module - Load Classifiers \"" + XML_PATH + "\" successfully.");
    }
    
    
    /**Sử dụng phương thức này để đặt panel nơi sẽ hiển thị ảnh chụp từ camera.
     * @param pan là JPanel bạn muốn hiển thị ảnh chụp của camera.
     * @see FaceDetection#setDetectPanel(javax.swing.JPanel, int) 
     */
    public static final void setDetectPanel(JPanel pan){
        setDetectPanel(pan, 0);
    }

    
    /**Sử dụng phương thức này để đặt bảng điều khiển có góc hiển thị ảnh chụp từ camera.
     * @param pan là JPanel mà bạn muốn hiển thị ảnh chụp từ camera.<br>
     * @param borderRadius là bán kính đường viền góc của JPanel.<br>
     * @see FaceDetection#setDetectPanel(javax.swing.JPanel) 
     */
    public static final void setDetectPanel(JPanel pan, int borderRadius){
        panCam = pan;
        width = panCam.getWidth();
        height = panCam.getHeight();
        BorderRadius = borderRadius;
    }
    

    /**Sử dụng phương thức này để bắt đầu nhận diện khuôn mặt bằng ID máy ảnh.
     * @param index ID của thiết bị quay video cần mở. Để mở máy ảnh mặc định sử dụng giá trị 0.
     * @see FaceDetection#loadModule() 
     * @see FaceDetection#setDetectPanel(javax.swing.JPanel) 
     * @see FaceDetection#setDetectPanel(javax.swing.JPanel, int) 
     * @see FaceDetection#endDetection() 
     */
    public static final void startDetection(int index){
        if(!isLoad()){
            Log.add("!!! Error try to Face Detection: Module has not been loaded. !!!\nUse loadModule() and setDetectPanel() method before run this method.");
            System.exit(0); }
        webSource = new VideoCapture(index);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
    }
    

    /**Sử dụng phương thức này để kết thúc nhận diện khuôn mặt.
     * @see FaceDetection#startDetection(int) 
     */
    public static final void endDetection(){
        myThread.runnable = false;
        webSource.release();
        panCam.getGraphics().clearRect(0, 0, width, height);
    }

    
    /**Sử dụng phương thức này để đặt khung khi phát hiện khuôn mặt.
     * @param detectFace <code>true</code> nếu bạn muốn nhận diện khuôn mặt, một khung hình chữ nhật sẽ hiển thị khi chúng tôi phát hiện khuôn mặt.<code> false</code> nếu bạn không muốn.<br>
     * @param color là màu của khung hình chữ nhật khi nó hiển thị.<br>
     * @param thickness là độ dày của khung hình chữ nhật khi nó hiển thị.<br>
     * @see FaceDetection#isDetectFace() 
     */
    public static final void setDetectFace(boolean detectFace, Color color, int thickness){
        DetectFace = detectFace;
        scalar = new Scalar(color.getBlue(), color.getGreen(), color.getRed());
        Thickness = thickness;
    }
    
    
    /**Sử dụng phương thức này để nhận giá trị liệu khuôn mặt có được phát hiện hay không.
     * @return <code>true</code> nếu bạn đặt thành phát hiện khuôn mặt, <code>false</code> nếu bạn không đặt giá trị hoặc được đặt thành không phát hiện khuôn mặt.
     * @see FaceDetection#setDetectFace(boolean, java.awt.Color, int) 
     */
    public static final boolean isDetectFace(){
        return DetectFace;
    }
    
    
    /**Sử dụng phương thức này để lấy giá trị nhận diện khuôn mặt có đang chạy hay không.
     * @return <code>true</code> nếu phương thức startDetection() đang chạy, <code>false</code> nếu không.
     * @see FaceDetection#startDetection(int) 
     */
    public static final boolean isDetection(){
        return myThread == null ? false : myThread.runnable;
    }
    
    
    /**Sử dụng phương thức này để lấy BufferedImage của toàn bộ khung hình đang được hiển thị trên JPanel.
     * @return một BufferedImage của toàn bộ khung hình trong JPanel.
     */
    public static final BufferedImage getBufferedImage(){
        return buff;
    }
}