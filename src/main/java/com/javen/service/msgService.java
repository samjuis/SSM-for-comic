package com.javen.service;

import java.util.List;

import com.javen.model.message;

public interface msgService {
	public List<message> getMsg();
	public void addMsg(message Msg);
	public message getMessage(int position);
}
