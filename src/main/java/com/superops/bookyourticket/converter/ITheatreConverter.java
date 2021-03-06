package com.superops.bookyourticket.converter;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.MovieInfo;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.vo.MovieVO;
import com.superops.bookyourticket.vo.ScreenInfoVO;
import com.superops.bookyourticket.vo.TheatreListVO;
import com.superops.bookyourticket.vo.TheatreVO;

import java.util.List;

public interface ITheatreConverter {

    void convertToTheatreListVO(final List<TheatreInfo> data, final TheatreListVO empty);

    void convertToTheatreVO(TheatreInfo theatreInfo, TheatreVO empty) throws ApplicationError;

    void convertToTheatreAndScreenVO(TheatreInfo theatreInfo, List<ScreenInfoVO> screenInfoVOS, TheatreVO empty) throws ApplicationError;
}
