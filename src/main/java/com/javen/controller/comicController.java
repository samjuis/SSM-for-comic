package com.javen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.javen.config.MD5Utils;
import com.javen.model.DBChapters;
import com.javen.model.comics;
import com.javen.service.ComicService;
import com.javen.service.DBChaptersService;
import com.javen.service.comicChapterService;
import com.javen.service.userService;

@Controller
public class comicController {

	@Resource
	private ComicService comicService;
	@Resource
	private comicChapterService comicChapterService;
	@Resource
	private userService UserService;
	@Resource
	private DBChaptersService DBCS;
	@RequestMapping("all/audience/{audience}/theme/{theme}/finish/{finish}/state/pink/nation/{nation}/search/time/page/{page}")
	public void category(HttpServletRequest req, HttpServletResponse res,
			@PathVariable(value = "audience") int audience, @PathVariable(value = "theme") int theme,
			@PathVariable(value = "finish") int finish, @PathVariable(value = "nation") int nation,
			@PathVariable(value = "page") int page) throws IOException {
		res.setContentType("text/html;charset=UTF-8");

		List<comics> comicss = comicService.getComic(theme, audience, finish, nation, page);
		for (comics c : comicss) {
			c.setChapters(comicChapterService.getChapter(c.getId()));
			c.setChapters_url(comicChapterService.getChapter_url(c.getId()));
		}
		System.out.println(JSON.toJSONString(comicss));
		res.getWriter().print(JSON.toJSONString(comicss));
	}

	@RequestMapping("comicInfo/id/{id}")
	public void Detail(HttpServletRequest req, HttpServletResponse res, @PathVariable(value = "id") int id)
			throws IOException {
		res.setContentType("text/html;charset=UTF-8");
		comics comic = comicService.getDetail(id);
		comic.setChapters(comicChapterService.getChapter(id));
		res.getWriter().print(JSON.toJSONString(comic));
	}

	@RequestMapping("chapters/{id}/{chapter}")
	public void test(HttpServletRequest req, HttpServletResponse res, @PathVariable(value = "id") int id,
			@PathVariable(value = "chapter") int chapter) throws IOException {
		res.setContentType("text/html;charset=UTF-8");
		System.out.println(id+"    "+chapter);
		List<String> str = new ArrayList<>();
		List<String> str1 = new ArrayList<>();
		if(chapter<1) {
			chapter=1;
		}
		str.add("");
		DBChapters db =DBCS.getDBChapter(id, chapter-1);
		System.out.println(JSON.toJSON(db));
		db.setChapters_path(str);
		db.setComiclist(DBCS.getDBChapters(db.getChapters()));
		System.out.println(JSON.toJSON(db));
		res.getWriter().print(JSON.toJSON(db));

	}
	@RequestMapping("search")
	public void search(HttpServletRequest req,HttpServletResponse res) {
		res.setContentType("test/html;charset=UTF-8");
		String keywords=req.getParameter("keywords");
	}
	@RequestMapping("getComic")
	public void getComic(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(username.equals("")||username==null) {
			res.getWriter().println("ÇëÏÈµÇÂ¼ÔÙ²Ù×÷");
			return;
		}
		List<comics> comic=new ArrayList<>();
		if(UserService.getUser(username,MD5Utils.md5(password)).getRoleID()==2) {
			comic=comicService.getComics();
		}else {
			comic=comicService.getComicss(username,MD5Utils.md5(password));
		}
		res.getWriter().println(JSON.toJSONString(comic));
		
	}
	@RequestMapping("collectComic")
	public void collectComic(HttpServletRequest req,HttpServletResponse res) {
		int uid=Integer.parseInt(req.getParameter("u_id"));
		int comicId=Integer.parseInt(req.getParameter("ComicId"));
		System.out.println(req.getParameter("isCollect").toString());
		String isCollect=req.getParameter("isCollect").toString();
		if(isCollect.equals("true"))
			comicService.addCollectComic(uid,comicId);
		else 
			comicService.delCollectComic(uid,comicId);
	}
	@RequestMapping("getCollectComic")
	public void getCollectComic(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("test/html;charset=UTF-8");
		List<comics> cs=new ArrayList<>();
		cs=comicService.getCollectComics(Integer.parseInt(req.getParameter("uid")));
		System.out.println(JSON.toJSONString(cs)+"1111111111111");
		res.getWriter().println(JSON.toJSONString(cs));
		
	}
	@RequestMapping("delCollectComic")
	public void delCollectComic(HttpServletRequest req) {
		int uid=Integer.parseInt(req.getParameter("u_id"));
		int comicId=Integer.parseInt(req.getParameter("ComicId"));
		comicService.delCollectComic(uid,comicId);
	}

}
