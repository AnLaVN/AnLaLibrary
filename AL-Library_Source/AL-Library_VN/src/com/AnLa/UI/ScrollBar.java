package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;


/**Lớp ScrollBar hỗ trợ xuất thanh cuộn hiện đại.
 * @author AnLaVN
 */
public class ScrollBar extends JScrollBar {

    /**Tạo một Thanh cuộn hiện đại.
     */
    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(180, 180, 180));
        setBackground(Color.WHITE);
        setUnitIncrement(20);
    }
    
    
    private class ModernScrollBarUI extends BasicScrollBarUI {
        @Override protected JButton createIncreaseButton(int i) {   return new ScrollBarButton();   }
        @Override protected JButton createDecreaseButton(int i) {   return new ScrollBarButton();   }
        @Override protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {}
        @Override protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int x = rctngl.x;
            int y = rctngl.y;
            int width = rctngl.width - 4;
            int height = rctngl.height;
            if (this.scrollbar.getOrientation() == 1) {
                y += 8;
                height -= 16;
            } else {
                x += 8;
                width -= 16;
            }
            g2.setColor(this.scrollbar.getForeground());
            g2.fillRoundRect(x + 2, y, width, height, 10, 10);
        }
        @Override protected Dimension getMinimumThumbSize() {
            if (this.scrollbar.getOrientation() == 1) { return new Dimension(0, 60);    }
            return new Dimension(60, 0);
        }
        private class ScrollBarButton extends JButton {
            public ScrollBarButton() {  setBorder(BorderFactory.createEmptyBorder());   }
            @Override public void paint(Graphics grphcs) {}
        }
    }
}