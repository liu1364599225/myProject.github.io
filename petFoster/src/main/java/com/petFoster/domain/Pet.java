package com.petFoster.domain;

public class Pet {
    private Long pId;

    private String pPetname;

    private String pSex;

    private String pType;

    private Long fuId;

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpPetname() {
        return pPetname;
    }

    public void setpPetname(String pPetname) {
        this.pPetname = pPetname == null ? null : pPetname.trim();
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex == null ? null : pSex.trim();
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType == null ? null : pType.trim();
    }

    public Long getFuId() {
        return fuId;
    }

    public void setFuId(Long fuId) {
        this.fuId = fuId;
    }

	@Override
	public String toString() {
		return "Pet [pId=" + pId + ", pPetname=" + pPetname + ", pSex=" + pSex
				+ ", pType=" + pType + ", fuId=" + fuId + "]";
	}
    
    
}