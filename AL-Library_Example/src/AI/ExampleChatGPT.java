package AI;
// Make By Bình An || AnLaVN || KatoVN

import com.anlavn.ai.ChatGPT;
import com.anlavn.ai.ChatGPT.Model;

public class ExampleChatGPT {

    public static void main(String[] args) {
        ChatGPT cgpt = new ChatGPT("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");  //connect to OpenAI service using API key
        String Result = cgpt.Chat("What you can do ?", Model.Davinci, 64); //get result from request, calling model Davinci with max 128 token
        System.out.println(Result); //print result
    }
    
}