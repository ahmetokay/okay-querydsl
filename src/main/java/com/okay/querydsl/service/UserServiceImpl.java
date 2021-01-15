package com.okay.querydsl.service;

import com.okay.querydsl.core.AbstractFilterService;
import com.okay.querydsl.core.FilterModel;
import com.okay.querydsl.entity.QUser;
import com.okay.querydsl.entity.User;
import com.okay.querydsl.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserServiceImpl extends AbstractFilterService<FilterModel, User> implements UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> filterService(FilterModel userFilterModel) {

        QUser user = QUser.user;
        StringPath username = user.username;
        BooleanExpression usernameExpression = username.likeIgnoreCase("%hmE%");

        PageRequest page = PageRequest.of(0, 10, Sort.by("id").ascending());

        Page<User> allPage = userRepository.findAll(usernameExpression, page);
        return allPage.getContent();

        /*
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        //TODO burada mı mantıklı
        QUser user = QUser.user;
        StringPath username = user.username;
        BooleanExpression usernameExpression = username.likeIgnoreCase("%hmE%");
        booleanBuilder.and(usernameExpression);
        //TODO burada mı mantıklı

        return query.selectFrom(user).where(booleanBuilder).fetchResults().getResults();
        */

//        return super.filter(userFilterModel);
    }
}