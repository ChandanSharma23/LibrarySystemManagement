package com.libs.sys.Service;

import org.springframework.stereotype.Service;

import com.libs.sys.Entity.Record;

@Service
public interface RecordService {
	
	public void addRecord(Record record);
	public Record updateRecord(Record record );
	public void deleteRecord(int id);
	
	
	

}
