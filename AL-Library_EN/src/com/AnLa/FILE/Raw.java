package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**The Raw class supports write and read string data to file at specified location.
 * @author Admin
 */
public class Raw {
    private String filePath = "RawFile.txt";
    private FileOutputStream fos = null;
    private DataOutputStream dos = null;

    
    /**Create a default Raw File at "RawFile.txt" location.
     * @see Raw#setFilePath(java.lang.String) 
     */
    public Raw() {  openFile(); }

    /**Create a Raw File at filePath location.
     * @param filePath specified location of Raw file, file name extension should be ".txt".
     */
    public Raw(String filePath) {   
        this.filePath = filePath;   
        openFile();
    }
    
    /**Use this method to setup Raw file location.
     * @param filePath specified location of Raw file, file name extension should be ".txt".
     * @see Raw#Raw(java.lang.String) 
     */
    public void setFilePath(String filePath){   this.filePath = filePath;   }
    
    private void openFile(){
        try {
            fos = new FileOutputStream(filePath);
            dos = new DataOutputStream(fos);
        } catch (FileNotFoundException ex) {Log.add("!!! Error try to open file \"" + filePath +"\". !!!");}
    }

    /**Use this method to close the file if you don't want write or read to there anymore.
     */
    public void closeFile(){
        try {   
            dos.flush();
            dos.close();
            fos.close();
        } catch (IOException ex){Log.add("!!! Error try to close file \"" + filePath +"\". !!!");}
    }
    
    /**Use this method to write string Data to file.
     * @param Data a string data need write to file.
     */
    public void writeData(String Data){
        try {
            dos.write(Data.getBytes());
        } catch (IOException ex){Log.add("!!! Error try to write raw data to file \"" + filePath +"\". !!!");}
    }
    
    /**Use this method to read string data from file.
     * @return a string data in file, return null if nothing.
     */
    public String readData(){
        String data = null;
        try{
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            data = new String(dis.readAllBytes());
            dis.close();
            fis.close();
        }catch(IOException ex){Log.add("!!! Error try to read raw data from file \"" + filePath +"\". !!!");}
        return data;
    }
}