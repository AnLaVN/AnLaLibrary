package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.AnLa.UI.DownloadPopup;
import static com.cloudinary.Uploader.BUFFER_SIZE;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**The DocNet class supports to read an online document from URL.
 * @author AnLaVN
 */
public class DocNet {
    private static InputStream ins;
    private static BufferedReader br;
    private static URL url;
    private DocNet() {}
    
    
    /**Create an online document from URL.
     * @param URL is the link to your online document.
     * @throws java.io.IOException throw exception if there is an error like no internet connection, malformed URL or the document does not exist.
     */
    public DocNet(String URL) throws IOException{
        url = new URL(URL);
        ins = url.openStream();
        br = new BufferedReader(new InputStreamReader(ins));
    }
    
    
    /**Use this method to get the number of bytes of the link.
     * @return number of bytes of the link.
     * @throws java.io.IOException throw exception if there is an error like no internet connection or the document does not exist.
     */
    public final long getSize() throws IOException {
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("HEAD");
            return con.getContentLengthLong();
        } finally { if (con != null) con.disconnect();  }
    }
    
    
    /**Use this method to reads a line of text.<br>A line is considered to be terminated by '\n', '\r', a carriage return followed or by reaching the end-of-file.
     * @return A String containing the contents of the line, not including any line-termination characters, or null if the end of the stream has been reached without reading any characters.
     * @throws java.io.IOException throw exception if there is an error like no internet connection or the document does not exist.
     */ 
    public final String readLine() throws IOException{
        return br.readLine();
    }
    
    
    /**Use this method to read all line of text.
     * @return A String containing the content of online document.
     * @throws java.io.IOException throw exception if there is an error like no internet connection or the document does not exist.
     */
    public final String readAllLine() throws IOException{
        return new String(ins.readAllBytes(), "UTF-8");
    }
    
    
    /**Use this method to save the file to your computer.
     * @param filePath is the file path you want to save the file.
     * @throws java.io.IOException throw exception if there is an error like no internet connection or the document does not exist.
     */
    public final void saveAs(String filePath) throws IOException {
        Log.add("Doc Net - Start collecting information.");
        FileOutputStream outputStream = new FileOutputStream(filePath);
        filePath = filePath.replaceAll("\\\\", "/");
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1, percentCompleted = 0, index = filePath.lastIndexOf("/");
        long totalBytesRead = 0, fileSize = getSize();
        String fileName = filePath.substring(index < 0 ? 0 : index);
        Log.add("Doc Net - Collect information successfully:\n\t\tFile name \"" + fileName + "\", total size " + fileSize + " bytes.");
        DownloadPopup dp = new DownloadPopup();
        dp.tittle.setText("Download " + fileName);
        dp.setVisible(true);
        while ((bytesRead = ins.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
            totalBytesRead += bytesRead;
            percentCompleted = (int) (totalBytesRead * 100 / fileSize);
            dp.content.setText(totalBytesRead + " / " + fileSize + " bytes.");
            dp.bar.setValue(percentCompleted);
        }
        dp.bar.stopAnimation();
        dp.dispose();
        Log.add("Doc Net - Save file successfully:\n\t\tFile path \"" + filePath + "\", total size " + fileSize + " bytes.");
    }
}