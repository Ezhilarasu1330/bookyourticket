package com.superops.bookyourticket.converter.impl;

import com.superops.bookyourticket.converter.ITheatreConverter;
import com.superops.bookyourticket.model.MovieInfo;
import com.superops.bookyourticket.model.TheatreInfo;
import com.superops.bookyourticket.vo.MovieVO;
import com.superops.bookyourticket.vo.MovietListVO;
import com.superops.bookyourticket.vo.TheatreListVO;
import com.superops.bookyourticket.vo.TheatreVO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TheatreConverter implements ITheatreConverter {

    @Override
    public void convertToTheatreListVO(final List<TheatreInfo> data, final TheatreListVO empty) {
        final List<TheatreVO> theatreVOs = new LinkedList<>();
        data.forEach(theatreInfo -> {
            final TheatreVO theatreVO = new TheatreVO();

            theatreVO.setTheatreId(theatreInfo.getTheatreId());
            theatreVO.setTheatreName(theatreInfo.getTheatreName());
            theatreVO.setTheatreLoc(theatreInfo.getTheatreLoc());
            theatreVO.setStatus(theatreInfo.getStatus());
            theatreVOs.add(theatreVO);
        });
        empty.setTheatres(theatreVOs);
    }

    @Override
    public void convertToTheatreVO(TheatreInfo theatreInfo, TheatreVO empty) {
        empty.setTheatreId(theatreInfo.getTheatreId());
        empty.setTheatreName(theatreInfo.getTheatreName());
        empty.setTheatreLoc(theatreInfo.getTheatreLoc());
        empty.setStatus(theatreInfo.getStatus());
    }
}
