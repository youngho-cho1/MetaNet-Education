package dao;
import java.util.*;

import test.UserInfo;

/*CREATE TABLE MEMBERS(
		MNO INTEGER PRIMARY KEY AUTO_INCREMENT,
		EMAIL VARCHAR(40)	NOT NULL,
		PWD	  VARCHAR(100)	NOT NULL,
		MNAME	VARCHAR(50)	NOT NULL,
		CRE_DATE	DATETIME	NOT NULL,
		MOD_DATE 	DATETIME	NOT NULL
		);*/
public interface UserInfoDao {
	List<UserInfo> selectList() throws Exception;
	int insert(UserInfo userinfo) throws Exception;
	int delete(String id) throws Exception;
	UserInfo selectOne(String id) throws Exception;
	UserInfo exist(String id, String password) throws Exception;
	int update(UserInfo userinfo) throws Exception;
	
}
