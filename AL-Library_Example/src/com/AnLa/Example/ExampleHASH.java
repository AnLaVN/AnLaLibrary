package com.AnLa.Example;

// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.HASH.AES;
import com.AnLa.HASH.SHA256;

public class ExampleHASH {

    public static void main(String[] args) {
        String originalStr = "This is the string need to hash";
        String AES_Key     = "This is secury key for AES";
        
        String Hash_SHA256 = SHA256.Encrypt(originalStr);
        String Hash_AES    = AES.Encrypt(originalStr, AES_Key);
        
        System.out.println("HASH SHA256 no key: " + Hash_SHA256);
        System.out.println("HASH AES with key: "  + Hash_AES);
        
        System.out.println("\nDecrypt AES only: " + AES.Decrypt(Hash_AES, AES_Key));
    }
    
}