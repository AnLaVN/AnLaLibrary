package OpenAI;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.OpenAI.ChatGPT;


public class ExampleChatGPT {

    public static void main(String[] args) {
        ChatGPT cgpt = new ChatGPT("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");  //connect to OpenAI service using API key
        String Result = cgpt.Chat("Who is mr bean?", ChatGPT.Model.Davinci, 128); //get result from request, calling model Davinci with max 128 token
        System.out.println(Result); //print result
    }
    
}