package com.perfectorial.logic;

import com.perfectorial.dao.GenericDao;
import com.perfectorial.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * This class provides a skeletal implementation of the <tt>GenericLogic</tt> interface, to
 * minimize the effort required to implement this interface.
 *
 * @author Mohsen Ebrahimi
 */
public abstract class AbstractGenericLogic<T extends Entity> implements GenericLogic<T> {
    @Autowired
    private GenericDao<T> genericDao;

    @Override
    public T get(Serializable id) {
        return genericDao.get(id);
    }

    @Override
    public List<T> getAll() {
        return genericDao.getAll();
    }

    @Override
    public T create(T t) {
        return genericDao.create(t);
    }

    @Override
    public void update(T t) {
        genericDao.update(t);
    }

    @Override
    public void delete(T t) {
        genericDao.delete(t);
    }

    @Override
    public List<T> get(T sample, boolean ignoreNulls) {
        throw new UnsupportedOperationException();
    }
}