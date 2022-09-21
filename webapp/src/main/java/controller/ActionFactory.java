package controller;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		// 페이지 컨트롤러에 대한 인스턴스만 생성하겠다 --> 이 것을 프론트 컨트롤로 반환하겠다
		Action action = null;
		if(command.equals("login")) {
			action = new UserInfoLoginAction();
		}else if(command.equals("list")) {
			action = new UserInfoListAction();
		} /*
			 * else if(command.equals("login")) { action = new UserInfoLoginAction(); }else
			 * { action = new UserInfoLoginAction(); }
			 */
		return action;
	}
}
