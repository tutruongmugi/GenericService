package com.clone.instagram.controllers;

import com.clone.instagram.entities.GenericEntity;
import com.clone.instagram.services.genericServices.GenericService;
import com.clone.instagram.services.genericServices.IGenericService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
public abstract class GenericController<T extends GenericEntity> implements IGenericController<T>{

    private final IGenericService<T> genericService;

//    @Override
//    @GetMapping
//    public List<T> findAll() {
//        return genericService.findAll();
//    }
//
//    @Override
//    @GetMapping("{id}")
//    public T findById(@PathVariable Long id) {
//        return genericService.findById(id).get();
//    }

    @Override
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        genericService.deleteById(id);
    }
}
