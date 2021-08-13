package com.superops.bookyourticket.vo;

import java.util.List;

public class MovietListVO extends BaseVO {

    private List<MovieVO> movies;

    public List<MovieVO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieVO> movies) {
        this.movies = movies;
    }
}
