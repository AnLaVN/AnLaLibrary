package FILE;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.ObjectData;

public class ExampleObjectData {

    public static void main(String[] args) {
        ObjectData.writeData("myFile.dat", new myObject("AnLaVN", 19)); //write new object to myFile.dat
        myObject myobj = (myObject) ObjectData.readData("myFile.dat");  //read object from myFile.dat, store in myobj variable
        System.out.println("My name: " + myobj.getName());  //print value of object
        System.out.println("My age: " + myobj.getAge());
    }
}