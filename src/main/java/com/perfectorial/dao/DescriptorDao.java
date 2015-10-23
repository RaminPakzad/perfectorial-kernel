package com.perfectorial.dao;

import com.perfectorial.entity.DescriptorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/25/2015
 * @deprecated methods are migrated to {@link com.perfectorial.dao.AbstractGenericDao}. After full migration
 * class can be safely deleted.
 */
class DescriptorDao<T extends DescriptorEntity> {
    public static final String DESCRIPTOR_ENTITY = "DescriptorEntity";

    @Autowired
    protected MongoOperations mongoOperation;

    public void save(DescriptorEntity entity) {
        mongoOperation.save(entity, DESCRIPTOR_ENTITY);
    }

    public T getByCode(String code) {
        return (T) get("code", code, getType());
    }

    public Class getType() {
        Type tClass = null;
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) type;
            tClass = paramType.getActualTypeArguments()[0];
        }

        return (Class) tClass;
    }

    public T get(String property, String propertyValue, Class<T> clazz) {
        final Criteria criteria = Criteria.where(property).is(propertyValue);
        return mongoOperation.findOne(Query.query(criteria), clazz);
    }
}
