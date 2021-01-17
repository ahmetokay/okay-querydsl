package com.okay.querydsl.model.query;

import com.fasterxml.jackson.annotation.JsonView;
import com.okay.querydsl.core.QueryModel;
import com.okay.querydsl.enm.EnumUserType;
import com.okay.querydsl.entity.Role;
import com.okay.querydsl.model.Views;
import lombok.Data;

import java.util.List;

@Data
public class UserQueryModel extends QueryModel {

    @JsonView(Views.Internal.class)
    private String name;

    @JsonView(Views.Internal.class)
    private String surname;

    private String username;

    private EnumUserType type;

    private List<Role> roleList;
}