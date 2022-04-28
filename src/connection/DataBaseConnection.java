package connection;

import java.sql.*;

public class DataBaseConnection{
    private final String DBDriver ="com.mysql.jdbc.Driver";

    private final String DBURL = "jdbc:mysql://localhost:3306/first?useSSL=false";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "seven0531";

    private Connection conn = null;
    //构造器
    public DataBaseConnection(){
        try{
            Class.forName(DBDriver);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //获得连接
    public Connection getConnection(){
        return this.conn; }

    //关闭连接
    public void close() throws SQLException{
        this.conn.close(); }


}
