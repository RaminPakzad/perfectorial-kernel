package com.perfectorial.logic;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the common requirements that should be implemented by all logic classes. For
 * example, all logic classes need to implement the CRUD operations, or get an object by its
 * id.
 *
 * @param <T> the type of instance that its logic needs to be implemented
 * @author Mohsen Ebrahimi
 */
interface GenericLogic<T> {
    T get(Serializable id);

    /**
     * Gets an instance of T as sample and returns all documents with the same key/value pairs.
     *
     * @param sample      an instance of T to search base on it
     * @param ignoreNulls compare the null fields if {@code false}, otherwise only compares
     *                    non-null fields.
     * @return all documents whose key/value pairs are same as {@code sample}.
     */
    List<T> get(T sample, boolean ignoreNulls);

    List<T> getAll();

    T create(T t);

    void update(T t);

    void delete(T t);
}
