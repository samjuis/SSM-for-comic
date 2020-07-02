package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javen.dao.msgDao;
import com.javen.model.message;
import com.javen.service.msgService;


@Service("msgService")
@Transactional
public class msgServiceImpl implements msgService {
	@Resource
	private msgDao MsgDao;
	public List<message> getMsg(){
		return MsgDao.getMsg();
	}
	public void addMsg(message Msg) {
		this.MsgDao.addMsg(Msg);
	}
	public message getMessage(int position) {
		return MsgDao.getMessage(position);
	}
}
