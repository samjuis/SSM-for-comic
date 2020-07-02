package com.javen.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javen.dao.userDao;
import com.javen.model.User;
import com.javen.service.userService;

@Service("userService")
@Transactional
public class userServiceImpl implements userService{
	@Resource
	private userDao UserDao;
	public User getUser(String username,String password) {
		return UserDao.getUser(username, password);
	}
	public void addUser(User user) {
		this. UserDao.addUser(user);
	}
	public void addIntegral(int uid,int ran,String date) {
		this.UserDao.addIntegral(uid, ran, date);
	}
	public int getIntegral(int uid,int ran,String date) {
		return UserDao.getIntegral(uid, ran, date);
	}
	public void updateIntgral(int uid,int ran) {
		this.UserDao.updateIntgral(uid, ran);
	}
}
