package com.controller;

import java.util.Scanner;

import com.pojo.StudentPojo;
import com.service.StudentService;

public class StudentController {

	public static void main(String[] args) throws Exception {

		StudentService stdService = new StudentService();
		Scanner sc = new Scanner(System.in);

		int choice;

		do {

			System.out.println("\n===== STUDENT CRUD MENU =====");
			System.out.println("1. Insert Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Fetch All Students");
			System.out.println("5. Exit");
			System.out.print("Enter Your Choice : ");

			choice = sc.nextInt();
			sc.nextLine();

			StudentPojo std = new StudentPojo();

			switch (choice) {

			case 1:
				System.out.print("Enter ID : ");
				std.setId(sc.nextInt());
				sc.nextLine();

				System.out.print("Enter Name : ");
				std.setName(sc.nextLine());

				System.out.print("Enter City : ");
				std.setCity(sc.nextLine());

				stdService.InsetData(std);
				break;

			case 2:
				System.out.print("Enter ID to Update : ");
				std.setId(sc.nextInt());
				sc.nextLine();

				System.out.print("Enter New Name : ");
				std.setName(sc.nextLine());

				stdService.UpdateData(std);
				break;

			case 3:
				System.out.print("Enter ID to Delete : ");
				std.setId(sc.nextInt());

				stdService.DeleteData(std);
				break;

			case 4:
				stdService.FetchAllata();
				break;

			case 5:
				System.out.println("Thank You! Program Closed.");
				break;

			default:
				System.out.println("Invalid Choice! Please Enter 1 to 5.");
			}

		} while (choice != 5);

		sc.close();
	}
}