package com.example.demo.cmm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conntest {
	static class DBConstant{
		public static final String ORACLE_DRIVER = "";
		public static final String MYSQL_DRIVER = "";
		public static final String MARIADB_DRIVER = "org.mariadb.jdbc.Driver";
		public static final String MSSQL_DRIVER = "";
		public static final String URL = "jdbc:mariadb://localhost:3306/mariadb";
		public static final String USERNAME = "root";
		public static final String PASSWORD = "root";
	}
	
	static class TestDAO{
		Connection conn;
		Statement stmt;
		TestDAO(){
			try {
				Class.forName(DBConstant.MARIADB_DRIVER);
				conn=DriverManager.getConnection(DBConstant.URL,DBConstant.USERNAME,DBConstant.PASSWORD);
				stmt=conn.createStatement();
			}catch(Exception e){
				System.out.println("DB 접속실패");
				e.printStackTrace();
			}
			
		}
		
		List<?> getValue(String tabname,String colname){
			var list = new ArrayList<>();
			String sql = String.format("select * from %s;",tabname);
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					list.add(rs.getString(colname));
				}
			} catch (Exception e) {
				System.out.println("테이블 접속 실패");
				e.printStackTrace();
			}
			if(list.size()==0) {
				System.out.println("등록된 값이 없습니다.");
			}
			return list;
		}
	}
	
	public static void main(String[] args) {
		TestDAO instance = new TestDAO();
		System.out.println("리스트에 있는 값:"+instance.getValue("managers", "email"));
	}
}
