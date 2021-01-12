package com.example.demo.cmm.enm;

public enum Sql {
	CREATE_MANAGERS,CREATE_SUBJECTS,CREATE_STUDENTS,CREATE_TEACERS,CREATE_GRADES,
	CREATE_ARTICLES,CREATE_REPLIES,
	TRUNCATE,
	COUNT,
	SELECT_ALL_STUDENTS;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case CREATE_MANAGERS:
			query="create table managers(mgr_num int primary key auto_increment,"
					+ "email varchar(20),"
					+ "password varchar(20),"
					+ "name varchar(20),"
					+ "profile_img text)";break;
		case CREATE_SUBJECTS:
			query="create table subjects(sub_num int primary key auto_increment, "
					+ "subject varchar(20),"
					+ "desc varchar(100))";break;
		case CREATE_STUDENTS:
			query="create table students(stu_num int primary key auto_increment, "
					+ "userid varchar(20), "
					+ "password varchar(20), "
					+ "name varchar(20), "
					+ "birthday varchar(20), "
					+ "gender varchar(20), "
					+ "reg_date varchar(20), "
					+ "profile_img text,"
					+ "mgr_num int, "
					+ "constraint mgr_stu_fk foreign key(mgr_num) references managers(mgr_num)";break;
		case CREATE_TEACERS:
			query="create table teachers(tea_num int primary key auto_increment,"
					+ "name varchar(20),"
					+ "password varchar(20),"
					+ "subject varchar(20),"
					+ "email varchar(20),"
					+ "profile_img text,"
					+ "sub_num int,"
					+ "constraint sub_tea_fk foreign key(sub_num) references subjects(sub_num)";break;
		case CREATE_GRADES:
			query="create table grades(grd_num int primary key auto_increment,"
					+ "score varchar(20), "
					+ "subject varchar(20), "
					+ "grade varchar(20), "
					+ "exam_date varchar(20), "
					+ "pass_exam varcher(20),"
					+ "stu_num int,"
					+ "constraint stu_grd_fk foreing key(stu_num) references students(stu_num)";break;
		case CREATE_ARTICLES:
			query="create table articles(art_num int primary key auto_increment,"
					+ "title varchar(20),"
					+ "content text,"
					+ "count varchar(20),"
					+ "mgr_num int,"
					+ "tea_num int,"
					+ "stu_num int,"
					+ "constraint mgr_art_fk foreign key(mgr_num) references managers(mgr_num)"
					+ "constraint tea_art_fk foreign key(tea_num) references teachers(tea_num)"
					+ "constraint stu_art_fk foreign key(stu_num) references students(stu_num)";break;
		case CREATE_REPLIES:
			query="create table replies(reply_num int primary key auto_increment,"
					+ "content varchar(100),"
					+ "art_num int,"
					+ "mgr_num int,"
					+ "tea_num int,"
					+ "stu_num int,"
					+ "constraint art_rep_fk foreign key(art_num) references articles(art_num)"
					+ "constraint mgr_art_fk foreign key(mgr_num) references managers(mgr_num)"
					+ "constraint tea_art_fk foreign key(tea_num) references teachers(tea_num)"
					+ "constraint stu_art_fk foreign key(stu_num) references students(stu_num)";break;
		case TRUNCATE:
			query="truncate table ";break;
		case COUNT:
			query="select count(*) as count from ";break;
		case SELECT_ALL_STUDENTS:
			query="select stu_num stuNum,userid,password,name,birthday,gender,reg_date regDate,subject,profile_img profileImg from students";break;
		}
		return query;
	}
}
