package com.baoyz.recyclerviewdemo;

import java.io.Serializable;

public class RecyclerViewItem implements Serializable {

	public static final int FIRST = 1;
	public static final int SECOND = 2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int type;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
