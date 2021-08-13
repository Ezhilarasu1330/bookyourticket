package com.superops.bookyourticket.service;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.vo.BaseVO;

public interface ITheatreService {

    BaseVO getTheatreList() throws ApplicationError;

    BaseVO getTheatreInfo(Long id) throws ApplicationError;

    BaseVO getTheatreAndShows(Long id) throws ApplicationError;
}
