package com.superops.bookyourticket.converter;

import com.superops.bookyourticket.model.MovieInfo;
import com.superops.bookyourticket.vo.MovieVO;
import com.superops.bookyourticket.vo.MovietListVO;

import java.util.List;

public interface IMovieInfoConverter {

    void convertToMovieListVO(final List<MovieInfo> data, final MovietListVO empty);

    void convertToMovieVO(final MovieInfo movieInfo, final MovieVO empty);
}
