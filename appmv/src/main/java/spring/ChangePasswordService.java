package spring;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPassword, String newPassword) {
		System.out.println("여기서 에러");
		Member member = memberDao.selectByEmail(email);
		System.out.println("memberDao.selectByEmail(email)"+ memberDao.selectByEmail(email));
		System.out.println("member"+ member);
		if(member == null) throw new MemberNotFoundException();
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
	}

	public ChangePasswordService() {}
}
