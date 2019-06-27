package com.libs.sys.Dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.libs.sys.Entity.Record;
import com.libs.sys.Model.UserBookDetails;


@Repository
public interface RecordDao {
	
	public Record updateRecord(Record record );
	public Record getRecordById(int id);

	public List<UserBookDetails> getUserDetails(int id);

	public void addRecord(int bookID, int id);
	public List<UserBookDetails> getBooksTobeReturned();
	public List<UserBookDetails> getBooksTobeIssued();
	public void acceptRequest(int buid);

	
	

}
