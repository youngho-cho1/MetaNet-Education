package test;

import java.sql.*;


import com.mysql.cj.jdbc.result.ResultSetMetaData;

import app.AppDao;

public class Ex38 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = AppDao.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = orderBy();
			rs = stmt.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i = 1; i<= cols; i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.println(columnName + "\t");
			}
			System.out.println("\n---------------------------------");
			while(rs.next()) {
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static String insert() {
		String sql = "inser into obtest values(3, 'hi');";
		return sql;
	}
	public static String orderBy() {
		String sql = "select * from obtest by id desc";
		return sql;
	}


}
