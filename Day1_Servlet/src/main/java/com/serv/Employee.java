package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Employee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String empName = req.getParameter("empName");

		String age1 = req.getParameter("age");
		int age = Integer.parseInt(age1);

		String city = req.getParameter("city");

		String salary1 = req.getParameter("salary");
		double salary = Double.parseDouble(salary1);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
			PreparedStatement ps = c
					.prepareStatement("insert into employee(empName, age, city, salary) values(?,?,?,?)");
			ps.setString(1, empName);
			ps.setInt(2, age);
			ps.setString(3, city);
			ps.setDouble(4, salary);

			int check = ps.executeUpdate();

			if (check > 0) {
				out.println("<h1 style='color:Green;'>Employee Registered Successfully<h1>");
				System.out.println("Inserted Data");
			} else {
				System.out.println("Inserted Faild");
			}

		} catch (Exception e) {

		}

	}
}
