package com.okay.querydsl.controller;

import com.okay.querydsl.core.FilterModel;
import com.okay.querydsl.entity.User;
import com.okay.querydsl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<List<User>> list(@RequestBody FilterModel filterModel) {
        List<User> userDtoList = userService.filterService(filterModel);

        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }
}