package com.superops.bookyourticket.converter;

import com.superops.bookyourticket.model.ScreenSeatInfo;
import com.superops.bookyourticket.model.ShowInfo;
import com.superops.bookyourticket.vo.ScreenSeatInfoListVO;

import java.util.List;

public interface IScreenInfoConverter {

    void convertToScreenSeatListVO(ShowInfo showInfo, final List<ScreenSeatInfo> screenSeatInfoList, ScreenSeatInfoListVO empty);
}
