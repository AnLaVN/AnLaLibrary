package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**Lớp ProgressBar hỗ trợ xuất thanh tiến trình hiện đại.
 * @author AnLaVN
 */
public class ProgressBar extends JProgressBar {
    
    private Color colorString = new Color(200, 200, 200);
    
    /**Tạo một Thanh Tiến Trình hiện đại.
     */
    public ProgressBar() {
        setStringPainted(true);
        setPreferredSize(new Dimension(100, 15));
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(69, 124, 235));
        setUI(new BasicProgressBarUI() {
            @Override
            protected void paintString(Graphics grphcs, int i, int i1, int i2, int i3, int i4, Insets insets) {
                grphcs.setColor(getColorString());
                super.paintString(grphcs, i, i1, i2, i3, i4, insets);
            }
        });
    }
    
    public Color getColorString() {
        return colorString;
    }
    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }
}