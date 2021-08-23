package com.pkuokuo.jwtdemo.mapper;

import com.pkuokuo.jwtdemo.entity.NewsaasUser;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author pkuoukuo
 * @date 2021/8/17 15:34
 * <功能简介>
 */
@Repository
public interface NewsaasUserMapper {
    NewsaasUser selectUserByPhoneAndPwd(Map<String, Object> paramMap);

    NewsaasUser selectUserByPhone(String phone);
}
