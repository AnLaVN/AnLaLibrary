package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**Lớp LiquidProgress hỗ trợ xuất thanh tiến trình dạng chất lỏng hiện đại.
 * @author AnLaVN
 */
public class LiquidProgress extends JProgressBar {
    private final LiquidProgressUI UI;
    private int borderSize = 5, spaceSize = 5;
    private Color animateColor = new Color(125, 216, 255), borderColor = new Color(0, 178, 255);

    
    /**Tạo một Thanh Tiến Trình dạng chất lỏng hiện đại.
     */
    public LiquidProgress() {
        UI = new LiquidProgressUI(this);
        setOpaque(false);
        setFont(new Font(getFont().getFamily(), 1, 20));
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.WHITE);
        setForeground(new Color(0, 178, 255));
        setUI(UI);
        setStringPainted(true);
    }

    public void startAnimation() {  UI.start(); }
    public void stopAnimation()  {  UI.stop();  }
    public int getBorderSize()   {  return borderSize;  }
    public void setBorderSize(int borderSize) { this.borderSize = borderSize;   }
    public int getSpaceSize()    {  return spaceSize;   }
    public void setSpaceSize(int spaceSize) {   this.spaceSize = spaceSize;     }
    public Color getAnimateColor(){ return animateColor;}
    public void setAnimateColor(Color animateColor) {   this.animateColor = animateColor;   }
    public Color getBorderColor() { return borderColor; }
    public void setBorderColor(Color borderColor)   {   this.borderColor = borderColor;     }
    

    private class LiquidProgressUI extends BasicProgressBarUI {
        private final LiquidProgress pro;
        private Thread thread;
        private boolean start;
        private float location1 = -1f;
        private float location2;
        private void init() {   start();    }
        private void sleep() {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        public LiquidProgressUI(LiquidProgress pro) {
            this.pro = pro;
            init();
        }
        public void start() {
            if (!start) {
                start = true;
                thread = new Thread(() -> {
                    while (start) {
                        location1 += 0.01f;
                        location2 += 0.01f;
                        if (location1 > 1f)     location1 = -1f;
                        if (location2 > 1f)     location2 = -1f;
                        pro.repaint();
                        sleep();
                    }
                });
                thread.start();
            }
        }
        public void stop() {    start = false;  }
        
        @Override public void paint(Graphics grphcs, JComponent jc) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = jc.getWidth();
            int height = jc.getHeight();
            int size = Math.min(width, height);
            int x = (width - size) / 2;
            int y = (height - size) / 2;
            g2.setColor(pro.getBorderColor());
            g2.fillOval(x, y, size, size);
            int borderSize = pro.getBorderSize();
            size -= borderSize * 2;
            g2.setColor(pro.getBackground());
            g2.fillOval(x + borderSize, y + borderSize, size, size);
            int spaceSize = pro.getSpaceSize();
            borderSize += spaceSize;
            size -= spaceSize * 2;
            createAnimation(g2, x + borderSize, y + borderSize, size);
            if (progressBar.isStringPainted())   paintString(grphcs);
            g2.dispose();
        }

        private void createAnimation(Graphics2D grphcs, int x, int y, int size) {
            BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Ellipse2D circle = new Ellipse2D.Double(0, 0, size, size);
            g2.setColor(progressBar.getBackground());
            g2.fill(circle);
            g2.setComposite(AlphaComposite.SrcIn);
            int value = (int) (size * progressBar.getPercentComplete());
            int waterStyleHeight = (int) (size * 0.07f); //  Height 7% of Size
            g2.setColor(pro.getAnimateColor());
            g2.fillRect(0, size - value, size, size);
            g2.fill(new ModelLiquid(new Rectangle((int) (location1 * size), size - value - waterStyleHeight, size, waterStyleHeight)).createWaterStyle());
            g2.fill(new ModelLiquid(new Rectangle((int) (location2 * size), size - value - waterStyleHeight, size, waterStyleHeight)).createWaterStyle());
            g2.dispose();
            grphcs.drawImage(img, x, y, null);
        }

        private void paintString(Graphics g) {
            Insets b = progressBar.getInsets();
            int barRectWidth = progressBar.getWidth() - b.right - b.left;
            int barRectHeight = progressBar.getHeight() - b.top - b.bottom;
            g.setColor(progressBar.getForeground());
            paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
        }
    }
    
    
    private class ModelLiquid {
        public Rectangle getSize() {    return size;    }
        public void setSize(Rectangle size) {   this.size = size;   }
        public ModelLiquid(Rectangle size) {    this.size = size;   }
        public ModelLiquid() {}
        private Rectangle size;

        public Shape createWaterStyle() {
            double width = size.getWidth();
            double heigh = size.getHeight();
            double space = width / 4;
            double x = size.getX();
            double y = size.getY();
            GeneralPath gp1 = new GeneralPath(new CubicCurve2D.Double(x, y + heigh, x + space, y + heigh, x + space, y, x + width / 2, y));
            gp1.lineTo(x + width / 2, y + heigh);
            GeneralPath gp2 = new GeneralPath(new CubicCurve2D.Double(x + width / 2, y, x + width - space, y, x + width - space, y + heigh, x + width, y + heigh));
            gp2.lineTo(x + width / 2, y + heigh);
            Area area = new Area(gp1);
            area.add(new Area(gp2));
            return area;
        }
    }
}