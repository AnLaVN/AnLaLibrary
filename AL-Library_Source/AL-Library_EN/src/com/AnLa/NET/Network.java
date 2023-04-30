package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**The Network class supports get network information: WLAN information, address IPv4.
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
    
    /**Parameters of currently available wireless network.
     */
    public static enum Key{
        Name, Description, GUID, Physical_address, Interface_type, State, SSID, BSSID, Network_type, Radio_type, 
        Authentication, Cipher, Connection_mode, Band, Channel, Receive_rate, Transmit_rate, Signal, Profile, Hosted_network_status
    }
    
    /**Use this method to get information about the available wireless network interface and their status.
     * @return status of the parameter.
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
    
    
    /**Use this method to get your public IPv4 address.
     * @return IPv4 address.
     * @throws java.io.IOException throw exception if there is no internet connection.
     */
    public static final String myIPv4() throws IOException{
        return new DocNet("http://checkip.amazonaws.com/").readLine();
    }
}