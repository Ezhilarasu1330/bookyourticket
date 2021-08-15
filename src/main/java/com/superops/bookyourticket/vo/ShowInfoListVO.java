package com.superops.bookyourticket.vo;

import java.util.List;

public class ShowInfoListVO extends BaseVO{

    private List<ShowInfoVO> showInfoVOS;

    public List<ShowInfoVO> getShowInfoVOS() {
        return showInfoVOS;
    }

    public void setShowInfoVOS(List<ShowInfoVO> showInfoVOS) {
        this.showInfoVOS = showInfoVOS;
    }
}
