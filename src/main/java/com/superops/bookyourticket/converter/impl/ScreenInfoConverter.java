package com.superops.bookyourticket.converter.impl;

import com.superops.bookyourticket.converter.IScreenInfoConverter;
import com.superops.bookyourticket.model.BookedSeatInfo;
import com.superops.bookyourticket.model.ScreenSeatInfo;
import com.superops.bookyourticket.model.ShowInfo;
import com.superops.bookyourticket.repository.BookedSeatInfoRepository;
import com.superops.bookyourticket.vo.ScreenSeatInfoListVO;
import com.superops.bookyourticket.vo.ScreenSeatInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScreenInfoConverter implements IScreenInfoConverter {

    @Autowired
    private BookedSeatInfoRepository bookedSeatInfoRepo;

    @Override
    public void convertToScreenSeatListVO(ShowInfo showInfo, List<ScreenSeatInfo> screenSeatInfoList, ScreenSeatInfoListVO empty) {

        try {
            final List<ScreenSeatInfoVO> screenSeatInfoVOS = new LinkedList<>();
            screenSeatInfoList.forEach(screenSeatInfoObj -> {

                ScreenSeatInfoVO screenSeatInfoVO = new ScreenSeatInfoVO();
                // screenSeatInfoVO.setScreenId(screenSeatInfoObj.getScreenInfo().getScreenId());
                screenSeatInfoVO.setScreenSeatId(screenSeatInfoObj.getScreenSeatId());
                screenSeatInfoVO.setSeatNumber(screenSeatInfoObj.getSeatNumber());
                screenSeatInfoVO.setStatus(screenSeatInfoObj.getStatus());
                List<BookedSeatInfo> bookedSeatInfoList = bookedSeatInfoRepo.findByShowInfoAndScreenSeatInfo(showInfo, screenSeatInfoObj);
                if (bookedSeatInfoList.size() > 0) {
                    screenSeatInfoVO.setBooked(Boolean.TRUE);
                }
                screenSeatInfoVOS.add(screenSeatInfoVO);
            });
            empty.setScreenSeatInfo(screenSeatInfoVOS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
