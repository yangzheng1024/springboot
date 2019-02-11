package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.dao.UserDao;
import com.example.demo.global.BaseApi;
import com.example.demo.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户页面
 *
 * @author 杨正
 */
@Api(description = "用户信息")
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
    @ApiOperation(value = "新增用户", notes = "新增注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("/register")
    public Object register(@RequestBody String param) throws Exception {
        JSONObject json = JSONUtil.parseObj(param);
        String name = json.getStr("name");
        String password = json.getStr("password");
        /* 参数判空 */
        if (StrUtil.isEmpty(name)) {
            return resSuccess("1", "用户名不能为空", "");
        }
        if (StrUtil.isEmpty(password)) {
            return resSuccess("1", "密码不能为空", "");
        }
        // 加密密码
        password = md5(password);
        // 生成主键
        String userId = getUserId();
        /* 封装到user对象 */
        User user = JSONUtil.toBean(json, User.class);
        user.setId(Long.valueOf(userId));
        user.setPassword(password);
        Long id = userDao.save(user).getId();
        return resSuccess("0", "成功", JSONUtil.createObj().put("userId", id));
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
