package com.javen.service;

import java.util.List;

import com.javen.model.comics_chapter;

public interface comicChapterService {
	public List<String> getChapter(int id);

	public List<String> getChapter_url(int id);

	public void addChapter(comics_chapter c);
}
