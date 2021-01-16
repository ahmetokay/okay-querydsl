package com.okay.querydsl.repository;

import com.okay.querydsl.core.BaseRepository;
import com.okay.querydsl.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}