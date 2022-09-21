package test;

public class UserInfo {
	private String id;
	private String pwd;
	
//	public UserInfo() {
//		
//	}
//	public UserInfo(String id, String pwd) {
//		super();
//		this.id = id;
//		this.pwd = pwd;
//	}
	public String getId(){
		return id;
	}
	public UserInfo setId(String id) {
		this.id = id;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public UserInfo setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	
}
