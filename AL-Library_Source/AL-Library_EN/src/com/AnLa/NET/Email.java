package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**The Email class supports create a SMTP to send email.
 * @author AnLaVN
 */
public class Email {
    private String HostEmail = null, HostServer = "smtp.gmail.com", Title = "Email title", Content = "<h1>Email content.</h1>", File = null;
    private int HostPort = 587;
    private Session session = null;
    private void setHost(String hostEmail, final String hostPass, String hostServer, int hostPort){
        this.HostEmail = hostEmail;
        this.HostServer= hostServer;
        this.HostPort  = hostPort;
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", HostServer);
        p.put("mail.smtp.port", HostPort);
        this.session = Session.getInstance(p, new javax.mail.Authenticator() {
            @Override protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(HostEmail, hostPass);
            }
        });
    }    
    private Email() {}
    
    
    
    /**Create a host SMTP with full information.
     * @param hostEmail is your SMTP email address.<br>
     * @param hostPass is your SMTP server passwords.<br>
     */
    public Email(String hostEmail, String hostPass) {
        setHost(hostEmail, hostPass, HostServer, HostPort);
    }
    
    
    /**Create a host SMTP with full information.
     * @param hostEmail is your SMTP email address.<br>
     * @param hostPass is your SMTP server passwords.<br>
     * @param hostServer is your SMTP server address. Default is 'smtp.gmail.com'.<br>
     */
    public Email(String hostEmail, String hostPass, String hostServer) {
        setHost(hostEmail, hostPass, hostServer, HostPort);
    }
    
    
    /**Create a host SMTP with full information.
     * @param hostEmail is your SMTP email address.<br>
     * @param hostPass is your SMTP server passwords.<br>
     * @param hostServer is your SMTP server address. Default is 'smtp.gmail.com'.<br>
     * @param hostPort is port of your SMTP server. Default is '587'.<br>
     */
    public Email(String hostEmail, String hostPass, String hostServer, int hostPort) {
        setHost(hostEmail, hostPass, hostServer, hostPort);
    }

    
    /** Use this method to setup email content.
     * @param title is Email Title.<br>
     * @param content is Email Content.<br>
     */
    public final void setEmail(String title, String content){
        setEmail(title, content, null);
    }
    
    
    /** Use this method to setup email content.
     * @param title is Email Title.<br>
     * @param content is Email Content.<br>
     * @param filePath is location of file will attachment in email.<br>
     */
    public final void setEmail(String title, String content, String filePath){
        this.Title = title;
        this.Content = content;
        this.File = filePath != null ? filePath.replaceAll("\\\\", "/") : null;
    }

    
    /**Use this method to send email with the types of recipients is TO.
     * @param listEmail is the list of email addresses of the recipients.<br>
     * @throws javax.mail.MessagingException throw an exception if there is no internet connection or can't send email to the recipient.
     */
    public final void sendEmailTO(String... listEmail) throws MessagingException {
        sendEmail(Message.RecipientType.TO, listEmail);
    }
    
    
    /**Use this method to send email with the types of recipients is CC.
     * @param listEmail is the list of email addresses of the recipients.<br>
     * @throws javax.mail.MessagingException throw an exception if there is no internet connection or can't send email to the recipient.
     */
    public final void sendEmailCC(String... listEmail) throws MessagingException {
        sendEmail(Message.RecipientType.CC, listEmail);
    }
    
    
    /**Use this method to send email with the types of recipients is BCC.
     * @param listEmail is the list of email addresses of the recipients.<br>
     * @throws javax.mail.MessagingException throw an exception if there is no internet connection or can't send email to the recipient.
     */
    public final void sendEmailBCC(String... listEmail) throws MessagingException {
        sendEmail(Message.RecipientType.BCC, listEmail);
    }
    
    
    /**Use this method to send email to recipient.
     * @param typeSend defines the manner in which a recipient may be categorized by a Message object, such as TO, CC, or BCC.<br>
     * @param listEmail is the list of email addresses of the recipients.<br>
     * @throws javax.mail.MessagingException throw an exception if there is no internet connection or can't send email to the recipient.
     */
    public final void sendEmail(Message.RecipientType typeSend, String... listEmail) throws MessagingException {
        String ListEmail = "";
        for(String Email : listEmail) ListEmail += "," + Email;
        ListEmail = ListEmail.replaceFirst(",", "");
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(HostEmail));
        msg.addRecipients(typeSend, InternetAddress.parse(ListEmail));
        msg.setSubject(Title);
        if(File == null) msg.setContent(Content, "text/html");
        else{
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(Content, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(new FileDataSource(File)));
            messageBodyPart.setFileName(new File(File).getName());
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
        }
        Transport.send(msg);
    }
}