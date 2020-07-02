package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.javen.model.comics;

public interface ComicDao {
	public List<comics> getComic(@Param("theme")int theme,@Param("audience")int audience,@Param("finish")int finish,@Param("nation")int nation,@Param("page")int page);
	public comics getDetail(@Param("id")int id);
	public void insertComic(comics comic) ;

	public int insertTypes(@Param("id")int id,@Param("theme")int theme,@Param("audience")int audience,@Param("nation")int nation,@Param("finish")int finish);
	@Select("select id,comics_name from comics")
	public List<comics> getComics();
	@Select("select comics.id as id,comics_name as title from comics inner join user on user.id=comics.u_id where username=#{username} and password=#{password}")
	public List<comics> getComicss(@Param("username")String username,@Param("password")String password);
	public void addCollectComic(@Param("uid")int uid,@Param("comicId")int comicId);
	public void delCollectComic(@Param("uid")int uid,@Param("comicId")int comicId);
	public List<comics> getCollectComics(@Param("uid")int uid);
}
