package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**Lớp Raw hỗ trợ ghi và đọc chuỗi dữ liệu Thô vào tệp tại vị trí được chỉ định.
 * @author Admin
 */
public class Raw {
    private String filePath = "RawFile.txt";
    private FileOutputStream fos = null;
    private DataOutputStream dos = null;

    
    /**Tạo một tệp Thô mặc định tại vị trí "RawFile.txt".
     * @see Raw#setFilePath(java.lang.String) 
     */
    public Raw() {  openFile(); }

    /**Tạo một tệp thô tại vị trí filePath.
     * @param filePath vị trí cụ thể của tệp Thô, phần mở rộng tệp tin nên là ".txt".
     */
    public Raw(String filePath) {   
        this.filePath = filePath;   
        openFile();
    }
    
    /**Sử dụng phương thức này để thiết lập vị trí tệp Thô.
     * @param filePath là vị trí cụ thể của tệp Thô, phần mở rộng tệp tin nên là ".txt".
     * @see Raw#Raw(java.lang.String)
     */
    public void setFilePath(String filePath){   this.filePath = filePath;   }
    
    private void openFile(){
        try {
            fos = new FileOutputStream(filePath);
            dos = new DataOutputStream(fos);
        } catch (FileNotFoundException ex) {Log.add("!!! Error try to open file \"" + filePath +"\". !!!");}
    }

    /**Sử dụng phương thức này để đóng tệp nếu bạn không muốn ghi hoặc đọc vào đó nữa.
     */
    public void closeFile(){
        try {   
            dos.flush();
            dos.close();
            fos.close();
        } catch (IOException ex){Log.add("!!! Error try to close file \"" + filePath +"\". !!!");}
    }
    
    /**Sử dụng phương pháp này để ghi chuỗi dữ liệu Thô vào tệp.
     * @param Data là chuỗi dữ liệu cần ghi vào tệp.
     */
    public void writeData(String Data){
        try {
            dos.write(Data.getBytes());
        } catch (IOException ex){Log.add("!!! Error try to write raw data to file \"" + filePath +"\". !!!");}
    }
    
    /**Sử dụng phương pháp này để đọc dữ liệu chuỗi từ tệp.
     * @return một chuỗi dữ liệu trong tệp, trả về null nếu không có gì.
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