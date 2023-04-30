package com.AnLa.UI;
//Edit by Bình An || AnLaVN || KatoVN

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**Lớp ComboBox hỗ trợ tạo comboBox đẹp mắt với chế độ sáng và tối.
 * @author AnLaVN
 * @param <E>
 */
public class ComboBox<E> extends JComboBox<E> {

    public ComboBox() {
        setUI(new ComboSuggestionUI());
    }

    private class ComboSuggestionUI extends BasicComboBoxUI {

        @Override
        public void installUI(JComponent jc) {
            super.installUI(jc);
            Border border = new Border();
            JTextField txt = (JTextField) comboBox.getEditor().getEditorComponent();
            txt.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent fe) {
                    border.setColor(new Color(128, 189, 255));
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    border.setColor(new Color(206, 212, 218));
                }
            });
            comboBox.addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(180, 180, 180));
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(150, 150, 150));
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(150, 150, 150));
                }
            });
            AutoCompleteDecorator.decorate(comboBox);
            txt.setSelectionColor(new Color(54, 189, 248));
            txt.setBorder(new EmptyBorder(0, 4, 0, 4));
            txt.setBackground(Mode.getBackColor());
            txt.setForeground(Mode.getTextColor());
            comboBox.setBackground(Mode.getBackColor());
            comboBox.setBorder(border);
        }

        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();
        }

        @Override
        protected ComboPopup createPopup() {
            return new ComboSuggestionPopup(comboBox);
        }

        @Override
        protected ListCellRenderer createRenderer() {
            return new ListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
                    String text = e == null ? "" : e.toString();
                    JLabel label = new JLabel(text);
                    label.setFont(comboBox.getFont());
                    label.setForeground(Mode.getTextColor());
                    if (i >= 0) {
                        label.setBorder(new EmptyBorder(5, 8, 5, 8));
                    } else {
                        label.setBorder(null);
                    }
                    if (bln) {
                        label.setOpaque(true);
                        label.setBackground(Mode.getBackColor().darker());
                        label.setForeground(new Color(17, 155, 215));
                    }
                    return label;
                }
            };
        }

        @Override
        public void paintCurrentValueBackground(Graphics grphcs, Rectangle rctngl, boolean bln) {
        }

        private class ComboSuggestionPopup extends BasicComboPopup {

            public ComboSuggestionPopup(JComboBox combo) {
                super(combo);
                setBorder(new Border(1));
            }

            @Override
            protected JScrollPane createScroller() {
                JScrollPane scroll = super.createScroller();
                list.setBackground(Mode.getBackColor());
                ScrollBarCustom sb = new ScrollBarCustom();
                sb.setPreferredSize(new Dimension(12, 70));
                scroll.setVerticalScrollBar(sb);
                ScrollBarCustom sbH = new ScrollBarCustom();
                sbH.setOrientation(JScrollBar.HORIZONTAL);
                scroll.setHorizontalScrollBar(sbH);
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                return scroll;
            }
        }

        private class ArrowButton extends JButton {

            public ArrowButton() {
                setContentAreaFilled(false);
                setBorder(new EmptyBorder(5, 5, 5, 5));
                setBackground(new Color(150, 150, 150));
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void paint(Graphics grphcs) {
                super.paint(grphcs);
                Graphics2D g2 = (Graphics2D) grphcs.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = getWidth();
                int height = getHeight();
                int sizeX = 24;
                int sizeY = 16;
                int x = (width - sizeX) / 2;
                int y = (height - sizeY) / 2;
                int px[] = {x, x + sizeX, x + sizeX / 2};
                int py[] = {y, y, y + sizeY};
                g2.setColor(getBackground());
                g2.fillPolygon(px, py, px.length);
                g2.dispose();
            }
        }

        private class Border extends EmptyBorder {

            public Color getFocusColor() {
                return focusColor;
            }

            public void setFocusColor(Color focusColor) {
                this.focusColor = focusColor;
            }

            public Color getColor() {
                return color;
            }

            public void setColor(Color color) {
                this.color = color;
            }

            private Color color = new Color(206, 212, 218);
            private Color focusColor = new Color(128, 189, 255);

            public Border(int border) {
                super(border, border, border, border);
            }

            public Border() {
                this(5);
            }

            @Override
            public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) grphcs.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (cmpnt.isFocusOwner()) {
                    g2.setColor(focusColor);
                } else {
                    g2.setColor(color);
                }
                g2.drawRect(x, y, width - 1, height - 1);
                g2.dispose();
            }
        }
    }

    private class ModernScrollBarUI extends BasicScrollBarUI {

        private final int THUMB_SIZE = 60;

        @Override
        protected Dimension getMinimumThumbSize() {
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                return new Dimension(0, THUMB_SIZE);
            } else {
                return new Dimension(THUMB_SIZE, 0);
            }
        }

        @Override
        protected JButton createIncreaseButton(int i) {
            return new ScrollBarButton();
        }

        @Override
        protected JButton createDecreaseButton(int i) {
            return new ScrollBarButton();
        }

        @Override
        protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        }

        @Override
        protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int x = rctngl.x;
            int y = rctngl.y;
            int width = rctngl.width - 4;
            int height = rctngl.height;
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                y += 8;
                height -= 16;
            } else {
                x += 8;
                width -= 16;
            }
            g2.setColor(scrollbar.getForeground());
            g2.fillRoundRect(x + 2, y, width, height, 10, 10);
        }

        private class ScrollBarButton extends JButton {

            public ScrollBarButton() {
                setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void paint(Graphics grphcs) {
            }
        }
    }

    private class ScrollBarCustom extends JScrollBar {

        public ScrollBarCustom() {
            setUI(new ModernScrollBarUI());
            setPreferredSize(new Dimension(8, 8));
            setForeground(new Color(180, 180, 180));
            setBackground(Mode.getBackColor());
            setUnitIncrement(20);
        }

        public class ScrollBarCustomUI extends BasicScrollBarUI {

            private boolean isMin;
            private boolean isMax;

            @Override
            public void installUI(JComponent c) {
                super.installUI(c);
                scrollbar.addAdjustmentListener(new AdjustmentListener() {
                    @Override
                    public void adjustmentValueChanged(AdjustmentEvent e) {
                        BoundedRangeModel br = scrollbar.getModel();
                        boolean min = br.getValue() == br.getMinimum();
                        boolean max = br.getValue() + br.getExtent() == br.getMaximum();
                        if (isMin != min) {
                            isMin = min;
                            scrollbar.repaint();
                        } else if (isMax != max) {
                            isMax = max;
                            scrollbar.repaint();
                        }
                    }
                });
            }

            @Override
            protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
                grphcs.setColor(new Color(250, 250, 250));
                super.paintTrack(grphcs, jc, rctngl);
            }

            @Override
            protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
                Graphics2D g2 = (Graphics2D) grphcs;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (isDragging) {
                    g2.setColor(new Color(130, 130, 130));
                } else {
                    if (isThumbRollover()) {
                        g2.setColor(new Color(150, 150, 150));
                    } else {
                        g2.setColor(new Color(180, 180, 180));
                    }
                }
                int round = 2;
                int spaceX = 2;
                int spaceY = 8;
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    g2.fill(new RoundRectangle2D.Double(rctngl.getX() + spaceX, rctngl.getY() + spaceY, rctngl.getWidth() - spaceX * 2, rctngl.getHeight() - spaceY * 2, round, round));
                } else {
                    g2.fill(new RoundRectangle2D.Double(rctngl.getX() + spaceY, rctngl.getY() + spaceX, rctngl.getWidth() - spaceY * 2, rctngl.getHeight() - spaceX * 2, round, round));
                }
                g2.dispose();
            }

            @Override
            protected JButton createIncreaseButton(int i) {
                return new ScrollButton(scrollbar.getOrientation(), true);
            }

            @Override
            protected JButton createDecreaseButton(int i) {
                return new ScrollButton(scrollbar.getOrientation(), false);
            }

            private class ScrollButton extends JButton {

                private boolean hovered;
                private boolean pressed;
                private final int orientation;
                private final boolean increase;

                public ScrollButton(int orientation, boolean increase) {
                    this.orientation = orientation;
                    this.increase = increase;
                    setContentAreaFilled(false);
                    setPreferredSize(new Dimension(18, 18));
                    addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent me) {
                            if (SwingUtilities.isLeftMouseButton(me)) {
                                pressed = true;
                            }
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            if (SwingUtilities.isLeftMouseButton(me)) {
                                pressed = false;
                            }
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            hovered = true;
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            hovered = false;
                        }
                    });
                }

                @Override
                public void paint(Graphics grphcs) {
                    Graphics2D g2 = (Graphics2D) grphcs.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    if ((increase && isMax) || (!increase && isMin)) {
                        g2.setColor(new Color(250, 250, 250));
                    } else {
                        if (pressed) {
                            g2.setColor(new Color(150, 150, 150));
                        } else {
                            if (hovered) {
                                g2.setColor(new Color(200, 200, 200));
                            } else {
                                g2.setColor(new Color(250, 250, 250));
                            }
                        }
                    }
                    g2.fill(new Rectangle(0, 0, getWidth(), getHeight()));
                    int width = getWidth();
                    int height = getHeight();
                    int y = (height - 5) / 2;
                    int x = (width - 5) / 2;
                    if ((increase && isMax) || (!increase && isMin)) {
                        g2.setColor(Color.LIGHT_GRAY);
                    } else {
                        if (pressed) {
                            g2.setColor(Color.WHITE);
                        } else {
                            g2.setColor(Color.GRAY);
                        }
                    }
                    if (orientation == JScrollBar.VERTICAL) {
                        int xx[] = {4, width - 4, width / 2};
                        int yy[] = {5, 5, 0};
                        Polygon poly = new Polygon(xx, yy, xx.length);
                        g2.translate(0, (y));
                        if (increase) {
                            g2.rotate(Math.toRadians(180), width / 2, height / 2 - y);
                            g2.fill(poly);
                        } else {
                            g2.fill(poly);
                        }
                    } else {
                        int xx[] = {4, height - 4, height / 2};
                        int yy[] = {5, 5, 0};
                        Polygon poly = new Polygon(xx, yy, xx.length);
                        g2.translate(x, 0);
                        if (increase) {
                            g2.rotate(Math.toRadians(90), width / 2 - x, height / 2 - y);
                            g2.fill(poly);
                        } else {
                            g2.rotate(Math.toRadians(-90), width / 2 - 1, height / 2);
                            g2.fill(poly);
                        }
                    }
                    g2.dispose();
                }
            }
        }
    }
}