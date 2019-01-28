package com.example.demo.global;

import cn.hutool.json.JSONObject;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Random;

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
    protected JSONObject resSuccess(String code, String msg, Object data) {
        result.put("data", data);
        result.put("msg", msg);
        result.put("code", code);
        return result;
    }

    /**
     * md5加密
     *
     * @param str 要加密的字符串
     * @return {@link String}
     */
    protected String md5(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(md5.digest(str.getBytes()));
    }

    /**
     * 生成userId主键
     *
     * @return {@link String}
     */
    protected String getUserId() {
        Random random = new Random();
        int i = random.nextInt(99999) + 10000;
        return System.currentTimeMillis() + String.valueOf(i);
    }
}
