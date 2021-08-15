package com.superops.bookyourticket.constants;

public class MessageConstants {

    public static final int SUCCESS_CODE = 200;
    public static final int VALIDATION_CODE = 201;
    public static final int ACCESS_FORBIDDEN_CODE = 203;
    public static final int UNKNOWN_ERROR_CODE = 204;

    public final static String FORBIDDEN_ACCESS = "Access forbidden for this request";

    public final static String SUCCESS = "Success";
    public static final String ERROR = "Error";
    public final static String UNKNOWN_ERROR = "There is some unknown error processing this request";
    public final static String USER_FIRST_NAME_NULL = "The First Name is Null, Kindly add first name";
    public final static String USER_LAST_NAME_NULL = "The Last Name is Null, Kindly add last name";
    public final static String USER_MAIL_ID_NULL = "The Mail Id is Null, Kindly add mail Id";
    public final static String USER_PASSWORD_NULL = "The Password is Null, Kindly add password";
    public final static String USER_PHONE_NUMBER_NULL = "The Phone number is Null, Kindly add phone number";
    public final static String USER_MAIL_ID_NOT_VALID = "The Given mail id is not valid, Kindly give valid mail address";
    public final static String USER_MAIL_ID_EXISTS = "The Given mail id is already exists, Kindly change it";
    public final static String USER_PHONE_NUMBER_NOT_VALID = "The Given Phone number is not valid, Kindly give valid phone number";
    public final static String USER_PASSWORD_WEAK = "The given password is weak, The password must contains 8 characters along with 2 numbers and 1 special character";
    public static final String INVALID_REQUEST = "The given request is invalid, kindly give a valid one";
    public final static String BAD_CREDENTIALS = "The credentials is wrong, Kindly give the valid credentials";
    public static final String ACC_DISABLED = "Account disabled, Kindly contact administrator";

    public final static String THEATRE_LIST_FETCHED_SUCCESS = "Theatre list fetched successfully";
    public final static String THEATRE_INFO_FETCHED_SUCCESS = "Theatre info fetched successfully";

    public final static String MOVIE_LIST_FETCHED_SUCCESS = "Movie list fetched successfully";
    public final static String MOVIE_INFO_FETCHED_SUCCESS = "Movie info fetched successfully";
    public final static String SCREEN_SEAT_INFO_FETCHED_SUCCESS = "Screen seat info fetched successfully";
    public final static String USER_REGISTER_SUCCESS = "User registered successfully";
    public final static String USER_AUTHENTICATE_SUCCESS = "User authenticated successfully";

}
