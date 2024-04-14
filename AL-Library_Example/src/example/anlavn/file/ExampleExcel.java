package example.anlavn.file;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.file.Excel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExampleExcel {

    public static void main(String[] args) throws IOException {
        //Write
        ArrayList<Object[]> myData = new ArrayList<>();         //declare array to store data to write to Excel file
        myData.add(new Object[]{4, 68.11, "AnLaVN", true});     //add data
        myData.add(new Object[]{3, 69.11, "AnLaVN", false});    //add data
        Excel.WriteExcel("myExcel.xlsx", "mySheet", myData.iterator()); //convert to Iterator and write to Excel file
        
        //Read
        Iterator<Object[]> myExcel = Excel.ReadExcel("myExcel.xlsx", "mySheet");    //declare Iterator to store data from Excel file
        while (myExcel.hasNext()) { //loop to take every row from Iterator
            Object[] row = myExcel.next();  //get row data
            System.out.println(row[0]+" | "+row[1]+" | "+row[2]+" | "+row[3]);  //print it
        }
    }
}