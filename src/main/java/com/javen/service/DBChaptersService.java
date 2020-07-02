package com.javen.service;

import java.util.List;

import com.javen.model.DBChapters;

public interface DBChaptersService {
	public DBChapters getDBChapter(int id,int chapters);
	public List<String> getDBChapters(int id);
	public void addComic(int comics_id,int chapter_id,List<String> cover);
}
