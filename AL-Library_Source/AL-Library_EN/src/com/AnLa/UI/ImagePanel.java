package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**The ImagePanel class supports displaying resizable images.
 * @author AnLaVN
 */
public class ImagePanel extends javax.swing.JPanel {
    private BufferedImage image;

    
    /**Create a default ImagePanel.
     */
    public ImagePanel(){}    
    
    
    /**Use this method to set Picture for Panel.
     * @param filePath is a String path of picture file inside source folder.<br>
     * Example: "src/Your/Packages/yourImages.png"
     */
    public void setPic(String filePath) {
        try {
            filePath = filePath.replaceAll("\\\\", "/");
            if (filePath.startsWith("src")) {
                image = ImageIO.read(ImagePanel.class.getResource(filePath.replaceFirst("src", "")));
            }else{
                File file = new File(filePath);
                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
                image = ImageIO.read(file);
            }
        }
        catch (IOException ex) {  Log.add(ex.toString()); }
        repaint();    
    }
    
    
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    @Override public void setCursor(Cursor cursor)      {   super.setCursor(cursor);}
    @Override public void setLayout(LayoutManager mgr)  {   super.setLayout(mgr);   }
}