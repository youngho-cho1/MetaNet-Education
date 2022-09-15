package app;
import java.sql.*;
import java.util.*;

import javax.management.relation.Role;

class User{
	private String bankname;
	private String name;
//	private String account;
	private String pw;
	public String getBankname() {
		return bankname;
	}
	public User setBankname(String bankname) {
		this.bankname = bankname;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
//	public String getAccount() {
//		return account;
//	}
//	public User setAccount(String account) {
//		this.account = account;
//		return this;
//	}
	public String getPw() {
		return pw;
	}
	public User setPw(String pw) {
		this.pw = pw;
		return this;
	}
	
	
}
public class AppDao {
	private static AppDao instance;
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static ResultSetMetaData rsmd;

	public void setRsmd(ResultSetMetaData rsmd) {
		AppDao.rsmd = rsmd;
	}
	public void setInstance(AppDao instance) {
		AppDao.instance = instance;
	}
	public  AppDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("오류 : " + e.getStackTrace());
		} 
	}
	public static AppDao getInstance() {
		if(instance == null) {
			instance = new AppDao();
		}
		return instance;
	}
	public Connection getConnection() {
		return this.conn;
	}

	public void createTable() {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("create table DBTEST(ID varchar(50), PW varchar(50))");
			if(result < 0) {
				System.out.println("실행 실패");
			}else {
				System.out.println("실행 성공");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}

	public void insert(String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			String bankname = BankApp_Join.member.getBankname();
			String name = BankApp_Join.member.getName();
			String passwd = BankApp_Join.member.getPasswd();
			String account = BankApp_Join.member.getAccount();
			pstmt.setString(1, bankname);
			pstmt.setString(2, name);
			pstmt.setString(3, passwd);
			pstmt.setString(4, account);
			
//			System.out.println(BankApp_Join.member.getBankname());
//			System.out.println(BankApp_Join.member.getName());
//			System.out.println(BankApp_Join.member.getPasswd());
//			System.out.println(BankApp_Join.member.getAccount());
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공": "실패"	;
			 System.err.println(msg);
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
	
	public void update(String sql) {
		Statement stmt = null;
		Connection conn = AppDao.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "성공": "실패";
			System.out.println(msg);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}

	public static String select() {
		String sql = "select bankname, name, pwd from member";
		return sql;
	}
	public static String delete() {
		String sql = "delete * from member where name=?";
		return sql;
	}
	public static void main(String[] args) {
	}
	public static Connection getConn() {
		return conn;
	}
	public static void setConn(Connection conn) {
		AppDao.conn = conn;
	}
	public static PreparedStatement getPstmt() {
		return pstmt;
	}
	public static void setPstmt(PreparedStatement pstmt) {
		AppDao.pstmt = pstmt;
	}
	public static ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		AppDao.rs = rs;
	}
	public static ResultSetMetaData getRsmd() {
		return rsmd;
	}

}