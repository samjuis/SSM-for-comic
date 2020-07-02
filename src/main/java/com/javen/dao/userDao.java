package com.javen.dao;

import org.apache.ibatis.annotations.Param;

import com.javen.model.User;

public interface userDao {
	public User getUser(@Param("username")String username,@Param("password")String password);
	public void addUser(User user);
	public void addIntegral(@Param("uid")int uid,@Param("ran")int ran,@Param("date")String date);
	public int getIntegral(@Param("uid")int uid,@Param("ran")int ran,@Param("date")String date);
	public void updateIntgral(@Param("uid")int uid,@Param("ran")int ran);
}
