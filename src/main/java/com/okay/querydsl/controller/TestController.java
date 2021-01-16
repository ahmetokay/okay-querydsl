package com.okay.querydsl.controller;

import com.okay.querydsl.entity.User;
import com.okay.querydsl.model.query.UserQueryModel;
import com.okay.querydsl.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ResponseEntity<Page<User>> filter(@RequestBody UserQueryModel userQueryModel) {
        return new ResponseEntity<>(userService.filter(userQueryModel), HttpStatus.OK);
    }
}