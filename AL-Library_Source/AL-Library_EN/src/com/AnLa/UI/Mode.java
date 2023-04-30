package com.AnLa.UI;
// Make By Bình An || AnLaVN || KatoVN

import java.awt.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;


/**The Mode class supports change mode from light to dark, component from nimbus to windows look and feel.
 * @author AnLaVN
 */
public class Mode {
    private static boolean MODE = false;
    private static final LookAndFeel PRE_LF = UIManager.getLookAndFeel();
    private static final String SYS_LF = UIManager.getSystemLookAndFeelClassName();
    private static Color TextDarkMode = Color.decode("#F0F0F0"), TextLightMode = Color.decode("#2C3338");
    private static Color BackDarkMode = Color.decode("#363B41"), BackLightMode = Color.decode("#FFFFFF");
    
    
    /**Use this method to get current Mode.
     * @return <code>true</code> if Dark Mode, <code>false</code> if Light Mode.<br>
     */
    public static boolean getMode() {   return MODE;    }

    /**Use this method to set Mode for UI.
     * @param MODE <code>true</code> is Dark Mode, <code>false</code> is Light Mode.<br>
     */
    public static void setMode(boolean MODE) {  
        Mode.MODE = MODE;   
    }
    
    /**Use this method to get Text color at current Mode.
     * @return Text color at current Mode.
     */
    public static Color getTextColor()      {   return MODE ? TextDarkMode : TextLightMode; }
    
    /**Use this method to get text color at light Mode.
     * @return Text Color at light Mode.
     */
    public static Color getTextLightColor() {   return TextLightMode;   }

    /**Use this method to get text color at dark Mode.
     * @return Text Color at dark Mode.
     */
    public static Color getTextDarkColor()  {   return TextDarkMode;    }
    
    /**Use this method to get background color at current Mode.
     * @return Background color at current Mode.
     */
    public static Color getBackColor()      {   return MODE ? BackDarkMode : BackLightMode; }

    /**Use this method to get background color at light Mode.
     * @return Background Color at light Mode.
     */
    public static Color getBackLightColor() {   return BackLightMode;   }

    /**Use this method to get background color at dark Mode.
     * @return Background Color at dark Mode.
     */
    public static Color getBackDarkColor()  {   return BackDarkMode;    }
    
    /**Use this method to custom Color of Text in 2 case Dark and Light.
     * @param TextDarkMode is Color of Text if The Mode is Dark, should be light color.<br>
     * @param TextLightMode is Color of Text if The Mode is Light, should be dark color.<br>
     */
    public static void setTextColor(Color TextDarkMode, Color TextLightMode){
        Mode.TextDarkMode  = TextDarkMode;
        Mode.TextLightMode = TextLightMode;
    }
    
    /**Use this method to custom Color of Background in 2 case Dark and Light.
     * @param BackDarkMode is Color of Background if The Mode is Dark, should be dark color.<br>
     * @param BackLightMode is Color of Background if The Mode is Light, should be light color.<br>
     */
    public static void setBackColor(Color BackDarkMode, Color BackLightMode){
        Mode.BackDarkMode  = BackDarkMode;
        Mode.BackLightMode = BackLightMode;
    }
    
