package com.clone.instagram.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
