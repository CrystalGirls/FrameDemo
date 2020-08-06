package net.crystalos.framedemo.dao.inter;

import net.crystalos.framedemo.common.inter.IBaseDAO;
import net.crystalos.framedemo.dao.entity.UserEntity;

import java.util.List;

/**
 * Description: 用户Dao层接口
 * Create on 2020/8/6 11:19
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
public interface IUserDao extends IBaseDAO<UserEntity> {
    List<UserEntity> getAll();
    List<UserEntity> getAll(int pageIndex);
    List<UserEntity> getAll(int pageIndex, int pageSize);
    UserEntity getUserById(long id);
    List<UserEntity> findUserByName(String name);
    List<UserEntity> findUserBySex(int sex);
}
