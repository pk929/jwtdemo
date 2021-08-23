package com.pkuokuo.jwtdemo.controller;

import com.pkuokuo.jwtdemo.VO.JSONResultVo;
import com.pkuokuo.jwtdemo.entity.NewsaasUser;
import com.pkuokuo.jwtdemo.service.InfoService;
import com.pkuokuo.jwtdemo.utils.JWTUtils;
import com.pkuokuo.jwtdemo.utils.PassToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pkuoukuo
 * @date 2021/8/17 14:03
 * <功能简介>
 */
@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    InfoService infoService;
    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/toLogin")
    @ResponseBody
    @PassToken
    public JSONResultVo toLogin(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("phone",phone);
        paramMap.put("pwd",pwd);
        log.info(paramMap.toString());
        NewsaasUser user = infoService.selectUserByPhoneAndPwd(paramMap);
        log.info(user.toString());


        Map<String, Object> token_claim_map = new HashMap<String, Object>(){{
            put("name", "张三");
            put("age", "18");
            put("gender", "1");
            put("phone", phone);
        }};

        String jwtToken = JWTUtils.createJWT("abcdefg", token_claim_map);

        //我的处理方式是把token放到accountVO里去了
        user.setToken(jwtToken);

        return JSONResultVo.ok(user);

    }

}
