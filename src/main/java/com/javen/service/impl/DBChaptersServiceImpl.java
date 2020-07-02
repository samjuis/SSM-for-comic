package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javen.dao.DBChaptersDao;
import com.javen.model.DBChapters;
import com.javen.service.DBChaptersService;
@Service("DBChapterService")
@Transactional
public class DBChaptersServiceImpl implements DBChaptersService{
	@Resource
	private DBChaptersDao DBCD;
	public DBChapters getDBChapter(int id,int chapters) {
		return DBCD.getDBChapter(id, chapters);
	}
	public List<String> getDBChapters(int id) {
		return DBCD.getDBChapters(id);
	}
	public void addComic(int comics_id,int chapter_id,List<String> cover) {
		this.DBCD.addComic(comics_id,chapter_id, cover);
	}
}
