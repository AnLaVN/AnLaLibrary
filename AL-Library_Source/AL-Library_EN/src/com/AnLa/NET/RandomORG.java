package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import java.io.IOException;

/**The RandomORG class supports to create true random numbers from random.org
 * @author AnLaVN
 */
public class RandomORG {
    private static final String 
            RANINT = "https://www.random.org/integers/?num=1&min=MIN&max=MAX&col=1&base=BAS&format=plain&rnd=new",
            RANSEQ = "https://www.random.org/sequences/?min=MIN&max=MAX&col=1&format=plain&rnd=new",
            RANSTR = "https://www.random.org/strings/?num=1&len=LEN&digits=DIG&upperalpha=UPE&loweralpha=LOW&unique=on&format=plain&rnd=new",
            RANQUO = "https://www.random.org/quota/?format=plain";
    
    
    /**Use this method to generate truly random integers.
     * @param min is the smallest value allowed for each integer.
     * @param max is the largest value allowed for each integer.
     * @param base is the base that will be used to print the numbers. Decimal is default.<br>Example: 2(binary), 8(octal), 10(decimal) or 16(hexadecimal).
     * @return truly random integer.
     * @throws java.io.IOException throw an exception if there is no internet connection or cannot connect to random.org
     */
    public static final String getInteger(int min, int max, int base) throws IOException{
        return new DocNet(RANINT
                .replaceFirst("MIN", String.valueOf(min))
                .replaceFirst("MAX", String.valueOf(max))
                .replaceFirst("BAS", String.valueOf(base != 2 && base != 8 && base != 10 && base != 16 ? 10 : base))
        ).readLine();
    }
    
    
    /**Use this method to randomize a given interval of integers and arrange them in random order.
     * @param min is the lower bound of the interval (inclusive).
     * @param max is the upper bound of the interval (inclusive).
     * @return string with random order.
     * @throws java.io.IOException throw an exception if there is no internet connection or cannot connect to random.org
     */
    public static final String getSequence(int min, int max) throws IOException{
        return new DocNet(RANSEQ
                .replaceFirst("MIN", String.valueOf(min))
                .replaceFirst("MAX", String.valueOf(max))
        ).readAllLine().trim();
    }
    
    
    /**Use this method to generate truly random strings of various length and character compositions.
     * @param len is the length of the string.
     * @param digit Determines whether digits (0-9) are allowed to occur in the string.
     * @param upper Determines whether uppercase alphabetic characters (A-Z) are allowed to occur in the string.
     * @param lower Determines whether lowercase alphabetic characters (a-z) are allowed to occur in the string.
     * @return truly random string.
     * @throws java.io.IOException throw an exception if there is no internet connection or cannot connect to random.org
     */
    public static final String getString(int len, boolean digit, boolean upper, boolean lower) throws IOException{
        return new DocNet(RANSTR
                .replaceFirst("LEN", String.valueOf(len < 1 || len > 20 ? 10 : len))
                .replaceFirst("DIG", digit ? "on" : "off")
                .replaceFirst("UPE", upper ? "on" : "off")
                .replaceFirst("LOW", lower ? "on" : "off")
        ).readLine();
    }
    
    
    /**Use this method to examine your quota. The quota system works on the basis of IP addresses. 
     * Each IP address has a base quota of 1,000,000 bits. 
     * When your client makes a request for random numbers (or strings, etc.), 
     * the server deducts the number of bits it took to satisfy your request from the quota associated with your client's IP address.
     * @return number of quota bits remaining of your IP address.
     * @throws java.io.IOException throw an exception if there is no internet connection or cannot connect to random.org
     */
    public static final String getQuota() throws IOException{
        return new DocNet(RANQUO).readLine();
    }
}