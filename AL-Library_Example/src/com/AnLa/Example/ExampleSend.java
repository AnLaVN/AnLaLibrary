package com.AnLa.Example;

// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.SMTP.SendMail;

public class ExampleSend {

    public static void main(String[] args) {
        SendMail sm = new SendMail();
        sm.setHost("yourEmail@domain.com", "applicationPass");
        sm.setEmail("Tittle Email", "<h1>hello, this is test email</h1>");
        sm.sendMailTo("yourFriend@domain.com");
    }
}