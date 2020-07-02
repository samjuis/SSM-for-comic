package com.javen.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.ibm.icu.text.SimpleDateFormat;
import com.javen.config.pathConfig;
import com.javen.model.comics;
import com.javen.model.comics_chapter;
import com.javen.model.message;
import com.javen.service.ComicService;
import com.javen.service.DBChaptersService;
import com.javen.service.comicChapterService;
import com.javen.service.msgService;

@Controller
public class uploadController {

	@Resource
	private ComicService comicService;
	@Resource
	private comicChapterService CCS;
	@Resource
	private DBChaptersService DBCS;
	@Resource
	private msgService MS;
	@Autowired
	private pathConfig pc;

	@RequestMapping("uploadComic")
	public void uploadComic(HttpServletRequest req, HttpServletResponse res, @RequestParam("file") MultipartFile[] file)
			throws IOException {
		if (req.getParameter("username") == null || req.getParameter("username").equals("")) {
			res.getWriter().println("ÇëÏÈµÇÂ¼");
		}
		comics comic = new comics();
		comic.setAuthor(req.getParameter("author"));
		comic.setTitle(req.getParameter("title"));
		comic.setDescribe(req.getParameter("describe"));
		comic.setUid(1);
		for (int i = 0; i < file.length; i++) {
			String filename = file[i].getOriginalFilename();
			File filepath = new File("D:/pic/", filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			try {
				file[i].transferTo(new File(pc.picURL + File.separator + filename));
			} catch (Exception e) {
				System.out.println(e);
			}
			comic.setCover("http://139.9.87.94/imgs/" + filename);
		}
		int theme = Integer.parseInt(req.getParameter("theme"));
		int audience = Integer.parseInt(req.getParameter("audience"));
		int nation = Integer.parseInt(req.getParameter("nation"));
		int finish = Integer.parseInt(req.getParameter("finish"));
		comicService.insertComic(comic);
		comicService.insertTypes(comic.getId(), theme, audience, nation, finish);
	}

	@RequestMapping("uploadComicChapters")
	public void uploadComicChapters(HttpServletRequest req, HttpServletResponse res,
			@RequestParam("file") MultipartFile[] file) throws IOException {
		if (req.getParameter("username") == null || req.getParameter("username").equals("")) {
			res.getWriter().println("ÇëÏÈµÇÂ¼");
		}
		comics_chapter cc = new comics_chapter();
		cc.setChapter(Integer.parseInt(req.getParameter("chapter")));
		cc.setComics_id(Integer.parseInt(req.getParameter("comic_id")));
		cc.setTitle(req.getParameter("title"));
		CCS.addChapter(cc);
		List<String> url = new ArrayList<>();
		for (int i = 0; i < file.length; i++) {
			String filename = file[i].getOriginalFilename();
			File filepath = new File(pc.picURL + cc.getComics_id() + "/" + cc.getChapter() + "/", filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			try {
				file[i].transferTo(new File(
						pc.picURL + cc.getComics_id() + "/" + cc.getChapter() + "/" + File.separator + filename));
			} catch (Exception e) {
				System.out.println(e);
			}
			url.add(("http://139.9.87.94/imgs/" + cc.getComics_id() + "/" + cc.getChapter() + "/" + filename));
		}
		DBCS.addComic(cc.getComics_id(), cc.getId(), url);
	}

	@RequestMapping("uploadFile")
	public void uploadFile(HttpServletRequest req, HttpServletResponse res, @RequestParam("file") MultipartFile file)
			throws IOException {
		res.setContentType("text/html;charset=UTF-8");

		String filename = file.getOriginalFilename();
		File filepath = new File(pc.msgPath + "demos/", filename);
		if (!filepath.getParentFile().exists()) {
			filepath.getParentFile().mkdirs();
		}
		try {
			file.transferTo(new File(pc.msgPath + "demos/" + File.separator + filename));
		} catch (Exception e) {
			System.out.println(e);
		}

		res.getWriter().print(JSON.toJSON(true));

	}

	@RequestMapping("uploadMessage")
	public void uoloadMessage(HttpServletRequest req, HttpServletResponse res, @RequestParam("file") MultipartFile file)
			throws IOException {
		res.setContentType("text/html;charset=UTF-8");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		message msg = new message();
		msg.setContext(req.getParameter("htmlbody"));
		System.out.println(req.getParameter("htmlbody"));
		if (msg.getContext().equals("")) {
			return;
		}
		msg.setDateTime(sdf.format(d));
		msg.setTitle(req.getParameter("title"));
		msg.setNikeName(req.getParameter("nikeName"));
		msg.setU_id(Integer.parseInt(req.getParameter("uid")));
		String filename = file.getOriginalFilename();
		File filepath = new File(pc.msgPath + "message/" + msg.getU_id() + "/", filename);
		if (!filepath.getParentFile().exists()) {
			filepath.getParentFile().mkdirs();
		}
		try {
			file.transferTo(new File(pc.msgPath + "message/" + msg.getU_id() + "/" + File.separator + filename));
		} catch (Exception e) {
			System.out.println(e);
		}
		msg.setImgurl("http://139.9.87.94/pic/message/" + msg.getU_id() + "/" + filename);
		MS.addMsg(msg);
		res.getWriter().print(JSON.toJSON(true));

	}
	@RequestMapping("testmap")
	public void testmap() {
		System.out.print(pc.msgPath);
	}
}
