package com.pkuokuo.jwtdemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class UserMac implements Serializable {
    private Integer id;
    private String user_id;
    private String mac;
    private Integer status;
    private Date create_time;
}
