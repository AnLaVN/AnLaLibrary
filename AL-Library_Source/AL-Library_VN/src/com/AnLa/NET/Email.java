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

/**Lớp Email hỗ trợ tạo một SMTP để gửi email.
 * @author AnLaVN
 */
public class Email {
    private String HostEmail = null, HostServer = "smtp.gmail.com", Title = "Tiêu đề email", Content = "<h1>Nội dung email.</h1>", File = null;
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
    
    
    
    /**Tạo một máy chủ SMTP với đầy đủ thông tin.
     * @param hostEmail là địa chỉ email SMTP của bạn.<br>
     * @param hostPass là mật khẩu máy chủ SMTP của bạn.<br>
     */
    public Email(String hostEmail, String hostPass) {
        setHost(hostEmail, hostPass, HostServer, HostPort);
    }
    
    
    /**Tạo một máy chủ SMTP với đầy đủ thông tin.
     * @param hostEmail là địa chỉ email SMTP của bạn.<br>
     * @param hostPass là mật khẩu máy chủ SMTP của bạn.<br>
     * @param hostServer là địa chỉ máy chủ SMTP. Mặc định là 'smtp.gmail.com'<br>
     */
    public Email(String hostEmail, String hostPass, String hostServer) {
        setHost(hostEmail, hostPass, hostServer, HostPort);
    }
    
    
    /**Tạo một máy chủ SMTP với đầy đủ thông tin.
     * @param hostEmail là địa chỉ email SMTP của bạn.<br>
     * @param hostPass là mật khẩu máy chủ SMTP của bạn.<br>
     * @param hostServer là địa chỉ máy chủ SMTP. Mặc định là 'smtp.gmail.com'<br>
     * @param hostPort là cổng của máy chủ SMTP. Mặc định là '587'<br>
     */
    public Email(String hostEmail, String hostPass, String hostServer, int hostPort) {
        setHost(hostEmail, hostPass, hostServer, hostPort);
    }

    
    /**Sử dụng phương thức này để thiết lập nội dung email.
     * @param title là Tiêu đề Email.<br>
     * @param content là Nội dung Email.<br>
     */
    public final void setEmail(String title, String content){
        setEmail(title, content, null);
    }
    
    
    /**Sử dụng phương thức này để thiết lập nội dung email.
     * @param title là Tiêu đề Email.<br>
     * @param content là Nội dung Email.<br>
     * @param filePath là vị trí của tệp tin sẽ đính kèm trong email.<br>
     */
    public final void setEmail(String title, String content, String filePath){
        this.Title = title;
        this.Content = content;
        this.File = filePath != null ? filePath.replaceAll("\\\\", "/") : null;
    }
    
    
    /**Sử dụng phương pháp này để gửi email với phân loại người nhận là TO.
     * @param listEmail là danh sách địa chỉ Email của người nhận.<br>
     * @throws javax.mail.MessagingException ném một ngoại lệ nếu không có kết nối internet hoặc không thể gửi email đến người nhận.
     */
    public final void sendEmailTO(String... listEmail) throws MessagingException {
        sendEmail(Message.RecipientType.TO, listEmail);
    }
    
    
    /**Sử dụng phương pháp này để gửi email với phân loại người nhận là CC.
     * @param listEmail là danh sách địa chỉ Email của người nhận.<br>
     * @throws javax.mail.MessagingException ném một ngoại lệ nếu không có kết nối internet hoặc không thể gửi email đến người nhận.
     */
    public final void sendEmailCC(String... listEmail) throws MessagingException {
        sendEmail(Message.RecipientType.CC, listEmail);
    }
    
    
    /**Sử dụng phương pháp này để gửi email với phân loại người nhận là BCC.
     * @param listEmail là danh sách địa chỉ Email của người nhận.<br>
     * @throws javax.mail.MessagingException ném một ngoại lệ nếu không có kết nối internet hoặc không thể gửi email đến người nhận.
     */
    public final void sendEmailBCC(String... listEmail) throws MessagingException {
        sendEmail(Message.RecipientType.BCC, listEmail);
    }
    
    
    /**Sử dụng phương thức này để gửi email đến người nhận.
     * @param typeSend xác định cách phân loại người nhận theo đối tượng Tin nhắn, chẳng hạn như TO, CC hoặc BCC.<br>
     * @param listEmail là danh sách địa chỉ Email của người nhận.<br>
     * @throws javax.mail.MessagingException ném một ngoại lệ nếu không có kết nối internet hoặc không thể gửi email đến người nhận.
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