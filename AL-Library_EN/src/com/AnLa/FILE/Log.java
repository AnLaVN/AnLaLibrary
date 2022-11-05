package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**The Log class supports to print to console and output log file.
 * @author Admin
 */
public class Log {
    private static final String PATH = "Log/" + new SimpleDateFormat("dd-MM-yyyy HH;mm;ss").format(new Date()) + ".txt";
    private static Raw LogFile = new Raw(PATH);

    /**Use this method to write a log, it also print them to console. Automatically add new lines.
     * @param text a string text you want write to log.
     */
    public static void add(String text){
        File path = new File("Log");
        if (!path.exists()){    
            path.mkdirs();  
            LogFile = new Raw(PATH);
        }
        text = text.trim();
        if(!text.equals("")){
            LogFile.writeData(text+"\n");
            System.out.println(text);
        }
    }
    
    /**Use this method to get current Log File location.
     * @return a string of Log File location.
     */
    public static String getFilePath(){ return PATH;    }
    
    /**Use this method if you want to close the log file properly. It is not necessary to use.
     */
    public static void closeFile(){    LogFile.closeFile();    }
}