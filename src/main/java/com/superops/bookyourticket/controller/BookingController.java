package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.vo.BookTicketReqVO;
import com.superops.bookyourticket.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookingController extends BaseController {

    private static final Logger applogger = LogManager.getLogger(BookingController.class);
}
