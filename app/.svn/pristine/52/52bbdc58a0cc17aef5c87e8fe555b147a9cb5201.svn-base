package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
class Tinfo{
	private String id;
	private String yname;
	private Date day;
	private int money;
	public String getId() {
		return id;
	}
	public Tinfo setId(String id) {
		this.id = id;
		return this;
	}
	public String getYname() {
		return yname;
	}
	public Tinfo setYname(String yname) {
		this.yname = yname;
		return this;
	}
	public Date getDay() {
		return day;
	}
	public Tinfo setDay(Date day) {
		this.day = day;
		return this;
	}
	public int getMoney() {
		return money;
	}
	public Tinfo setMoney(int money) {
		this.money = money;
		return this;
	}
	
}
class History{
	private String ybankname;
	public String getYbankname() {
		return ybankname;
	}
	public History setYbankname(String ybankname) {
		this.ybankname = ybankname;
		return this;
	}
	private String bankname;
	private String money;
	private String account;
	private String yname;
	private String day;
	private String division;
	public String getBankname() {
		return bankname;
	}
	public History setBankname(String bankname) {
		this.bankname = bankname;
		return this;
	}
	public String getMoney() {
		return money;
	}
	public History setMoney(String money) {
		this.money = money;
		return this;
	}
	public String getAccount() {
		return account;
	}
	public History setAccount(String account) {
		this.account = account;
		return this;
	}
	public String getYname() {
		return yname;
	}
	public History setYname(String yname) {
		this.yname = yname;
		return this;
	}
	public String getDay() {
		return day;
	}
	public History setDay(String day) {
		this.day = day;
		return this;
	}
	public String getDivision() {
		return division;
	}
	public History setDivision(String division) {
		this.division = division;
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
	static String myaccount = "";
	static int cnt = 0;
	static List<History> data = new ArrayList<>();
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
	public void trans_insert() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);
		BankApp_Transfer.transfer.setDay(formatedNow);
		Connection conn = AppDao.getInstance().getConnection();
		PreparedStatement pstmt = null, pstmt2 = null, pstmt3 = null;
		ResultSet rs = null, rs2 = null;
		ResultSetMetaData rsmd = null;
		List<Tinfo> data = new ArrayList<>();
		String yname = "";
		String bankname = BankApp_Transfer.transfer.getBankname();
		String account = BankApp_Transfer.transfer.getAccount();
		System.out.println("account: " + account);
		String money = BankApp_Transfer.transfer.getMoney();
		String date = "y", date2 = "n";
		try {
			pstmt2 = conn.prepareStatement("select bankname, name, account, despoit from member where account=?");
			pstmt2.setString(1, account);
			rs2 = pstmt2.executeQuery();
			rsmd = rs2.getMetaData();
			
			
			while(rs2.next()) {
				BankApp_Transfer.transfer.setYname(rs2.getString(2));
				yname = rs2.getString(2);
			}
			System.out.println("BankApp_Login.w_name: "+BankApp_Login.w_name);
			System.out.println("yname: " + yname);
			if(!BankApp_Login.w_name.equals(yname)) {
			pstmt = conn.prepareStatement("insert into history(ybankname, name, yname, yaccount, division, day, money) values(?,?,?,?,?,?,?)");
//			insert into history(name, yname, division, money) values('조영호','문채영','y','1000');
			// y면 입금== 들어오는 돈 n이면 출금 == 나가는 돈
			pstmt.setString(1, bankname);
			pstmt.setString(2, BankApp_Login.w_name);
			pstmt.setString(3, yname);
			pstmt.setString(4, account);
			pstmt.setString(5, date);
			BankApp_Transfer.transfer.setDivision(date);
			pstmt.setString(6, formatedNow);
			pstmt.setString(7, money);
			pstmt.executeUpdate();
			
			pstmt3 = conn.prepareStatement("insert into history(ybankname, name, yname, yaccount, division, day, money) values(?,?,?,?,?,?,?)");
			pstmt3.setString(1, BankApp_Login.y_bank);
			pstmt3.setString(2, yname);
			pstmt3.setString(3, BankApp_Login.w_name);
			pstmt3.setString(4, account);
			pstmt3.setString(5, date2);
			pstmt3.setString(6, formatedNow);
			pstmt3.setString(7, money);
			pstmt3.executeUpdate();
			}
			else {
				pstmt3 = conn.prepareStatement("insert into history(ybankname, name, yname, yaccount, division, day, money) values(?,?,?,?,?,?,?)");
				pstmt3.setString(1, BankApp_Login.y_bank);
				pstmt3.setString(2, yname);
				pstmt3.setString(3, BankApp_Login.w_name);
				pstmt3.setString(4, account);
				pstmt3.setString(5, date2);
				pstmt3.setString(6, formatedNow);
				pstmt3.setString(7, money);
				pstmt3.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void history() {
		Connection conn = AppDao.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
	
		BankApp_Transfer.transfer.getAccount();
		BankApp_Transfer.transfer.getBankname();
		BankApp_Transfer.transfer.getDay();
		BankApp_Transfer.transfer.getDivision();
		BankApp_Transfer.transfer.getMoney();
		BankApp_Transfer.transfer.getYname();
		try {
			pstmt = conn.prepareStatement("select ybankname, bankname, yaccount, despoit, yname, "
					+ "division, day, money from member left join history ON"
					+ " member.name = history.name where member.name=? union"
					+ " select ybankname, bankname, yaccount, despoit, yname, division, day, money  "
					+ "from member right join history ON member.name = history.name where member.name=?");
			pstmt.setString(1, BankApp_Login.w_name); 
			pstmt.setString(2, BankApp_Login.w_name);
			rs = pstmt.executeQuery();

				data.clear();
				while(rs.next()) {
					History history = new History().setBankname(rs.getString(1)).setYbankname(rs.getString(2)).setAccount(rs.getString(3)).setYname(rs.getString(5))
							.setDivision(rs.getString(6)).setDay(rs.getString(7)).setMoney(rs.getString(8));
					data.add(history);
				}
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static String update() {
		String sql = "UPDATE MEMBER SET despoit=? WHERE NAME=?";
		return sql;
		
	}
	public void accountselect() {
		Connection conn = AppDao.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT ACCOUNT FROM MEMBER WHERE NAME =?");
			pstmt.setString(1, BankApp_Login.w_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				myaccount = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String update2() {
		String sql = "UPDATE MEMBER SET despoit=? WHERE ACCOUNT=?";
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