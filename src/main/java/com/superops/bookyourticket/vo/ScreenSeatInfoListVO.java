package com.superops.bookyourticket.vo;

import java.util.Date;
import java.util.List;

public class ScreenSeatInfoListVO extends BaseVO{

    private String theatreName;
    private String movieName;
    private Date showStartTime;
    private List<ScreenSeatInfoVO> screenSeatInfo;

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(Date showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<ScreenSeatInfoVO> getScreenSeatInfo() {
        return screenSeatInfo;
    }

    public void setScreenSeatInfo(List<ScreenSeatInfoVO> screenSeatInfo) {
        this.screenSeatInfo = screenSeatInfo;
    }
}
