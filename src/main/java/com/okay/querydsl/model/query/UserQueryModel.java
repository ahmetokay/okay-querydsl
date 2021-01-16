package com.okay.querydsl.model.query;

import com.okay.querydsl.core.QueryModel;
import com.okay.querydsl.enm.EnumUserType;
import com.okay.querydsl.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserQueryModel extends QueryModel {

    private String name;

    private String surname;

    private String username;

    private EnumUserType type;

    private List<Role> roleList;
}