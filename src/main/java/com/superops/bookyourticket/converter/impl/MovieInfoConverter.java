package com.superops.bookyourticket.converter.impl;

import com.superops.bookyourticket.converter.IMovieInfoConverter;
import com.superops.bookyourticket.model.MovieInfo;
import com.superops.bookyourticket.vo.MovieVO;
import com.superops.bookyourticket.vo.MovietListVO;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MovieInfoConverter implements IMovieInfoConverter {

    @Override
    public void convertToMovieListVO(final List<MovieInfo> data, final MovietListVO empty) {
        final List<MovieVO> movieVOs = new LinkedList<>();
        data.forEach(movieDetail -> {
            final MovieVO movieVO = new MovieVO();

            movieVO.setMovieId(movieDetail.getMovieId());
            movieVO.setMovieName(movieDetail.getMovieName());
            movieVO.setReleasedDate(movieDetail.getReleasedDate());
            movieVO.setLanguage(movieDetail.getLanguage());
            movieVO.setStatus(movieDetail.getStatus());
            movieVOs.add(movieVO);
        });
        empty.setMovies(movieVOs);
    }

    @Override
    public void convertToMovieVO(MovieInfo movieInfo, MovieVO empty) {
        empty.setMovieId(movieInfo.getMovieId());
        empty.setMovieName(movieInfo.getMovieName());
        empty.setReleasedDate(movieInfo.getReleasedDate());
        empty.setLanguage(movieInfo.getLanguage());
        empty.setStatus(movieInfo.getStatus());
    }
}
