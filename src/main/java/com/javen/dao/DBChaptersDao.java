package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javen.model.DBChapters;

public interface DBChaptersDao {
	public DBChapters getDBChapter(@Param("id")int id,@Param("chapters")int chapters) ;
	public List<String>getDBChapters(@Param("id")int id);
	public void addComic(@Param("comics_id")int comics_id,@Param("comics_chapter_id")int chapter_id,@Param("covers")List<String> cover);
}
