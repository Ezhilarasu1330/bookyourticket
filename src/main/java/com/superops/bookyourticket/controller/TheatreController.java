package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.service.IShowInfoService;
import com.superops.bookyourticket.service.ITheatreService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
@CrossOrigin("*")
public class TheatreController extends BaseController {

    private static final Logger applogger = LogManager.getLogger(TheatreController.class);

    @Autowired
    private ITheatreService theatreService;

    @GetMapping("/list")
    public ResponseVO getTheatreList() {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = theatreService.getTheatreList();
            super.success(responseVO, response, MessageConstants.THEATRE_LIST_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @GetMapping("/{id}")
    public ResponseVO getTheatreInfo(@PathVariable Long id) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = theatreService.getTheatreInfo(id);
            super.success(responseVO, response, MessageConstants.THEATRE_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @GetMapping("/{id}/screeninfo")
    public ResponseVO getTheatreInfoAndScreenInfo(@PathVariable Long id) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = theatreService.getTheatreAndScreenInfo(id);
            super.success(responseVO, response, MessageConstants.THEATRE_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @GetMapping("/{id}/shows")
    public ResponseVO getTheatreInfoAndShows(@PathVariable Long id) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = theatreService.getTheatreAndShowsInfo(id);
            super.success(responseVO, response, MessageConstants.THEATRE_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @GetMapping("/{theatreId}/shows/{showId}/seats")
    public ResponseVO getAvailableSeats(@PathVariable Long theatreId, @PathVariable Long showId) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = theatreService.getTheatreAndShowsInfo(theatreId);
            super.success(responseVO, response, MessageConstants.THEATRE_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }
}
