package test;

public class User {
	private String id;
	private String pwd;
	public String getId(){
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public User setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
}
