package com.clone.instagram.services.genericServices;

import com.clone.instagram.entities.GenericEntity;
import com.clone.instagram.exceptions.ResourceNotFoundException;
import com.clone.instagram.repositories.IGenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericService<T extends GenericEntity> implements IGenericService<T> {

    private IGenericRepository<T> abstractRepository;
    private Class<T> clazz;

    public GenericService(IGenericRepository<T> abstractRepository) {
        this.abstractRepository = abstractRepository;
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),GenericService.class);
    }


    @Override
    public List<T> findAll() {
        return abstractRepository.findAll();
    }

    @Override
    public T findById(Long id) {

        return abstractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(clazz.getSimpleName(),"Id",id));
    }

    @Override
    public T  save(T entity) {

        return abstractRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        abstractRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        abstractRepository.deleteById(id);
    }

    @Override
    public long count() {
        return abstractRepository.count();
    }
}
