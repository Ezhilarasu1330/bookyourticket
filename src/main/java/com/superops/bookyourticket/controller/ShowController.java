package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.service.IShowInfoService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@CrossOrigin("*")
public class ShowController extends BaseController {

    @Autowired
    private IShowInfoService showInfoService;

    @GetMapping("/{showId}/seats")
    public ResponseVO getScreenSeatInfo(@PathVariable Long showId) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = showInfoService.getShowAndSeatsInfo(showId);
            super.success(responseVO, response, MessageConstants.SCREEN_SEAT_INFO_FETCHED_SUCCESS);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }
}
