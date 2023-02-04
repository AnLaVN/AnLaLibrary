package NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.RandomORG;
import java.io.IOException;

public class ExampleRandomORG {

    public static void main(String[] args) throws IOException {
        System.out.println(RandomORG.getInteger(0, 10, 10));            //get a truly random integer from 0 to 10 in decimal
        System.out.println(RandomORG.getSequence(0, 10));               //get truly random order integer from 0 to 10
        System.out.println(RandomORG.getString(10, true, true, true));  //get a truly random string with digit, upper, lower case and length equal 10
        System.out.println(RandomORG.getQuota());                       //get number quota bits remaining of your IP address.
    }
}