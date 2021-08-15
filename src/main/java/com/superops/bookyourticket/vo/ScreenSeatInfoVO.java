package com.superops.bookyourticket.vo;

public class ScreenSeatInfoVO extends BaseVO{

    private long screenId;
    private long screenSeatId;
    private String seatNumber;
    private boolean isBooked;
    private String status;

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getScreenSeatId() {
        return screenSeatId;
    }

    public void setScreenSeatId(long screenSeatId) {
        this.screenSeatId = screenSeatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
