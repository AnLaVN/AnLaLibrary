package HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.anlavn.hash.SHA;
import com.anlavn.hash.SHA.Types;

public class ExampleSHA {

    public static void main(String[] args) {
        String orgStr = "This is original string.", //declare original string need to hash
               hashStr= SHA.Encrypt(Types.SHA_256, orgStr); //hash original string, only supports encryption, decryption it is impossible.
        System.out.println("Hash SHA256 of orgStr: " + hashStr);   //print hash string
    }
}