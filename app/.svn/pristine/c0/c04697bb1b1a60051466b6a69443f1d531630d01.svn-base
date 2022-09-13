package test;
import java.util.*;
public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor, eng, math, total;
		double avg;
		String names[] = {"여랑", "재현", "민아"};
		int kors[] = {30, 20, 100};
		int engs[] = {100, 70, 100};
		int maths[] = {20, 50, 100};
		List arr = new ArrayList();
		
		for(int i = 0; i < names.length; i++) {
			arr.add(names[i]);
			arr.add(kors[i]);
			arr.add(engs[i]);
			arr.add(maths[i]);
			
			
		}
		System.out.println("-------- 학생 성적 프로그램 --------\n");
		System.out.println(" 이름\t국어\t영어\t수학\t총점\t평균");
		Iterator iterator = arr.iterator();
		while(iterator.hasNext()) {
			System.out.println("\n" + iterator.next());
			Object obj = iterator.next();
			kor = (Integer)obj;
//			kor = in.intValue();
			eng = ((Integer) iterator.next()).intValue();
			math = (Integer) iterator.next();
			total = kor + eng + math;
			avg = (double)total / 3;
			System.out.println("\t" + kor + "\t" + eng + "\t" + math);
			
		}
	}

}
