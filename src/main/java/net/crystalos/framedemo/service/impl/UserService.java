package net.crystalos.framedemo.service.impl;

import net.crystalos.framedemo.dao.entity.UserEntity;
import net.crystalos.framedemo.dao.inter.IUserDao;
import net.crystalos.framedemo.service.inter.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Description: 用户Service
 * Create on 2020/8/6 15:15
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
@Service("userService")
public class UserService implements IUserService {

    /*常规的业务处理都是在Service层完成的，Service层从Dao层取出数据之后，经过一些算法加
        工然后将数据给到Controller层，再由Controller层将数据通过http协议传输出去供对外接口
        或者是页面使用。
     */

    /*这里使用的是指定名称注入，也可以使用@Autowired进行自动注入，
        自动注入要求变量名称即userDao要和Dao层的名称完成一致，例如：
        @Autowired
        IUserDao userDao;
     */
    @Resource(name = "userDao")
    IUserDao userDao;

    @Override
    public boolean addUser(Map<String, Object> map) {
        UserEntity user = new UserEntity();
        user.setLoginName(map.get("loginname").toString());
        user.setPass(map.get("pass").toString());
        user.setName(map.get("name").toString());
        user.setSex(Integer.parseInt(map.get("sex").toString()));
        /*这里我们可以直接调用框架的save方法进行更新，这种方法需要提前在实体类中配置好，如果不配置，
            就需要我们在Dao层手动编写Sql语句进行插入。
        */
        userDao.save(user);
        return true;
    }

    @Override
    public boolean updateUser(Map<String, Object> map) {
        long id = Long.parseLong(map.get("id").toString());
        UserEntity user = userDao.getUserById(id);
        if(map.get("loginname") != null) {
            user.setLoginName(map.get("loginname").toString());
        }
        if(map.get("pass") != null) {
            user.setPass(map.get("pass").toString());
        }
        if(map.get("name") != null) {
            user.setName(map.get("name").toString());
        }
        if(map.get("sex") != null) {
            user.setSex(Integer.parseInt(map.get("sex").toString()));
        }
        /*这里我们可以直接调用框架的update方法进行更新，在调用此方法的时候，需要先根据主键查询出实体类的全部数据，
            然后变更新的数据，之后框架会自动完成更新，在不使用主键作为条件进行更新的时候，需要我们在Dao层手动编写Sql
            语句进行更新。
        */
        userDao.update(user);
        return true;
    }

    @Override
    public boolean deleteUser(Map<String, Object> map) {
        long id = Long.parseLong(map.get("id").toString());
        UserEntity user = userDao.getUserById(id);
        /*这里我么可以通过查询出实体类然后用框架的删除方法，也可以直接在Dao层写删除语句，然后带入相关的参数进行
            删除，至于带入的方法，和查询类似
         */
        userDao.delete(user);
        return true;
    }

    @Override
    public List getUser(Map<String, Object> map) {
        if(map.get("pageIndex") != null && map.get("pageSize") != null) {
            //判断有页码和每页数量的时候，我们调用分页查询带有页码和每页数量的语句
            return userDao.getAll(Integer.parseInt(map.get("pageIndex").toString()), Integer.parseInt(map.get("pageSize").toString()));
        } else if (map.get("pageIndex") != null) {
            //判断只有页码的时候，我们就默认给每页30条
            return userDao.getAll(Integer.parseInt(map.get("pageIndex").toString()),30);
        } else {
            return userDao.getAll();
        }
    }

    @Override
    public List findUser(Map<String, Object> map) {
        /*由于我们后台Dao层只做了对姓名的模糊查询以及对性别的查询，因此我们这里Map中就会二选一，
            有姓名的时候以姓名查询，没有姓名的时候才进行性别查询，也可以在Dao层增加两者都有的时候的
            查询。在姓名和性别都没有的时候，我们就获取全部的数据。
         */
        if(map.get("name") != null) {
            return userDao.findUserByName(map.get("name") .toString());
        } else if(map.get("sex") != null) {
            return userDao.findUserBySex(Integer.parseInt(map.get("sex").toString()));
        } else {
            return userDao.getAll();
        }
    }

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
