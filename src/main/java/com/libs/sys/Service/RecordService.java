package com.libs.sys.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.libs.sys.Entity.Record;
import com.libs.sys.Model.UserBookDetails;

@Service
public interface RecordService {
	
	public void addRecord(Record record);
	public Record updateRecord(Record record );
	public void deleteRecord(int id);
	public List<UserBookDetails> getUserDetails(int id);
	
	

}
