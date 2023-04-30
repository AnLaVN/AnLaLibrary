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

/**Lớp DocNet hỗ trợ đọc tài liệu trực tuyến từ URL.
 * @author AnLaVN
 */
public class DocNet {
    private static InputStream ins;
    private static BufferedReader br;
    private static URL url;
    private DocNet() {}
    
    
    /**Tạo một tài liệu trực tuyến từ URL.
     * @param URL là liên kết đến tài liệu trực tuyến của bạn.
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet, URL không đúng định dạng hoặc tài liệu không tồn tại.
     */
    public DocNet(String URL) throws IOException{
        url = new URL(URL);
        ins = url.openStream();
        br = new BufferedReader(new InputStreamReader(ins));
    }
    
    
    /**Sử dụng phương thức này để lấy số byte của liên kết.
     * @return số byte của liên kết.
     * @throws IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc tài liệu không tồn tại.
     */
    public final long getSize() throws IOException {
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("HEAD");
            return con.getContentLengthLong();
        } finally { if (con != null) con.disconnect();  }
    }
    
    
    /**Sử dụng phương thức này để đọc một dòng văn bản.<br>Một dòng được coi là kết thúc bởi '\n', '\r', theo sau là dấu xuống dòng hoặc đến cuối tệp.
     * @return Chuỗi chứa nội dung của dòng, không bao gồm bất kỳ ký tự kết thúc dòng nào hoặc null nếu đã đến cuối luồng mà không đọc bất kỳ ký tự nào.
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc tài liệu không tồn tại.
     */
    public final String readLine() throws IOException{
        return br.readLine();
    }
    
    
    /**Sử dụng phương thức này để đọc tất cả các dòng văn bản.
     * @return Chuỗi chứa nội dung của tài liệu trực tuyến.
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc tài liệu không tồn tại.
     */
    public final String readAllLine() throws IOException{
        return new String(ins.readAllBytes(), "UTF-8"); 
    }
    
    
    /**Sử dụng phương thức này để lưu tệp về máy của bạn.
     * @param filePath là đường dẫn tệp bạn muốn lưu file.
     * @throws java.io.IOException ném ngoại lệ nếu có lỗi như không có kết nối internet hoặc tài liệu không tồn tại.
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
        dp.tittle.setText("Tải xuống " + fileName);
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