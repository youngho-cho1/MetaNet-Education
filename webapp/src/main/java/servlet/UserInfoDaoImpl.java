package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.UserInfoDao;
import test.DBUtil;
import test.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {
	private DataSource datasource;
	public void setDataSource(DataSource datasource) {
		this.datasource = datasource;
	}
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
		try {
			pstmt = conn.prepareStatement("INSERT INTO MEMBER(ID,PWD) VALUES(?,?)");

			pstmt.setString(1, userinfo.getId());
			pstmt.setString(2, userinfo.getPwd());
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {}
		}
		return pstmt.executeUpdate();
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			return stmt.executeUpdate("DELETE FROM MEMBER WHERE ID='"+id+"'");
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
			}
		}
	}

	@Override
	public UserInfo selectOne(String id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs =null;
		UserInfo userinfo = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ID, PWD FROM MEMBER WHERE ID = '"+id+"'");
			if(rs.next()) {
				userinfo = new UserInfo().setId(rs.getString("ID")).setPwd(rs.getString("PWD"));
			}
		}catch(Exception e) {
			throw e;
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		return userinfo;
	}

	@Override
	public int update(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE MEMBER SET pwd=? WHERE id=?");
			stmt.setString(1, userinfo.getPwd());
			stmt.setString(2, userinfo.getId());
			return stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		
	}

	@Override
	public UserInfo exist(String id, String pwd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo userinfo = null;
		String sql = "SELECT ID,PWD FROM MEMBER WHERE ID=? AND PWD=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userinfo = new UserInfo().setId(rs.getString(1))
						.setPwd(rs.getString(2));
			}		
		}catch(SQLException e) {
			throw e;
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
