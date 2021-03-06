package com.okay.querydsl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okay.querydsl.core.GenericQueryModel;
import com.okay.querydsl.core.PageModel;
import com.okay.querydsl.enm.EnumUserType;
import com.okay.querydsl.model.query.UserQueryModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class QuerydslApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);

        UserQueryModel userQueryModel = new UserQueryModel();
        userQueryModel.setName("test");
        userQueryModel.setType(EnumUserType.USER);
        PageModel pageModel = new PageModel();
        pageModel.setPage(0);
        pageModel.setSize(5);
        pageModel.setSortField("id");
        pageModel.setSortOrder(1);
        userQueryModel.setPageModel(pageModel);
        GenericQueryModel genericQueryModel = new GenericQueryModel();
        genericQueryModel.setKey("username");
        genericQueryModel.setOperation("like");
        genericQueryModel.setValue("hme");
        userQueryModel.setQueryModelList(List.of(genericQueryModel));
        try {
            String s = new ObjectMapper().writeValueAsString(userQueryModel);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}