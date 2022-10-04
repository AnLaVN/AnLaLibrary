package com.AnLa.JDBC;
// Make By Bình An || AnLaVN || KatoVN

import java.sql.*;

public class SQL{
    private String URL = null, USERNAME = null, PASSWORD = null;
    private Connection CON = null;
    
    private boolean isSQL(){    return (URL != null && USERNAME != null && PASSWORD != null);   }
    
    /**Tạo kết nối SQL mặc định.
     * @see SQL#setSQL(java.lang.String, java.lang.String, java.lang.String) 
     */
    public SQL() {}
    
    /**Tạo kết nối SQL với đầy đủ thông tin.
     * @param DB_url là URL Database để kết nối.<br>
     * @param DB_username là Tên đăng nhập Database.<br>
     * @param DB_password là Mật khẩu Database.<br>
     */
    public SQL(String DB_url, String DB_username, String DB_password) {
        this.URL = DB_url; 
        this.USERNAME = DB_username;
        this.PASSWORD = DB_password;
    }
    
    /**Sử dụng phương thức này để thiết lập thông tin kết nối SQL. Hỗ trợ MSSQL và MYSQL.
     * @param DB_url là URL Database để kết nối.<br>
     * @param DB_username là Tên đăng nhập Database.<br>
     * @param DB_password là Mật khẩu Database.<br>
     * @see SQL#SQL(java.lang.String, java.lang.String, java.lang.String) 
     */
    public void setSQL(String DB_url, String DB_username, String DB_password){
        this.URL = DB_url; 
        this.USERNAME = DB_username;
        this.PASSWORD = DB_password;
    }
    
    /**Sử dụng phương thức này để kiểm tra kết nối của SQL có null không.
     * @return <code>true</code> nếu kết nối SQL là null, <code>false</code> ngược lại.
     */
    public boolean isConnectNull(){ 
        return CON == null; 
    }
    
    /**Sử dụng phương thức này để kết nối Database của bạn.
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
                default          ->{System.out.println("!!! Error Syntax !!! SQL does not exist."); s = false;}
            }//Check SQL information
            if(isSQL() && s){   CON = DriverManager.getConnection(URL, USERNAME, PASSWORD); }
            else{   System.out.println("\t!!! Error !!! SQL is not set up, please use setSQL method."); }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("\t!!! Error trying to connect Database. !!!");
            throw new RuntimeException(e);
        }
    }
    
    
    /**Sử dụng phương thức này để đặt Câu lệnh truy vấn.
     * @param Query là một câu lệnh Truy vấn SQL dạng chuỗi.<br>
     * @return Câu lệnh chuẩn bị sẵn SQL.
     */
    public PreparedStatement setQuery(String Query){
        try{    return CON.prepareStatement(Query); }
        catch(SQLException e){
            System.out.println("\n!!! Error trying to set query. !!!");
            throw new RuntimeException(e);
        }
    }
    
    /**Sử dụng phương thức này để nhận Tập Kết Quả của câu lệnh chuẩn bị sẵn SQL.
     * @param ps là một câu lệnh chuẩn bị sẵn SQL.<br>
     * @return Tập Kết Quả sau khi truy vấn.
     */
    public ResultSet Execute(PreparedStatement ps){
        try{    return ps.executeQuery();   }
        catch(SQLException e){
            System.out.println("\n!!! Error trying to execute query. !!!");
            throw new RuntimeException(e);
        }
    }
    
    /**Sử dụng phương thức này để nhận Tập Kết Quả của câu lệnh truy vấn SQL dạng chuỗi.
     * @param Query là một câu lệnh Truy vấn SQL dạng chuỗi.<br>
     * @return Tập Kết Quả sau khi truy vấn.
     */
    public ResultSet ExecuteQuery(String Query){
        return Execute(setQuery(Query));
    }
}