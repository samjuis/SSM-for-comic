package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javen.model.comics_chapter;

public interface comicChapterDao {
	public List<String> getChapter(@Param("id") int id);

	public List<String> getChapter_url(@Param("id") int id);

	public void addChapter(comics_chapter c);
}
