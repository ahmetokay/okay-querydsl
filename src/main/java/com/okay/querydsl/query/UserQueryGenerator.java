package com.okay.querydsl.query;

import com.okay.querydsl.enm.EnumUserType;
import com.okay.querydsl.entity.User;
import com.okay.querydsl.entity.query.QUser;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserQueryGenerator extends AbstractQueryGenerator<UserQueryModel, User, QUser> {

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
    }
}