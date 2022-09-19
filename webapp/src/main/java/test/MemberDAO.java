package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class MemberDAO {
	private Statement stmt;
	private Connection conn;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/app?autoReconnect=true";
	private static final String user = "root";
	private static final String pwd = "1234";
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from member";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 성공");
			stmt = conn.createStatement();
			System.out.println("Statement 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
