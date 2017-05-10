package com.spring.hibernate.service.impl;

import com.spring.hibernate.dao.BaseDao;
import com.spring.hibernate.domain.DO.User;
import com.spring.hibernate.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by siyong.xu on 2017-05-05.
 */
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
    @Resource
    private BaseDao<T> baseDao;

    public void insertObject(T object) {
        baseDao.insertObject(object);
    }

    public void delete(T object) {
        baseDao.delete(object);
    }

    public void update(T updateObject) {
        baseDao.update(updateObject);
    }

    public T queryById(int id) {
        return baseDao.queryById(id);
    }

    public List<T> queryAll() {
        return baseDao.queryAll();
    }

    @Override
    public List<T> findListByExample(T object) {
        return null;
    }

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }
}
