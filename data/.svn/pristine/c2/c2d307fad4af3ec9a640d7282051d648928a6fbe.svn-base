package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bankDto.Grade;
import dbConnect.DbConnector;

public class Dao {
	
	private static final Dao INSTANCE= new Dao();
	private Dao() {}
	public static Dao getInstance(){
		return INSTANCE;
	}
	public int joinAcc(String userId, String userPw, String account) {
		int chk = 0;
//		ResultSet rs = null;
		PreparedStatement pstm= null;
		String query="";
		Connection conn = null;
		try {
			conn = DbConnector.getInstance().dbConnection();
			query ="insert into bankAcc values(?,?,?,0,3)";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, account);
			chk = pstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return chk;
	}
	public ArrayList<Grade> getGradelist() {
		ArrayList<Grade> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String query = "";
		Connection conn =null;
		try {
			conn = DbConnector.getInstance().dbConnection();
			query ="select grade 등급,count(*) 회원수 from bankAcc group by (grade) order by grade ";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int cols = rsmd.getColumnCount();
//			for (int i = 1; i <= cols; i++) {
//				System.out.print(rsmd.getColumnName(i)+"\t");
//			}
			while(rs.next()) {
				list.add(new Grade(rs.getInt(1), rs.getInt(2)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int login(String userId, String userPw) {
		int rs =0;
		ResultSet result = null;
		Connection conn = null;
		PreparedStatement pstm =null;
		String query = "";
		try {
			conn =DbConnector.getInstance().dbConnection();
			query = "select count(*) from bankacc where userid=? and userPw=?";
			pstm =conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			
			result = pstm.executeQuery();
			while(result.next()) {
				rs = result.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		
		return rs;
	}
	public int getUserGrade(String sessionId) {
		int grade = 0;
		ResultSet rs = null;
		Connection conn =null;
		PreparedStatement pstm =null;
		String query = "";
		try {
			conn =DbConnector.getInstance().dbConnection();
			query="select grade from bankacc where userid=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, sessionId);
			rs = pstm.executeQuery();
			if(rs.next()) {
				grade = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		return grade;
	}
	
	
	
}
