package com.pkuokuo.jwtdemo.handler;

import com.pkuokuo.jwtdemo.VO.JSONResultVo;
import com.pkuokuo.jwtdemo.utils.JWTUtils;
import com.pkuokuo.jwtdemo.utils.PassToken;
import com.pkuokuo.jwtdemo.utils.Utils;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author pkuoukuo
 * @date 2021/8/17 14:09
 * <功能简介>
 */
@Component
@Slf4j
public class LoginHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestName = String.valueOf(handler);
        HttpSession session = request.getSession();
        log.warn("LoginHandler_requestName:"+requestName+";sessionId:"+session.getId());

        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            log.info("不是映射到方法直接通过");
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        else {
            // 默认全部检查
            log.info("进行jwt验证");
            if (StringUtil.isNullOrEmpty(token)){
                log.error("token为空");
                Utils.result(response, JSONResultVo.error("token为空"));
                return false;
            }
            // 获取 token 中的 user Name
            String userId = JWTUtils.getAudience(token);
            log.info(userId);

            // 验证 jwt
            if (!JWTUtils.verifyJWT(token, "abcdefg")){
                Utils.result(response, JSONResultVo.error("token失效"));
                return false;
            }
            //获取载荷内容
            String phone = JWTUtils.getClaimByName(token, "phone").asString();
            log.info(phone);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception { /* compiled code */ }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception { /* compiled code */ }
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { /* compiled code */ }

}
