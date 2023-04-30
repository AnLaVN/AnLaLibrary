package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**The SQL class supports to connect, execute mySQL and SQL server.
 * @author AnLaVN
 */
public class SQL{
    private String URL = null, USERNAME = null, PASSWORD = null;
    private Connection CON = null;
    private PreparedStatement getPreparedStatement(String Query, Object... args) throws SQLException{
        PreparedStatement ps = null;
        if(Query.trim().startsWith("{"))    ps = CON.prepareCall(Query);
        else                                ps = CON.prepareStatement(Query);
        for(int i=0; i < args.length; i++)  ps.setObject(i + 1, args[i]);
        return ps;
    }
    private SQL(){}
    
    
    /**Create a SQL connect with full information.
     * @param DB_url is Database URL to connect.<br>
     * @param DB_username is Database Username.<br>
     * @param DB_password is Database Password.<br>
     */
    public SQL(String DB_url, String DB_username, String DB_password) {
        this.URL = DB_url; 
        this.USERNAME = DB_username;
        this.PASSWORD = DB_password;
    }
    

    /**Use this method to check the connection of SQL is null.
     * @return <code>true</code> if SQL connection is null, <code>false</code> in the opposite.
     */
    public final boolean isConnectNull(){     return CON == null;     }
    
    
     /**Use this method to get connection of SQL.
     * @return Connection of your SQL.
     */
    public final Connection getConnect(){     return CON;             }
    
    
    /**Use this method to connect your Database.
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @see SQL#SQL(java.lang.String, java.lang.String, java.lang.String) 
     */
    public final void Connect() throws ClassNotFoundException, SQLException{
        boolean s = true;
        String SQLType = URL.substring(5, URL.indexOf("//")-1); //Check type SQL
        Log.add("SQL type: "+SQLType);
        switch (SQLType) {
            case "sqlserver" -> Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            case "mysql"     -> Class.forName("com.mysql.cj.jdbc.Driver");
            default          ->{Log.add("!!! Error Syntax !!! SQL does not exist."); s = false;}
        }//Check SQL information
        if(URL!=null && USERNAME!=null && PASSWORD!=null && s)  CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        else{   Log.add("!!! Error !!! SQL is not set up, please use setSQL method.");  }
    }
    
    
    /**Use this method to execute Update Query with multiple arguments Object Varargs.
     * @param Query is a String SQL Query statement.<br>
     * @param args is array multiple arguments Object Varargs.<br>
     * @return number of row affected after execute the Query.
     * @see SQL#Query(java.lang.String, java.lang.Object...)
     */
    public final int Update(String Query, Object... args){
        try{    
            return getPreparedStatement(Query, args).executeUpdate(); 
        }catch (SQLException e) {
            Log.add("!!! Error try to execute update query: " + Query + "!!!\n\tError code: " + e.toString());
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
    

    /**Use this method to execute Query with multiple arguments Object Varargs.
     * @param Query is a String SQL Query statement.<br>
     * @param args is array multiple arguments Object Varargs.<br>
     * @return a Result Set after execute the Query.
     * @see SQL#Update(java.lang.String, java.lang.Object...) 
     */
    public final ResultSet Query(String Query, Object... args) {
        try {
            return getPreparedStatement(Query, args).executeQuery(); 
        }catch (SQLException e) {
            Log.add("!!! Error try to execute query: " + Query + "!!!\n\tError code: " + e.toString());
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, e); 
            throw new RuntimeException(e);
        }
    }
}