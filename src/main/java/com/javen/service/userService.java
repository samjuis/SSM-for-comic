package com.javen.service;

import org.apache.ibatis.annotations.Param;

import com.javen.model.User;

public interface userService {
	public User getUser(String username,String password);
	public void addUser(User user);
	public void addIntegral(int uid,int ran,String date);
	public int getIntegral(int uid,int ran,String date);
	public void updateIntgral(int uid,int ran);
}