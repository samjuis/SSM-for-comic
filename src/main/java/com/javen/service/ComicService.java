package com.javen.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javen.model.comics;

public interface ComicService {
	public List<comics> getComic(int theme,int audience,int finish,int nation,int page);
	public comics getDetail(int id);
	public void insertComic(comics comic);
	public int insertTypes(int id,int theme,int audience,int nation,int finish);
	public List<comics> getComics();
	public List<comics> getComicss(String username,String password);
	public void addCollectComic(int uid,int comicId);
	public List<comics> getCollectComics(int uid);
	public void delCollectComic(@Param("uid")int uid,@Param("comicId")int comicId);
}
