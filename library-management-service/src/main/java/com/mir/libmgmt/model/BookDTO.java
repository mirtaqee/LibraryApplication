package com.mir.libmgmt.model;

import java.io.Serializable;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String author;
	private String publisher;

	public BookDTO(int id, String title, String author, String publisher) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public BookDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
