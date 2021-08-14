package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.constants.ResponseStatus;
import com.superops.bookyourticket.service.IUserService;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.ResponseVO;
import com.superops.bookyourticket.vo.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseVO registerUser(@RequestBody final UserDetailVO userProfileVO) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            userProfileVO.setUserRole("CUSTOMER");
            final BaseVO response = this.userService.registerUser(userProfileVO);
            super.success(responseVO, response, MessageConstants.USER_REGISTER_SUCCESS);
        } catch (final NumberFormatException e) {
            super.error(responseVO, ResponseStatus.USER_PHONE_NUMBER_NOT_VALID.getCode(), ResponseStatus.USER_PHONE_NUMBER_NOT_VALID.getMessage(), e);
        } catch (final DataIntegrityViolationException e) {
            super.error(responseVO, ResponseStatus.USER_MAIL_ID_EXISTS.getCode(), ResponseStatus.USER_MAIL_ID_EXISTS.getMessage(), e);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }

    @PostMapping(value = "/authenticate")
    public ResponseVO authenticateUser(@RequestBody final UserDetailVO userDetailVO) {
        final ResponseVO responseVO = new ResponseVO();
        try {
            final BaseVO response = this.userService.getUser(userDetailVO);
            super.success(responseVO, response, MessageConstants.USER_AUTHENTICATE_SUCCESS);
        } catch (final BadCredentialsException | InternalAuthenticationServiceException e) {
            super.error(responseVO, ResponseStatus.BAD_CREDENTIALS.getCode(), ResponseStatus.BAD_CREDENTIALS.getMessage(), e);
        } catch (final Exception e) {
            super.userErrorHandler(responseVO, e);
        }
        return responseVO;
    }
}
