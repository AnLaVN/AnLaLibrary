package HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.HASH.SHA256;

public class ExampleSHA256 {

    public static void main(String[] args) {
        String orgStr = "This is original string.", //declare original string need to hash
               hashStr= SHA256.Encrypt(orgStr); //hash original string, only supports encryption, decryption it is impossible.
        System.out.println("Hash SHA256 of orgStr: " + hashStr);   //print hash string
    }
}