package com.pkuokuo.jwtdemo.service;

import com.pkuokuo.jwtdemo.entity.NewsaasUser;

import java.util.Map;

/**
 * @author pkuoukuo
 * @date 2021/8/17 15:31
 * <功能简介>
 */
public interface InfoService {
    NewsaasUser selectUserByPhoneAndPwd(Map<String, Object> paramMap);

    NewsaasUser selectUserByPhone(String phone);
}
