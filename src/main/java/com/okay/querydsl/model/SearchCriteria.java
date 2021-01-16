package com.okay.querydsl.model;

import lombok.Data;

@Data
public class SearchCriteria {

    private String type;

    private String key;

    private String operation;

    private Object value;
}