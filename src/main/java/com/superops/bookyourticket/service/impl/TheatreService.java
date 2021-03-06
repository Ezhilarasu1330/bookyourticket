package com.superops.bookyourticket.service.impl;

import com.superops.bookyourticket.converter.ITheatreConverter;
import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.MovieInfo;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.repository.TheatreInfoRepository;
import com.superops.bookyourticket.service.IScreenInfoService;
import com.superops.bookyourticket.service.ITheatreService;
import com.superops.bookyourticket.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService implements ITheatreService {

    @Autowired
    private TheatreInfoRepository theatreInfoRepo;

    @Autowired
    private ITheatreConverter theatreConverter;

    @Autowired
    private IScreenInfoService screenInfoService;

    public BaseVO getTheatreList() throws ApplicationError {
        final TheatreListVO theatreListVO = new TheatreListVO();
        List<TheatreInfo> theatreList = theatreInfoRepo.findAll();
        theatreConverter.convertToTheatreListVO(theatreList, theatreListVO);
        return theatreListVO;
    }

    public BaseVO getTheatreInfo(Long id) throws ApplicationError {
        TheatreInfo theatreInfo = theatreInfoRepo.getById(id);
        final TheatreVO theatreVO = new TheatreVO();
        theatreConverter.convertToTheatreVO(theatreInfo, theatreVO);
        return theatreVO;
    }

    public BaseVO getTheatreAndScreenInfo(Long id) throws ApplicationError {
        TheatreInfo theatreInfo = theatreInfoRepo.getById(id);
        List<ScreenInfoVO> screenInfoVOS = screenInfoService.getScreenListByTheatreInfo(theatreInfo);
        final TheatreVO theatreVO = new TheatreVO();
        theatreConverter.convertToTheatreAndScreenVO(theatreInfo, screenInfoVOS, theatreVO);
        return theatreVO;
    }

    public BaseVO getTheatreAndShowsInfo(Long id) throws ApplicationError {
        TheatreInfo theatreInfo = theatreInfoRepo.getById(id);
        List<ScreenInfoVO> screenInfoVOS = screenInfoService.getScreenAndMovieListByTheatreInfo(theatreInfo);
        final TheatreVO theatreVO = new TheatreVO();
        theatreConverter.convertToTheatreAndScreenVO(theatreInfo, screenInfoVOS, theatreVO);
        return theatreVO;
    }
}
