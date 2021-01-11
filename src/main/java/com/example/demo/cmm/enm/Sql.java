package com.example.demo.cmm.enm;

public enum Sql {
	TRUNCATE_STUDENTS,
	COUNT,
	SELECT_ALL_STUDENTS;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case TRUNCATE_STUDENTS:
			query="truncate table students";break;
		case COUNT:
			query="select count(*) as count from ";break;
		case SELECT_ALL_STUDENTS:
			query="select stu_num stuNum,userid,password,name,birthday,gender,reg_date regDate,subject,profile_img profileImg from students";break;
		}
		return query;
	}
}
