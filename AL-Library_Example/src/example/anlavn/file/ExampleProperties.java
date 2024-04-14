package example.anlavn.file;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.file.Properties;

public class ExampleProperties {

    public static void main(String[] args) {
        String lang = "EN"; //"VN" if you want using vietnamese languages, "EN" if you want english
        Properties proper = new Properties("src/example/anlavn/file/myProperties_" + lang + ".properties");    //load properties file
        System.out.println("Properties of hello key: " + proper.getString("hello"));    //print value of key in file
    }
    
}