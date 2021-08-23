package com.pkuokuo.jwtdemo.VO;

import com.pkuokuo.jwtdemo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;


/**
 * @author pkuoukuo
 * @date 2021/6/21 11:25
 * <返回类>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class JSONResultVo implements Serializable {
    private Object code;
    private String msg;
    private Object result;

    public static JSONResultVo ok() {
        JSONResultVo jsonResultVo = new JSONResultVo(Status.SUCCESS.getCode(), null, null);
        log.warn("jsonResultVo1 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

    public static JSONResultVo ok(Object data) {
        JSONResultVo jsonResultVo = new JSONResultVo(Status.SUCCESS.getCode(), null, data);
        log.warn("jsonResultVo1 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

    public static JSONResultVo ok(Integer code, String msg, Object data) {
        JSONResultVo jsonResultVo = new JSONResultVo(code, msg, data);
        log.warn("jsonResultVo2 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

    public static JSONResultVo error() {
        JSONResultVo jsonResultVo = new JSONResultVo(Status.FAILURE.getCode(), Status.FAILURE.getMessage(), null);
        log.warn("jsonResultVo3 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

    public static JSONResultVo error(String msg) {
        JSONResultVo jsonResultVo = new JSONResultVo(Status.FAILURE.getCode(), msg, null);
        log.warn("jsonResultVo3 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

    public static JSONResultVo error(Status status) {
        JSONResultVo jsonResultVo = new JSONResultVo(status.getCode(), status.getMessage(), null);
        log.warn("jsonResultVo3 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

    public static JSONResultVo error(Integer code, String errorMsg, Object data) {
        JSONResultVo jsonResultVo = new JSONResultVo(code, errorMsg, data);
        log.warn("jsonResultVo4 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }
}
