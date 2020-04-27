package com.mir.libmgmt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "LIBRARY_ID")
	private Library libraryId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "PUBLISHER")
	private String publisher;

	public Book(int id, Library libraryId, String title, String author, String publisher) {
		super();
		this.id = id;
		this.libraryId = libraryId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Library getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Library libraryId) {
		this.libraryId = libraryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
