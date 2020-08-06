package net.crystalos.framedemo.controller;

import com.alibaba.fastjson.JSONObject;
import net.crystalos.framedemo.service.inter.ILoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Description: 登陆控制器
 * Create on 2020/8/6 16:06
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
@RestController
@RequestMapping("/login") //此条注解可以不写，只是访问地址的区别
public class LoginController {

    @Resource(name = "loginService")
    ILoginService loginService;

    @RequestMapping(value = "/in",produces="application/json;charset=UTF-8")
    public String login(@RequestBody Map<String, Object> map) {
        return JSONObject.toJSONString(loginService.login(map));
    }
}
