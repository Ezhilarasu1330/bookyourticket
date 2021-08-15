package com.superops.bookyourticket.vo;

import java.util.List;

public class ScreenInfoVO extends BaseVO{

    private long screenId;
    private String screenName;
    private int noOfSeats;
    private String status;
    List<ShowInfoVO> showInfo;

    public List<ShowInfoVO> getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(List<ShowInfoVO> showInfo) {
        this.showInfo = showInfo;
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
