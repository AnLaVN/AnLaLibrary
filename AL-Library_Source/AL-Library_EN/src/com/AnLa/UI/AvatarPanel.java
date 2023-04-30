package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;

/**The AvatarPanel class supports display a cropped avatar picture.
 * @author AnLaVN
 */
public class AvatarPanel extends javax.swing.JPanel{
    private BufferedImage image;
    
    /**Create a default AvatarPanel.
     */
    public AvatarPanel(){}
    
    /**Use this method to set Picture for Panel.
     * @param filePath is a string path or url of picture.<br>Example: "src/Your/Packages/yourImages.png" or "https://i.pinimg.com/564x/b7/d2/62/b7d262d9ab6397f959a2030f65947b4f.jpg"
     */
    public void setPic(String filePath) {
        try { 
            if(filePath.startsWith("http")) image = ImageIO.read(new URL(filePath));
            else{
                File file = new File(filePath.replaceAll("\\\\", "/"));
                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
                image = ImageIO.read(file);
            }
        }
        catch (IOException e) {  Log.add("!!! Error try to set picture AvatarPanel from \"" + filePath +"\". !!!\n\tError code: " + e.toString()); }
        repaint();    
    }
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int circleDiameter = Math.min(getWidth(),getHeight());
        Ellipse2D.Double circle = new Ellipse2D.Double(0,0,circleDiameter,circleDiameter);
        g2.setClip(circle);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    @Override public void setCursor(Cursor cursor)      {   super.setCursor(cursor);}
    @Override public void setLayout(LayoutManager mgr)  {   super.setLayout(mgr);   }
}