package com.superops.bookyourticket.service.impl;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.*;
import com.superops.bookyourticket.repository.*;
import com.superops.bookyourticket.service.IBookingService;
import com.superops.bookyourticket.service.IScreenSeatService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.BookTicketReqVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    private static final Logger applogger = LogManager.getLogger(BookingService.class);

    @Autowired
    private ShowInfoRepository showInfoRepo;

    @Autowired
    private BookedSeatInfoRepository bookedSeatInfoRepo;

    @Autowired
    private ScreenSeatInfoRepository screenSeatInfoRepo;

    @Autowired
    private UserInfoRepository userInfoRepo;

    @Autowired
    private BookingInfoRepository bookingInfoRepo;

    @Override
    public BaseVO bookSeats(BookTicketReqVO bookTicketReqVO, long userId) throws ApplicationError {
        applogger.info("User Selected Seats : " + bookTicketReqVO.getSelectedSeat().size());
        if (bookTicketReqVO.getSelectedSeat().size() > 6) {
            throw new ApplicationError(MessageConstants.USER_CAN_BOOK_MAX_6_TICKETS);
        } else {
            ShowInfo showInfo = showInfoRepo.getById((long) bookTicketReqVO.getShowId());
            final List<Integer> selectedSeats = bookTicketReqVO.getSelectedSeat();

            for (final Integer selectedSeatObj : selectedSeats) {
                ScreenSeatInfo screenSeatInfo = screenSeatInfoRepo.findById((long) selectedSeatObj).get();
                List<BookedSeatInfo> bookedSeatInfoList = bookedSeatInfoRepo.findByShowInfoAndScreenSeatInfo(showInfo, screenSeatInfo);
                if (bookedSeatInfoList.size() > 0) {
                    throw new ApplicationError(MessageConstants.TICKET_ALREADY_BOOKED_BY_OTHER_USER);
                }
            }


            UserInfo userInfo = userInfoRepo.getById(userId);
            BookingInfo bookingInfo = new BookingInfo();
            bookingInfo.setShowInfo(showInfo);
            bookingInfo.setStatus("A");
            bookingInfo.setUserInfo(userInfo);
            BookingInfo newBooking = bookingInfoRepo.save(bookingInfo);

            selectedSeats.forEach(selectedSeatObj -> {
                ScreenSeatInfo screenSeatInfo = screenSeatInfoRepo.findById((long) selectedSeatObj).get();
                BookedSeatInfo bookedSeatInfo = new BookedSeatInfo();
                bookedSeatInfo.setBookingInfo(newBooking);
                bookedSeatInfo.setScreenSeatInfo(screenSeatInfo);
                bookedSeatInfo.setShowInfo(showInfo);
                bookedSeatInfo.setStatus("A");

                bookedSeatInfoRepo.save(bookedSeatInfo);
            });
            return null;
        }
    }
}
