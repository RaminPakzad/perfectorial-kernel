package com.perfectorial.dao;

import com.perfectorial.entity.DescriptorEntity;
import com.perfectorial.entity.DescriptorType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/25/2015
 */
public class DescriptorDao<T extends DescriptorEntity> extends GenericDao {
    public static final String DESCRIPTOR_ENTITY = "DescriptorEntity";

    public void save(DescriptorEntity entity) {
        entity.setDescriptorType(DescriptorType.valueOf(entity));
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

}
