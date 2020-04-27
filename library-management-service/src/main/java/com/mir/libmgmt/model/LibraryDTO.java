package com.mir.libmgmt.model;

public class LibraryDTO {

	private int id;
	private String desc;
	private String address;

	public LibraryDTO() {
	}

	public LibraryDTO(int id, String desc, String address) {
		this.id = id;
		this.desc = desc;
		this.address = address;
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