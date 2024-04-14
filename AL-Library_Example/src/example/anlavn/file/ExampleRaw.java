package example.anlavn.file;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.file.Raw;

public class ExampleRaw {

    public static void main(String[] args) {
        Raw raw = new Raw("myFile.txt");    //create myFile.txt in src/FILE/ folder
        //raw.writeData("your text"); //write data to file
        System.out.println(raw.readData()); //read data from file
        raw.closeFile();    //close file if you dont use anymore
    }
    
}