package net.crystalos.framedemo.common.inter;

import org.hibernate.Session;

import java.util.List;

/**
 * Description: Dao层基础类接口
 * Create on 2020/8/6 10:54
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
public interface IBaseDAO<T> {

    /**
     * Description:获取Session
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @return org.hibernate.Session
     * @version 1.0
     */
    Session getSession();

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void save(T[] t);

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void save(List<T> t);

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void save(T t);

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @return java.util.List<java.lang.Object>
     * @version 1.0
     */
    List<Object> saveObj(T[] t);

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @return java.lang.Object
     * @version 1.0
     */
    Object saveObj(T t);

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param session (session)
     * @param t (泛型)
     * @return java.util.List<java.lang.Object>
     * @version 1.0
     */
    List<Object> save(Session session, T[] t);

    /**
     * Description: 保存
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param session (session)
     * @param t (泛型)
     * @return java.lang.Object
     * @version 1.0
     */
    Object save(Session session, T t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void update(T[] t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void update(List<T> t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void update(T t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void updateObj(T[] t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void updateObj(T t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param session (session)
     * @param t (泛型)
     * @version 1.0
     */
    void update(Session session, T[] t);

    /**
     * Description: 更新
     * Date: 2020/8/6 10:54
     *
     * @author Miss.Crystal
     * @param session (session)
     * @param t (泛型)
     * @version 1.0
     */
    void update(Session session, T t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @return void
     * @version 1.0
     */
    void delete(T[] t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void delete(List<T> t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void delete(T t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void deleteObj(T[] t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param t (泛型)
     * @version 1.0
     */
    void deleteObj(T t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param session (session)
     * @param t (泛型)
     * @version 1.0
     */
    void delete(Session session, T[] t);

    /**
     * Description: 删除
     * Date: 2020/8/6 10:55
     *
     * @author Miss.Crystal
     * @param session (session)
     * @param t (泛型)
     * @version 1.0
     */
    void delete(Session session, T t);
}
