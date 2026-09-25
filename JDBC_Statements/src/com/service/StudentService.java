package com.service;

import com.Dao.StudentDao;

public class StudentService {

	StudentDao stDao = new StudentDao();
	

	public void Insertdata() throws Exception {
		stDao.InsertData();
	}

	public void UpdateData() throws Exception {
		stDao.UpadateData();
	}
	
	public void DeleteData() throws Exception {
		stDao.DeleteData();
	}
	
	public void FetchData() throws Exception {
		stDao.FetchAllData();
	}
}
