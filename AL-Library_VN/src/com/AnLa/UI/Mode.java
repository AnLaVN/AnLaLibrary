package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.Color;
import javax.swing.*;
import static javax.swing.JOptionPane.*;


/**Lớp Mode hỗ trợ thay đổi chế độ từ sáng sang tối, component từ nimbus sang giao diện windows.
 * @author Admin
 */
public class Mode {
    private static boolean MODE = false;
    private static final LookAndFeel PRE_LF = UIManager.getLookAndFeel();
    private static final String SYS_LF = UIManager.getSystemLookAndFeelClassName();
    private static Color TextDarkMode = Color.decode("#F0F0F0"), TextLightMode = Color.decode("#2C3338");
    private static Color BackDarkMode = Color.decode("#363B41"), BackLightMode = Color.decode("#FFFFFF");

    
    
    /**Sử dụng phương thức này để đặt Chế độ cho UI.
     * @param MODE <code>true</code> là Chế độ Tối, <code>false</code> là Chế độ Sáng.
     */
    public static void setMode(boolean MODE) {  
        Mode.MODE = MODE;   
    }
    
    /**Sử dụng phương thức này để tùy chỉnh Màu của Văn Bản trong 2 trường hợp Chế Độ Tối và Sáng.
     * @param TextDarkMode là Màu của Văn Bản nếu Chế Độ là Tối, nên là màu sáng.<br>
     * @param TextLightMode là Màu của Văn Bản nếu Chế Độ là Sáng, nên là màu tối.<br>
     */
    public static void setTextColor(Color TextDarkMode, Color TextLightMode){
        Mode.TextDarkMode  = TextDarkMode;
        Mode.TextLightMode = TextLightMode;
    }
    
    /**Sử dụng phương thức này để tùy chỉnh Màu của Nền trong 2 trường hợp Chế Độ Tối và Sáng.
     * @param BackDarkMode là Màu của Nền nếu Chế Độ là Tối, nên là màu tối.<br>
     * @param BackLightMode là Màu của Nền nếu Chế Độ là Sáng, nên là màu sáng.<br>
     */
    public static void setBackColor(Color BackDarkMode, Color BackLightMode){
        Mode.BackDarkMode  = BackDarkMode;
        Mode.BackLightMode = BackLightMode;
    }
    
    /**Sử dụng phương thức này để thay đổi Chế độ cho một Component.
     * @param Component là biến Component cần thay đổi Chế Độ.<br>
     */
    public static void setModeComponent(JComponent Component){
        JComponent j = null;
        if(Component instanceof JPanel       pan) {j = pan;}
        if(Component instanceof JLabel       lbl) {j = lbl;}
        if(Component instanceof JRadioButton rdo) {j = rdo;}
        if(Component instanceof JCheckBox    chk) {j = chk;}
        if(Component instanceof JTextField   txt) {j = txt;}
        if(Component instanceof JTextArea    tar) {j = tar;}
        if(Component instanceof JTable       tbl) {j = tbl;}
        if(Component instanceof JButton      btn) {j = btn;}
        if(Component instanceof JScrollBar   scb) {j = scb;}
        if(j != null){
            if(!(j instanceof JScrollBar)){
            j.setForeground (   MODE ? TextDarkMode : TextLightMode );}
            j.setBackground (   MODE ? BackDarkMode : BackLightMode );
        }
    }
    
    
    
