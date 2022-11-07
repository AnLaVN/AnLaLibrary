package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**The ObjectData class supports write and read object data to file at specified location.<br>Make sure your object class was "implements Serializable".
 * @author Admin
 */
public class ObjectData {
    
    
    /**Use this method to write object Data to file at filePath location.
     * @param filePath specified location of file, file name extension should be ".dat".
     * @param Data a object data need write to file.
     */
    public static final void writeData(String filePath, Object Data){
        try{
            File file = new File(filePath.replaceAll("\\\\", "/"));
            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(true);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Data);
            oos.flush();    oos.close();
            fos.flush();    fos.close();
        }catch(IOException e){Log.add("!!! Error try to write object data to file \"" + filePath +"\". !!!");}
    }
    
    
    /**Use this method to read object data from file at filePath location.
     * @param filePath specified location of file.
     * @return a object data in file.
     */
    public static final Object readData(String filePath){
        try{
            File file = new File(filePath.replaceAll("\\\\", "/"));
            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(true);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object Data = ois.readObject();
            ois.close();    fis.close();
            return Data;
        }catch(IOException | ClassNotFoundException e){
            Log.add("!!! Error try to read object data from file \"" + filePath +"\". !!!");
            throw new RuntimeException(e);}
    }
}