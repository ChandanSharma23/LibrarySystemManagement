package com.libs.sys.Dao;


import com.libs.sys.Entity.Record;

public interface RecordDao {
	
	public void addRecord(Record record);
	public Record updateRecord(Record record );
	public void deleteRecord(int id);
	
	

}
