package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import com.k33ptoo.components.KGradientPanel;
import java.awt.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**The ChatBox class supports display a message box like messenger.
 * @author Admin
 */
public class ChatBox extends JScrollPane{
    private final Chat chat = new Chat();
    
    /**Create a default message box. To customize the look, refer to the methods below.
     * @see ChatBox#setFontSize(java.awt.Font) <br>
     * @see ChatBox#setBorderRadius(int) <br>
     * @see ChatBox#setNotifiColor(java.awt.Color) <br>
     * @see ChatBox#setRightBubble(java.awt.Color, java.awt.Color, int) <br>
     * @see ChatBox#setLeftBubble(java.awt.Color, java.awt.Color, int) <br>
     */
    public ChatBox() {
        this.setHorizontalScrollBar(null);
        this.setVerticalScrollBar(new com.AnLa.UI.ScrollBar());
        this.setBorder(null);
        chat.setBorder(null);
        this.setViewportView(chat);
    }

    /**Use this method to add a bubble text at right side message box.
     * @param message is a message you want to add.<br>
     */
    public void addRightBubble(String message)  {    chat.addRightBubble(message);  }

    /**Use this method to add a bubble text at left side message box.
     * @param message is a message you want to add.<br>
     */
    public void addLeftBubble(String message)   {    chat.addLeftBubble(message);   }

    /**Use this method to add a notification in message box.
     * @param message is a notification you want to add.<br>
     */
    public void addNotifiBox(String message)    {    chat.addNotifiBox(message);    }
        
    /**Use this method to customize font size of message.
     * @param font is your desired font.<br>
     */
    public void setFontSize(Font font)          {   chat.setFontSize(font);         }

    /**Use this method to customize border radius of bubble message.
     * @param BorderRadius is your desired border radius.<br>
     */
    public void setBorderRadius(int BorderRadius)   {   chat.setBorderRadius(BorderRadius); }

    /**Use this method to customize the color of notification message.
     * @param NotifiColor is your desired color.<br>
     */
    public void setNotifiColor(Color NotifiColor)   {   chat.setNotifiColor(NotifiColor);   }

    /**Use this method to customize the bubble at the right side of the message box
     * @param StartColor is gradient end color to the left.<br>
     * @param EndColor is gradient end color to the right.<br>
     * @param GradientFocus is location to which the gradient should focus (accepts negative value)<br>
     */
    public void setRightBubble(Color StartColor, Color EndColor, int GradientFocus) {
        chat.setRightBubble(StartColor, EndColor, GradientFocus);
    }

    /**Use this method to customize the bubble at the left side of the message box
     * @param StartColor is gradient end color to the left.<br>
     * @param EndColor is gradient end color to the right.<br>
     * @param GradientFocus is location to which the gradient should focus (accepts negative value)<br>
     */
    public void setLeftBubble(Color StartColor, Color EndColor, int GradientFocus)  {
        chat.setLeftBubble(StartColor, EndColor, GradientFocus);
    }
    
    @Override protected void paintComponent(Graphics g) { super.paintComponent(g);  }
    @Override public void setLayout(LayoutManager mgr)  {   super.setLayout(mgr);   }

    private class Chat extends JPanel    {
        private int preHeight = 0, line, X, Y, widthPane, widthText, heightText,
                BorderRadius = 20,
                RightGradientFocus = 180,
                LeftGradientFocus  = 200;
        private Color 
                RightStartColor = new Color(67, 156, 251),
                RightEndColor   = new Color(241, 135, 251),
                LeftStartColor  = new Color(150, 198, 234),
                LeftEndColor    = new Color(181, 151, 246),
                NotifiColor     = new Color(150, 150, 150);
        private final Color Blind = new Color(0,0,0,0);
        private final JLabel temp = new JLabel();
        private Font font = new Font("Tahoma", 0, 17);

        private Chat() {
            this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            this.setBorder(null);
        }

