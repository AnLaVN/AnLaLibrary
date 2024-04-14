package example.anlavn.net;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.net.Network;
import static anlavn.net.Network.Key.SSID;
import java.io.IOException;

public class ExampleNetwork {

    public static void main(String[] args) throws IOException{
        System.out.println("My IPv4: " + Network.myIPv4());             //print my public ip, not local ip
        System.out.println("My Wlan: " + Network.myWLAN().get(SSID));   //print wlan ssid name
    }
}