package com.superops.bookyourticket.service.impl;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.ScreenInfo;
import com.superops.bookyourticket.model.ShowInfo;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.repository.ShowInfoRepository;
import com.superops.bookyourticket.service.IShowInfoService;
import com.superops.bookyourticket.vo.ScreenInfoVO;
import com.superops.bookyourticket.vo.ShowInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowInfoService implements IShowInfoService {

    private static final Logger applogger = LogManager.getLogger(ShowInfoService.class);

    @Autowired
    private ShowInfoRepository showInfoRepo;

    public List<ShowInfoVO> getShowListByScreenInfo(ScreenInfo screenInfo) throws ApplicationError {
        try {
            List<ShowInfo> showInfoList = showInfoRepo.findByScreenInfo(screenInfo);

            applogger.info("Screen Name : " + screenInfo.getScreenName() + " show count : " + showInfoList.size());
            List<ShowInfoVO> showInfoVOS = new ArrayList<>();
            showInfoList.forEach(showInfo -> {
                ShowInfoVO showInfoVO = new ShowInfoVO();
                showInfoVO.setShowId(showInfo.getShowId());
                showInfoVO.setMovieName(showInfo.getMovieInfo().getMovieName());
                showInfoVO.setShowStartTime(showInfo.getShowStartTime());
                showInfoVO.setShowEndTime(showInfo.getShowEndTime());
                showInfoVO.setStatus(showInfo.getStatus());
                showInfoVOS.add(showInfoVO);
            });
            return showInfoVOS;
        } catch (Exception e) {
            applogger.error("Screen Info List : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
