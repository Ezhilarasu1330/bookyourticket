package com.superops.bookyourticket.repository;

import com.superops.bookyourticket.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByEmailIdAndUserStatus(final String email, final String active);

    UserInfo findByEmailId(final String email);

    UserInfo findByUserId(final long userId);

}
