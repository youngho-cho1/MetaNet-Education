package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import app.AppDao;

/*제약 조건(constraint)
제약 조건(constraint)이란 데이터 무결성을 지키기 위해
데이터를 입력 받았을 때 실행되는 검사 규칙을 의미한다
이러한 제약 조건은 create 문으로 테이블을 생성할 때나 alter문으로 필드를 추가할 때도 설정할 수도 있습니다.

- mysql에서 사용할 수 있는 제약 조건은 다음과 같습니다
1. not null
2. unique
3. primary key
4. foreign key
5. default

- not null
not null 제약 조건을 설정하면, 해당 필드는 null 값을 저장할 수 없습니다
즉, 이 제약 조건이 설정된 필드는 무조건 데이터를 가지고 있어야 합니다
not null 제약 조건은 create문으로 테이블을 생성할 때나,
나중에 alter 문으로 추가 가능 
ex1) [테이블 생성
create table test1(
 	id	varchar(10),
 	pw	varchar(30)	 not null,
 	name	varchar(30)
*/
public class Ex34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = AppDao.getInstance().getConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(alter4());
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException e) {}
		}
	}
	public static String alter() {
		String sql = "alter table attest add column age varchar(10) not null";
		return sql;
	}
	public static String alter2() {
		String sql = "alter table attest modify age int";
		return sql;
	}
	public static String alter3() {
		String sql = "alter table attest change pw password varchar(30) not null;";
		return sql;
	}
	public static String alter4() {
		String sql = "alter table attest drop age";
		return sql;
	}
// ex2) age int 
// ex3) pw를 pwd와 varchar(30) not null
// ex4) age 삭제
	
}
