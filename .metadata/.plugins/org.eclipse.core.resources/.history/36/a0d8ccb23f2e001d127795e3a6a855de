package test;
import java.util.*;
public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int snum = 0;
		int[] scores =  null;
		int selectNo = 0;
		Scanner sc = new Scanner(System.in);
		while(run) {
			System.out.println("\n");
			System.out.println("---------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택> ");
			selectNo = sc.nextInt();
			switch(selectNo) {
			case 1:{
				System.out.print("학생수> ");
				snum = sc.nextInt();
				scores = new int[snum];
				break;
			}
			case 2:{	
				for(int i=0; i<scores.length; i++) {
					System.out.print(i+"번 점수입력> ");
					scores[i] = sc.nextInt();
				}
				break;
			}
			case 3:{
				System.out.print("점수리스트> ");
				for(int i=0; i<scores.length; i++) {
					System.out.print(scores[i]+", ");
				}
				
				break;
			}
			case 4:{
				System.out.print("분석> ");
				int max = 0,min = 1000, sum = 0;
				double avg = 0;
				for(int i=0; i<scores.length; i++) {
					if(max < scores[i]) {
						max = scores[i];
					}
					else if(min > scores[i]) {
						min = scores[i];
					}
					sum += scores[i];
				}
				avg = sum/snum;
				System.out.println("MAX: "+max);
				System.out.println("MIN: "+min);
				System.out.println("AVG: "+avg);
				break;
	
			}
			case 5:{
				System.out.print("종료");
				run = false;
			}
			}
			
		}
	}

}
