package HASH;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.HASH.BCrypt;

public class ExampleBCrypt {

	public static void main(String[] args) {
		String  pass = "This is original string.",               //declare original string need to hash
			 hashStr = BCrypt.Encrypt(pass, BCrypt.genSalt());   //hash original string, only supports encryption.
		
		System.out.println("Hash BCrypt of orgStr: " + hashStr);//print hash string
		System.out.println("is orgStr match: " + BCrypt.Check(pass, hashStr));  //check if original string is match with hash string
	}
}