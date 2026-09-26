package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.StudentPojo;

public class StudentDao {

	public void InsertData(StudentPojo std) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");

		PreparedStatement pr = c.prepareStatement("insert into students(id, name, city) Values(?,?,?)");

		pr.setInt(1, std.getId());
		pr.setString(2, std.getName());
		pr.setString(3, std.getCity());

		int insert = pr.executeUpdate();

		if (insert > 0) {
			System.out.println("Insert Data");
		} else {
			System.out.println("Isertion Faild");
		}

	}

	public void UpdateData(StudentPojo std) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
		PreparedStatement pr = c.prepareStatement("update students set name = ? where id = ?");
		pr.setString(1, std.getName());
		pr.setInt(2, std.getId());

		int update = pr.executeUpdate();

		if (update > 0) {
			System.out.println("Update Data");
		} else {
			System.out.println("Updation Faild");
		}
	}

	public void DeleteData(StudentPojo std) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
		PreparedStatement pr = c.prepareStatement("delete from students where id = ?");
		pr.setInt(1, std.getId());

		int delete = pr.executeUpdate();

		if (delete > 0) {
			System.out.println("delete Data");
		} else {
			System.out.println("deletion Faild");

		}
	}

	public void FetchAllData() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
		PreparedStatement pr = c.prepareStatement("Select * from students");

		ResultSet fetch = pr.executeQuery();

		while (fetch.next()) {
			System.out.println(
					"ID: " + fetch.getInt(1) + " Name: " + fetch.getString(2) + " City: " + fetch.getString(3));
		}

	}
}
