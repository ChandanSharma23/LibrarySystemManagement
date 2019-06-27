package com.libs.sys.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookid")
	private int id;
	@Column(name="Name")
	private String name;
	
	@Column(name="Author")
	private String author;
	
	@Column(name="Publisher")
	private String publisher;
	
	
	@Column(name="No_of_Copies")
	private int copiesOwned;
	
	@Column(name="Issued_Copies")
	private int copiesIssued;

	public Book()
	{
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCopiesOwned() {
		return copiesOwned;
	}

	public void setCopiesOwned(int copiesOwned) {
		this.copiesOwned = copiesOwned;
	}

	public int getCopiesIssued() {
		return copiesIssued;
	}

	public void setCopiesIssued(int copiesIssued) {
		this.copiesIssued = copiesIssued;
	}

	public Book(int id, String name, String author, String publisher, int copiesOwned, int copiesIssued) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.copiesOwned = copiesOwned;
		this.copiesIssued = copiesIssued;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", copiesOwned=" + copiesOwned + ", copiesIssued=" + copiesIssued + "]";
	}
	
	
	

	
}
