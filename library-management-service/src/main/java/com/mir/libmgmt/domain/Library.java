package com.mir.libmgmt.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class Library {

	@Id
	private int id;

	@Column(name = "DESC")
	private String desc;

	@Column(name = "ADDRESS")
	private String address;

	@OneToMany(mappedBy = "libraryId", cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<>();

	public Library() {

	}

	public Library(int id) {
		super();
		this.id = id;
	}

	public Library(int id, String desc, String address) {
		super();
		this.id = id;
		this.desc = desc;
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}