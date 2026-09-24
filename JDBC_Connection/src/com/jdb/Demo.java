package com.jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");

		Statement s = c.createStatement();
		
		
//		============================Insert Data==============================

//		int insert = s.executeUpdate("insert into students(id, name, city) Values(3,'Rahul','Selu')");

//		if (insert > 0) {
//			System.out.println("Insert Data");
//		} else {
//			System.out.println("Dont Insert Data");
//		}

		
//		==============================Update data==========================
		
//		int Update = s.executeUpdate("Update students set name = 'Oma', city = 'Jintur' Where id = 12");
//
//		if (Update > 0) {
//			System.out.println("Update Data");
//		} else {
//			System.out.println("Dont Update Data");
//		}

		
//		===============================delete data========================
		
//		int delete = s.executeUpdate("delete from students where name = 'pavan'");
//		
//		if (delete > 0) {
//			System.out.println("delete Data");
//		} else {
//			System.out.println("Dont delete Data");
//		}

//		===================================Fetch All Data======================

		ResultSet fetchData = s.executeQuery("SELECT * FROM students");

		while (fetchData.next()) {
			System.out.println("ID: " + fetchData.getInt(1) + " Name: " + fetchData.getString(2) + " City: "
					+ fetchData.getString(3));
		}

		c.close();
	}

}
