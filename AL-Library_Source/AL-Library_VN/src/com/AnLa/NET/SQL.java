package com.AnLa.NET;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Lớp SQL hỗ trợ kết nối, thực thi mySQL và SQL Server.
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
    
    
    /**Sử dụng phương thức này để kiểm tra kết nối của SQL có null không.
     * @return <code>true</code> nếu kết nối SQL là null, <code>false</code> ngược lại.
     */
    public final boolean isConnectNull(){     return CON == null;     }
    
    
     /**Sử dụng phương thức này để lấy kết nối của SQL.
     * @return Kết nối SQL của bạn.
     */
    public final Connection getConnect(){     return CON;             }
    
    
    /**Sử dụng phương thức này để kết nối Database của bạn.
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
    
    
    /**Sử dụng phương thức này để thực thi Truy Vấn Cập nhật với nhiều đối số Object Varargs.
     * @param Query là câu lệnh Truy vấn SQL dạng chuỗi.<br>
     * @param args là mảng nhiều đối số Object Varargs.<br>
     * @return số hàng bị ảnh hưởng sau khi thực hiện Truy Vấn.
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

    
    /**Sử dụng phương thức này để thực thi Truy Vấn với nhiều đối số Object Varargs.
     * @param Query là câu lệnh Truy vấn SQL dạng chuỗi.<br>
     * @param args là mảng nhiều đối số Object Varargs.<br>
     * @return Tập Kết Quả sau khi thực hiện Truy Vấn.
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