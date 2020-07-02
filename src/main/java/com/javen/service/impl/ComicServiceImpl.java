package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.javen.dao.ComicDao;
import com.javen.model.comics;
import com.javen.service.ComicService;

@Service("ComicService")
@Transactional
public class ComicServiceImpl implements ComicService {
	@Resource
	private ComicDao comicDao;
	
	public List<comics> getComic(int theme,int audience,int finish,int nation,int page){
		return comicDao.getComic(theme, audience, finish, nation, page);
	}
	public comics getDetail(int id) {
		return comicDao.getDetail(id);
	}
	public void insertComic(comics comic) {
		this. comicDao.insertComic(comic);
	}
	public int insertTypes(int id,int theme,int audience,int nation,int finish) {
		return comicDao.insertTypes(id, theme, audience, nation, finish);
	}
	public List<comics> getComics(){
		return comicDao.getComics();
	}
	public List<comics> getComicss(String username,String password){
		return comicDao.getComicss(username, password);
	}
	public void addCollectComic(int uid,int comicId) {
		this. comicDao.addCollectComic(uid, comicId);
	}
	public List<comics> getCollectComics(int uid){
		return comicDao.getCollectComics(uid);
	}
	public void delCollectComic(@Param("uid")int uid,@Param("comicId")int comicId) {
		this.comicDao.delCollectComic(uid, comicId);
	}
}
