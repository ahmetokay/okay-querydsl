package com.okay.querydsl.model;

import lombok.Data;

@Data
public class SearchCriteria {

    private String key;

    private String operation;

    private String value;
}