package com.music.entity;

public class SongAndSinger {
	private Integer songId;

    private String songName;

    private String songSongfile;

    private String songWordsfile;

    private Integer songState;

    private String songPricture;

    private Integer songVip;

    private Singer singer;

    private String songRsrv1;

    private String songRsrv2;
    
    
    public SongAndSinger(){
    	
    }
    
    

    public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    public String getSongSongfile() {
        return songSongfile;
    }

    public void setSongSongfile(String songSongfile) {
        this.songSongfile = songSongfile == null ? null : songSongfile.trim();
    }

    public String getSongWordsfile() {
        return songWordsfile;
    }

    public void setSongWordsfile(String songWordsfile) {
        this.songWordsfile = songWordsfile == null ? null : songWordsfile.trim();
    }

    public Integer getSongState() {
        return songState;
    }

    public void setSongState(Integer songState) {
        this.songState = songState;
    }

    public String getSongPricture() {
        return songPricture;
    }

    public void setSongPricture(String songPricture) {
        this.songPricture = songPricture == null ? null : songPricture.trim();
    }

    public Integer getSongVip() {
        return songVip;
    }

    public void setSongVip(Integer songVip) {
        this.songVip = songVip;
    }


    public String getSongRsrv1() {
        return songRsrv1;
    }

    public void setSongRsrv1(String songRsrv1) {
        this.songRsrv1 = songRsrv1 == null ? null : songRsrv1.trim();
    }

    public String getSongRsrv2() {
        return songRsrv2;
    }

    public void setSongRsrv2(String songRsrv2) {
        this.songRsrv2 = songRsrv2 == null ? null : songRsrv2.trim();
    }



	@Override
	public String toString() {
		return "SongAndSinger [songId=" + songId + ", songName=" + songName
				+ ", songSongfile=" + songSongfile + ", songWordsfile="
				+ songWordsfile + ", songState=" + songState
				+ ", songPricture=" + songPricture + ", songVip=" + songVip
				+ ", singer=" + singer + ", songRsrv1=" + songRsrv1
				+ ", songRsrv2=" + songRsrv2 + "]";
	}
    
    
}