    /**Sử dụng phương thức này để thay đổi Trình Chọn Tệp thành Giao diện của Windows.
     * @return một <code>JFileChooser</code> đã thay đổi Giao diện.<br>
     */
    public static JFileChooser WFileChooser(){
        JFileChooser chooser = null;
        try {
            UIManager.setLookAndFeel(SYS_LF);
            chooser = new JFileChooser();
            UIManager.setLookAndFeel(PRE_LF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of File Chooser. !!!");}
        return chooser;
    }

    /**Sử dụng phương thức này để thay đổi Hộp Kiểm thành Giao diện của Windows.
     * @return một <code>JCheckBox</code> đã thay đổi Giao diện.<br>
     */
    public static JCheckBox WCheckBox(){
        JCheckBox checkbox = null;
        try {
            UIManager.setLookAndFeel(SYS_LF);
            checkbox = new JCheckBox();
            UIManager.setLookAndFeel(PRE_LF);}
        catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of Check Box. !!!");}
        return checkbox;
    }
    
    /**Sử dụng phương thức này để thay đổi Combo Box thành Giao diện của Windows.
     * @return một <code>JComboBox</code> đã thay đổi Giao diện.<br>
     */
    public static JComboBox WComboBox(){
        JComboBox combobox = null;
        try {
            UIManager.setLookAndFeel(SYS_LF);
            combobox = new JComboBox();
            UIManager.setLookAndFeel(PRE_LF);}
        catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of Combo Box. !!!");}
        return combobox;
    }
    
    
    
    /**Sử dụng phương thức này để hiển thị một hộp thoại thông báo.
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị, nếu null hoặc không có <code>Frame</code>, một <code>Frame</code> mặc định sẽ được sử dụng.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     */
    public static void WMessage(JComponent parentComponent, Object message){
        WMessage(parentComponent, message, "Message Dialog", INFORMATION_MESSAGE);
    }
    
    /**Sử dụng phương thức này để hiển thị một hộp thoại thông báo, với tất cả các tham số.
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị, nếu null hoặc không có <code>Frame</code>, một <code>Frame</code> mặc định sẽ được sử dụng.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     * @param title Chuỗi tiêu đề cho hộp thoại.<br>
     * @param messageType loại thông báo sẽ được hiển thị:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>,<code> QUESTION_MESSAGE</code>, hoặc <code>PLAIN_MESSAGE</code>.<br>
     */
    public static void WMessage(JComponent parentComponent, Object message, String title, int messageType){
        WMessage(parentComponent, message, title, messageType, null);
    }
    
    /**Sử dụng phương thức này để hiển thị một hộp thoại thông báo, với tất cả các tham số.
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị, nếu null hoặc không có <code>Frame</code>, một <code>Frame</code> mặc định sẽ được sử dụng.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     * @param title Chuỗi tiêu đề cho hộp thoại.<br>
     * @param messageType loại thông báo sẽ được hiển thị:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>,<code> QUESTION_MESSAGE</code>, hoặc <code>PLAIN_MESSAGE</code>.<br>
     * @param icon - một biểu tượng để hiển thị trong hộp thoại giúp người dùng xác định loại thông báo đang được hiển thị.
     */
    public static void WMessage(JComponent parentComponent, Object message, String title, int messageType, Icon icon){
        try {
            UIManager.setLookAndFeel(SYS_LF);
            JOptionPane.showMessageDialog(parentComponent, message, title, messageType, icon);
            UIManager.setLookAndFeel(PRE_LF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of MessageDialog. !!!");}
    }
    
    
    
    /**Sử dụng phương thức này để hiển thị hộp thoại Xác Nhận với các tùy chọn "Yes, No and Cancel".
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     * @return một số nguyên cho biết tùy chọn được người dùng chọn.
     */
    public static int WConfirm(JComponent parentComponent, Object message){
        return WConfirm(parentComponent, message, "Confirm Dialog", YES_NO_CANCEL_OPTION);
    }
    
    /**Sử dụng phương thức này để hiển thị hộp thoại Xác Nhận, trong đó số lượng lựa chọn được xác định bởi tham số optionType.
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     * @param title Chuỗi tiêu đề cho hộp thoại.<br>
     * @param optionType một <code>int</code> chỉ định các tùy chọn có sẵn trên hộp thoại:<br>
     * YES_NO_OPTION, YES_NO_CANCEL_OPTION hoặc OK_CANCEL_OPTION.<br>
     * @return một số nguyên cho biết tùy chọn được người dùng chọn.
     */
    public static int WConfirm(JComponent parentComponent, Object message, String title, int optionType){
        return WConfirm(parentComponent, message, title, optionType, QUESTION_MESSAGE);
    }
    
    /**Sử dụng phương thức này để hiển thị hộp thoại Xác Nhận, với tất cả các tham số và biểu tượng mặc định.
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     * @param title Chuỗi tiêu đề cho hộp thoại.<br>
     * @param optionType một <code>int</code> chỉ định các tùy chọn có sẵn trên hộp thoại:<br>
     * YES_NO_OPTION, YES_NO_CANCEL_OPTION hoặc OK_CANCEL_OPTION.<br>
     * @param messageType loại thông báo sẽ được hiển thị:<br>
     * ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE hoặc PLAIN_MESSAGE.<br>
     * @return một số nguyên cho biết tùy chọn được người dùng chọn.
     */
    public static int WConfirm(JComponent parentComponent, Object message, String title, int optionType, int messageType){
        return WConfirm(parentComponent, message, title, optionType, messageType, null);
    }

    /**Sử dụng phương thức này để hiển thị hộp thoại Xác Nhận, với tất cả các tham số.
     * @param parentComponent <code>Frame</code> trong đó hộp thoại được hiển thị.<br>
     * @param message <code>Object</code> để hiển thị.<br>
     * @param title Chuỗi tiêu đề cho hộp thoại.<br>
     * @param optionType một <code>int</code> chỉ định các tùy chọn có sẵn trên hộp thoại:<br>
     * YES_NO_OPTION, YES_NO_CANCEL_OPTION hoặc OK_CANCEL_OPTION.<br>
     * @param messageType loại thông báo sẽ được hiển thị:<br>
     * ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE hoặc PLAIN_MESSAGE.<br>
     * @param icon biểu tượng để hiển thị trong hộp thoại.<br>
     * @return một số nguyên cho biết tùy chọn được người dùng chọn.
     */
    public static int WConfirm(JComponent parentComponent, Object message, String title, int optionType, int messageType, Icon icon)   {
        try {
            UIManager.setLookAndFeel(SYS_LF);
            int ConfirmDialog = JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType, icon);
            UIManager.setLookAndFeel(PRE_LF);
            return ConfirmDialog;
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of ConfirmDialog. !!!");
            throw new RuntimeException(e);}
    }
    
    
    
    /**Sử dụng phương thức này để hiển thị hộp thoại Nhập, hiển thị câu hỏi. <code>message</code>.
     * @param message <code>Object</code> để hiển thị. <br>
     * @return thông tin đầu vào của người dùng.
     */
    public static String WInput(Object message){
        return WInput(null, message);
    }
    
    /**Sử dụng phương thức này để hiển thị hộp thoại Nhập, hiển thị bên trong <code>Component</code>.
     * @param parentComponent <code> Thành phần </code> chính cho hộp thoại. <br>
     * @param message <code>Object</code> để hiển thị. <br>
     * @return thông tin đầu vào của người dùng.
     */
    public static String WInput(JComponent parentComponent, Object message){
        return WInput(parentComponent, message,"Input Dialog" , QUESTION_MESSAGE);
    }
    
    /**Sử dụng phương thức này để hiển thị hộp thoại Nhập, có <code>tittle</code> và <code>messageType</code>.
     * @param parentComponent <code> Thành phần </code> chính cho hộp thoại. <br>
     * @param message <code>Object</code> để hiển thị. <br>
     * @param title <code>String</code> tiêu đề để hiển thị trong thanh tiêu đề hộp thoại.<br>
     * @param messageType loại tin nhắn sẽ được hiển thị:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>, <code>QUESTION_MESSAGE</code> hoặc <code>PLAIN_MESSAGE</code>.<br>
     * @return thông tin đầu vào của người dùng.
     */
    public static String WInput(JComponent parentComponent, Object message, String title, int messageType){
        try {
            UIManager.setLookAndFeel(SYS_LF);
            String InputDialog = JOptionPane.showInputDialog(parentComponent, message, title, messageType);
            UIManager.setLookAndFeel(PRE_LF);
            return InputDialog;
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of InputDialog. !!!");
            throw new RuntimeException(e);}
    }
}