package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import app.AppDao;

public class Ex42 {

   public static void main(String[] args) {
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
         for( int i = 1; i <= columnCnt; i++) {
            String columnName = rsmd.getColumnName(i);
            System.out.print(columnName + "\t");
         }
         System.out.println("\n-------------------------------------------");
         while(rs.next()) {
            for( int i = 1; i <= columnCnt; i++ ) {
               String columnValue = rs.getString(i);
               System.out.print(columnValue + "\t");
            }
            System.out.println();
         }
      }catch(SQLException e) {
         e.printStackTrace();
      }
      finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
            if (conn != null)
               conn.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }

   }
   
   public static String select() {
//ex1
//      String sql="select * from jntest1 cross join jntest2";
//      String sql="select * from jntest1, jntest2";
//      return sql;
//ex2
//      String sql="select * from jntest1 t1 inner join t2 ont1.id = t2.id;
//      return sql;
//ex3
      String sql="select * from jntest1 t1 left outer join jntest2 t2 on t1.id = t2.id ";
      return sql;
//ex4
//      String sql="select * from jntest1 t1 right outer join jntest2 t2 on t1.id = t2.id";
      
   }

}