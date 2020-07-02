package com.javen.model;

public class comics_chapter {
	private int id;
	private int comics_id;
	private String title;
	private int chapter;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getChapter() {
		return chapter;
	}
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComics_id() {
		return comics_id;
	}
	public void setComics_id(int comics_id) {
		this.comics_id = comics_id;
	}

}
