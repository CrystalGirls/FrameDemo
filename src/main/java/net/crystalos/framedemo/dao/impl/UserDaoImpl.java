package net.crystalos.framedemo.dao.impl;

import net.crystalos.framedemo.common.impl.BaseDAOImpl;
import net.crystalos.framedemo.dao.entity.UserEntity;
import net.crystalos.framedemo.dao.inter.IUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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

     @Override
    public List<UserEntity> getAll() {
        session = getSession();
        //编写Sql语句
        String sql = "select id,login_name,pass,name,sex from user";
        //开启事物处理
        session.beginTransaction();
        query = session.createSQLQuery(sql);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public List<UserEntity> getAll(int pageIndex) {
        session = getSession();
        //编写Sql语句，：pageIndex为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user limit :pageIndex";
        //开启事物处理
        session.beginTransaction();
        query = session.createSQLQuery(sql);
        //将sql语句中pageIndex参数替换成实际的数值
        query.setParameter("pageIndex", pageIndex);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public List<UserEntity> getAll(int pageIndex, int pageSize) {
        session = getSession();
        //编写Sql语句，：pageIndex和:pageSize为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user limit :pageIndex,:pageSize";
        //开启事物处理
        session.beginTransaction();
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
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public UserEntity getUserById(long id) {
        session = getSession();
        //编写Sql语句，：id为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where id = :id";
        //开启事物处理
        session.beginTransaction();
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中id参数替换成实际的数值
        query.setParameter("id", id);
        query.addEntity(UserEntity.class);
        UserEntity user = null;
        try {
            user = (UserEntity) query.uniqueResult();//uniqueResult方法只获取一条数据
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<UserEntity> findUserByName(String name) {
        session = getSession();
        //编写Sql语句，：name为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where name like :name";
        //开启事物处理
        session.beginTransaction();
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
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public List<UserEntity> findUserBySex(int sex) {
        session = getSession();
        //编写Sql语句，：sex为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where sex = :sex";
        //开启事物处理
        session.beginTransaction();
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中sex参数替换成实际的数值
        query.setParameter("sex", sex);
        query.addEntity(UserEntity.class);
        List<UserEntity> userList = null;
        try {
            userList =  query.list();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public UserEntity login(String loginName, String pass) {
        session = getSession();
        //编写Sql语句，：login_name和:pass为需要被替换的参数
        String sql = "select id,login_name,pass,name,sex from user where login_name = :login_name and pass = :pass";
        //开启事物处理
        session.beginTransaction();
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
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public boolean rePass(long id, String pass) {
        session = getSession();
        //编写Sql语句，:pass和：id为需要被替换的参数
        String sql = "update user set pass = :pass where id = :id";
        //开启事物处理
        session.beginTransaction();
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中pass和id参数替换成实际的数值
        query.setParameter("pass", pass);
        query.setParameter("id", id);
        int count = query.executeUpdate();
        session.flush();
        session.getTransaction().commit();
        session.close();
        return count > 0;
    }

    @Override
    public boolean deleteById(long id) {
        session = getSession();
        //编写Sql语句，：id为需要被替换的参数
        String sql = "delete from user where id = :id";
        //开启事物处理
        session.beginTransaction();
        query = this.getSession().createSQLQuery(sql);
        //将sql语句中id参数替换成实际的数值
        query.setParameter("id", id);
        int count = query.executeUpdate();
        session.flush();
        session.getTransaction().commit();
        session.close();
        return count > 0;
    }
}
