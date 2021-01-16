package com.okay.querydsl.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.okay.querydsl.core.BaseEntity;
import com.okay.querydsl.enm.EnumUserType;
import com.okay.querydsl.model.Views;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "RL_USER", schema = "PUBLIC")
public class User extends BaseEntity {

    @JsonView(Views.Public.class)
    @Column(name = "NAME")
    private String name;

    @JsonView(Views.Internal.class)
    @Column(name = "SURNAME")
    private String surname;

    @JsonView(Views.Internal.class)
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @JsonView(Views.Public.class)
    @Column(name = "REGISTER_DATE")
    private Date registerDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private EnumUserType type;

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