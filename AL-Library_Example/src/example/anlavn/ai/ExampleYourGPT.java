package example.anlavn.ai;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.ai.YourGPT;

public class ExampleYourGPT {

    public static void main(String[] args) throws InterruptedException {
        YourGPT.API_KEY = "alk~XXX...XXX";          // Add api key to use
        YourGPT.loadModule();                       // Load module default.
        YourGPT.params.put("--host", "localhost");  // Run at localhost
        YourGPT.params.put("--port", "3000");       // Run at port 3000
        YourGPT.params.put("-ngl", "25");           // Number of GPU player - Allows offloading some layers to the GPU for computation
        YourGPT.params.put("-c", "2048");           // Context size - Set the size of the prompt context
        YourGPT.start();            // Start YGPT process with previous parameters.
        Thread.sleep(60000);        // Wait 60s.
        YourGPT.destroy();          // Forcibly destroy YGPT process.
    }

}