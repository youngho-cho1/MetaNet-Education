package test;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		for(int i=0; i <= 5; i++) {
			for(int j=5; j >= i; j--) {
				System.out.print(" ");
					}
			for(int k=0;k <= i; k++) {
				if(k==0) {
					System.out.print("*");
				}
				else{
				System.out.print("**");
				}
			}
			
			System.out.println("");
		}
		
		  for(int i=0; i <= 5; i++) {
			  for(int j=0; j <= i; j++) {		  
				  System.out.print(" "); 
				  } 
			  for(int k=5;k >= i; k--) {
				  if(k==5) {
						System.out.print("*");
					}
					else{
					System.out.print("**");
					}
				}
			  System.out.println(""); 
			  }
		 
		
	}

}
