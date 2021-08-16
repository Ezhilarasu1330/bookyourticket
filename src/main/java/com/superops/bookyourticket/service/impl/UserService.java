package com.superops.bookyourticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.converter.impl.UserInfoConverter;
import com.superops.bookyourticket.exception.ApplicationError;
import com.superops.bookyourticket.model.UserInfo;
import com.superops.bookyourticket.repository.UserInfoRepository;
import com.superops.bookyourticket.util.Validator;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.UserDetailVO;
import com.superops.bookyourticket.service.IUserService;

import java.util.ArrayList;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserInfoRepository userInfoRepo;

    @Autowired
    private UserInfoConverter userInfoConverter;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(final String emailId) throws UsernameNotFoundException {
        final UserInfo userInfo = this.userInfoRepo.findByEmailId(emailId);
        return new User(userInfo.getEmailId(), userInfo.getPassword(), new ArrayList<>());
    }

    @Override
    public BaseVO registerUser(final UserDetailVO userDetailVO) throws ApplicationError {
        if (userDetailVO.getFirstName() == null || userDetailVO.getFirstName().equals("")) {
            throw new ApplicationError(MessageConstants.USER_FIRST_NAME_NULL);
        } else if (userDetailVO.getLastName() == null || userDetailVO.getLastName().equals("")) {
            throw new ApplicationError(MessageConstants.USER_LAST_NAME_NULL);
        } else if (userDetailVO.getEmailId() == null || userDetailVO.getEmailId().equals("")) {
            throw new ApplicationError(MessageConstants.USER_MAIL_ID_NULL);
        } else if (userDetailVO.getPhoneNumber() == null || userDetailVO.getPhoneNumber().equals("")) {
            throw new ApplicationError(MessageConstants.USER_PHONE_NUMBER_NULL);
        } else if (userDetailVO.getPassword() == null || userDetailVO.getPassword().equals("")) {
            throw new ApplicationError(MessageConstants.USER_PASSWORD_NULL);
        } else if (!Validator.mailValidator(userDetailVO.getEmailId())) {
            throw new ApplicationError(MessageConstants.USER_MAIL_ID_NOT_VALID);
        } else if (!Validator.mailValidator(userDetailVO.getEmailId())) {
            throw new ApplicationError(MessageConstants.USER_MAIL_ID_NOT_VALID);
        } else if (!Validator.passwordValidator(userDetailVO.getPassword())) {
            throw new ApplicationError(MessageConstants.USER_PASSWORD_WEAK);
        }

        Long.parseLong(userDetailVO.getPhoneNumber());
        final UserInfo userProfile = new UserInfo();
        this.userInfoConverter.convertUserProfile(userDetailVO, userProfile);
        this.userInfoRepo.save(userProfile);
        return null;
    }

    @Override
    public BaseVO getUser(final UserDetailVO userDetailVO) throws ApplicationError {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetailVO.getEmailId(), userDetailVO.getPassword()));
        final UserInfo userInfo = this.userInfoRepo.findByEmailId(userDetailVO.getEmailId());
        if (!userInfo.getUserStatus().equals("A")) {
            throw new ApplicationError(MessageConstants.ACC_DISABLED);
        }
        this.userInfoConverter.convertUserProfileVO(userInfo, userDetailVO);
        return userDetailVO;
    }
}
