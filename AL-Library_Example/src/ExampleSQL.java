
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.JDBC.SQL;
import java.sql.*;

public class ExampleSQL {

    public static void main(String[] args) throws SQLException{
        //Create new sql variable
        SQL sql = new SQL();
        
        
        //Check SQL Connect Infor
        System.out.println("SQL Connect is null : "+sql.isConnectNull());
        
        
        //Set SQL Information(URL, Username, Passsword), it can be a MSSQL or MYSQL
        sql.setSQL("jdbc:sqlserver://localhost:1433;DatabaseName=AChatDB;encrypt=true;trustServerCertificate=true", "sa", "");
      //sql.setSQL("jdbc:mysql://localhost:3306/Your_Database_Name", "root", "12345");
     
        
        //Connect to Database, it will automatically determine your SQL type
        sql.Connect();
        
        
        //Check SQL Connect Infor again
        System.out.println("SQL Infor is null : "+sql.isConnectNull());
        
        
        //Execute Query, they are 2 way:
        ResultSet rs = null;
        
        //Way 1: Useful for Select, Update Query Statements with Arguments
        PreparedStatement ps = sql.setQuery("select * from USERINFO");
      //PreparedStatement ps = sql.setQuery("insert into USERINFO values (?, ?);
      //ps.setString(1, "Username");
      //ps.setString(2, "Password");
        rs = sql.Execute(ps);
        
        //Way 2: Usefull for Select Query with no Arguments
      //rs = sql.ExecuteQuery("select * from USERINFO");
        
        
        //Print a Result Set to screen
        while(rs.next()){
            System.out.println("Username: "+rs.getString(1));
        }
    }
}