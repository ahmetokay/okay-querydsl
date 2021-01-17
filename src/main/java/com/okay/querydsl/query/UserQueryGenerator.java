package com.okay.querydsl.query;

import com.okay.querydsl.core.AbstractQueryGenerator;
import com.okay.querydsl.enm.EnumUserType;
import com.okay.querydsl.entity.QUser;
import com.okay.querydsl.entity.Role;
import com.okay.querydsl.entity.User;
import com.okay.querydsl.model.query.UserQueryModel;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class UserQueryGenerator extends AbstractQueryGenerator<UserQueryModel, User, QUser> {


//    private final Converter burada olacak

    @Override
    protected void prepareQuery(BooleanBuilder queryBuilder, UserQueryModel queryModel, QUser entityPath) {
        String name = queryModel.getName();
        if (!StringUtils.isEmpty(name)) {
            queryBuilder.and(entityPath.username.eq(name));
        }

        String surname = queryModel.getSurname();
        if (!StringUtils.isEmpty(surname)) {
            queryBuilder.and(entityPath.surname.eq(surname));
        }

        String username = queryModel.getUsername();
        if (!StringUtils.isEmpty(username)) {
            queryBuilder.and(entityPath.username.eq(username));
        }

        EnumUserType type = queryModel.getType();
        if (type != null) {
            queryBuilder.and(entityPath.type.eq(type));
        }

        List<Role> roleList = queryModel.getRoleList();
        if (roleList != null) {
            queryBuilder.and(entityPath.roleList.any().in(roleList));
        }
    }
}