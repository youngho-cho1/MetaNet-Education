package test;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBUtil {
	
    private static DBUtil instance;
    private Connection conn;
    private DataSource ds;
    public DBUtil(){
        try {
        	ds =(DataSource)new InitialContext().lookup("java:/comp/env/jdbc/oracle");
        } catch (NamingException e) {
            System.out.println("오류 : " + e.getStackTrace());
        }
    }

    // 접속종료
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        close(conn);
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            close(conn, pstmt);
        }
    }
    public static DBUtil getInstance(){
        if(instance == null) {
            instance = new DBUtil();
        }
        return instance;

    }
    public Connection getConnection() {
       try {
    	   conn = ds.getConnection();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
       return this.conn;
    }
    public void main(String[] ars) {
    	System.out.println("test");
    }

}