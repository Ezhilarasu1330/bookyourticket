package com.superops.bookyourticket.vo;

import java.util.List;

public class TheatreVO extends BaseVO {

    private long theatreId;
    private String theatreName;
    private String theatreLoc;
    private String status;
    private String logoUrl;
    private List<ScreenInfoVO> screenInfoList;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<ScreenInfoVO> getScreenInfoList() {
        return screenInfoList;
    }

    public void setScreenInfoList(List<ScreenInfoVO> screenInfoList) {
        this.screenInfoList = screenInfoList;
    }

    public long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(long theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreLoc() {
        return theatreLoc;
    }

    public void setTheatreLoc(String theatreLoc) {
        this.theatreLoc = theatreLoc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
