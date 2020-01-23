package com.music.entity;

import java.util.List;

public class SonglistAndSong {

	private Integer songlistId;

    private String songlistName;

    private String songlistPriture;

    private Integer userId;

    private String songlistRsrv1;

    private String songlistRsrv2;

    private String songlistSketch;

    private List<SongAndSinger> songList;
    
    
    
    
    public List<SongAndSinger> getSongList() {
		return songList;
	}

	public void setSongList(List<SongAndSinger> songList) {
		this.songList = songList;
	}

	public Integer getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Integer songlistId) {
        this.songlistId = songlistId;
    }

    public String getSonglistName() {
        return songlistName;
    }

    public void setSonglistName(String songlistName) {
        this.songlistName = songlistName == null ? null : songlistName.trim();
    }

    public String getSonglistPriture() {
        return songlistPriture;
    }

    public void setSonglistPriture(String songlistPriture) {
        this.songlistPriture = songlistPriture == null ? null : songlistPriture.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSonglistRsrv1() {
        return songlistRsrv1;
    }

    public void setSonglistRsrv1(String songlistRsrv1) {
        this.songlistRsrv1 = songlistRsrv1 == null ? null : songlistRsrv1.trim();
    }

    public String getSonglistRsrv2() {
        return songlistRsrv2;
    }

    public void setSonglistRsrv2(String songlistRsrv2) {
        this.songlistRsrv2 = songlistRsrv2 == null ? null : songlistRsrv2.trim();
    }

    public String getSonglistSketch() {
        return songlistSketch;
    }

    public void setSonglistSketch(String songlistSketch) {
        this.songlistSketch = songlistSketch == null ? null : songlistSketch.trim();
    }
	
}
