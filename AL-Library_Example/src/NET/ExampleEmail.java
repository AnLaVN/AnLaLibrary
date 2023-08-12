package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.anlavn.net.Email;
import java.util.Arrays;
import java.util.HashSet;
import javax.mail.MessagingException;

public class ExampleEmail {

    public static void main(String[] args) throws MessagingException {
        Email mail = new Email("noreply@eoa.somee.com", "Qnrhifq8LPUe", "smtp.zoho.com");  //setup your SMTP service
        
        mail.setEmail("Tittle Email", "<h1>Chào cậu, đây là email gửi từ bình an</h1>");  //setup your email content
        mail.addSetTO("binhan29122003@gmail.com", "dangthehuh2903@gmail.com");
        mail.addSetTO(new HashSet<>(Arrays.asList("binhan29122003@gmail.com", "dangthehuh2903@gmail.com")));
        mail.addSetCC(new HashSet<>(Arrays.asList("anldbps21776@fpt.edu.vn")));
        mail.addSetAttachments(new HashSet<>(Arrays.asList("C:/Users/Admin/Pictures/meme/Binh2.png", "C:/Users/Admin/Pictures/meme/banh.gif")));
        
        mail.sendEmail();
    }
}