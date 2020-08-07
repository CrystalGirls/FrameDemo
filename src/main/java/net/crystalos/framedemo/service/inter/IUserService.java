package net.crystalos.framedemo.service.inter;

import net.crystalos.framedemo.dao.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Description: 用户Service接口
 * Create on 2020/8/6 13:51
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
public interface IUserService {
    boolean addUser(Map<String, Object> map);
    boolean updateUser(Map<String, Object> map);
    boolean deleteUser(Map<String, Object> map);
    List getUser(Map<String, Object> map);
    List findUser(Map<String, Object>map);
    boolean rePass(Map<String, Object>map);
    boolean deleteUser(long id);
}
