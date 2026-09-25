package com.service;

import com.dao.StudentDao;

public class StudentService {
	
	StudentDao stdDao = new StudentDao();
	
	public void InsertData() throws Exception {
		
		stdDao.InsertData();
	}

	public void UpdateData() throws Exception {
		stdDao.UpdateData();
		
	}

	public void DeleteData() throws Exception {
		stdDao.DeleteData();
		
	}

	public void FetchAllData() throws Exception {
		stdDao.FetchAllData();
		
	}

}
