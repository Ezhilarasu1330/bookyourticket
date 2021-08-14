package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.service.IMovieService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController extends BaseController {

    private static final Logger applogger = LogManager.getLogger(MovieController.class);

    @Autowired
    private IMovieService movieService;

    @GetMapping("/list")
    public ResponseVO getMovieList() {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = this.movieService.getMovieList();
            super.success(responseVO, response, MessageConstants.MOVIE_LIST_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @GetMapping("/{id}")
    public ResponseVO getMovieInfo(@PathVariable Long id) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = this.movieService.getMovieInfo(id);
            super.success(responseVO, response, MessageConstants.MOVIE_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

}
