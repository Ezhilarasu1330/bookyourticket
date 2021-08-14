package com.superops.bookyourticket.service;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.vo.BaseVO;

public interface ITheatreService {

    BaseVO getTheatreList() throws ApplicationError;

    BaseVO getTheatreInfo(Long id) throws ApplicationError;

    BaseVO getTheatreAndScreenInfo(Long id) throws ApplicationError;

    BaseVO getTheatreAndShowsInfo(Long id) throws ApplicationError;
}
