package com.appmv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberListService;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.VersionPrinter;

public class MainForXmlSpring {
	private static ApplicationContext ctx =null;
	public static void main(String[] args) throws IOException{
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		ChangePasswordService pwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요: ");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new")) {
//				processNewCommand(command.split(" "));
				continue;
			}
			
		}
	}
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
	}
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4	) {
			printHelp();
			return;
		}
		ChangePasswordService changePasswordService = ctx.getBean("changPasswordService", ChangePasswordService.class);
		 try {
		      changePasswordService.changePassword(arg[1], arg[2], arg[3]);
		      System.out.println("암호를 변경했습니다.\n");
		    } catch (MemberNotFoundException e) {
		      System.out.println("존재하지 않는 이메일입니다.\n");
		    } catch (IdPasswordNotMatchingException e) {
		      System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		    }
	}
	private static void processListCommand() {
		MemberListService listPrinter = ctx.getBean("listPrinter", MemberListService.class);
		listPrinter.memberList();
	}
	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
	}
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재 비밀번호 변경 비밀번호");
	}
}
