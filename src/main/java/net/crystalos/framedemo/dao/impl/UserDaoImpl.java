package net.crystalos.framedemo.dao.impl;

import net.crystalos.framedemo.common.impl.BaseDAOImpl;
import net.crystalos.framedemo.dao.entity.UserEntity;
import net.crystalos.framedemo.dao.inter.IUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: 用户Dao
 * Create on 2020/8/6 11:23
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDAOImpl<UserEntity> implements IUserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Transactional
    @Override
    public List<UserEntity> getAll() {
        //编写Sql语句
        String sql = "select id,login_name,pass,name,sex from user";
        query = this.getSession().createSQLQuery(sql);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return userList;
    }

    @Transactional
    @Override
    public List<UserEntity> getAll(int pageIndex) {
        //编写Sql语句，：pageIndex为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user limit :pageIndex";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中pageIndex参数替换成实际的数值
        query.setParameter("pageIndex", pageIndex);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return userList;
    }

    @Transactional
    @Override
    public List<UserEntity> getAll(int pageIndex, int pageSize) {
        //编写Sql语句，：pageIndex和:pageSize为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user limit :pageIndex,:pageSize";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中pageIndex和pageSize参数替换成实际的数值
        query.setParameter("pageIndex", pageIndex);
        query.setParameter("pageSize", pageSize);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return userList;
    }

    @Transactional
    @Override
    public UserEntity getUserById(long id) {
        //编写Sql语句，：id为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where id = :id";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中id参数替换成实际的数值
        query.setParameter("id", id);
        query.addEntity(UserEntity.class);
        UserEntity user = null;
        try {
            user = (UserEntity) query.uniqueResult();//uniqueResult方法只获取一条数据
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return user;
    }

    @Transactional
    @Override
    public List<UserEntity> findUserByName(String name) {
        //编写Sql语句，：name为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where name like :name";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中name参数替换成实际的数值
        //模糊查询的时候，参数两头带入%符号
        query.setParameter("name", "%"+name+"%");
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return userList;
    }

    @Transactional
    @Override
    public List<UserEntity> findUserBySex(int sex) {
        //编写Sql语句，：sex为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where sex = :sex";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中sex参数替换成实际的数值
        query.setParameter("sex", sex);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return userList;
    }

    @Transactional
    @Override
    public UserEntity login(String loginName, String pass) {
        //编写Sql语句，：login_name和:pass为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where login_name = :login_name and pass = :pass";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中login_name和和pass参数替换成实际的数值
        query.setParameter("login_name", loginName);
        query.setParameter("pass", pass);
        query.addEntity(UserEntity.class);
        UserEntity user = null;
        try {
            user = (UserEntity) query.uniqueResult();//uniqueResult方法只获取一条数据
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return user;
    }

    @Transactional
    @Override
    public boolean rePass(long id, String pass) {
        //编写Sql语句，:pass和：id为需要被替换的参数
        String sql = "update user set pass = :pass where id = :id";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中pass和id参数替换成实际的数值
        query.setParameter("pass", pass);
        query.setParameter("id", id);
        int count = query.executeUpdate();
        return count > 0;
    }

    @Transactional
    @Override
    public boolean deleteById(long id) {
        //编写Sql语句，：id为需要被替换的参数
        String sql = "delete from user where id = :id";
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中id参数替换成实际的数值
        query.setParameter("id", id);
        int count = query.executeUpdate();
        return count > 0;
    }
}
