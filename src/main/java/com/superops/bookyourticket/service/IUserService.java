package com.superops.bookyourticket.service;

import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.UserDetailVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    BaseVO registerUser(final UserDetailVO userProfileVO) throws ApplicationError;

    BaseVO getUser(final UserDetailVO userProfileVO) throws ApplicationError;
}
