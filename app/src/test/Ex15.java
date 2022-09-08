package test;

public class Ex15 {
	String str = "";
	public void foo(int i) {
		try {
			if(i==1) {
				throw new Exception();
			}
			str += " 1 ";
		} catch(Exception e) {
			str += " 2 ";
			return;
		} finally {
			str += " 3 ";
		}
		str += " 4 ";
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex15 ee = new Ex15();
		ee.foo(0);
		ee.foo(1);
		System.out.println(ee.str);
	}

}
