package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tka", "root", "Dream@2003");
			PreparedStatement ps = c.prepareStatement("Select * from student where email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				session.setAttribute("fname", rs.getString("fname"));
				session.setAttribute("lname", rs.getString("lname"));
				session.setAttribute("age", rs.getInt("age"));
				session.setAttribute("city", rs.getString("city"));
				session.setAttribute("mobile", rs.getString("mobile"));
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("dob", rs.getDate("dob"));
				session.setAttribute("tenthPercentage", rs.getDouble("tenthPercentage"));
				session.setAttribute("twelfthPercentage", rs.getDouble("twelfthPercentage"));
				session.setAttribute("graduationPercentage", rs.getDouble("graduationPercentage"));
				session.setAttribute("gender", rs.getString("gender"));

				out.print("<h1 style = 'color: green'> Login Successfully... </h1>");
				RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
				rd.forward(req, resp);
//				rd.include(req, resp);
				System.out.println("Login Successfully... ");
			} else {
				out.print("<H1 style = 'color:red'>Login Faild....</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, resp);
//				rd.include(req, resp);

				System.out.println("Login Faild... ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
