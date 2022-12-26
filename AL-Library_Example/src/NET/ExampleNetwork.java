package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.Network;

public class ExampleNetwork {

    public static void main(String[] args){
        System.out.println("My IPv4: " + Network.myIPv4()); //print my public ip, not local ip
        System.out.println("My Wlan: " + Network.myWLAN().get("SSID")); //print wlan ssid name
    }
    
}