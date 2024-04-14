package example.anlavn.hash;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.hash.AES;

public class ExampleAES {

    public static void main(String[] args) {
        String orgStr = "This is original string.", //declare original string need to hash
               myKey  = "This is key to hash ",     //declare my security key to hash string
               hashStr= AES.Encrypt(orgStr, myKey); //hash original string with security key
        System.out.println("Hash AES of orgStr: " + hashStr);   //print hash string
        System.out.println("My original string: " + AES.Decrypt(hashStr, myKey));   //encrypt hash string and print it
    }
}