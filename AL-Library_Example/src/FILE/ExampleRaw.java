package FILE;
// Make By Bình An || AnLaVN || KatoVN

import com.anlavn.file.Raw;

public class ExampleRaw {

    public static void main(String[] args) {
        Raw raw = new Raw("myFile.txt");    //create myFile.txt in src/FILE/ folder
        //raw.writeData("your text"); //write data to file
        System.out.println(raw.readData()); //read data from file
        raw.closeFile();    //close file if you dont use anymore
    }
    
}