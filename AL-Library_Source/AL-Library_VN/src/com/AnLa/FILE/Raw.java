package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**Lớp Raw hỗ trợ ghi và đọc chuỗi dữ liệu Thô vào tệp tại vị trí được chỉ định.
 * @author AnLaVN
 */
public class Raw {
    private String filePath = "RawFile.txt";
    private FileOutputStream fos = null;
    private DataOutputStream dos = null;
    
    /**Tạo một tệp Thô mặc định tại vị trí "RawFile.txt".
     */
    public Raw() { }

    /**Tạo một tệp thô tại vị trí filePath.
     * @param filePath là vị trí cụ thể của tệp Thô, phần mở rộng tệp tin nên là ".txt".
     */
    public Raw(String filePath) {   
        this.filePath = filePath;  
    }
    
    
    /**Sử dụng phương thức này để lấy vị trí tập tin.
     * @return vị trí của tệp Thô.
     */
    public String getFilePath(){    return this.filePath;   }
    

    /**Sử dụng phương thức này để đóng tệp nếu bạn không muốn ghi hoặc đọc vào đó nữa.
     */
    public void closeFile(){
        try {
            if(fos != null && dos != null){     dos.flush();    dos.close();    fos.close();    }
        }catch (IOException e){
            Log.add("!!! Error try to close file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    /**Sử dụng phương pháp này để ghi chuỗi dữ liệu Thô vào tệp.
     * @param Data là chuỗi dữ liệu cần ghi vào tệp.
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
    
    
    /**Sử dụng phương pháp này để đọc dữ liệu chuỗi từ tệp.
     * @return một chuỗi dữ liệu trong tệp, trả về null nếu không có gì.
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