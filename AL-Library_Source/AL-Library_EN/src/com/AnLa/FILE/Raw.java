package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**The Raw class supports write and read string data to file at specific location.
 * @author AnLaVN
 */
public class Raw {
    private String filePath = "RawFile.txt";
    private FileOutputStream fos = null;
    private DataOutputStream dos = null;
    
    /**Create a default Raw File at "RawFile.txt" location.
     */
    public Raw() {}

    /**Create a Raw File at filePath location.
     * @param filePath is specific location of Raw file, file name extension should be ".txt".
     */
    public Raw(String filePath) {   
        this.filePath = filePath;  
    }
    
    
    /**Use this method to get file location.
     * @return location of Raw file.
     */
    public String getFilePath(){    return this.filePath;   }
    

    /**Use this method to close the file if you don't want write or read to there anymore.
     */
    public void closeFile(){
        try {
            if(fos != null && dos != null){     dos.flush();    dos.close();    fos.close();    }
        }catch (IOException e){
            Log.add("!!! Error try to close file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to write string Data to file.
     * @param Data a string data need write to file.
     */
    public void writeData(String Data){
        try {
            if(fos == null || dos == null){
                fos = new FileOutputStream(filePath);
                dos = new DataOutputStream(fos);
            }
            dos.write(Data.getBytes()); 
        }catch (IOException e){
            Log.add("!!! Error try to write raw data to file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to read string data from file.
     * @return a string data in file, return null if nothing.
     */
    public String readData(){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            String data = new String(dis.readAllBytes());
            dis.close();    fis.close();
            return data;
        }catch(IOException e){
            Log.add("!!! Error try to read raw data from file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
}