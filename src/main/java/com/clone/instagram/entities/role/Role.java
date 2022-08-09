package com.clone.instagram.entities.role;

import com.clone.instagram.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name="name")
    private RoleName name;

    public Role(RoleName name){
        this.name=name;
    }
}
