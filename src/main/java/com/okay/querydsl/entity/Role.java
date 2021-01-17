package com.okay.querydsl.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.okay.querydsl.core.BaseEntity;
import com.okay.querydsl.model.Views;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "RL_ROLE", schema = "PUBLIC")
public class Role extends BaseEntity {

    @JsonView(Views.Public.class)
    @Column(name = "NAME")
    private String name;

    @JsonView(Views.Internal.class)
    @Column(name = "DESCRIPTION")
    private String description;
}