package net.crystalos.framedemo.service.impl;

import net.crystalos.framedemo.dao.entity.UserEntity;
import net.crystalos.framedemo.dao.inter.IUserDao;
import net.crystalos.framedemo.service.inter.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl implements IUserService {

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
        /* 一般逻辑删除在Controller层是remove或者delete方法，但是实际调用的是update方法，只是将专门用于标记数据
        可用和不可用的标记位进行改变。
        例如：我个人习惯在每张表中添加is_using字段这里就进行如下操作：
        if(map.get("is_using) != null) {
            user.setSex(Integer.parseInt(map.get("is_using").toString()));
        }
        只需要在Controller层将Map中字段的值改一下即可完成逻辑删除
         */
        /*这里我们可以直接调用框架的update方法进行更新，在调用此方法的时候，需要先根据主键查询出实体类的全部数据，
            然后变更新的数据，之后框架会自动完成更新，在不使用主键作为条件进行更新的时候，需要我们在Dao层手动编写Sql
            语句进行更新。
        */
        userDao.update(user);
        return true;
    }

    /*删除需要整个过程是同一个事物，所以如果采用实体类删除，那么就需要在Service层添加事物处理
        不过以我个人习惯，事物类型尽量在Dao层处理，因此会使用下面手动写Sql的方式删除
     */
    @Transactional
    @Override
    public boolean deleteUser(Map<String, Object> map) {
        /*这里删除方法试用Map做为入参，是因为删除还可以以其他参数做为条件，未必一定要ID，只是我们这里用Id举例*/
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
    public boolean rePass(Map<String, Object> map) {
        long id = 0;
        String loginName = null;
        String oldPass = null;
        String newPass = (map.get("newpass").toString());
        String reNewPass = (map.get("renewpass").toString());
        if(map.get("id") != null) {
            id = Long.parseLong(map.get("id").toString());
        }
        if(map.get("loginname") != null) {
            loginName = map.get("loginname").toString();
        }
        if(map.get("oldpass") != null) {
            oldPass = (map.get("oldpass").toString());
        }
        if(!newPass.equals(reNewPass)) {
            //判断两遍新密码是否相同，不同则直接失败；
            return false;
        }
        //判断是否有id，如果有，表示这次修改是管理员修改其他用户密码，直接进行修改
        if(id > 0) {
            return userDao.rePass(id, newPass);
        } else if(loginName != null && oldPass != null) {
            //修改自己的密码通过用户名和原密码验证
            UserEntity user = userDao.login(loginName, oldPass);
            if (user != null) {
                //当查询出来用户不为空的时候执行修改，否则认为登录名或者原密码错误
                return userDao.rePass(user.getId(), newPass);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUser(long id) {
        return userDao.deleteById(id);
    }

    @Override
    public boolean deleteUser(List<Long> ids) {
        return userDao.deleteById(ids);
    }
}
