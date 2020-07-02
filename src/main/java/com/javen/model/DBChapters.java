package com.javen.model;


import java.io.Serializable;
import java.util.List;

/**
 *
 */

public class DBChapters {

    protected Long id;
    //婕敾ID
    protected Long comic_id;
    //婕敾鏍囬
    protected String title;
    //绔犺妭鏍囬
    protected String chapters_title;
    //绔犺妭缂栧彿
    protected int chapters;
    //绔犺妭婕敾椤甸潰
    protected int num;
    //褰撳墠涓嬭浇鐨勬极鐢婚〉闈�
    protected int current_num;
    //寮�濮嬩笅杞芥椂闂�
    protected Long create_time;
    //鏈�鍚庢洿鏂版椂闂�
    protected Long update_time;
    /*state鐘舵�佹暟鎹簱淇濆瓨*/
    protected int stateInte;
   
    protected List<String> comiclist;
  
    protected List<String> chapters_path;

    public int getStateInte() {
        return this.stateInte;
    }
    public void setStateInte(int stateInte) {
        this.stateInte = stateInte;
    }
    public Long getUpdate_time() {
        return this.update_time;
    }
    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
    public Long getCreate_time() {
        return this.create_time;
    }
    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }
    public int getCurrent_num() {
        return this.current_num;
    }
    public void setCurrent_num(int current_num) {
        this.current_num = current_num;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getChapters() {
        return this.chapters;
    }
    public void setChapters(int chapters) {
        this.chapters = chapters;
    }
    public String getChapters_title() {
        return this.chapters_title;
    }
    public void setChapters_title(String chapters_title) {
        this.chapters_title = chapters_title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getComic_id() {
        return this.comic_id;
    }
    public void setComic_id(Long comic_id) {
        this.comic_id = comic_id;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public DBChapters(Long id, Long comic_id, String title, String chapters_title,
            int chapters, int num, int current_num, Long create_time,
            Long update_time, int stateInte, List<String> comiclist,
            List<String> chapters_path) {
        this.id = id;
        this.comic_id = comic_id;
        this.title = title;
        this.chapters_title = chapters_title;
        this.chapters = chapters;
        this.num = num;
        this.current_num = current_num;
        this.create_time = create_time;
        this.update_time = update_time;
        this.stateInte = stateInte;
        this.comiclist = comiclist;
        this.chapters_path = chapters_path;
    }

    public DBChapters() {
    }



    public DownState getState() {
        switch (getStateInte()){
            case 0:
                return DownState.START;
            case 1:
                return DownState.DOWN;
            case 2:
                return DownState.PAUSE;
            case 3:
                return DownState.STOP;
            case 4:
                return DownState.ERROR;
            case 5:
                return DownState.FINISH;
            case 6:
                return DownState.NONE;
            case -1:
                return DownState.DELETE;
            case -2:
                return DownState.CACHE;
            default:
                return DownState.FINISH;
        }
    }

    public void setState(DownState state) {
        setStateInte(state.getState());
    }
    public List<String> getChapters_path() {
        return this.chapters_path;
    }
    public void setChapters_path(List<String> chapters_path) {
        this.chapters_path = chapters_path;
    }
    public List<String> getComiclist() {
        return this.comiclist;
    }
    public void setComiclist(List<String> comiclist) {
        this.comiclist = comiclist;
    }

}

