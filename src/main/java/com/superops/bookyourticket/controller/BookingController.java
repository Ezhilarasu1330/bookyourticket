package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookingController extends BaseController {

    @PostMapping("/ticket")
    public ResponseVO getMovieList() {
        final ResponseVO responseVO = new ResponseVO();
        try {

        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }
}
