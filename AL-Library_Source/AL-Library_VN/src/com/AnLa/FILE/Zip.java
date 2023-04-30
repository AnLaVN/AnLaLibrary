package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.UI.DownloadPopup;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**Lớp Zip hỗ trợ giải nén tệp zip vào thư mục của bạn.
 * @author AnLaVN
 */
public class Zip {
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1)   bos.write(bytesIn, 0, read);
        bos.close();
    }
    
    /**Sử dụng phương thức này để trích xuất một tệp .zip được chỉ định vào một thư mục được chỉ định.
     * @param zipFilePath là đường dẫn của tệp zip bạn muốn giải nén.
     * @param yourDirectory là đường dẫn của thư mục chứa các file sau khi giải nén.
     * Nó sẽ được tạo nếu không tồn tại, nếu bạn để trống thì thư mục gốc sẽ được chỉ định.
     */
    public static final void Extract(String zipFilePath, String yourDirectory){
        try{
            Log.add("Zip - Start collecting information.");
            long totalBytesRead = 0, fileSize = 0;
            int index = zipFilePath.lastIndexOf("/"), percentCompleted = 0;
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                fileSize += entry.getSize();
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            String fileName = zipFilePath.substring(index < 0 ? 0 : index);
            Log.add("Zip - Collect information successfully:\n\t\tFile name \"" + fileName + "\", total size after extract " + fileSize + " bytes.");
            DownloadPopup dp = new DownloadPopup();
            dp.tittle.setText("Giải nén " + fileName);
            dp.setVisible(true);
            if(yourDirectory == null || yourDirectory.equals("")) 
                yourDirectory = new File("").getAbsolutePath();
            else {
                File destDir = new File(yourDirectory); 
                if (!destDir.exists())      destDir.mkdir();
            }
            zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
            entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = yourDirectory + File.separator + entry.getName();
                if (!entry.isDirectory())   extractFile(zipIn, filePath);
                else                        new File(filePath).mkdirs();
                totalBytesRead += entry.getSize();
                percentCompleted = (int) (totalBytesRead * 100 / fileSize);
                dp.content.setText(totalBytesRead + " / " + fileSize + " byte.");
                dp.bar.setValue(percentCompleted);
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            dp.bar.stopAnimation();
            dp.dispose();
            Log.add("Zip - Extract zip file \"" + zipFilePath +"\" to \"" + yourDirectory + "\" directory successfully.");
            zipIn.close();
        } catch(IOException e){
            Log.add("!!! Error try to extract zip file \"" + zipFilePath +"\" to \"" + yourDirectory + "\" directory. !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
}