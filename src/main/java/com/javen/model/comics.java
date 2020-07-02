package com.javen.model;

import java.io.Serializable;
import java.util.List;

public class comics implements Serializable{
	private int id;
	private String title;
	private String cover;
	private String author;
	private String describe;
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	private List<String> chapters;
	private List<String> chapters_url;

	private static final long serivalVersionUID=1L;
	public static long getSerivalversionuid() {
		return serivalVersionUID;
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
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<String> getChapters() {
		return chapters;
	}
	public void setChapters(List<String> chapters) {
		this.chapters = chapters;
	}
	public List<String> getChapters_url() {
		return chapters_url;
	}
	public void setChapters_url(List<String> chapters_url) {
		this.chapters_url = chapters_url;
	}

	
}
