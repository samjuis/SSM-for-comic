package com.javen.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ibm.icu.text.SimpleDateFormat;
import com.javen.config.MD5Utils;
import com.javen.model.User;
import com.javen.service.userService;

@Controller
public class userController {
	
	@Resource
	private userService UserService;
	
    
	
	
	
	@RequestMapping("login")
	public void login(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("test/html;charset=UTF-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=UserService.getUser(username,MD5Utils.md5(password));
		Map map=new HashMap<>();
		if(user!=null||user.getId()!=0) {
			map.put("nikeName",user.getNikeName());
			map.put("u_id",user.getId());
			map.put("isNot",true);
			map.put("integral",user.getIntegral());
			res.getWriter().print(JSON.toJSONString(map));
		}else {
			map.put("isNot", false);
			res.getWriter().print(JSON.toJSONString(map));
		}
	}
	@RequestMapping("register")
	public void register(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("test/html;charset=UTF-8");
		User user=new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(MD5Utils.md5(req.getParameter("password")));
		user.setGender(Integer.parseInt(req.getParameter("gender")));
		user.setNikeName(req.getParameter("nikeName"));
		System.out.println(user.getUsername()+user.getPassword()+user.getGender()+user.getNikeName());
		user.setIntegral(0);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setRetime(sdf.format(d));
		UserService.addUser(user);
		if(user.getId()!=0) {
			Map map=new HashMap<>();
			map.put("u_id",user.getId());
			map.put("isNot",true);
			map.put("integral",user.getIntegral());
			res.getWriter().print(JSON.toJSONString(map));
		}
	}
	@RequestMapping("qiandao")
	public void qiandao(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("test/html;charset=UTF-8");
		int uid=Integer.parseInt(req.getParameter("uid"));
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Random r = new Random(1);
		int ran1 = r.nextInt(10);
		if(UserService.getIntegral(uid, ran1, sdf.format(d))==1) {
			return;
		}else {
			UserService.addIntegral(uid,ran1,sdf.format(d));
			UserService.updateIntgral(uid,ran1);
		}
		res.getWriter().print(ran1);
	}
}
