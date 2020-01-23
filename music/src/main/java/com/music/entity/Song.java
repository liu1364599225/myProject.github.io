package com.music.entity;

public class Song {
    private Integer songId;

    private String songName;

    private String songSongfile;

    private String songWordsfile;

    private Integer songState;

    private String songPricture;

    private Integer songVip;

    private Integer singerId;

    private Integer songtypeId;

    private Integer mvId;

    private Integer specialId;

    private String songRsrv1;

    private String songRsrv2;

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

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public Integer getSongtypeId() {
        return songtypeId;
    }

    public void setSongtypeId(Integer songtypeId) {
        this.songtypeId = songtypeId;
    }

    public Integer getMvId() {
        return mvId;
    }

    public void setMvId(Integer mvId) {
        this.mvId = mvId;
    }

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
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
}