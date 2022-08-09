package com.clone.instagram.services.genericServices;

import com.clone.instagram.entities.GenericEntity;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T extends GenericEntity> {
    List<T> findAll();
    T findById(Long id);
    T  save(T entity);
    void delete(T entity);
    void deleteById(Long id);
    long count();
}
