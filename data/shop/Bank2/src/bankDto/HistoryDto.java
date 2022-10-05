package bankDto;

public class HistoryDto {
	private String userId;
	private int money;
	public HistoryDto(String userId, int money) {
		super();
		this.userId = userId;
		this.money = money;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
