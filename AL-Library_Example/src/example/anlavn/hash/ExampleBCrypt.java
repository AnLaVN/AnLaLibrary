package example.anlavn.hash;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.hash.BCrypt;

public class ExampleBCrypt {

    public static void main(String[] args) {
        String orgStr = "This is original string.",               //declare original string need to hash
            hashStr = BCrypt.Encrypt(orgStr, BCrypt.genSalt());   //hash original string, only supports encryption.
        
        System.out.println("Hash BCrypt of orgStr: " + hashStr);//print hash string
        System.out.println("is orgStr match: " + BCrypt.Check(orgStr, hashStr));  //check if original string is match with hash string
    }
}