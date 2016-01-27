package com.miki.rms.domain.shared.repository;

/** Created by miki on 25.12.2015. */
public interface DomainRepository<Id, T> {

    /** Find one entity based on id
     * 
     * @param id
     * @return */
    T findOne(Id id);

    /** save entity;
     * 
     * @param entity */
    T save(T entity);

    /** delete entity
     * 
     * @param entity */
    void delete(T entity);
}
