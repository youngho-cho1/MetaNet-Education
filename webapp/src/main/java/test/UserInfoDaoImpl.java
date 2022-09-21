package test;

import java.sql.*;
import java.util.*;


import dao.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserInfo> selectList() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<UserInfo> userInfos = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ID,PWD FROM MEMBER ORDER BY ID ASC");
			userInfos = new ArrayList<UserInfo>();
			while(rs.next()) {
				userInfos.add(new UserInfo().setId(rs.getString("id")).setPwd(rs.getString("pwd")));
			}
		}catch(Exception e) { throw e;
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				
			}
		}
		return userInfos;
	}

	@Override
	public int insert(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		ArrayList<UserInfo> userInfos = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO MEMBER(ID,PWD) VALUES(?,?)");
			pstmt2 = conn.prepareStatement("SELECT ID,PWD FROM MEMBER ORDER BY ID ASC");
			rs = pstmt2.executeQuery();
			rsmd = rs.getMetaData();
	
			pstmt.setString(1, userinfo.getId());
			pstmt.setString(2, userinfo.getPwd());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {}
		}
		return result;
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectOne(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updqte(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo exist(String id, String pwd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		UserInfo userinfo = new UserInfo();
		String sql = "SELECT ID,PWD FROM MEMBER WHERE ID=? AND PWD=?";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
//			userinfo.setId(rs.getString("id"));
//			userinfo.setPwd(rs.getString("pwd"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {}
		}
		
		return userinfo;
	}

}
