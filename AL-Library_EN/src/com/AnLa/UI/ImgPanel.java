package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImgPanel extends javax.swing.JPanel {
    private BufferedImage image;
    public void setPic(String filePath) {
        try { image = ImageIO.read(getClass().getResource(filePath)); }
        catch (IOException ex) {    System.out.println(ex); }
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