package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**Lớp Network hỗ trợ lấy thông tin mạng: Thông tin WLAN, địa chỉ IPv4.
 * @author AnLaVN
 */
public class Network {
    public static class WLAN{
        private HashMap<String, String> arr = null;
        private WLAN() {}
        private WLAN(HashMap<String, String> hashmap){  this.arr = hashmap; }
        public String get(Key parameter){
            return arr.get(parameter.toString().replaceAll("_", " "));
        }
    }
    
    /**Các thông số của mạng không dây khả dụng đang sử dụng hiện tại.
     */
    public static enum Key{
        Name, Description, GUID, Physical_address, Interface_type, State, SSID, BSSID, Network_type, Radio_type, 
        Authentication, Cipher, Connection_mode, Band, Channel, Receive_rate, Transmit_rate, Signal, Profile, Hosted_network_status
    }
    
    /**Sử dụng phương thức này để lấy thông tin về giao diện mạng không dây khả dụng và trạng thái của chúng.
     * @return trạng thái của tham số.
     */
    public static final WLAN myWLAN(){
        HashMap<String, String> arr = new HashMap<>();
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "netsh wlan show interfaces");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (r.read() != -1) {
                String line = r.readLine();
                if(!line.contains(":") || line.contains("interface on the system:"))    continue;
                int index = line.indexOf(":");
                String key = line.substring(0, index).trim();
                String val = line.substring(index+2).trim();
                arr.put(key, val);
            }
        } catch (IOException ex) {  Log.add("!!! Error try to get WLAN information. !!!"); }
        return new WLAN(arr);
    }
    
    
    /**Sử dụng phương thức này để lấy địa chỉ IPv4 công khai của bạn.
     * @return Ðịa chỉ IPv4.
     * @throws java.io.IOException ném ngoại lệ nếu như không có kết nối internet.
     */
    public static final String myIPv4() throws IOException{
        return new DocNet("http://checkip.amazonaws.com/").readLine();
    }
}