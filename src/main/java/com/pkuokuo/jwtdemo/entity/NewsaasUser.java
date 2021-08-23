package com.pkuokuo.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public final class NewsaasUser implements Serializable {
    private Integer id;
    private String user_id;
    private String account;
    private String name;
    private String phone;
    private Integer is_admin;
    private Integer identity_id;
    private String pwd;
    private List<UserMac> userMac;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_time;

    private String token;
}
