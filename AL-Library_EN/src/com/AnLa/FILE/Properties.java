package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


/**The Properties class supports to get value of properties at specified location.
 * @author Admin
 */
public class Properties {
    private ResourceBundle Lang;

    
    /**Create a default Properties File.
     * @see Properties#setProperties(java.lang.String) 
     */
    public Properties() {}
    
    /**Create a Properties File at filePath location.
     * @param filePath specified location of Properties file, file name extension must be ".properties".
     */
    public Properties(String filePath) {    setProperties(filePath);    }
    
    
    /**Use this method to setup Properties file location.
     * @param filePath specified location of Properties file, file name extension must be ".properties".
     * @see Properties#Properties(java.lang.String) 
     */
    public final void setProperties(String filePath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            Lang = new PropertyResourceBundle(fis);
            fis.close();
        }catch(IOException e){Log.add("!!! Error trying to open properties file \"" + filePath +"\". !!!");}
    }
    
    /**Use this method to get a string value from given key.
     * @param Key a string key in Properties file.
     * @return a string value of key in Properties file.
     */
    public String getString(String Key){    return Lang.getString(Key); }
}