        private void setFontSize(Font font)             {
            this.font = font;
        }
        private void setBorderRadius(int BorderRadius)  {
            this.BorderRadius = BorderRadius;
        }
        private void setNotifiColor(Color NotifiColor)  {
            this.NotifiColor = NotifiColor;
        }
        private void setRightBubble(Color StartColor, Color EndColor, int GradientFocus){
            RightStartColor = StartColor;
            RightEndColor = EndColor;
            RightGradientFocus = GradientFocus;
        }
        private void setLeftBubble(Color StartColor, Color EndColor, int GradientFocus) {
            LeftStartColor = StartColor;
            LeftEndColor = EndColor;
            LeftGradientFocus = GradientFocus;
        }
        private void rePaint(Rectangle aRect)   {
            this.scrollRectToVisible(aRect);
            super.validate();
            super.repaint(); 
        }
        private void addRightBubble(String text){
            text = text.trim();
            if(!text.equals("")){
                KGradientPanel RightBubble = new KGradientPanel();   
                JTextArea txt = new JTextArea();
                txt.setFont(font);
                txt.setText(text);

                //Thuat toan tinh toan kich thuoc, vi tri cho chat bubble
                temp.setFont(font);
                temp.setText(text);
                widthText = temp.getMaximumSize().width + 5;
                heightText= temp.getMaximumSize().height;
                line = widthText < widthPane - 50 ? 1 : ((widthText / (widthPane - 2*50)) + 1);
                X = widthText < widthPane ? widthPane - widthText - 40 : 60;
                Y = Y + preHeight + 25;
                preHeight = (line * heightText);

                //Tao chat bubble
                RightBubble.setkBorderRadius(BorderRadius);         txt.setBorder(null);            //txt.setColumns(20);
                RightBubble.setkStartColor(RightStartColor);        txt.setWrapStyleWord(true);     //txt.setRows(1000);
                RightBubble.setkEndColor(RightEndColor);            txt.setLineWrap(true);          txt.setEditable(false);
                RightBubble.setkGradientFocus(RightGradientFocus);  txt.setEditable(false);    
                RightBubble.setBackground(Blind);                   txt.setBackground(Blind);

                javax.swing.GroupLayout cboxLayout = new javax.swing.GroupLayout(RightBubble);
                RightBubble.setLayout(cboxLayout);
                cboxLayout.setHorizontalGroup(
                    cboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cboxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, widthText < widthPane ? widthText : widthPane - 2*50, Short.MAX_VALUE)
                        .addContainerGap())
                );
                cboxLayout.setVerticalGroup(
                    cboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cboxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, heightText, Short.MAX_VALUE)
                        .addContainerGap())
                );
                //setLocationRelativeTo(null);
                this.add(RightBubble, new AbsoluteConstraints(X, Y, -1, -1));
                Rectangle aRect = new Rectangle();
                aRect.y = Y + preHeight + 100;
                rePaint(aRect);
            }
        }
        private void addLeftBubble(String text) {
            text = text.trim();
            if(!text.equals("")){
                KGradientPanel LeftBubble  = new KGradientPanel();  
                JTextArea txt = new JTextArea();
                txt.setFont(font);
                txt.setText(text.trim());

                //Thuat toan tinh toan kich thuoc, vi tri cho chat bubble
                temp.setFont(font);
                temp.setText(text.trim());
                widthText = temp.getMaximumSize().width + 5;
                heightText= temp.getMaximumSize().height;
                line = widthText < widthPane - 50 ? 1 : ((widthText / (widthPane - 2*50)) + 1);
                X = 20;
                Y = Y + preHeight + 25;
                preHeight = (line * heightText);

                //Tao chat bubble
                LeftBubble.setkBorderRadius(BorderRadius);          txt.setBorder(null);            //txt.setColumns(20);
                LeftBubble.setkStartColor(LeftStartColor);          txt.setWrapStyleWord(true);     //txt.setRows(1000);
                LeftBubble.setkEndColor(LeftEndColor);              txt.setLineWrap(true);          
                LeftBubble.setkGradientFocus(LeftGradientFocus);    txt.setEditable(false);  
                LeftBubble.setBackground(Blind);                    txt.setBackground(Blind);

                javax.swing.GroupLayout cboxLayout = new javax.swing.GroupLayout(LeftBubble);
                LeftBubble.setLayout(cboxLayout);
                cboxLayout.setHorizontalGroup(
                    cboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cboxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, widthText < widthPane ? widthText : widthPane - 2*50, Short.MAX_VALUE)
                        .addContainerGap())
                );
                cboxLayout.setVerticalGroup(
                    cboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cboxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, heightText, Short.MAX_VALUE)
                        .addContainerGap())
                );
                //setLocationRelativeTo(null);
                this.add(LeftBubble, new AbsoluteConstraints(X, Y, -1, -1));
                Rectangle aRect = new Rectangle();
                aRect.y = Y + preHeight + 100;
                rePaint(aRect);
            }
        }
        private void addNotifiBox(String text)  {
            text = text.trim();
            if(!text.equals("")){
                JLabel label = new JLabel(text.trim());
                label.setBackground(Blind);
                label.setFont(font);
                label.setForeground(NotifiColor);
                label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                Y = Y + preHeight + 20;
                preHeight = heightText;
                this.add(label, new AbsoluteConstraints(0, Y, widthPane, heightText));
                Rectangle aRect = new Rectangle();
                aRect.y = Y + 50;
                rePaint(aRect);
            }
        }
        @Override protected void paintComponent(Graphics g)     {   widthPane = getWidth(); }
        @Override public final void setLayout(LayoutManager mgr){   super.setLayout(mgr);   }
    }
}