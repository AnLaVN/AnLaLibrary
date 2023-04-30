package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**Lớp ObjectData hỗ trợ ghi và đọc dữ liệu của đối tượng vào tệp tại vị trí được chỉ định.<br>Đảm bảo rằng lớp đối tượng của bạn đã "implements Serializable".
 * @author AnLaVN
 */
public class ObjectData {
    
    
    /**Sử dụng phương thức này để ghi dữ liệu của đối tượng vào tệp tại vị trí filePath.
     * @param filePath là vị trí được chỉ định của tệp, phần mở rộng tệp tin nên là ".dat".
     * @param Data là dữ liệu của đối tượng cần ghi vào tệp.
     */
    public static final void writeData(String filePath, Object Data){
        try{
            File file = new File(filePath.replaceAll("\\\\", "/"));
            file.setExecutable(true);   file.setReadable(true); file.setWritable(true);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Data);
            oos.flush();    oos.close();
            fos.flush();    fos.close();
        }catch(IOException e){
            Log.add("!!! Error try to write object data to file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    /**Sử dụng phương thức này để đọc dữ liệu của đối tượng từ tệp tại vị trí filePath.
     * @param filePath là vị trí được chỉ định của tệp.
     * @return dữ liệu của đối tượng trong tệp.
     */
    public static final Object readData(String filePath){
        try{
            File file = new File(filePath.replaceAll("\\\\", "/"));
            file.setExecutable(true);   file.setReadable(true); file.setWritable(true);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object Data = ois.readObject();
            ois.close();    fis.close();
            return Data;
        }catch(IOException | ClassNotFoundException e){
            Log.add("!!! Error try to read object data from file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
}