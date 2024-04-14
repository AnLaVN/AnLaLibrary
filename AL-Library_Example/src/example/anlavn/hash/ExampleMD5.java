package example.anlavn.hash;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.hash.MD5;

public class ExampleMD5 {

    public static void main(String[] args) {
        String orgStr = "This is original string.", //declare original string need to hash
               hashStr= MD5.Encrypt(orgStr); //hash original string, only supports encryption, decryption it is impossible.
        System.out.println("Hash MD5 of orgStr: " + hashStr);   //print hash string
    }
}