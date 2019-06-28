package com.libs.sys.Service;

import java.util.Date;
import java.util.List;

import com.libs.sys.Dao.BookDao;
import com.libs.sys.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.libs.sys.Dao.RecordDao;
import com.libs.sys.Entity.Record;
import com.libs.sys.Model.UserBookDetails;

@Service
public class RecordServiceImpl implements RecordService {
	
	@Autowired
	@Qualifier("recordDaoImpl")
	RecordDao recordDao;

    @Autowired
    @Qualifier("bookDaoImpl")
    BookDao bookDao;
	


	@Override
	public Record updateRecord(Record record) {
		// TODO Auto-generated method stub
		return recordDao.updateRecord(record);
	}

	@Override
	public void updateRecord(int id) {
		// TODO Auto-generated method stub
           Record record =  recordDao.getRecordById(id);
           record.setReturnRequest("return initiated");
           recordDao.updateRecord(record);
           System.out.println(recordDao.getRecordById(id));
	}

	@Override

	public List<UserBookDetails> getUserDetails(int id) {
		return recordDao.getUserDetails(id);
	}

	public void addRecord(int bookID, int id) {
		// TODO Auto-generated method stub
		recordDao.addRecord(bookID,id);
		
		
	}

	@Override
	public List<UserBookDetails> getBooksTobeReturned() {
		// TODO Auto-generated method stub
		return recordDao.getBooksTobeReturned();
	}

	@Override
	public List<UserBookDetails> getBookstoBeIssued() {
		// TODO Auto-generated method stub
		return recordDao.getBooksTobeIssued();

	}

	@Override
	public void acceptRequest(int buid) {
		// TODO Auto-generated method stub
		recordDao.acceptRequest(buid);
		
		
	}

    @Override
    public void acceptReturnRequest(int buid) {
	    Record rec = recordDao.getRecordById(buid);
	    rec.setReturnDate(new Date());
        rec.setReturnRequest("completed");
        recordDao.updateRecord(rec);
        Book book =bookDao.getBookById(rec.getId());
        book.setCopiesIssued(book.getCopiesIssued()-1);
        bookDao.updateBook(book);
    }

}
