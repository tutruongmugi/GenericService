package com.clone.instagram.repositories;

import com.clone.instagram.entities.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@NoRepositoryBean
public interface IGenericRepository<T extends GenericEntity> extends JpaRepository<T,Long> {

}
