package com.javen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.javen.model.message;
import com.javen.model.types;
import com.javen.service.msgService;
import com.javen.service.typesService;

@Controller
public class messageController {
	@Resource
    private msgService MsgService;
	
	@Resource
	private typesService TypeService;
	@RequestMapping("msg")
	public void msg(HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=UTF-8");

		List<message> msgList=MsgService.getMsg();

		for(message msg:msgList) {

			System.out.println(msg.getContext()+msg.getDateTime()+msg.getNikeName()+JSON.toJSONString(msgList));
		}
		res.getWriter().print(JSON.toJSONString(msgList));
	}
	@RequestMapping("uploadMsg")
	public void uploadMsg(HttpServletRequest req,HttpServletResponse res) {
		
	}
	@RequestMapping("getTypes")
	public void getTypes(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=UTF-8");
		List<types> T=new ArrayList<>();
		T=TypeService.getTypes();
		res.getWriter().println(JSON.toJSONString(T));
	}
	@RequestMapping("getMsg")
	public void getMsg(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=UTF-8");
		message msg=MsgService.getMessage(Integer.parseInt(req.getParameter("position")));
		res.getWriter().println(JSON.toJSONString(msg));
	}
}
