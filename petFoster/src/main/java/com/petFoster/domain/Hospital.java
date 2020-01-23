package com.petFoster.domain;

public class Hospital {
    private Long hId;

    private String hHospitalname;

    private String hContactway;

    private String hAddress;

    private String hBusinesshours;

    private String hHospitalphoto;

    private String hServiceintroduction;

    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
        this.hId = hId;
    }

    public String gethHospitalname() {
        return hHospitalname;
    }

    public void sethHospitalname(String hHospitalname) {
        this.hHospitalname = hHospitalname == null ? null : hHospitalname.trim();
    }

    public String gethContactway() {
        return hContactway;
    }

    public void sethContactway(String hContactway) {
        this.hContactway = hContactway == null ? null : hContactway.trim();
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress == null ? null : hAddress.trim();
    }

    public String gethBusinesshours() {
        return hBusinesshours;
    }

    public void sethBusinesshours(String hBusinesshours) {
        this.hBusinesshours = hBusinesshours == null ? null : hBusinesshours.trim();
    }

    public String gethHospitalphoto() {
        return hHospitalphoto;
    }

    public void sethHospitalphoto(String hHospitalphoto) {
        this.hHospitalphoto = hHospitalphoto == null ? null : hHospitalphoto.trim();
    }

    public String gethServiceintroduction() {
        return hServiceintroduction;
    }

    public void sethServiceintroduction(String hServiceintroduction) {
        this.hServiceintroduction = hServiceintroduction == null ? null : hServiceintroduction.trim();
    }
}