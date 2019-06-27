package com.libs.sys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.libs.sys.Dao.RecordDao;
import com.libs.sys.Entity.Record;

public class RecordServiceImpl implements RecordService {
	
	@Autowired
	@Qualifier("recordDaoImpl")
	RecordDao recordDao;
	

	@Override
	public void addRecord(Record record) {
		// TODO Auto-generated method stub
           recordDao.addRecord(record);
	}

	@Override
	public Record updateRecord(Record record) {
		// TODO Auto-generated method stub
		return recordDao.updateRecord(record);
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
             recordDao.deleteRecord(id);
	}

}
