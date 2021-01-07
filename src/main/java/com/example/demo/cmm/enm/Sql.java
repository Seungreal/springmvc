package com.example.demo.cmm.enm;

public enum Sql {
	TRUNCATE_STUDENTS,
	COUNT_STUDENTS,
	SELECT_ALL_STUDENTS;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case TRUNCATE_STUDENTS:
			query="truncate table students;";break;
		case COUNT_STUDENTS:
			query="select count(*) as count from students;";break;
		case SELECT_ALL_STUDENTS:
			query="select * from students";break;
		}
		return query;
	}
}
