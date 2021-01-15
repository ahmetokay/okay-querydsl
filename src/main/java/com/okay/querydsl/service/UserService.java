package com.okay.querydsl.service;

import com.okay.querydsl.core.FilterModel;
import com.okay.querydsl.entity.User;

import java.util.List;

public interface UserService {

    List<User> filterService(FilterModel userFilterModel);
}