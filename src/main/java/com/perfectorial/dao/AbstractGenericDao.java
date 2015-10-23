package com.perfectorial.dao;

import com.perfectorial.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * This class provides a skeletal implementation of the <tt>GenericDao</tt> interface, to
 * minimize the effort required to implement this interface.
 *
 * @author Mohsen Ebrahimi
 */
@Service
public abstract class AbstractGenericDao<T extends Entity> implements GenericDao<T> {
    @Autowired
    protected MongoOperations mongoOperation;

    @Override
    public T get(Serializable id) {
        return null;
    }

    // TODO: remove first parameter and use getType instead.
    @Override
    public T get(Class<T> clazz, String property, String propertyValue) {
        final Criteria criteria = Criteria.where(property).is(propertyValue);
        return mongoOperation.findOne(Query.query(criteria), clazz);
    }

    @Override
    public T getByCode(String code) {
        return get(getType(), "code", code);
    }

    @Override
    public List<T> getAll() {
        return mongoOperation.findAll(getType());
    }

    @Override
    public void create(T t) {
        mongoOperation.save(t);
    }

    @Override
    public void update(T t) {
        final Criteria criteria = Criteria.where("id").is(t.getId());
        mongoOperation.updateFirst(Query.query(criteria), Update.update(t.getId(), t), getType());
    }

    @Override
    public void delete(T t) {

    }

    /**
     * Considering the fact that T.class is not valid in java, this method is written to satisfy
     * the same requirement.
     *
     * @return the same result of T.class
     */
    private Class<T> getType() {
        Type tClass = null;
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) type;
            tClass = paramType.getActualTypeArguments()[0];
        }

        return (Class<T>) tClass;
    }
}
