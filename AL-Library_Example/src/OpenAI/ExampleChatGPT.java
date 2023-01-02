package OpenAI;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.OpenAI.ChatGPT;


public class ExampleChatGPT {

    public static void main(String[] args) {
        ChatGPT cgpt = new ChatGPT("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");  //connect to OpenAI service using API key
        String Result = cgpt.Chat("How to install live server for old ?", ChatGPT.Model.Davinci, 128); //get result from request, calling model Davinci with max 128 token
        System.out.println(Result); //print result
    }
    
}