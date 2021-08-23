package com.pkuokuo.jwtdemo.enums;

import lombok.Getter;


/**
 * @author pkuoukuo
 * @date 2021/6/21 11:25
 * <功能简介>
 */
@Getter
public enum Status {
    SUCCESS(200, "成功"),
    FAILURE(900, "失败"),
    UNKNOWN_EXCEPTION(901,"未知错误"),
    PARAMETER_ERROR(902,"参数错误"),
    USER_NO_ACCESS(903, "无权访问"),
    NO_SIGN_IN(904, "未登录"),
    DATA_DUPLICATION(905, "数据重复"),


    ;
    private Integer code;
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

//    public static LoginStatus parse(int code) {
//        LoginStatus[] values = values();
//        for (LoginStatus value : values) {
//            if (value.getCode() == code) {
//                return value;
//            }
//        }
//        throw new RuntimeException("Unknown code of ResultEnum");
//    }

}
