package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;

/**The NativeLibrary class supports to loading dynamic libraries. 
 * @author AnLaVN
 */
public class NativeLibrary {
    
    /**Use this method to loads library from specific location.
     * @param filePath is specific location of library file.<br>Example: "package/File.dll".
     */
    public static final void load(String filePath){     System.load(new File(filePath).getAbsolutePath());  }
}