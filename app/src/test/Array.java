package test;
import java.util.*;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[5];
		Random rand = new Random();
		int max = 0;
		int min = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)rand.nextInt(100);
			System.out.print(arr[i]+", ");
			
		}
			System.out.println(" ");
		max = arr[0];
		min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
			else if(min > arr[i]) {
				min = arr[i];
			}
		}
		

		System.out.println("MAX: "+ max);
		System.out.println("MIN: "+ min);
		
	}

}
