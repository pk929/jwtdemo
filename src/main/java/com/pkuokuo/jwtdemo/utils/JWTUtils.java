package com.pkuokuo.jwtdemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pkuoukuo
 * @date 2021/8/20 14:17
 * <auth0类包JWT工具类包>
 */

public class JWTUtils {
    /**
     * JWT头部信息
     */
    private static Map<String, Object> HEADER_MAP = new HashMap<>();

    /**
     * JWT加密秘钥
     */
    private static String TOKEN_KEY = "p3:As3[Vd&da.D";

    /**
     * JWT生效时间
     */
    private static Date TOKEN_BEGIN = new Date();

    /**
     * JWT到期时间，默认十分钟
     */
    private static Date TOKEN_TIMEOUT = new Date(TOKEN_BEGIN.getTime() + 10 * 60 * 1000);

    /**
     * JWT签发主体
     */
    private static String TOKEN_ISSUSER = "";

    /**
     * JWT接收主体
     */
    private static String TOKEN_AUDIENCE = "aaa";

    /**
     * JWT所有人
     */
    private static String TOKEN_SUBJECT = "";

    /**
     * JWT唯一标识
     */
    private static String TOKEN_JWT_ID = "";

    /**
     * JWT自定义声明
     */
    private static Map<String, Object> TOKEN_CLAIM_MAP = new HashMap<>();

    private static String TOKEN_KEY_ID = "";

    private static Map<String, Object[]> TOKEN_ARRAY_CLAIM = new HashMap<>();

    /**
     * 设置头部信息
     * @param header_map
     */
    public static void setHeaderMap(Map<String, Object> header_map){
        HEADER_MAP = header_map;
    }
    /**
     * 设置加密秘钥
     * @param token_key
     */
    public static void setTokenKey(String token_key){
        TOKEN_KEY = token_key;
    }

    /**
     * 设置生效时间
     * @param token_begin
     */
    public static void setTokenBegin(Date token_begin){
        TOKEN_BEGIN = token_begin;
    }

    /**
     * 设置到期时间
     * @param token_timeout
     */
    public static void setTokenTimeout(Date token_timeout){
        TOKEN_TIMEOUT = token_timeout;
    }

    /**
     * 设置签发主体
     * @param token_issuser
     */
    public static void setTokenIssuser(String token_issuser){
        TOKEN_ISSUSER = token_issuser;
    }

    /**
     * 设置接收主体
     * @param token_audience
     */
    public static void setTokenAudience(String token_audience){
        TOKEN_AUDIENCE = token_audience;
    }

    /**
     * 设置所有人
     * @param token_subject
     */
    public static void setTokenSubject(String token_subject){
        TOKEN_SUBJECT = token_subject;
    }

    /**
     * 设置唯一标识
     * @param token_jwt_id
     */
    public static void setTokenJwtId(String token_jwt_id){
        TOKEN_JWT_ID = token_jwt_id;
    }

    /**
     * 设置自定义声明
     * @param token_claim_map
     */
    public static void setTokenClaimMap(Map<String, Object> token_claim_map){
        TOKEN_CLAIM_MAP = token_claim_map;
    }

    /**
     *
     * @param token_key_id
     */
    public static void setTokenKeyId(String token_key_id){
        TOKEN_KEY_ID = token_key_id;
    }

    /**
     *
     * @param token_array_claim
     */
    public static void setTokenArrayClaim(Map<String, Object[]> token_array_claim){
        TOKEN_ARRAY_CLAIM = token_array_claim;
    }

    /**
     * 创建JWT
     */
    public static String createJWT(String token_key){
        return createJWT(HEADER_MAP, TOKEN_BEGIN, TOKEN_TIMEOUT, TOKEN_AUDIENCE, TOKEN_ISSUSER, TOKEN_SUBJECT, token_key, TOKEN_CLAIM_MAP, TOKEN_JWT_ID, TOKEN_KEY_ID);
    }

