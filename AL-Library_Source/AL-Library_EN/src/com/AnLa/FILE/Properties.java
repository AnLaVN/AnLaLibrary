package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**The Properties class supports to get value of properties at specific location.
 * @author AnLaVN
 */
public class Properties {
    private static ResourceBundle Lang;
    
    
    /**Create a default Properties file.
     * @see Properties#setProperties(java.lang.String)
     * @see Properties#Properties(java.lang.String) 
     */
    public Properties() {}
    
    
    /**Create a properties file at location filePath.
     * @param filePath is specific location of Properties file, file name extension must be ".properties".
     */
    public Properties(String filePath) {    setProperties(filePath);    }
    
    
    /**Use this method to setup Properties file location.
     * @param filePath is specific location of Properties file, file name extension must be ".properties".
     * @see Properties#Properties(java.lang.String) 
     */
    public final void setProperties(String filePath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            Lang = new PropertyResourceBundle(fis);
            fis.close();
        }catch(IOException e){
            Log.add("!!! Error trying to open properties file \"" + filePath +"\". !!!\n\tError code: " + e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to get a string value from given key.
     * @param Key a string key in Properties file.
     * @return a string value of key in Properties file.
     */
    public String getString(String Key){    return Lang.getString(Key); }
}