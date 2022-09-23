package app;
import java.sql.*;
import java.util.*;

import javax.management.relation.Role;
import javax.swing.JOptionPane;

class User{
	private String bankname;
	private String name;
	private String pw;
	private String id;
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
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
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
class Info{
	private String id;

	public String getId() {
		return id;
	}

	public Info setId(String id) {
		this.id = id;
		return this;
	}
}
class UserName{
	private String name;
	public String getName() {
		return name;
	}
	public UserName setName(String name) {
		this.name = name;
		return this;
	}
}
class UserDespoit{
	private String bankname;
	private String name;
	private String account;
	private int despoit;
	public String getBankname() {
		return bankname;
	}
	public UserDespoit setBankname(String bankname) {
		this.bankname = bankname;
		return this;
	}
	public String getName() {
		return name;
	}
	public UserDespoit setName(String name) {
		this.name = name;
		return this;
	}
	public String getAccount() {
		return account;
	}
	public UserDespoit setAccount(String account) {
		this.account = account;
		return this;
	}
	public int getDespoit() {
		return despoit;
	}
	public UserDespoit setDespoit(int despoit) {
		this.despoit = despoit;
		return this;
	}
}
public class AppDao {
	static int join_cnt = 0;
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app?autoReconnect=true", "root", "1234");
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

	public void insert() {
		BankApp_Join.sus = 0;
		join_cnt = 0;
		Connection conn = AppDao.getInstance().getConnection();
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<Info> data = new ArrayList<>();
		
		String bankname = BankApp_Join.member.getBankname();
		String name = BankApp_Join.member.getName();
		String id = BankApp_Join.member.getId();
		String passwd = BankApp_Join.member.getPasswd();
		String account = BankApp_Join.member.getAccount();
		try {
			pstmt = conn.prepareStatement("insert into member(bankname, name, id, pwd, account, despoit) values(?,?,?,?,?,0)");
			pstmt2 = conn.prepareStatement(AppDao.select());
			rs = pstmt2.executeQuery();
			rsmd = rs.getMetaData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(rs.next()) {
				Info info = new Info().setId(rs.getString(3));
				data.add(info);
			}
			Iterator<Info> iterator = data.iterator();
			while(iterator.hasNext()) {
				Info uinfo = iterator.next();
				if(id.equals(uinfo.getId())) {
					JOptionPane.showMessageDialog(null,"아이디가 중복됩니다." );
					join_cnt ++;
				}
				
			}
			
			System.out.println("1"+bankname+"2"+name+"3"+id+"4"+passwd+"5"+account);
			if(name.equals("")||id.equals("")||passwd.equals("")||account.equals("")) {
				JOptionPane.showMessageDialog(null,"공백란을 입력해주세요." );
			}
			else if(join_cnt == 0) {
				pstmt.setString(1, bankname);
				pstmt.setString(2, name);
				pstmt.setString(3, id);
				pstmt.setString(4, passwd);
				pstmt.setString(5, account);
				int result = pstmt.executeUpdate();
				String msg = result > -1 ? "성공": "실패"	;
				System.err.println(msg);
				if (msg == "성공") {
					JOptionPane.showMessageDialog(null,"회원가입에 성공하셨습니다." );
					BankApp_Join.sus ++;
				}
			}
		
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
			}catch(Exception e) {JOptionPane.showMessageDialog(null,"공백란을 입력해주세요." );}
		}
	}
	
	public static String update() {
		String sql = "UPDATE MEMBER SET despoit=? WHERE NAME=?";
		return sql;
		
	}

	public static String select() {
		String sql = "select bankname, name, id, pwd from member";
		return sql;
	}
	public static String select_id() {
		String sql = "select name from member";
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