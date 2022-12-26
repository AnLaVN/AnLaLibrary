package JDBC;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.JDBC.SQL;
import java.sql.*;

public class ExampleSQL {

    public static void main(String[] args) throws SQLException {
        final String 
            DB_name = "myDatabase", //declare your database name
            DB_username = "sa",     //declare your database login username
            DB_password = "",       //declare your database login password
            MSSQL = "jdbc:sqlserver://localhost:1433;DatabaseName=" + DB_name + ";encrypt=true;trustServerCertificate=true", //declare MSSQL url with your database name
            mySQL = "jdbc:mysql://localhost:3306/" + DB_name,  //declare mySQL url with your database name
            DB_url= MSSQL;  //choice the database to which you will connect
        SQL sql = new SQL(DB_url, DB_username, DB_password);    //setup to your database information
        sql.Connect();  //connect to your database (if exists)
        
        ResultSet rs = sql.Query("select * from myTable");      //query all from table
        while(rs.next()){
            System.out.println("ID: " + rs.getString("ID") + " - " + rs.getString("Name"));//get value
        }
        
        System.out.println("-------------------------------------------------------------------------");
        
        int ID = 1;
        sql.Update("delete from myTable where ID = ?", ID); //query delete from table with parameters ID
        rs = sql.Query("select * from myTable");            //query all from table
        while(rs.next()){
            System.out.println("ID: " + rs.getString("ID") + " - " + rs.getString("Name"));//get value
        }
    }
    
}