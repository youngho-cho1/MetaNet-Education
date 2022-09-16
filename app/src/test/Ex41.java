package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import app.AppDao;

/*	[실습 테이블 만들기] : LSTEST
	CREATE TABLE LSTEST(
		PHONE VARCHAR(15),
		NAME VARCHAR(10),
			)*/
	
public class Ex41 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = AppDao.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql = select();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int columnCnt = rsmd.getColumnCount();
			for(int i =1; i<= columnCnt;i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.println(columnName + "\t");
			}
			System.out.println("\n--------------------------------------");
			while(rs.next()) {
				for(int i = 1; i <= columnCnt; i++) {
					String columnValue = rs.getString(i);
					System.out.println(columnValue + "\t");
				}
				System.out.println();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {e.printStackTrace();}
		}
		
	}

	public static String select() {
//		String sql = "select phone, name from lstest where phone like '%011";
//		String sql = "select phone, name from lstest where phone like '011%";
//		String sql = "select phone, name from lstest where phone like '%070%";
//		String sql = "select phone, name from lstest where phone like '0%8'";
//		String sql = "select phone, name from lstest where phone like '_순_'";
//		String sql = "select phone, name from lstest where phone like '칠__";
//		String sql = "select phone, name from lstest where phone like '__이";
		String sql = "select phone, name from lstest where phone like '갑_이";
		
		return sql;
	}
}
