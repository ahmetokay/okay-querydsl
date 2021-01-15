package com.okay.querydsl.repository;

import com.okay.querydsl.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>, QuerydslPredicateExecutor<User> {

}