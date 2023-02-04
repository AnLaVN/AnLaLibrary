package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.DocNet;
import java.io.IOException;

public class ExampleDocNet {

    public static void main(String[] args) throws IOException {
        DocNet docnet = new DocNet("https://raw.githubusercontent.com/AnLaVN/AL-Library/Releases/LICENSE.md"); //set address of network document
        System.out.println(docnet.readAllLine());   //read all line in network document
        docnet.saveAs("LICENSE.md");
    }
}