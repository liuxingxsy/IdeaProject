package com.spring.hibernate.service;

import java.util.List;

/**
 * Created by siyong.xu on 2017-05-05.
 */
public interface BaseService<T> {
    void insertObject(T object);

    void delete(T object);

    void update(T updateObject);

    T queryById(int id);

    List<T> queryAll();

    List<T> findListByExample(T object);
}
