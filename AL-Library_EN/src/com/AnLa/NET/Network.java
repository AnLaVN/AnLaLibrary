package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**The NET class supports get network information:<br>
 * WLAN information, address IPv4.
 * @author Admin
 */
public class Network {
    
    /**Use this method to get information your WLAN.
     * @return a HashMap of cmd "netsh wlan show interfaces".
     */
    public static HashMap<String, String> myWLAN(){
        HashMap<String, String> arr = new HashMap<>();
        String line;
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "netsh wlan show interfaces");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (r.read() != -1) {
                line = r.readLine();
                if(line.contains("Software")){ arr.put("Radio status", arr.get("Radio status")+" "+line.trim()); }
                if(!line.contains(":") || line.contains("interface on the system:")){continue;}
                int index = line.indexOf(":");
                String key = line.substring(0, index).trim();
                String val = line.substring(index+2).trim();
                arr.put(key, val);
            }
        } catch (IOException ex) {System.out.println(ex);}
        return arr;
    }
    
    
    /**Use this method to get your public IPv4 address.
     * @return IPv4 address.
     * @throws java.io.IOException If URL malformed or IOException.
     */
    public static String myIPv4() throws IOException{
        URL url = new URL("http://checkip.amazonaws.com/");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        return br.readLine();
    }
}