package com.okay.querydsl.service;

import com.okay.querydsl.core.PageModel;
import com.okay.querydsl.entity.query.QUser;
import com.okay.querydsl.entity.User;
import com.okay.querydsl.query.UserQueryGenerator;
import com.okay.querydsl.query.UserQueryModel;
import com.okay.querydsl.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserQueryGenerator userQueryGenerator;

    public UserServiceImpl(UserRepository userRepository, UserQueryGenerator userQueryGenerator) {
        this.userRepository = userRepository;
        this.userQueryGenerator = userQueryGenerator;
    }

    @Override
    public Page<User> filter(UserQueryModel userQueryModel) {
        Predicate generateQuery = userQueryGenerator.generateQuery(userQueryModel, QUser.user);

        PageModel pageModel = userQueryModel.getPageModel();
        return userRepository.findAll(generateQuery, PageRequest.of(pageModel.getPage(), pageModel.getSize(), Sort.unsorted()));
    }
}