package com.libs.sys.Dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.libs.sys.Entity.Record;
import com.libs.sys.Model.UserBookDetails;

@Repository
public interface RecordDao {
	
	public void addRecord(Record record);
	public Record updateRecord(Record record );
	public void deleteRecord(int id);
	public List<UserBookDetails> getUserDetails(int id);
	
	

}
