package com.superops.bookyourticket.service;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.vo.BaseVO;

public interface IMovieService {

    public BaseVO getMovieList() throws ApplicationError;

    public BaseVO getMovieInfo(Long id) throws ApplicationError;
}
