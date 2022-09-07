package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class MyCalendar {
	static MyCalendar myCalendar = new MyCalendar();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myCalendar.starter();
	}
	public void starter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 달력 출력: a, 과거 달력 출력: z ");
		String input = sc.next();
		switch(input) {
		case "a":
			buildCurrentCalendar();
			break;
		case "z":
			int year = getYear();
			int month = getMonth();
			buildPastCalendar(year, month);
			break;
		case "c":
			System.out.println("오류입니다.");
			starter();
			break;
		}
	}
	public int getYear() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n 출력을 원하는 연도를 숫자로 입력하세요");
		int yearInput = sc.nextInt();
		if(yearInput <= 0) {
			System.out.println("연도는 자연수로 입력해주세요.");
			yearInput = sc.nextInt();
		}
		return yearInput;
	}
	public int getMonth() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n 출력을 원하는 월을 숫자로 입력해주세요");
		int monthInput = sc.nextInt();
		if(monthInput <= 0 || monthInput > 12) {
			System.out.println("월은 1~12 사이로 입력해주세요");
			monthInput = sc.nextInt();
		}
		return monthInput;
	}
	public int[] getCurrent() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH)+ 1;
		int [] currentYearMonth = {currentYear, currentMonth};
		return currentYearMonth;
	}
	public boolean isLeapYear(int year) {
		if(year %4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else return false;
	}
	public int calMonth1stDayWeek(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		Date currentTime = new Date();
		String YMD = year + "-" + month + "-01";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(currentTime);
		System.out.println("<오늘 날짜는 " + today + "입니다>");
		try {
			calendar.setTime(formatter.parse(YMD));
		}catch(ParseException e){
			e.printStackTrace();
		}
		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		return dayNum;
	}
	public void buildCurrentCalendar() {
		int year = myCalendar.getCurrent()[0];
		int month = myCalendar.getCurrent()[1];
		
		int dayMax = 0;
		int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		boolean leapTest = isLeapYear(year);
		if(month == 2 && leapTest == true) {
			dayMax = dayDataLeapYear[month - 1];
		}
		if(month == 2 && leapTest == false) {
			dayMax = dayData[month - 1];
		}
		if(month != 2) {
			dayMax = dayData[month - 1];
		}
		int dayWeek1 = calMonth1stDayWeek(year, month);
		printCalendar(year, month, dayMax, dayWeek1);
		
	}
	public void buildPastCalendar(int year, int month) {
		
		int dayMax = 0;
		int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		boolean leapTest = isLeapYear(year);
		if(month == 2 && leapTest == true) {
			dayMax = dayDataLeapYear[month - 1];
		}
		if(month == 2 && leapTest == false) {
			dayMax = dayData[month - 1];
		}
		if(month != 2) {
			dayMax = dayData[month - 1];
		}
		int dayWeek1 = calMonth1stDayWeek(year, month);
		printCalendar(year, month, dayMax, dayWeek1);
	}
	public void printCalendar(int year, int month, int dayMax, int dayWeek1) {
		  System.out.println("========== " + year + "년 " + month + "월 ==========");
	        System.out.println("  일  월  화  수  목  금  토  ");
	        for (int j = 1; j < dayWeek1; j++) {
	            System.out.print(" ✨ "); //
	        }
	        for (int i = 1; i <= dayMax; i++) {
	            if (i < 10) {// 한 자리 수이면 앞에 공백 한 번 더 추가
	                System.out.print("  " + i + " ");
	            }
	            if (i >= 10) {
	                System.out.print(" " + i + " ");
	            }
	            // 줄바꿈
	            if ((dayWeek1 - 1 + i ) % 7 == 0) { // 공백 = (dayWeek1 - 1) + i 가 일주일 한 줄.
	                System.out.println();//줄바꿈
	            }
	        }
	}
	
}
	
