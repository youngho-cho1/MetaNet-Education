package test;
/*- 그룹화하여 데이터 조회 (GROUP BY) 
	: 대표적인 그룹 함수 COUNT(), AVG(), MIN(), MAX(), SUM() 함수 통과
	  HAVING 절을 사용
	  [연슨 테이블]: GBTEST
	  CREATE TABLE GBTEST(
			  IDX	int,
			  TYPE	int,
			  NAME	VARCHAR(20));
			  
	[레코드 추가]
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	insert into gbtest values(1, 1, '홍길동');
	ex1) 유형별로 갯수를 가져오고 싶은데, 단순히 count 함수로 데이터를
	조회하면 전체 갯수만을 가져옵니다.
	ex2) 컬럼 그룹화: 
	ex3) type 1 초과인, type 그룹화하여 name 갯수 초기화(조건 처리 후 컬럼 그룹화)
	HAVING 사용
	ex4) typr 1	초과인, type 그룹화하여 name 갯수를 가져온 후, 그 중에 갯수가 2개 이상인 데이터 조회( 조건 처리 후에 컬럼 그룹화 후에 조건 처리)
	 
	연습문제) type 1 초과인, type 그룹화하여 name 갯수를 가져온 후, 
			그 중에 갯수가 2개 이상인 데이터를 type 내림차순 정렬으로 조회(내림차순 정렬)
			  */

import java.sql.*;

import app.AppDao;

public class Ex40 {

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
		}
		
	}
	public static String select() {
//		String sql = "select type, count(name) as cnt from gbtest where type > 1 group by type";
		String sql = "select type, count(name) as cnt from gbtest where type > 1 group by type having cnt >= 2 order by type desc";
		return sql;
	}

}
