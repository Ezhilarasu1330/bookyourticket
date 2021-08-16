package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.service.IBookingService;
import com.superops.bookyourticket.service.IShowInfoService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.BookTicketReqVO;
import com.superops.bookyourticket.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@CrossOrigin("*")
public class ShowController extends BaseController {

    private static final Logger applogger = LogManager.getLogger(ShowController.class);

    //UserId will be set in jwtUtil validateToken method while request pass through the JWT Filter
    public static long userId;

    @Autowired
    private IShowInfoService showInfoService;

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/{showId}/seats")
    public ResponseVO getScreenSeatInfo(@PathVariable Long showId) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = showInfoService.getShowAndSeatsInfo(showId);
            super.success(responseVO, response, MessageConstants.SCREEN_SEAT_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.utilityErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @PostMapping("/{showId}/book")
    public ResponseVO getScreenSeatInfo(@RequestBody BookTicketReqVO bookTicketReqVO) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = bookingService.bookSeats(bookTicketReqVO, userId);
            super.success(responseVO, response, MessageConstants.SUCCESS);
        } catch (final Exception e) {
            super.utilityErrorHandler(responseVO, e);
        }
        return responseVO;
    }
}