    public static String createJWT(String token_key, Map<String,Object> token_claim_map){
        return createJWT(HEADER_MAP, TOKEN_BEGIN, TOKEN_TIMEOUT, TOKEN_AUDIENCE, TOKEN_ISSUSER, TOKEN_SUBJECT, token_key, token_claim_map, TOKEN_JWT_ID, TOKEN_KEY_ID);
    }

    public static String createJWT(String token_key, Map<String,Object> token_claim_map, Map<String, Object> header_map){
        return createJWT(header_map, TOKEN_BEGIN, TOKEN_TIMEOUT, TOKEN_AUDIENCE, TOKEN_ISSUSER, TOKEN_SUBJECT, token_key, token_claim_map, TOKEN_JWT_ID, TOKEN_KEY_ID);
    }

    public static String createJWT(String token_key, Map<String,Object> token_claim_map, Date token_begin, Date token_timeout){
        return createJWT(HEADER_MAP, token_begin, token_timeout, TOKEN_AUDIENCE, TOKEN_ISSUSER, TOKEN_SUBJECT, token_key, token_claim_map, TOKEN_JWT_ID, TOKEN_KEY_ID);
    }

    public static String createJWT(String token_key, Map<String,Object> token_claim_map, Date token_timeout, String token_audience, String token_issuser){
        return createJWT(HEADER_MAP, TOKEN_BEGIN, token_timeout, token_audience, token_issuser, TOKEN_SUBJECT, token_key, token_claim_map, TOKEN_JWT_ID, TOKEN_KEY_ID);
    }

    public static String createJWT(String token_key, Map<String,Object> token_claim_map, Date token_begin, Date token_timeout, String token_audience, String token_issuser, String token_subject){
        return createJWT(HEADER_MAP, token_begin, token_timeout, token_audience, token_issuser, token_subject, token_key, token_claim_map, TOKEN_JWT_ID, TOKEN_KEY_ID);
    }


    /**
     * 创建JWT
     * @param header_map 头部信息
     * @param token_begin 生效时间
     * @param token_timeout 到期时间
     * @param token_audience 接收主体
     * @param token_issuser 签发主体
     * @param token_subject 所有人
     * @param token_key 加密秘钥
     * @param token_claim_map 自定义声明
     * @param token_jwt_id 唯一标识
     * @param token_key_id key_id
     * @return jwt
     */
    public static String createJWT(Map<String, Object> header_map, Date token_begin, Date token_timeout,
                                     String token_audience, String token_issuser, String token_subject,
                                     String token_key, Map<String,Object> token_claim_map,
                                     String token_jwt_id, String token_key_id){
        String token;
        try {
            JWTCreator.Builder builder = JWT.create()
                    .withHeader(header_map) // 自定义头部
                    .withIssuedAt(new Date()) // 设置签发时间
                    .withNotBefore(token_begin) // 设置生效时间
                    .withExpiresAt(token_timeout) // 设置过期时间
                    .withAudience(token_audience) // 接收人
                    .withIssuer(token_issuser) // 签发人
                    .withSubject(token_subject) //JWT的所有人
                    .withJWTId(token_jwt_id) // JWT的唯一标识
                    .withKeyId(token_key_id); //

//                .withClaim("","") // 自定义声明
//                .withArrayClaim("",new String[]{}) //
            for (Map.Entry<String, Object> stringObjectEntry : token_claim_map.entrySet()) {
                builder.withClaim(stringObjectEntry.getKey(), String.valueOf(stringObjectEntry.getValue()));
            }
            token = builder.sign(Algorithm.HMAC256(token_key));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        return token;
    }

    /**
     * 校验JWT
     * @param token 待校验的jwt
     * @param token_key 加密秘钥
     * @return boolean
     */
    public static Boolean verifyJWT(String token, String token_key){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(token_key)).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) {
        String audience;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return audience;
    }

    /**
     * 根据名称获取声明
     * @param token
     * @param name
     * @return
     */
    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }

    /**
     * 获取所有声明
     * @param token
     * @return
     */
    public static Map<String, Claim> getClaims(String token){
        return JWT.decode(token).getClaims();
    }



}

