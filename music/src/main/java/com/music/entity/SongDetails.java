package com.music.entity;

public class SongDetails {
	private Integer songId;

    private String songName;

    private String songSongfile;

    private String songWordsfile;

    private Integer songState;

    private String songPricture;

    private Integer songVip;
    
    private String singerName;
    
    private String songtypeName;
    
    private Integer mvID;
    
    private String specialName;

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
		this.songName = songName;
	}

	public String getSongSongfile() {
		return songSongfile;
	}

	public void setSongSongfile(String songSongfile) {
		this.songSongfile = songSongfile;
	}

	public String getSongWordsfile() {
		return songWordsfile;
	}

	public void setSongWordsfile(String songWordsfile) {
		this.songWordsfile = songWordsfile;
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
		this.songPricture = songPricture;
	}

	public Integer getSongVip() {
		return songVip;
	}

	public void setSongVip(Integer songVip) {
		this.songVip = songVip;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getSongtypeName() {
		return songtypeName;
	}

	public void setSongtypeName(String songtypeName) {
		this.songtypeName = songtypeName;
	}

	public Integer getMvID() {
		return mvID;
	}

	public void setMvID(Integer mvID) {
		this.mvID = mvID;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	@Override
	public String toString() {
		return "SongDetails [songId=" + songId + ", songName=" + songName
				+ ", songSongfile=" + songSongfile + ", songWordsfile="
				+ songWordsfile + ", songState=" + songState
				+ ", songPricture=" + songPricture + ", songVip=" + songVip
				+ ", singerName=" + singerName + ", songtypeName="
				+ songtypeName + ", mvID=" + mvID + ", specialName="
				+ specialName + "]";
	}
    
    
    
}
