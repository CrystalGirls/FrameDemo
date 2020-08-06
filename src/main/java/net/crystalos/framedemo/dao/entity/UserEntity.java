package net.crystalos.framedemo.dao.entity;

import javax.persistence.*;

/**
 * Description: 用户实体类
 * Create on 2020/8/6 10:59
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
@Entity
@Table(name = "user")
public class UserEntity {
    /*说明：实体类需要和数据库表结构进行匹配*/
    //id主键
    private long id;
    //用户登陆名
    private String loginName;
    //用户密码
    private String pass;
    //用户姓名
    private String name;
    //用户性别
    private int sex;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
