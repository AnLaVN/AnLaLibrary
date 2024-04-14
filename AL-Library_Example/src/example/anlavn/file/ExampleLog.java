package example.anlavn.file;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.file.Log;

public class ExampleLog {

    public static void main(String[] args) {
        Log.add("Your text");   //write text to log file, will auto create as Logs folder.
        System.out.println("File path: " + Log.getFilePath());  //print path of log file.
        Log.closeFile();    //close file if your dont use anymore.
    }
    
}