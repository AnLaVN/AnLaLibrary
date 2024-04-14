package example.anlavn.net;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.net.Email;
import java.util.Arrays;
import java.util.HashSet;
import javax.mail.MessagingException;

public class ExampleEmail {

    public static void main(String[] args) throws MessagingException {
        Email mail = new Email("youremail@domain.com", "yourpass");  //setup your SMTP service
        
        mail.setEmail("Tittle Email", "<h1>Chào cậu, đây là email gửi từ bình an</h1>");    //setup your email content
        mail.addSetTO("yourfriend1@gmail.com", "yourfriend12@gmail.com");                   //setup set type TO
        mail.addSetTO(new HashSet<>(Arrays.asList("yourfriend1@gmail.com", "yourfriend12@gmail.com")));
        mail.addSetCC("yourfriend13@fpt.edu.vn");
        mail.addSetAttachments("C:/path/to/your/file.png", "C:/path/to/your/meme.gif");
        
        mail.sendEmail();
    }
}