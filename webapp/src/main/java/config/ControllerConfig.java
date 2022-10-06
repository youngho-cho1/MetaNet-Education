package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import controller.LogInController;
import controller.MemberListController;
import dao.MySqlMemberDao;

@Configuration
public class ControllerConfig implements WebMvcConfigurer {
	@Autowired
	private MySqlMemberDao memberDao;
	
	@Bean
	public LogInController loginController() {
		LogInController logInController = new LogInController();
		logInController.setMemberDao(memberDao);
		return logInController;
	}
	
	@Bean
	public MemberListController memberListController() {
		MemberListController memberListController = new MemberListController();
		memberListController.setMemberDao(memberDao);
		return memberListController;
	}
}
