package SMTP;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.SMTP.SendMail;
import javax.mail.MessagingException;

public class ExampleSendMail {

    public static void main(String[] args) throws MessagingException {
        SendMail sm = new SendMail("yourEmail@domain.com", "applicationPass");//setup your SMTP service, at here is GMail SMTP
        sm.setEmail("Tittle Email", "<h1>hello, this is test email</h1>");  //set up your email
        sm.sendMailTo("yourFriend@domain.com"); //set email for your friend
    }
}