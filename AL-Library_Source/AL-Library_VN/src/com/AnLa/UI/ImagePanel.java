package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**Lớp ImagePanel hỗ trợ hiển thị hình ảnh có thể thay đổi kích thước.
 * @author AnLaVN
 */
public class ImagePanel extends javax.swing.JPanel {
    private BufferedImage image;
    
    
    /**Tạo một ImagePanel mặc định.
     */
    public ImagePanel(){}
    
        
    /**Sử dụng phương thức này để đặt Hình ảnh cho Panel.
     * @param filePath là Chuỗi đường dẫn của tệp ảnh trong thư mục source.<br>
     * Ví dụ: "src/Your/Packages/yourImages.png"
     */
    public void setPic(String filePath) {
        try { 
            filePath = filePath.replaceAll("\\\\", "/");
            if(filePath.startsWith("src")){
                image = ImageIO.read(ImagePanel.class.getResource(filePath.replaceFirst("src", "")));
            }else{
                File file = new File(filePath);
                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
                image = ImageIO.read(file);
            }
        }
        catch (IOException ex) {   Log.add(ex.toString()); }
        repaint();    
    }
    
    
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    @Override public void setCursor(Cursor cursor)      {   super.setCursor(cursor);}
    @Override public void setLayout(LayoutManager mgr)  {   super.setLayout(mgr);   }
}