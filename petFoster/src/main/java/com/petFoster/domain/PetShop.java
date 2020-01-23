package com.petFoster.domain;

public class PetShop {
    private Long psId;

    private String psAccountname;

    private String psPassword;

    private String psPetshopname;

    private String psContactway;

    private String psAddress;

    private String psPetshopphoto;

    private String psRequeststatus;

    private String psTyperange;

    private String psFeedbackinformation;

    public Long getPsId() {
        return psId;
    }

    public void setPsId(Long psId) {
        this.psId = psId;
    }

    public String getPsAccountname() {
        return psAccountname;
    }

    public void setPsAccountname(String psAccountname) {
        this.psAccountname = psAccountname == null ? null : psAccountname.trim();
    }

    public String getPsPassword() {
        return psPassword;
    }

    public void setPsPassword(String psPassword) {
        this.psPassword = psPassword == null ? null : psPassword.trim();
    }

    public String getPsPetshopname() {
        return psPetshopname;
    }

    public void setPsPetshopname(String psPetshopname) {
        this.psPetshopname = psPetshopname == null ? null : psPetshopname.trim();
    }

    public String getPsContactway() {
        return psContactway;
    }

    public void setPsContactway(String psContactway) {
        this.psContactway = psContactway == null ? null : psContactway.trim();
    }

    public String getPsAddress() {
        return psAddress;
    }

    public void setPsAddress(String psAddress) {
        this.psAddress = psAddress == null ? null : psAddress.trim();
    }

    public String getPsPetshopphoto() {
        return psPetshopphoto;
    }

    public void setPsPetshopphoto(String psPetshopphoto) {
        this.psPetshopphoto = psPetshopphoto == null ? null : psPetshopphoto.trim();
    }

    public String getPsRequeststatus() {
        return psRequeststatus;
    }

    public void setPsRequeststatus(String psRequeststatus) {
        this.psRequeststatus = psRequeststatus == null ? null : psRequeststatus.trim();
    }

    public String getPsTyperange() {
        return psTyperange;
    }

    public void setPsTyperange(String psTyperange) {
        this.psTyperange = psTyperange == null ? null : psTyperange.trim();
    }

    public String getPsFeedbackinformation() {
        return psFeedbackinformation;
    }

    public void setPsFeedbackinformation(String psFeedbackinformation) {
        this.psFeedbackinformation = psFeedbackinformation == null ? null : psFeedbackinformation.trim();
    }
}