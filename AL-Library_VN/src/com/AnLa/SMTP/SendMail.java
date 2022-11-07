package com.AnLa.SMTP;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**Lớp SendMail hỗ trợ tạo một SMTP Gmail để gửi email.
 * @author Admin
 */
public class SendMail {
    private String HostEmail = null, HostEPass = null;
    private String Content = "<h1>Email content.</h1>", Title = "Email title.";
    

    /**Tạo một máy chủ SMTP.
     * @see SendMail#setHost(java.lang.String, java.lang.String) <br>
     * @see SendMail#SendMail(java.lang.String, java.lang.String) 
     */
    public SendMail() {}

    /**Tạo một máy chủ SMTP với đầy đủ thông tin.
     * @param Email là địa chỉ email của bạn.<br>
     * @param Pass là mật khẩu ứng dụng của bạn trên Google Account.<br>
     */
    public SendMail(String Email, String Pass) {
        this.HostEmail = Email;
        this.HostEPass = Pass;
    }
    
    
    /**Sử dụng phương thức này để thiết lập máy chủ SMTP máy chủ.
     * @param Email là địa chỉ email của bạn.<br>
     * @param Pass là mật khẩu ứng dụng của bạn trên Google Account.<br>
     * @see SendMail#SendMail(java.lang.String, java.lang.String) 
     */
    public void setHost(String Email, String Pass){
        this.HostEmail = Email;
        this.HostEPass = Pass;
    }

    
    /**Sử dụng phương thức này để thiết lập nội dung email.
     * @param title là Tiêu đề Email.<br>
     * @param content là Nội dung Email.<br>
     * @see SendMail#setHost(java.lang.String, java.lang.String) 
     */
    public void setEmail(String title, String content){
        this.Title = title;
        this.Content = content;
    }

    
    /**Sử dụng phương thức này để gửi email đến người nhận.
     * @param ToEmail là địa chỉ Email của người nhận.<br>
     * @see SendMail#setEmail(java.lang.String, java.lang.String)
     */
    public void sendMailTo(String ToEmail) {
        try{
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com"); 
            p.put("mail.smtp.port", 587);
                
            Session s = Session.getInstance(p, new javax.mail.Authenticator() {
                @Override protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(HostEmail, HostEPass); }
                });
            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(HostEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ToEmail));
            msg.setSubject(Title);
            msg.setContent(Content, "text/html");
            Transport.send(msg);
        } catch (MessagingException ex) {Log.add("!!! Error try to send mail to " + ToEmail + "."); Log.add(ex.toString());}
    }
}