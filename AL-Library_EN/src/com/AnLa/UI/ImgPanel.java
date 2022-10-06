package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ImgPanel extends javax.swing.JPanel {
    private BufferedImage image;

    /**Use this method to set Picture for Panel.
     * @param filePath is a String path of picture file inside source folder.<br>Example: "src/Your/Packages/yourImages.png"
     */
    public void setPic(String filePath) {
        try { 
            File file = new File(filePath.replaceAll("\\\\", "/"));
            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(true);
            image = ImageIO.read(file);
        }
        catch (IOException ex) {  System.out.println(ex); }
        repaint();    
    }
    public ImgPanel(){}
    
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    
    @Override public void setCursor(Cursor cursor)      {   super.setCursor(cursor);}
    @Override public void setLayout(LayoutManager mgr)  {   super.setLayout(mgr);   }
}