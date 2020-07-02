package com.javen.model;

import java.io.Serializable;

public class User  implements Serializable{
	
	private int id;
	private int roleID;
	private String country;
	private String city;
	private String province;
	private int gender;
	private String password;
	private String username;
	private String nikeName;
	private int integral;
	private String img;
	private String retime;


	public String getRetime() {
		return retime;
	}
	public void setRetime(String retime) {
		this.retime = retime;
	}

	private static final long serivalVersionUID=1L;
	public static long getSerivalversionuid() {
		return serivalVersionUID;
	}
	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}




	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}



    
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public User() {
    	
    }

	@Override
	public String toString() {
		return "User [username=, password=]";
	}
    
    
}