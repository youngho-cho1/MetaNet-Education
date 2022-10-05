package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc(){
        ChangePasswordService PwdSvc = new ChangePasswordService(memberDao());
        return PwdSvc;
    }
    @Bean
    public MemberPrinter memberPrinter() {
    	return new MemberPrinter();
    }
    
    @Bean
    public MemberListService listPrinter() {
    	return new MemberListService(memberDao(), memberPrinter());
    }
    @Bean
    public VersionPrinter versionPrinter() {
    	VersionPrinter versionPrinter = new VersionPrinter();
    	versionPrinter.setMajorVersion(5);
    	versionPrinter.setMinorVersion(0);
    	return versionPrinter;
    }
}