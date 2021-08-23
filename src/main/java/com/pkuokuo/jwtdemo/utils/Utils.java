package com.pkuokuo.jwtdemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.pkuokuo.jwtdemo.VO.JSONResultVo;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author pkuoukuo
 * @date 2021/8/17 16:34
 * <功能简介>
 */
public class Utils {

    //返回数据
    public static void result(HttpServletResponse response, JSONResultVo jsonResultVo) throws Exception{
        String string = JSONObject.toJSONString(jsonResultVo);
        PrintWriter writer = response.getWriter();
        writer.write(string);
        writer.flush();
        writer.close();
    }

}