    /**Use this method to change Mode for a Component.
     * @param Component is a variable Component need change Mode.<br>
     */
    public static void setModeComponent(Component Component){
        JComponent j = null;
        if(Component instanceof JPanel       pan) {j = pan;}
        if(Component instanceof JLabel       lbl) {j = lbl;}
        if(Component instanceof JRadioButton rdo) {j = rdo;}
        if(Component instanceof JCheckBox    chk) {j = chk;}
        if(Component instanceof JTextField   txt) {j = txt;}
        if(Component instanceof JTextPane    tpa) {j = tpa;}
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

    
    
    /**Use this method to change File Chooser into Windows Look and Feel.
     * @return a <code>JFileChooser</code> was change Look and Feel.<br>
     */
    public static JFileChooser WFileChooser(){
        JFileChooser chooser = null;
        try {
            UIManager.setLookAndFeel(SYS_LF);
            chooser = new JFileChooser();
            UIManager.setLookAndFeel(PRE_LF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of File Chooser. !!!\n\tError code: " + e.toString());}
        return chooser;
    }

    /**Use this method to change Check Box into Windows Look and Feel.
     * @return a <code>JCheckBox</code> was change Look and Feel.<br>
     */
    public static JCheckBox WCheckBox(){
        JCheckBox checkbox = null;
        try {
            UIManager.setLookAndFeel(SYS_LF);
            checkbox = new JCheckBox();
            UIManager.setLookAndFeel(PRE_LF);}
        catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of Check Box. !!!\n\tError code: " + e.toString());}
        return checkbox;
    }
    
    /**Use this method to change Combo Box into Windows Look and Feel.
     * @return a <code>JComboBox</code> was change Look and Feel.<br>
     */
    public static JComboBox WComboBox(){
        JComboBox combobox = null;
        try {
            UIManager.setLookAndFeel(SYS_LF);
            combobox = new JComboBox();
            UIManager.setLookAndFeel(PRE_LF);}
        catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of Combo Box. !!!\n\tError code: " + e.toString());}
        return combobox;
    }
    
    
    
    /**Use this method to brings up a dialog displaying a message.
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed, if null, or has no <code>Frame</code>, a default <code>Frame</code> is used.<br>
     * @param message the <code>Object</code> to display.<br>
     */
    public static void WMessage(Component parentComponent, Object message){
        WMessage(parentComponent, message, "Message Dialog", INFORMATION_MESSAGE);
    }
    
    /**Use this method to brings up a dialog displaying a message, with all parameters.
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed, if null, or has no <code>Frame</code>, a default <code>Frame</code> is used.<br>
     * @param message the <code>Object</code> to display.<br>
     * @param title the title <code>String</code> for the dialog.<br>
     * @param messageType the type of message to be displayed:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>,<code> QUESTION_MESSAGE</code>, or <code>PLAIN_MESSAGE</code>.<br>
     */
    public static void WMessage(Component parentComponent, Object message, String title, int messageType){
        WMessage(parentComponent, message, title, messageType, null);
    }
    
    /**Use this method to brings up a dialog displaying a message, with all parameters.
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed, if null, or has no <code>Frame</code>, a default <code>Frame</code> is used.<br>
     * @param message the <code>Object</code> to display.<br>
     * @param title the title <code>String</code> for the dialog.<br>
     * @param messageType the type of message to be displayed:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>,<code> QUESTION_MESSAGE</code>, or <code>PLAIN_MESSAGE</code>.<br>
     * @param icon an icon to display in the dialog that helps the user identify the kind of message that is being displayed.<br>
     */
    public static void WMessage(Component parentComponent, Object message, String title, int messageType, Icon icon){
        try {
            UIManager.setLookAndFeel(SYS_LF);
            JOptionPane.showMessageDialog(parentComponent, message, title, messageType, icon);
            UIManager.setLookAndFeel(PRE_LF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of MessageDialog. !!!\n\tError code: " + e.toString());}
    }
    
    
    
    /**Use this method to brings up a Confirm dialog with the options "Yes, No and Cancel".
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed.<br>
     * @param message the <code>Object</code> to display.<br>
     * @return an integer indicating the option selected by the user.
     */
    public static int WConfirm(Component parentComponent, Object message){
        return WConfirm(parentComponent, message, "Confirm Dialog", YES_NO_CANCEL_OPTION);
    }
    
    /**Use this method to brings up a Confirm dialog, where the number of choices is determined by the optionType parameter.
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed.<br>
     * @param message the <code>Object</code> to display.<br>
     * @param title The title <code>String</code> for the dialog.<br>
     * @param optionType an <code>int</code> designating the options available on the dialog:<br>
     * <code>YES_NO_OPTION</code>, <code>YES_NO_CANCEL_OPTION</code>, or <code>OK_CANCEL_OPTION</code>.<br>
     * @return an integer indicating the option selected by the user.
     */
    public static int WConfirm(Component parentComponent, Object message, String title, int optionType){
        return WConfirm(parentComponent, message, title, optionType, QUESTION_MESSAGE);
    }
    
    /**Use this method to brings up a Confirm dialog, with all parameters and default icon.
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed.<br>
     * @param message the <code>Object</code> to display.<br>
     * @param title The title String for the dialog.<br>
     * @param optionType an <code>int</code> designating the options available on the dialog:<br>
     * <code>YES_NO_OPTION</code>, <code>YES_NO_CANCEL_OPTION</code>, or <code>OK_CANCEL_OPTION</code>.<br>
     * @param messageType the type of message to be displayed:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>, <code>QUESTION_MESSAGE</code>, or <code>PLAIN_MESSAGE</code>.<br>
     * @return an integer indicating the option selected by the user.
     */
    public static int WConfirm(Component parentComponent, Object message, String title, int optionType, int messageType){
        return WConfirm(parentComponent, message, title, optionType, messageType, null);
    }

    /**Use this method to brings up a Confirm dialog, with all parameters.
     * @param parentComponent the <code>Frame</code> in which the dialog is displayed.<br>
     * @param message the <code>Object</code> to display.<br>
     * @param title The title String for the dialog.<br>
     * @param optionType an <code>int</code> designating the options available on the dialog:<br>
     * <code>YES_NO_OPTION</code>, <code>YES_NO_CANCEL_OPTION</code>, or <code>OK_CANCEL_OPTION</code>.<br>
     * @param messageType the type of message to be displayed:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>, <code>QUESTION_MESSAGE</code>, or <code>PLAIN_MESSAGE</code>.<br>
     * @param icon the icon to display in the dialog.<br>
     * @return an integer indicating the option selected by the user.
     */
    public static int WConfirm(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon)   {
        try {
            UIManager.setLookAndFeel(SYS_LF);
            int ConfirmDialog = JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType, icon);
            UIManager.setLookAndFeel(PRE_LF);
            return ConfirmDialog;
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of ConfirmDialog. !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);}
    }
    
    
    
    /**Use this method to brings up a Input dialog, shows a question <code>message</code>.
     * @param message the <code>Object</code> to display.<br>
     * @return a user's input.
     */
    public static String WInput(Object message){
        return WInput(null, message);
    }
    
    /**Use this method to brings up a Input dialog, displayed on top of the <code>Component</code>.
     * @param parentComponent the parent <code>Component</code> for the dialog.<br>
     * @param message the <code>Object</code> to display.<br>
     * @return a user's input.
     */
    public static String WInput(Component parentComponent, Object message){
        return WInput(parentComponent, message,"Input Dialog" , QUESTION_MESSAGE);
    }
    
    /**Use this method to brings up a Input dialog, have <code>tittle</code> and <code>messageType</code>.
     * @param parentComponent <code>Component</code> chứa hộp thoại.<br>
     * @param message the <code>Object</code> to display.<br>
     * @param title the <code>String</code> to display in the dialog title bar.<br>
     * @param messageType the type of message that is to be displayed:<br>
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>, <code>WARNING_MESSAGE</code>, <code>QUESTION_MESSAGE</code>, or <code>PLAIN_MESSAGE</code>.<br>
     * @return a user's input.
     */
    public static String WInput(Component parentComponent, Object message, String title, int messageType){
        try {
            UIManager.setLookAndFeel(SYS_LF);
            String InputDialog = JOptionPane.showInputDialog(parentComponent, message, title, messageType);
            UIManager.setLookAndFeel(PRE_LF);
            return InputDialog;
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
            System.out.println("\n!!! Error trying to change Look and Feel of InputDialog. !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);}
    }
}