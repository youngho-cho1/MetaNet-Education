package test;

public class NotExistIDException extends Exception {
	public NotExistIDException() {} 
	// 오버로딩 : 매개변수의 유형과 개수를 다르게하여 다양한 유형의 호출의 응답할 수 있게 함
	public NotExistIDException(String message) {
		super(message);
	}
}
