package net.crystalos.framedemo.controller;

import com.alibaba.fastjson.JSONObject;
import net.crystalos.framedemo.service.inter.IUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description: 用户控制器
 * Create on 2020/8/7 9:46
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService userService;

    @RequestMapping(value = "/add")
    public String addUser(@RequestBody Map<String, Object> map) {
        if(userService.addUser(map)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/update")
    public String updateUser(@RequestBody Map<String, Object> map) {
        if(userService.updateUser(map)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/deleteList")
    public String deleteUser(@RequestBody List<Map<String, Object>> mapList) {
       List<Long> ids = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            ids.add(Long.parseLong(map.get("id").toString()));
        }
        if (userService.deleteUser(ids)) {
            return "success";
        } else {
            return "fail";
        }
    }
    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestBody Map<String, Object> map) {
        //以下为直接调用自己写的Sql删除
        long id = Long.parseLong(map.get("id").toString());
        if (userService.deleteUser(id)) {
            return "success";
        } else {
            return "fail";
        }
        /*一下为调用实体类删除的形式
        if(userService.deleteUser(map)) {
            return "success";
        } else {
            return "fail";
        }
         */
    }

    @RequestMapping(value = "/repass")
    public String rePass(@RequestBody Map<String, Object> map) {
        if(userService.rePass(map)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/get")
    public String getUser(@RequestBody Map<String, Object> map) {
        return JSONObject.toJSONString(userService.getUser(map));
    }

    @RequestMapping(value = "/find")
    public String findUser(@RequestBody Map<String, Object> map) {
        return JSONObject.toJSONString(userService.findUser(map));
    }
}
