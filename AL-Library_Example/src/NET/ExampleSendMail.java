package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.Email;
import javax.mail.MessagingException;

public class ExampleSendMail {

    public static void main(String[] args) throws MessagingException {
        Email mail = new Email("yourEmail@domain.com", "applicationPass");//setup your SMTP service, at here is GMail SMTP
        mail.setEmail("Tittle Email", "<h1>hello, this is test email</h1>");  //set up your email
        mail.sendMailTo("yourFriend@domain.com"); //set email for your friend
    }
}