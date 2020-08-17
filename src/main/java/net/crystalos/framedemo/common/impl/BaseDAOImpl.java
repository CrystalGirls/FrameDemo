package net.crystalos.framedemo.common.impl;

import net.crystalos.framedemo.common.inter.IBaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Description: Dao层基础类
 * Create on 2020/8/6 11:00
 *
 * @author Miss.Crystal
 * @version 1.0
 * Copyright (c) 2020 ♀Crystal♀ ,Inc. All Rights Reserved.
 */
@Repository("baseDao")
public class BaseDAOImpl<T> extends HibernateDaoSupport implements IBaseDAO<T> {
    @SuppressWarnings("unused")
    private Class<T> entityClass; // 表示当前实体类的类型

    //@Autowired
    //protected SessionFactory sessionFactory;

    //@PersistenceContext
    //private EntityManager entityManager;

    @Resource(name="PrimarySessionFactory")
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    protected StringBuffer sqlStr;
    protected NativeQuery query;
    protected Session session;
    protected final static int TRUE = 1;
    protected final static int FALSE = 0;

    // 构造方法，通过反射获取当前DAO对应POJO类的Class类
    @SuppressWarnings("unchecked")
    public BaseDAOImpl()
    {
        Class<T> c = (Class<T>) getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType)
        {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    public Session getSession()
    {
        return this.getSessionFactory().getCurrentSession();
        //return entityManager.unwrap(Session.class);
    }

    @Override
    public void save(T t)
    {
        session = this.getSession();
        session.beginTransaction();
        session.save(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(T[] t)
    {
        session = this.getSession();
        session.beginTransaction();
        for (T temp : t)
        {
            session.save(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(List<T> t)
    {
        session = this.getSession();
        session.beginTransaction();
        for (T temp : t)
        {
            session.save(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Object> saveObj(T[] t)
    {
        return this.save(getSession(), t);
    }

    @Override
    public Object saveObj(T t)
    {
        return this.save(getSession(), t);
    }

    @Override
    public List<Object> save(Session session, T[] t)
    {
        session.beginTransaction();
        List<Object> list = new ArrayList<>();
        for (T temp : t)
        {
            Object object = session.save(temp);
            list.add(object);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Object save(Session session, T t)
    {
        session.beginTransaction();
        Object object = session.save(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
        return object;
    }

    @Override
    public void update(T[] t) {
        session = this.getSession();
        session.beginTransaction();
        for(T temp : t) {
            session.update(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(List<T> t) {
        session = this.getSession();
        session.beginTransaction();
        for(T temp : t) {
            session.update(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(T t) {
        session = this.getSession();
        session.beginTransaction();
        session.update(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateObj(T[] t) {
        session = this.getSession();
        session.beginTransaction();
        for(T temp : t) {
            session.update(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateObj(T t) {
        session = this.getSession();
        session.beginTransaction();
        session.update(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Session session, T[] t) {
        session.beginTransaction();
        for (T temp : t)
        {
            session.update(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Session session, T t) {
        session.beginTransaction();
        session.update(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T[] t) {
        session = this.getSession();
        session.beginTransaction();
        for(T temp : t) {
            session.delete(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(List<T> t) {
        session = this.getSession();
        session.beginTransaction();
        for(T temp : t) {
            session.delete(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T t) {
        session = this.getSession();
        session.beginTransaction();
        session.delete(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObj(T[] t) {
        session = this.getSession();
        session.beginTransaction();
        for(T temp : t) {
            session.delete(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObj(T t) {
        session = this.getSession();
        session.beginTransaction();
        session.delete(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Session session, T[] t) {
        session.beginTransaction();
        for(T temp : t) {
            session.delete(temp);
        }
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Session session, T t) {
        session.beginTransaction();
        session.delete(t);
        //session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
