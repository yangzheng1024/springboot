package com.example.demo.global;

import cn.hutool.json.JSONObject;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 基类
 *
 * @author 杨正
 */
public class BaseApi {

    private static JSONObject result = new JSONObject(3);

    /**
     * 返回结果处理
     *
     * @param code 返回编号
     * @param msg  返回说明
     * @param data 返回数据
     * @return {@link JSONObject}
     */
    public JSONObject resSuccess(String code, String msg, Object data) {
        result.put("data", data);
        result.put("msg", msg);
        result.put("code", code);
        return result;
    }

    /**
     * md5加密
     */
    public String md5(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(md5.digest(str.getBytes()));
    }

}
