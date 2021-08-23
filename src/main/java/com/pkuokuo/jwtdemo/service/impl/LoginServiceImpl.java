package com.pkuokuo.jwtdemo.service.impl;

import com.pkuokuo.jwtdemo.mapper.NewsaasUserMapper;
import com.pkuokuo.jwtdemo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pkuoukuo
 * @date 2021/8/17 15:32
 * <功能简介>
 */
@Slf4j
@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginServiceImpl implements LoginService {
    @Autowired
    NewsaasUserMapper newsaasUserMapper;


}
