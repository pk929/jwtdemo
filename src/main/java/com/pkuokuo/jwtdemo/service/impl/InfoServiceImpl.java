package com.pkuokuo.jwtdemo.service.impl;

import com.pkuokuo.jwtdemo.entity.NewsaasUser;
import com.pkuokuo.jwtdemo.mapper.NewsaasUserMapper;
import com.pkuokuo.jwtdemo.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author pkuoukuo
 * @date 2021/8/17 15:32
 * <功能简介>
 */
@Slf4j
@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InfoServiceImpl implements InfoService {
    @Autowired
    NewsaasUserMapper newsaasUserMapper;


    @Override
    public NewsaasUser selectUserByPhoneAndPwd(Map<String, Object> paramMap) {

        return newsaasUserMapper.selectUserByPhoneAndPwd(paramMap);
    }

    @Override
    public NewsaasUser selectUserByPhone(String phone) {
        return newsaasUserMapper.selectUserByPhone(phone);

    }
}
