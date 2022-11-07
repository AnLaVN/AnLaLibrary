package com.AnLa.JDBC;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.sql.*;

/**The SQL class supports to connect, execute mySQL and SQL server.
 * @author Admin
 */
public class SQL{
    private String URL = null, USERNAME = null, PASSWORD = null;
    private Connection CON = null;
    
    private boolean isSQL(){    return (URL != null && USERNAME != null && PASSWORD != null);   }
    
    /**Create a default SQL connect.
     * @see SQL#setSQL(java.lang.String, java.lang.String, java.lang.String) 
     */
    public SQL() {}    
    
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
    
    
    /**Use this method to setup the SQL connect information. Support MSSQL and MYSQL.
     * @param DB_url is Database URL to connect.<br>
     * @param DB_username is Database Username.<br>
     * @param DB_password is Database Password.<br>
     * @see SQL#SQL(java.lang.String, java.lang.String, java.lang.String) 
     */
    public void setSQL(String DB_url, String DB_username, String DB_password){
        this.URL = DB_url; 
        this.USERNAME = DB_username;
        this.PASSWORD = DB_password;
    }
    

    /**Use this method to check the connection of SQL is null.
     * @return <code>true</code> if SQL connection is null, <code>false</code> in the opposite.
     */
    public boolean isConnectNull(){ 
        return CON == null; 
    }
    
    
    /**Use this method to connect your Database.
     * @see SQL#setSQL(java.lang.String, java.lang.String, java.lang.String) 
     */
    public void Connect(){
        boolean s = true;
        String SQLType = URL.substring(5, URL.indexOf("//")-1); //Check type SQL
        System.out.println("SQL type: "+SQLType);
        try{
            switch (SQLType) {
                case "sqlserver" -> Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                case "mysql"     -> Class.forName("com.mysql.cj.jdbc.Driver");
                default          ->{Log.add("!!! Error Syntax !!! SQL does not exist."); s = false;}
            }//Check SQL information
            if(isSQL() && s){   CON = DriverManager.getConnection(URL, USERNAME, PASSWORD); }
            else{   Log.add("!!! Error !!! SQL is not set up, please use setSQL method."); }
        }catch(ClassNotFoundException | SQLException e){
            Log.add("!!! Error trying to connect Database. !!!");
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to set a Query Statement.
     * @param Query is a String SQL Query statement.<br>
     * @return a Prepared Statement SQL.
     */
    public PreparedStatement setQuery(String Query){
        try{    return CON.prepareStatement(Query); }
        catch(SQLException e){
            Log.add("!!! Error trying to set query. !!!");
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to execute a String SQL Query statement.
     * @param Query is a String SQL Query statement.
     */
    public void Execute(String Query){
        try {   setQuery(Query).execute();  }
        catch (SQLException ex) {
            Log.add("!!! Error trying to execute query. !!!");
        }
    }
    
    
    /**Use this method to get a Result Set of Prepared Statement SQL.
     * @param ps is a Prepared Statement SQL.<br>
     * @return a Result Set after execute the Query.
     */
    public ResultSet Execute(PreparedStatement ps){
        try{    return ps.executeQuery();   }
        catch(SQLException e){
            Log.add("!!! Error trying to execute query. !!!");
            throw new RuntimeException(e);
        }
    }
    
    
    /**Use this method to get a Result Set of a String SQL Query statement.
     * @param Query is a String SQL Query statement.<br>
     * @return a Result Set after execute the Query.
     */
    public ResultSet ExecuteQuery(String Query){
        return Execute(setQuery(Query));
    }
}