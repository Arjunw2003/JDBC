package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public void InsertData() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");

		Statement s = c.createStatement();

		int insert = s.executeUpdate("insert into students(id, name, city) Values(4,'Kiran','Pune')");

		if (insert > 0) {
			System.out.println("Insert Data");
		} else {
			System.out.println("Dont Insert Data");
		}

		c.close();

	}

	public void UpadateData() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");

		Statement s = c.createStatement();

		int update = s.executeUpdate("update students set name = 'Monika' Where id = 3");

		if (update > 0) {
			System.out.println("Update Data");
		} else {
			System.out.println("Dont Update Data");
		}

		c.close();

	}

	public void DeleteData() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
		Statement s = c.createStatement();
		int delete = s.executeUpdate("delete from students where id = 4");

		if (delete > 0) {
			System.out.println("delete Data");
		} else {
			System.out.println("Dont delete Data");
		}

		c.close();

	}

	public void FetchAllData() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
		Statement s = c.createStatement();

		ResultSet fetchdata = s.executeQuery("SELECT * FROM Students");

		while (fetchdata.next()) {
			System.out.println("ID: " + fetchdata.getInt(1) + " Name: " + fetchdata.getString(2) + " City: "
					+ fetchdata.getString(3));
		}

	}
}
