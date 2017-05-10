package com.spring.hibernate.dao.impl;

import com.spring.hibernate.dao.BaseDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by siyong.xu on 2017-05-05.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    protected Logger log = LogManager.getLogger(this.getClass());
    protected Class<T> clazz;

    public BaseDaoImpl() {
        //通过反射取父类
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取参数化类型的数组，泛型可能有多个,当前取第一个
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        this.clazz = (Class<T>) actualTypeArguments[0];
    }

    @Resource(name = "sessionFactory")
    private void setSupperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void insertObject(T object) {
        getHibernateTemplate().save(object);
    }

    public void delete(T object) {
        getHibernateTemplate().delete(object);
    }

    public void update(T updateObject) {
        getHibernateTemplate().update(updateObject);
    }

    public T queryById(int id) {
        return getHibernateTemplate().get(this.clazz, id);
    }

    public List<T> queryAll() {
        return getHibernateTemplate().loadAll(clazz);
    }

    @Override
    public List<T> findListByExample(T object) {
        return getHibernateTemplate().findByExample(object);
    }
}
