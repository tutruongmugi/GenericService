package com.clone.instagram.controllers;

import java.util.List;


public interface IGenericController<T> {

//    List<T> findAll();
//    T findById(Long id);
    void deleteById(Long id);
}
