package com.AnLa.SMTP;
// Make By Bình An || AnLaVN || KatoVN

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**The SendMail class supports create a Gmail SMTP to send email.
 * @author Admin
 */
public class SendMail {
    private String HostEmail = null, HostEPass = null;
    private String Content = "<h1>Email content.</h1>", Title = "Email title.";
    

    /**Create a host SMTP.
     * @see SendMail#setHost(java.lang.String, java.lang.String) <br>
     * @see SendMail#SendMail(java.lang.String, java.lang.String) 
     */
    public SendMail() {}

    /**Create a host SMTP with full information.
     * @param Email is your email address.<br>
     * @param Pass is your App passwords on Google Account.<br>
     */
    public SendMail(String Email, String Pass) {
        this.HostEmail = Email;
        this.HostEPass = Pass;
    }
    
    
    /**Use this method to setup a host SMTP.
     * @param Email is your email address.<br>
     * @param Pass is your App passwords on Google Account.<br>
     * @see SendMail#SendMail(java.lang.String, java.lang.String) 
     */
    public void setHost(String Email, String Pass){
        this.HostEmail = Email;
        this.HostEPass = Pass;
    }

    
    /** Use this method to setup email content.
     * @param title is Email Title.<br>
     * @param content is Email Content.<br>
     * @see SendMail#setHost(java.lang.String, java.lang.String) 
     */
    public void setEmail(String title, String content){
        this.Title = title;
        this.Content = content;
    }

    
    /**Use this method to send email to recipient.
     * @param ToEmail is a recipient's Email address.<br>
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
        } catch (MessagingException ex) {   System.out.println(ex); }
    }
    
}