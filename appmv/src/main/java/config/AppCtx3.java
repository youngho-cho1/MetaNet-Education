package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.zaxxer.hikari.HikariDataSource;

import spring.MemberDao;
import spring.MemberPrinter;
//<import resource="classpath:appCtx2.xml" />

@Configuration
@Import({AppCtx2.class})
public class AppCtx3 {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	/* Hikari CP */
	@Bean(destroyMethod = "close")
	public HikariDataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/webapp");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}
}





