package net.crystalos.framedemo.service.inter;

import net.crystalos.framedemo.dao.entity.UserEntity;

import java.util.Map;

/**
 * Description: 登陆相关Service接口
 * Create on 2020/8/6 15:58
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
public interface ILoginService {
    UserEntity login(Map<String, Object> map);
}
