package com.libs.sys.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Record {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BUID")
	private int id;
	@Column(name="BID")
	private int bid;
	
	@Column(name="UID")
	private int uid;
	
	@Column(name="Date_Of_Issue")
	private Date issueDate;
	
	
	@Column(name="Date_Of_Return")
	private Date returnDate;
	
	@Column(name="Approved")
	private String Approved;
	
	

	@Column(name="Return_request")
	private String returnRequest;
	
	

	@Column(name="Return_approved")
	private String returnApproved;
	
	
	public String getReturnRequest() {
		return returnRequest;
	}

	public void setReturnRequest(String returnRequest) {
		this.returnRequest = returnRequest;
	}

	public String getReturnApproved() {
		return returnApproved;
	}

	public void setReturnApproved(String returnApproved) {
		this.returnApproved = returnApproved;
	}

	public Record()
	{}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getApproved() {
		return Approved;
	}

	public void setApproved(String approved) {
		Approved = approved;
	}

	public Record(int id, int bid, int uid, Date issueDate, Date returnDate, String approved, String returnRequest,
			String returnApproved) {
		super();
		this.id = id;
		this.bid = bid;
		this.uid = uid;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		Approved = approved;
		this.returnRequest = returnRequest;
		this.returnApproved = returnApproved;
	}
   @JsonIgnore
	@Override
	public String toString() {
		return "Record [id=" + id + ", bid=" + bid + ", uid=" + uid + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", Approved=" + Approved + ", returnRequest=" + returnRequest + ", returnApproved="
				+ returnApproved + "]";
	}

	

}
