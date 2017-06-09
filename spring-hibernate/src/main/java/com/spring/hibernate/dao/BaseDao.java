package com.spring.hibernate.dao;

import com.spring.hibernate.common.bean.Page;

import java.util.List;

/**
 * Created by siyong.xu on 2017-05-05.
 */
public interface BaseDao<T> {
    void insertObject(T object);

    void delete(T object);

    void update(T updateObject);

    T queryById(int id);

    List<T> queryAll();

    List<T> findListByExample(T object);
    Page<T> findListForPage(String hql,Page<T> page);
}
