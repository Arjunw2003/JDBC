package com.reg;

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
public class StudRegistration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String dob = req.getParameter("dob");

		String passingYear1 = req.getParameter("passingYear");
		int passingYear = Integer.parseInt(passingYear1);

		String specialization = req.getParameter("specialization");

		String semester = req.getParameter("semester");

		String tenth1 = req.getParameter("tenthPercentage");
		double tenthPercentage = Double.parseDouble(tenth1);

		String twelfth1 = req.getParameter("twelfthPercentage");
		double twelfthPercentage = Double.parseDouble(twelfth1);

		String graduation1 = req.getParameter("graduationPercentage");
		double graduationPercentage = Double.parseDouble(graduation1);

		String experience = req.getParameter("experience");
		String gender = req.getParameter("gender");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Dream@2003");

			PreparedStatement ps = c.prepareStatement(
					"insert into student_registration " + "(firstName, lastName, email, password, mobile, dob, "
							+ "passingYear, specialization, semester, tenthPercentage, "
							+ "twelfthPercentage, graduationPercentage, experience, gender) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, mobile);
			ps.setString(6, dob);
			ps.setInt(7, passingYear);
			ps.setString(8, specialization);
			ps.setString(9, semester);
			ps.setDouble(10, tenthPercentage);
			ps.setDouble(11, twelfthPercentage);
			ps.setDouble(12, graduationPercentage);
			ps.setString(13, experience);
			ps.setString(14, gender);

			int check = ps.executeUpdate();

			if (check > 0) {

				out.println("<h1 style='color:Green;'>" + "Student Registered Successfully" + "</h1>");

				System.out.println("Inserted Data");

			} else {

				System.out.println("Inserted Failed");
			}
		} catch (Exception e) {

		}

	}
}
