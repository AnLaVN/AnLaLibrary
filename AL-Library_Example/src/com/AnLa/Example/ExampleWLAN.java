package com.AnLa.Example;

// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.Network;
import java.io.IOException;
import java.util.HashMap;

public class ExampleWLAN {

    public static void main(String[] args) throws IOException {
        String myIP = Network.myIPv4();
        System.out.println("my public IPv4 Address: " + myIP);
        
        HashMap<String, String> myWLAN = Network.myWLAN();
        String SSID = myWLAN.get("SSID");
        String Signal = myWLAN.get("Signal");
        System.out.println("My SSID: " + SSID);
        System.out.println("SSID Signal: " + Signal);
        
    }
    
}
