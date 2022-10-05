package bankCommand;

import java.util.ArrayList;

import bankDto.Grade;
import dao.Dao;

public class GradeGroup {
	public ArrayList<Grade> getList(){
		ArrayList<Grade> list = new ArrayList<Grade>();
		Dao dao = Dao.getInstance();
		list = dao.getGradelist();
		return list;
	}
}
