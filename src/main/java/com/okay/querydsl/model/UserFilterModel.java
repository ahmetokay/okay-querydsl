package com.okay.querydsl.model;

import com.okay.querydsl.core.BaseFilterModel;
import com.okay.querydsl.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserFilterModel extends BaseFilterModel {

    private String name;

    private String surname;

    private String username;

    private List<Role> roleList;
}