package com.example.demo.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.dao.UserDao;
import com.example.demo.global.BaseApi;
import com.example.demo.po.User;
import com.mysql.cj.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 用户页面
 *
 * @author 杨正
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserApi extends BaseApi {

    private final UserDao userDao;

    /**
     * 注册
     *
     * @param param 用户信息
     * @return {@link String}
     */
    @PostMapping("/register")
    public Object register(@RequestBody String param) throws Exception {
        JSONObject json = JSONUtil.parseObj(param);
        String name = json.getStr("name");
        String password = json.getStr("password");
        if (StringUtils.isNullOrEmpty(name)) {
            return resSuccess("1", "用户名不能为空", "");
        }
        if (StringUtils.isNullOrEmpty(password)) {
            return resSuccess("1", "密码不能为空", "");
        }
        password = md5(password);
        /* 生成主键 */
        Random rd = new Random();
        int num = rd.nextInt(99999) + 10000;
        String userId = System.currentTimeMillis() + String.valueOf(num);
        /* 封装到user对象 */
        User user = JSONUtil.toBean(json, User.class);
        user.setId(Long.valueOf(userId));
        user.setPassword(password);
        System.out.println(userId);
        userDao.save(user);
        return resSuccess("0", "成功", "");
    }

    /**
     * 测试function
     *
     * @return {@link String}
     */
    @RequestMapping("/hello")
    public String test01() {
        return "hello world!";
    }

}
