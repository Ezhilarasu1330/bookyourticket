package com.superops.bookyourticket.vo;

import java.util.List;

public class TheatreListVO extends BaseVO {

    private List<TheatreVO> theatres;

    public List<TheatreVO> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<TheatreVO> theatres) {
        this.theatres = theatres;
    }
}
