package com.libs.sys.Model;

import java.util.Date;

public class UserBookDetails {
	int BUId;
	int UID;
	int BID;
	String userName;
	int RollNumber;
	String BookName;
	String Author;
	String Publisher;
	Date DateIssued;
	Date DateReturned;
	String Approved;
	String ReturnRequest;
	
	 public UserBookDetails(){
		 
	 }

	public int getBUId() {
		return BUId;
	}

	public void setBUId(int bUId) {
		BUId = bUId;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRollNumber() {
		return RollNumber;
	}

	public void setRollNumber(int rollNumber) {
		RollNumber = rollNumber;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public Date getDateIssued() {
		return DateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		DateIssued = dateIssued;
	}

	public Date getDateReturned() {
		return DateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		DateReturned = dateReturned;
	}

	public String getApproved() {
		return Approved;
	}

	public void setApproved(String approved) {
		Approved = approved;
	}

    public String getReturnRequest() {
        return ReturnRequest;
    }

    public void setReturnRequest(String returnRequest) {
        ReturnRequest = returnRequest;
    }
}
