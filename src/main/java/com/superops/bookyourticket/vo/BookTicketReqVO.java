package com.superops.bookyourticket.vo;

import java.util.List;

public class BookTicketReqVO {

    private int showId;
    private List<Integer> selectedSeat;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public List<Integer> getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(List<Integer> selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    @Override
    public String toString() {
        return "{\"BookTicketReqVO\":{"
                + "\"showId\":\"" + showId + "\""
                + ", \"selectedSeat\":" + selectedSeat
                + "}}";
    }
}
