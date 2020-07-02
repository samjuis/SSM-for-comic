package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.javen.model.message;

public interface msgDao {
	public List<message> getMsg();

	public void addMsg(message Msg);


	public message getMessage(@Param("position") int position);
}
