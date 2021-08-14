package com.superops.bookyourticket.service;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.vo.ScreenInfoVO;

import java.util.List;

public interface IScreenInfoService {

    List<ScreenInfoVO> getScreenListByTheatreInfo(TheatreInfo theatreInfo) throws ApplicationError;

    List<ScreenInfoVO> getScreenAndMovieListByTheatreInfo(TheatreInfo theatreInfo) throws ApplicationError;

}
