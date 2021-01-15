package com.okay.querydsl.entity;

import com.okay.querydsl.core.BaseEntity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@QueryEntity
@Table(name = "RL_ROLE", schema = "PUBLIC")
public class Role extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}