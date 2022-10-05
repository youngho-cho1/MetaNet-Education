package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {
	private static DbConnector instance;
	private Connection conn;
	
	public Connection dbConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","1234");
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		return conn;
	}
	public static DbConnector getInstance() {
		if(instance == null) {
			instance =  new DbConnector();
		}
		return instance;
	}
	public Connection getConnection() {
		return this.conn;
	}
}
