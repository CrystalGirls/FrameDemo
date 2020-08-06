package net.crystalos.framedemo.service.impl;

import net.crystalos.framedemo.dao.entity.UserEntity;
import net.crystalos.framedemo.dao.inter.IUserDao;
import net.crystalos.framedemo.service.inter.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Description: 登陆相关Service
 * Create on 2020/8/6 15:59
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
public class LoginService implements ILoginService {

    /*这里使用的是自动注入，也可以使用@Resource进行制定名称注入，
        自动注入要求变量名称即userDao要和Dao层的名称完成一致，
        而制定名称则可以随意,name中的名称一定要和Dao层一致，例如：
        @Resource(name = "userDao")
        IUserDao usersDao;
     */
    @Autowired
    IUserDao userDao;

    @Override
    public UserEntity login(Map<String, Object> map) {
        String loginName = map.get("loginname").toString();
        String pass = map.get("pass").toString();
        /*获取出密码明文之后，可以在这里对密码进行加密形成密文
            本用例暂时不对密码进行加密
         */
        return userDao.login(loginName, pass);
    }
}
