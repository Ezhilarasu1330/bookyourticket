package com.superops.bookyourticket.converter.impl;

import com.superops.bookyourticket.converter.IUserInfoConverter;
import com.superops.bookyourticket.model.UserInfo;
import com.superops.bookyourticket.util.JwtUtil;
import com.superops.bookyourticket.vo.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoConverter implements IUserInfoConverter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void convertUserProfile(final UserDetailVO data, UserInfo empty) {
        empty.setFirstName(data.getFirstName());
        empty.setLastName(data.getLastName());
        empty.setEmailId(data.getEmailId());
        empty.setPassword(jwtUtil.passwordEncoder().encode(data.getPassword()));
        empty.setPhoneNumber(data.getPhoneNumber());
        empty.setUserStatus("A");
    }

    public void convertUserProfileVO(final UserInfo data, final UserDetailVO empty) {
        empty.setUserId(data.getUserId());
        empty.setFirstName(data.getFirstName());
        empty.setLastName(data.getLastName());
        empty.setEmailId(data.getEmailId());
        empty.setUserStatus(data.getUserStatus());
        empty.setPassword(null);
        empty.setPhoneNumber(data.getPhoneNumber());
        empty.setToken(this.jwtUtil.generateToken(data, empty));
    }
}
