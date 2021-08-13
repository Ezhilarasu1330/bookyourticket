package com.superops.bookyourticket.service.impl;

import com.superops.bookyourticket.converter.IMovieInfoConverter;
import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.MovieInfo;
import com.superops.bookyourticket.repository.MovieInfoRepository;
import com.superops.bookyourticket.service.IMovieService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.MovieVO;
import com.superops.bookyourticket.vo.MovietListVO;
import com.superops.bookyourticket.vo.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieInfoRepository movieInfoRepo;

    @Autowired
    private IMovieInfoConverter movieInfoConverter;

    public BaseVO getMovieList() throws ApplicationError {
        final MovietListVO movieListVO = new MovietListVO();
        List<MovieInfo> movieList = movieInfoRepo.findAll();
        movieInfoConverter.convertToMovieListVO(movieList, movieListVO);
        return movieListVO;
    }

    public BaseVO getMovieInfo(Long id) throws ApplicationError {
        MovieInfo movieInfo = movieInfoRepo.getById(id);
        final MovieVO movieVO = new MovieVO();
        movieInfoConverter.convertToMovieVO(movieInfo, movieVO);
        return movieVO;
    }

}
