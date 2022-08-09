package com.clone.instagram.entities;

import com.clone.instagram.entities.role.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity @Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Table(name="users")
public class User extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="alias_name")
    private String aliasName;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany( cascade = CascadeType.ALL,mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "reaction", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
    private List<Post> postReactions;

    @Column(name="signup_date")
    private LocalDateTime signupDate;

    @Column(name="modify_date")
    private LocalDateTime modifyDate;

    @PrePersist
    protected void onCreate() {
        signupDate = LocalDateTime.now();
    }

    public List<Post> getPosts(){
        return posts == null? null : new ArrayList<>(posts);
    }

    public void setPosts(List<Post> posts){
        if(posts == null){
            this.posts=null;
        }
        else{
            this.posts = Collections.unmodifiableList(posts);
        }
    }

    public List<Role> getRoles(){
        return roles == null? null : new ArrayList<>(roles);
    }

    public void setRoles(List<Role> roles){
        if(roles == null){
            this.roles=null;
        }
        else{
            this.roles = Collections.unmodifiableList(roles);
        }
    }

    public List<Post> getPostReactions(){
        return postReactions == null? null : new ArrayList<>(postReactions);
    }

    public void setPostReactions(List<Post> postReactions){
        if(postReactions == null){
            this.postReactions=null;
        }
        else{
            this.postReactions = Collections.unmodifiableList(postReactions);
        }
    }



}
