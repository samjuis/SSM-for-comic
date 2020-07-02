package com.javen.model;

import java.io.Serializable;

public class types implements Serializable {
	private int id;
	private String theme;
	private String audience;
	private String nation;
	private String finish;
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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
}
