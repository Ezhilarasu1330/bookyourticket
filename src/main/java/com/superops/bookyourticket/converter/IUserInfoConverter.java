package com.superops.bookyourticket.converter;

import com.superops.bookyourticket.model.UserInfo;
import com.superops.bookyourticket.vo.UserDetailVO;

public interface IUserInfoConverter {

    void convertUserProfile(final UserDetailVO data, final UserInfo empty);
}
