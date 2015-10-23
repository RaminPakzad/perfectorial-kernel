package com.perfectorial.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the common requirements that should be implemented by all data access classes.
 * For example, all dao classes need to implement the CRUD operations, or get an object by its
 * id. These general methods are aggregated here and dao classes can focus on their own specific
 * needs.
 *
 * @param <T> the type of instance that its dao needs to be implemented
 * @author Mohsen Ebrahimi
 */
public interface GenericDao<T> {
    T get(Serializable id);

    /**
     * provides a basic filtering on documents of collection {@code T}. It means, the method
     * returns all documents of the collection <tt>T</tt>, if there is key named <tt>property</tt>
     * and its value is <tt>propertyValue</tt>.
     *
     * @param clazz         class of collection that filtering is performed on it
     * @param property      name of property in the collection
     * @param propertyValue value of the the property
     * @return documents of T that can satisfy the condition
     */
    T get(Class<T> clazz, String property, String propertyValue);

    /**
     * returns an instance of {@code T} with the specified {@code code}. This is written based
     * on this fact that all collections have a code field, but if one collection doesn't
     * have so, can simply return null.
     */
    T getByCode(String code);

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
