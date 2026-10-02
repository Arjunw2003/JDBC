package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");

		String age1 = req.getParameter("age");
		int age = Integer.parseInt(age1);

		String city = req.getParameter("city");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");

		String tenthPercentage = req.getParameter("tenthPercentage");
		double tenth = Double.parseDouble(tenthPercentage);

		String twelfthPercentage = req.getParameter("twelfthPercentage");
		double twelfth = Double.parseDouble(twelfthPercentage);

		String graduationPercentage = req.getParameter("graduationPercentage");
		double graduation = Double.parseDouble(graduationPercentage);

		String gender = req.getParameter("gender");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
			PreparedStatement ps = c.prepareStatement(
					"insert into student(fname,lname,age,city,mobile, email,password,dob,tenthPercentage,twelfthPercentage,graduationPercentage,gender) Values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, age);
			ps.setString(4, city);
			ps.setString(5, mobile);
			ps.setString(6, email);
			ps.setString(7, password);
			ps.setString(8, dob);
			ps.setDouble(9, tenth);
			ps.setDouble(10, twelfth);
			ps.setDouble(11, graduation);
			ps.setString(12, gender);

			int insert = ps.executeUpdate();

			if (insert > 0) {
				out.print("<h1 style = 'color: Green'>Student Registration Successfully...</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
//				rd.forward(req, resp);
				rd.include(req, resp);
				System.out.println("INSERTED");
			} else {
				out.print("<h1 style = 'color: red'>Student Registration Failds...</h1>");
				System.out.println("FAILD");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
