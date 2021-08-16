package com.superops.bookyourticket.service.impl;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.ScreenInfo;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.repository.ScreenInfoRepository;
import com.superops.bookyourticket.service.IScreenInfoService;
import com.superops.bookyourticket.service.IShowInfoService;
import com.superops.bookyourticket.vo.ScreenInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenInfoService implements IScreenInfoService {

    private static final Logger applogger = LogManager.getLogger(ScreenInfoService.class);

    @Autowired
    private ScreenInfoRepository screenInfoRepo;

    @Autowired
    private IShowInfoService showInfoService;

    public List<ScreenInfoVO> getScreenListByTheatreInfo(TheatreInfo theatreInfo) throws ApplicationError {
        try {
            List<ScreenInfo> screenInfoList = screenInfoRepo.findByTheatreInfo(theatreInfo);
            List<ScreenInfoVO> screenInfoVOS = new ArrayList<>();
            screenInfoList.forEach(screenInfo -> {
                ScreenInfoVO screenInfoVO = new ScreenInfoVO();
                screenInfoVO.setScreenId(screenInfo.getScreenId());
                screenInfoVO.setScreenName(screenInfo.getScreenName());
                screenInfoVO.setNoOfSeats(screenInfo.getNoOfSeats());
                screenInfoVO.setStatus(screenInfo.getStatus());
                screenInfoVOS.add(screenInfoVO);
            });
            return screenInfoVOS;
        } catch (Exception e) {
            applogger.error("Screen Info List : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ScreenInfoVO> getScreenAndMovieListByTheatreInfo(TheatreInfo theatreInfo) throws ApplicationError {
        try {
            List<ScreenInfo> screenInfoList = screenInfoRepo.findByTheatreInfo(theatreInfo);
            List<ScreenInfoVO> screenInfoVOS = new ArrayList<>();
            screenInfoList.forEach(screenInfo -> {
                ScreenInfoVO screenInfoVO = new ScreenInfoVO();
                try {
                    screenInfoVO.setShowInfo(showInfoService.getShowListByScreenInfo(screenInfo));
                } catch (ApplicationError applicationError) {
                    applicationError.printStackTrace();
                }
                screenInfoVO.setScreenId(screenInfo.getScreenId());
                screenInfoVO.setScreenName(screenInfo.getScreenName());
                screenInfoVO.setNoOfSeats(screenInfo.getNoOfSeats());
                screenInfoVO.setStatus(screenInfo.getStatus());
                screenInfoVOS.add(screenInfoVO);
            });
            return screenInfoVOS;
        } catch (Exception e) {
            applogger.info("Screen Info List : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
