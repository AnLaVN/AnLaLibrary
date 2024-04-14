package example.anlavn.net;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.net.License;

public class ExampleLicense {
    static { // Check the license authority before run code. Rhe program will continue if enough permissions. Else stop/delete the program.
        License.check("https://github.com/AnLaVN/LICENSE/raw/Releases/AL-Library_License.properties");
    }

    public static void main(String[] args) {
        System.out.println("Your program");
    }
    
}