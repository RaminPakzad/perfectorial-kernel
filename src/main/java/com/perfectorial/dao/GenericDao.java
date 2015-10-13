package com.perfectorial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/11/2015
 */
@Service
public class GenericDao {
    @Autowired
    protected MongoOperations mongoOperation;


    public <T> T get(String property, String propertyValue, Class<T> clazz) {
        final Criteria criteria = Criteria.where(property).is(propertyValue);
        return mongoOperation.findOne(Query.query(criteria), clazz);
    }


}
