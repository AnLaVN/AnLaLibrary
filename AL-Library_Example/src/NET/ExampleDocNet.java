package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.DocNet;


public class ExampleDocNet {

    public static void main(String[] args) {
        DocNet docnet = new DocNet("https://raw.githubusercontent.com/AnLaVN/AL-Library/Releases/LICENSE"); //set address of network document
        System.out.println(docnet.readAllLine());   //read all line in network document
    }
    
}