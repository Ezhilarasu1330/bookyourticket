package com.superops.bookyourticket.service;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.BookTicketReqVO;

public interface IBookingService {

    BaseVO bookSeats(final BookTicketReqVO bookTicketReqVO, long userId) throws ApplicationError;
}
