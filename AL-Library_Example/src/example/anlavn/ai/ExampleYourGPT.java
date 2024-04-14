package example.anlavn.ai;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.ai.YourGPT;

public class ExampleYourGPT {

    public static void main(String[] args) throws InterruptedException {
        YourGPT.loadModule();       // Load module default.
        YourGPT.params.put("--host", "localhost");
        YourGPT.params.put("--port", "3000");
        YourGPT.params.put("-ngl", "25");
        YourGPT.params.put("-c", "2048");
        YourGPT.start();            // Start YGPT process with previous parameters.
        Thread.sleep(60000);        // Wait 60s.
        YourGPT.destroy();          // Forcibly destroy YGPT process.
    }

}