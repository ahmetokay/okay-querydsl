package com.okay.querydsl.service;

import com.okay.querydsl.entity.User;
import com.okay.querydsl.model.query.UserQueryModel;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> filter(UserQueryModel queryModel);
}