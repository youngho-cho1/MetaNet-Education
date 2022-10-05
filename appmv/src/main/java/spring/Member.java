package spring;

import java.util.Date;

public class Member {
	private long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public Member(String email, String password, String name, Date registerDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}
	void setId(long id) {
	this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
	  public void changePassword(String oldPassword, String newPassword) {
		    if (!password.equals(oldPassword)) {
		      throw new IdPasswordNotMatchingException();
		    }
		    this.password = newPassword;
		  }
}
