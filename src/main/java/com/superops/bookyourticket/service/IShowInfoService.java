package com.superops.bookyourticket.service;


import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.ScreenInfo;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.ScreenSeatInfoListVO;
import com.superops.bookyourticket.vo.ShowInfoVO;

import java.util.List;

public interface IShowInfoService {

    List<ShowInfoVO> getShowListByScreenInfo(ScreenInfo screenInfo) throws ApplicationError;

    BaseVO getShowAndSeatsInfo(Long showId) throws ApplicationError;
}
