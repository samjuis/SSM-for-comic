package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javen.dao.comicChapterDao;
import com.javen.model.comics_chapter;
import com.javen.service.comicChapterService;

@Service("comicChapterService")
@Transactional
public class comicChapterServiceImpl implements comicChapterService {
	@Resource
	private comicChapterDao CCD;

	public List<String> getChapter(int id) {
		return CCD.getChapter(id);
	}

	public List<String> getChapter_url(int id) {
		return CCD.getChapter_url(id);
	}

	public void addChapter(comics_chapter c) {
		this.CCD.addChapter(c);
	}
}
