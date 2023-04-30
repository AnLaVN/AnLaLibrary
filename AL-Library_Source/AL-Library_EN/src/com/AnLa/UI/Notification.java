package com.AnLa.UI;
//Edit by Bình An || AnLaVN || KatoVN

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


/**The Notification class supports to create a animation popup notification.
 * @author AnLaVN
 */
public class Notification extends javax.swing.JComponent {

    private final Color BLIND = new Color(0, 0, 0, 0);
    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private final int animate = 20;
    private BufferedImage imageShadow;
    private final int shadowSize = 10;
    private final Type type;
    private final Location location;

    public Notification(Frame fram, Type type, Location location, String message) {
        this.fram = fram;
        this.type = type;
        this.location = location;
        initComponents();
//        Mode.setModeComponent(close);
//        Mode.setModeComponent(this);
//        Mode.setModeComponent(panel);
//        Mode.setModeComponent(lbIcon);
//        Mode.setModeComponent(lbMessage);
//        Mode.setModeComponent(lbMessageText);
        init(message);
        initAnimator();
    }

    private void init(String message) {
        setBackground(Color.WHITE);
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
        if (type == Type.SUCCESS) {
            lbIcon.setPic("src/com/AnLa/UI/Sucess.png");
            lbMessage.setText("Success");
        } else if (type == Type.INFO) {
            lbIcon.setPic("src/com/AnLa/UI/Info.png");
            lbMessage.setText("Info");
        } else {
            lbIcon.setPic("src/com/AnLa/UI/Warning.png");
            lbMessage.setText("Warning");
        }
        lbMessageText.setText(message);
    }

    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    if (location == Location.TOP_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.BOTTOM_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                        top_to_bot = true;
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            closeNotification();
                        }
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }

    public void showNotification() {
        animator.start();
    }

    private void closeNotification() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
        if (type == Type.SUCCESS) {
            g2.setColor(new Color(18, 163, 24));
        } else if (type == Type.INFO) {
            g2.setColor(new Color(28, 139, 206));
        } else {
            g2.setColor(new Color(241, 196, 15));
        }
        g2.fillRect(6, 9, 5, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
        super.paint(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createImageShadow();
    }

    private void createImageShadow() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }

    private BufferedImage createShadow() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        lbMessageText = new javax.swing.JLabel();
        lbIcon = new com.AnLa.UI.ImagePanel();
        close = new com.AnLa.UI.ImagePanel();

        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(462, 80));

        lbMessage.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(38, 38, 38));
        lbMessage.setText("Message");

        lbMessageText.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbMessageText.setForeground(new java.awt.Color(127, 127, 127));
        lbMessageText.setText("Message Text");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessage)
                    .addComponent(lbMessageText))
                .addContainerGap(399, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessageText)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        lbIcon.setBackground(BLIND);

        lbIcon.setPic("src/com/AnLa/UI/Sucess.png");

        javax.swing.GroupLayout lbIconLayout = new javax.swing.GroupLayout(lbIcon);
        lbIcon.setLayout(lbIconLayout);
        lbIconLayout.setHorizontalGroup(
            lbIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        lbIconLayout.setVerticalGroup(
            lbIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        close.setBackground(BLIND);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
        });

        close.setPic("src/com/AnLa/UI/Close.png");

        javax.swing.GroupLayout closeLayout = new javax.swing.GroupLayout(close);
        close.setLayout(closeLayout);
        closeLayout.setHorizontalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        closeLayout.setVerticalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        closeNotification();
    }//GEN-LAST:event_closeMousePressed
    
    /**The type of notification will be displayed, there are 3 types:<br>
     *<code>SUCCESS</code>, <code>INFO</code>, <code>WARNING</code>.
     */
    public static enum Type {
        SUCCESS, INFO, WARNING
    }
    
    /**The location of notification will be displayed, there are 7 locations:<br>
     *<code>TOP_LEFT</code>, <code>TOP_CENTER</code>, <code>TOP_RIGHT</code>, 
     *<code>BOTTOM_LEFT</code>, <code>BOTTOM_CENTER</code>, <code>BOTTOM_RIGHT</code>, 
     *<code>CENTER</code>
     */
    public static enum Location {
        TOP_CENTER, TOP_RIGHT, TOP_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, CENTER
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.AnLa.UI.ImagePanel close;
    private com.AnLa.UI.ImagePanel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessageText;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    private class ShadowRenderer {

        // size of the shadow in pixels (defines the fuzziness)
        private int size = 5;

        // opacity of the shadow
        private float opacity = 0.5f;

        // color of the shadow
        private Color color = Color.BLACK;

        public ShadowRenderer() {
            this(5, 0.5f, Color.BLACK);
        }

        public ShadowRenderer(final int size, final float opacity, final Color color) {
            this.size = size;
            this.opacity = opacity;
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public float getOpacity() {
            return opacity;
        }

        public int getSize() {
            return size;
        }

        public BufferedImage createShadow(final BufferedImage image) {
            // Written by Sesbastien Petrucci
            int shadowSize = size * 2;

            int srcWidth = image.getWidth();
            int srcHeight = image.getHeight();

            int dstWidth = srcWidth + shadowSize;
            int dstHeight = srcHeight + shadowSize;

            int left = size;
            int right = shadowSize - left;

            int yStop = dstHeight - right;

            int shadowRgb = color.getRGB() & 0x00FFFFFF;
            int[] aHistory = new int[shadowSize];
            int historyIdx;

            int aSum;

            BufferedImage dst = new BufferedImage(dstWidth, dstHeight,
                    BufferedImage.TYPE_INT_ARGB);

            int[] dstBuffer = new int[dstWidth * dstHeight];
            int[] srcBuffer = new int[srcWidth * srcHeight];

            GraphicsUtilities.getPixels(image, 0, 0, srcWidth, srcHeight, srcBuffer);

            int lastPixelOffset = right * dstWidth;
            float hSumDivider = 1.0f / shadowSize;
            float vSumDivider = opacity / shadowSize;

            int[] hSumLookup = new int[256 * shadowSize];
            for (int i = 0; i < hSumLookup.length; i++) {
                hSumLookup[i] = (int) (i * hSumDivider);
            }

            int[] vSumLookup = new int[256 * shadowSize];
            for (int i = 0; i < vSumLookup.length; i++) {
                vSumLookup[i] = (int) (i * vSumDivider);
            }

            int srcOffset;

            // horizontal pass : extract the alpha mask from the source picture and
            // blur it into the destination picture
            for (int srcY = 0, dstOffset = left * dstWidth; srcY < srcHeight; srcY++) {

                // first pixels are empty
                for (historyIdx = 0; historyIdx < shadowSize;) {
                    aHistory[historyIdx++] = 0;
                }

                aSum = 0;
                historyIdx = 0;
                srcOffset = srcY * srcWidth;

                // compute the blur average with pixels from the source image
                for (int srcX = 0; srcX < srcWidth; srcX++) {

                    int a = hSumLookup[aSum];
                    dstBuffer[dstOffset++] = a << 24;   // store the alpha value only
                    // the shadow color will be added in the next pass

                    aSum -= aHistory[historyIdx]; // substract the oldest pixel from the sum

                    // extract the new pixel ...
                    a = srcBuffer[srcOffset + srcX] >>> 24;
                    aHistory[historyIdx] = a;   // ... and store its value into history
                    aSum += a;                  // ... and add its value to the sum

                    if (++historyIdx >= shadowSize) {
                        historyIdx -= shadowSize;
                    }
                }

                // blur the end of the row - no new pixels to grab
                for (int i = 0; i < shadowSize; i++) {

                    int a = hSumLookup[aSum];
                    dstBuffer[dstOffset++] = a << 24;

                    // substract the oldest pixel from the sum ... and nothing new to add !
                    aSum -= aHistory[historyIdx];

                    if (++historyIdx >= shadowSize) {
                        historyIdx -= shadowSize;
                    }
                }
            }

            // vertical pass
            for (int x = 0, bufferOffset = 0; x < dstWidth; x++, bufferOffset = x) {

                aSum = 0;

                // first pixels are empty
                for (historyIdx = 0; historyIdx < left;) {
                    aHistory[historyIdx++] = 0;
                }

                // and then they come from the dstBuffer
                for (int y = 0; y < right; y++, bufferOffset += dstWidth) {
                    int a = dstBuffer[bufferOffset] >>> 24;         // extract alpha
                    aHistory[historyIdx++] = a;                     // store into history
                    aSum += a;                                      // and add to sum
                }

                bufferOffset = x;
                historyIdx = 0;

                // compute the blur avera`ge with pixels from the previous pass
                for (int y = 0; y < yStop; y++, bufferOffset += dstWidth) {

                    int a = vSumLookup[aSum];
                    dstBuffer[bufferOffset] = a << 24 | shadowRgb;  // store alpha value + shadow color

                    aSum -= aHistory[historyIdx];   // substract the oldest pixel from the sum

                    a = dstBuffer[bufferOffset + lastPixelOffset] >>> 24;   // extract the new pixel ...
                    aHistory[historyIdx] = a;                               // ... and store its value into history
                    aSum += a;                                              // ... and add its value to the sum

                    if (++historyIdx >= shadowSize) {
                        historyIdx -= shadowSize;
                    }
                }

                // blur the end of the column - no pixels to grab anymore
                for (int y = yStop; y < dstHeight; y++, bufferOffset += dstWidth) {

                    int a = vSumLookup[aSum];
                    dstBuffer[bufferOffset] = a << 24 | shadowRgb;

                    aSum -= aHistory[historyIdx];   // substract the oldest pixel from the sum

                    if (++historyIdx >= shadowSize) {
                        historyIdx -= shadowSize;
                    }
                }
            }

            GraphicsUtilities.setPixels(dst, 0, 0, dstWidth, dstHeight, dstBuffer);
            return dst;
        }
    }

    private class GraphicsUtilities {

        private GraphicsUtilities() {
        }

        private static GraphicsConfiguration getGraphicsConfiguration() {
            return GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice().getDefaultConfiguration();
        }

        public static BufferedImage createColorModelCompatibleImage(BufferedImage image) {
            ColorModel cm = image.getColorModel();
            return new BufferedImage(cm,
                    cm.createCompatibleWritableRaster(image.getWidth(),
                            image.getHeight()),
                    cm.isAlphaPremultiplied(), null);
        }

        public static BufferedImage createCompatibleImage(BufferedImage image) {
            return createCompatibleImage(image, image.getWidth(), image.getHeight());
        }

        public static BufferedImage createCompatibleImage(BufferedImage image,
                int width, int height) {
            return getGraphicsConfiguration().createCompatibleImage(width, height,
                    image.getTransparency());
        }

        public static BufferedImage createCompatibleImage(int width, int height) {
            return getGraphicsConfiguration().createCompatibleImage(width, height);
        }

        public static BufferedImage createCompatibleTranslucentImage(int width,
                int height) {
            return getGraphicsConfiguration().createCompatibleImage(width, height,
                    Transparency.TRANSLUCENT);
        }

        public static BufferedImage loadCompatibleImage(URL resource)
                throws IOException {
            BufferedImage image = ImageIO.read(resource);
            return toCompatibleImage(image);
        }

        public static BufferedImage toCompatibleImage(BufferedImage image) {
            if (image.getColorModel().equals(
                    getGraphicsConfiguration().getColorModel())) {
                return image;
            }

            BufferedImage compatibleImage
                    = getGraphicsConfiguration().createCompatibleImage(
                            image.getWidth(), image.getHeight(),
                            image.getTransparency());
            Graphics g = compatibleImage.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            return compatibleImage;
        }

        public static BufferedImage createThumbnailFast(BufferedImage image, int newSize) {
            float ratio;
            int width = image.getWidth();
            int height = image.getHeight();

            if (width > height) {
                if (newSize >= width) {
                    throw new IllegalArgumentException("newSize must be lower than"
                            + " the image width");
                } else if (newSize <= 0) {
                    throw new IllegalArgumentException("newSize must"
                            + " be greater than 0");
                }

                ratio = (float) width / (float) height;
                width = newSize;
                height = (int) (newSize / ratio);
            } else {
                if (newSize >= height) {
                    throw new IllegalArgumentException("newSize must be lower than"
                            + " the image height");
                } else if (newSize <= 0) {
                    throw new IllegalArgumentException("newSize must"
                            + " be greater than 0");
                }

                ratio = (float) height / (float) width;
                height = newSize;
                width = (int) (newSize / ratio);
            }

            BufferedImage temp = createCompatibleImage(image, width, height);
            Graphics2D g2 = temp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
            g2.dispose();

            return temp;
        }

        public static BufferedImage createThumbnailFast(BufferedImage image,
                int newWidth, int newHeight) {
            if (newWidth >= image.getWidth()
                    || newHeight >= image.getHeight()) {
                throw new IllegalArgumentException("newWidth and newHeight cannot"
                        + " be greater than the image"
                        + " dimensions");
            } else if (newWidth <= 0 || newHeight <= 0) {
                throw new IllegalArgumentException("newWidth and newHeight must"
                        + " be greater than 0");
            }

            BufferedImage temp = createCompatibleImage(image, newWidth, newHeight);
            Graphics2D g2 = temp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
            g2.dispose();

            return temp;
        }

        public static BufferedImage createThumbnail(BufferedImage image,
                int newSize) {
            int width = image.getWidth();
            int height = image.getHeight();

            boolean isWidthGreater = width > height;

            if (isWidthGreater) {
                if (newSize >= width) {
                    throw new IllegalArgumentException("newSize must be lower than"
                            + " the image width");
                }
            } else if (newSize >= height) {
                throw new IllegalArgumentException("newSize must be lower than"
                        + " the image height");
            }

            if (newSize <= 0) {
                throw new IllegalArgumentException("newSize must"
                        + " be greater than 0");
            }

            float ratioWH = (float) width / (float) height;
            float ratioHW = (float) height / (float) width;

            BufferedImage thumb = image;

            do {
                if (isWidthGreater) {
                    width /= 2;
                    if (width < newSize) {
                        width = newSize;
                    }
                    height = (int) (width / ratioWH);
                } else {
                    height /= 2;
                    if (height < newSize) {
                        height = newSize;
                    }
                    width = (int) (height / ratioHW);
                }

                BufferedImage temp = createCompatibleImage(image, width, height);
                Graphics2D g2 = temp.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
                g2.dispose();

                thumb = temp;
            } while (newSize != (isWidthGreater ? width : height));

            return thumb;
        }

        public static BufferedImage createThumbnail(BufferedImage image,
                int newWidth, int newHeight) {
            int width = image.getWidth();
            int height = image.getHeight();

            if (newWidth >= width || newHeight >= height) {
                throw new IllegalArgumentException("newWidth and newHeight cannot"
                        + " be greater than the image"
                        + " dimensions");
            } else if (newWidth <= 0 || newHeight <= 0) {
                throw new IllegalArgumentException("newWidth and newHeight must"
                        + " be greater than 0");
            }

            BufferedImage thumb = image;

            do {
                if (width > newWidth) {
                    width /= 2;
                    if (width < newWidth) {
                        width = newWidth;
                    }
                }

                if (height > newHeight) {
                    height /= 2;
                    if (height < newHeight) {
                        height = newHeight;
                    }
                }

                BufferedImage temp = createCompatibleImage(image, width, height);
                Graphics2D g2 = temp.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
                g2.dispose();

                thumb = temp;
            } while (width != newWidth || height != newHeight);

            return thumb;
        }

        public static int[] getPixels(BufferedImage img,
                int x, int y, int w, int h, int[] pixels) {
            if (w == 0 || h == 0) {
                return new int[0];
            }

            if (pixels == null) {
                pixels = new int[w * h];
            } else if (pixels.length < w * h) {
                throw new IllegalArgumentException("pixels array must have a length"
                        + " >= w*h");
            }

            int imageType = img.getType();
            if (imageType == BufferedImage.TYPE_INT_ARGB
                    || imageType == BufferedImage.TYPE_INT_RGB) {
                Raster raster = img.getRaster();
                return (int[]) raster.getDataElements(x, y, w, h, pixels);
            }
            // Unmanages the image
            return img.getRGB(x, y, w, h, pixels, 0, w);
        }

        public static void setPixels(BufferedImage img,
                int x, int y, int w, int h, int[] pixels) {
            if (pixels == null || w == 0 || h == 0) {
                return;
            } else if (pixels.length < w * h) {
                throw new IllegalArgumentException("pixels array must have a length"
                        + " >= w*h");
            }

            int imageType = img.getType();
            if (imageType == BufferedImage.TYPE_INT_ARGB
                    || imageType == BufferedImage.TYPE_INT_RGB) {
                WritableRaster raster = img.getRaster();
                raster.setDataElements(x, y, w, h, pixels);
            } else {
                // Unmanages the image
                img.setRGB(x, y, w, h, pixels, 0, w);
            }
        }
    }

}
