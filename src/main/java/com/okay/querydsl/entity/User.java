package com.okay.querydsl.entity;

import com.okay.querydsl.core.BaseEntity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@QueryEntity
@Table(name = "RL_USER", schema = "PUBLIC")
public class User extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "RL_USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "FK_USER_ID",
                            nullable = false,
                            updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "FK_ROLE_ID",
                            nullable = false,
                            updatable = false)}
    )
    private List<Role> roleList;
}