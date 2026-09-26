package com.service;

import com.dao.StudentDao;
import com.pojo.StudentPojo;

public class StudentService {

	StudentDao stdDao = new StudentDao();

	public void InsetData(StudentPojo std) throws Exception {
		stdDao.InsertData(std);
	}
	
	public void UpdateData(StudentPojo std) throws Exception {
		stdDao.UpdateData(std);
	}
	
	public void DeleteData(StudentPojo std) throws Exception {
		stdDao.DeleteData(std);
	}
	
	public void FetchAllata() throws Exception {
		stdDao.FetchAllData();
	}
}
