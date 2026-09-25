package com.controller;

import com.service.StudentService;

public class StudentController {

	public static void main(String[] args) throws Exception {

		StudentService stdService = new StudentService();

//		stdService.Insertdata();
//		stdService.UpdateData();
//		stdService.DeleteData();
		stdService.FetchData();
	}
}
