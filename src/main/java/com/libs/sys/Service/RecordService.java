package com.libs.sys.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.libs.sys.Entity.Record;
import com.libs.sys.Model.UserBookDetails;

@Service
public interface RecordService {
	
	
	public Record updateRecord(Record record );
	public void updateRecord(int id);

	public List<UserBookDetails> getUserDetails(int id);

	public void addRecord(int bookID, int id);
	public List<UserBookDetails> getBooksTobeReturned();
	public List<UserBookDetails> getBookstoBeIssued();
	public void acceptRequest(int buid);
	

	
	

}
