package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**The Log class supports to print to console and output log file.
 * @author AnLaVN
 */
public class Log {
    private static String PATTERN = "dd-MM-yyyy___HH꞉mm꞉ss";
    private static Raw LogFile = null;

    
    /**Use this method to write a log, it also print them to console. Automatically add new lines.
     * @param text a string text you want write to log.
     */
    public static final void add(String text){
        if(LogFile == null){    
            new File("Logs").mkdirs();  
            LogFile = new Raw("Logs/" + new SimpleDateFormat(PATTERN).format(new Date()) + ".txt");
        }
        if(text != null && !text.isBlank()){
            text = "[" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "]\t" + text.trim();
            LogFile.writeData(text+"\n");
            System.out.println(text);
        }
    }
    
    /**Use this method to set file name pattern. The default value is 'dd-MM-yyyy___HH꞉mm꞉ss'.<br>
     * Run this method first.
     * @param pattern is your file name pattern you want. Follows the SimpleDateFormat patterns.
     */
    public static final void setPattern(String pattern){    PATTERN = pattern;  }
    
    /**Use this method to get current Log File location.
     * @return a string of Log File location.
     */
    public static final String getFilePath(){   return LogFile.getFilePath();   }
    
    /**Use this method if you want to close the log file properly. It is not necessary to use.
     */
    public static final void closeFile(){    LogFile.closeFile();    }
}