package com.miki.rms.domain.shared.repository;

/**
 * Created by miki on 25.12.2015.
 */
public interface DomainRepository<Id, T> {

    T findOne(Id id);

    void save(T entity);

    void delete(T entity);
}
