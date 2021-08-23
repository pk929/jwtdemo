package com.pkuokuo.jwtdemo.controller;

import com.pkuokuo.jwtdemo.VO.JSONResultVo;
import com.pkuokuo.jwtdemo.entity.NewsaasUser;
import com.pkuokuo.jwtdemo.service.InfoService;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pkuoukuo
 * @date 2021/8/17 15:29
 * <功能简介>
 */
@Controller
@RequestMapping("info")
@Slf4j
public class InfoController {
    @Autowired
    InfoService infoService;

    @RequestMapping("/getInfo")
    @ResponseBody
    public JSONResultVo getInfo(HttpServletRequest request){
        String phone = request.getParameter("phone");
        if (StringUtil.isNullOrEmpty(phone))
            return JSONResultVo.error("号码为空");
        NewsaasUser user = infoService.selectUserByPhone(phone);


        return JSONResultVo.ok(user);
    }

}
