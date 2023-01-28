package FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.Serializable;
//Make sure your class have 'implements Serializable'
public class myObject implements Serializable{
    private String name;
    private int age;

    public myObject() {}
    public myObject(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {   return name;    }
    public int getAge()     {   return age;     }
}